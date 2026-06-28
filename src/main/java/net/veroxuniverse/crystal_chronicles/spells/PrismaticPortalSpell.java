package net.veroxuniverse.crystal_chronicles.spells;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.PortalFrameBlock;
import net.veroxuniverse.crystal_chronicles.block.PortalFrameBlockEntity;
import net.veroxuniverse.crystal_chronicles.registry.CCSchools;
import net.veroxuniverse.crystal_chronicles.util.PortalFramePart;
import org.jetbrains.annotations.Nullable;

public class PrismaticPortalSpell extends AbstractSpell {

    private static final int BASE_MANA_COST = 150;
    private static final int DEFAULT_COOLDOWN = 1200;

    public static final ResourceKey<Level> ALPHA_DIMENSION = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "alpha")
    );

    public static final ResourceLocation SPELL_ID = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "prismatic_portal");

    public PrismaticPortalSpell() {
        super();
        this.baseManaCost = BASE_MANA_COST;
        this.castTime = 60;
        this.baseSpellPower = 0;
        this.spellPowerPerLevel = 0;
    }

    @Override
    public CastType getCastType() { return CastType.LONG; }

    @Override
    public SchoolType getSchoolType() { return CCSchools.PRISMATIC.get(); }

    @Override
    public ResourceLocation getSpellResource() { return SPELL_ID; }

    @Override
    public DefaultConfig getDefaultConfig() {
        DefaultConfig config = new DefaultConfig();
        config.setMinRarity(SpellRarity.LEGENDARY);
        config.setMaxLevel(1);
        config.setCooldownSeconds(DEFAULT_COOLDOWN / 20.0);
        config.setSchoolResource(CCSchools.PRISMATIC_ID);
        return config.build();
    }

    @Override
    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        if (!(entity instanceof ServerPlayer player)) return;
        if (!(level instanceof ServerLevel serverLevel)) return;

        spawnHelixParticles(player, serverLevel);
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!(entity instanceof ServerPlayer player)) return;

        ResourceKey<Level> currentDim = level.dimension();

        if (currentDim.equals(ALPHA_DIMENSION)) {
            teleportToSpawn(player, (ServerLevel) level);
            return;
        }

        HitResult hit = player.pick(20.0, 0, false);
        if (hit.getType() != HitResult.Type.BLOCK) return;

        BlockHitResult blockHit = (BlockHitResult) hit;
        BlockPos targetPos = blockHit.getBlockPos();
        BlockState targetState = level.getBlockState(targetPos);

        if (!(targetState.getBlock() instanceof PortalFrameBlock portalBlock)) return;
        if (!targetState.getValue(PortalFrameBlock.FORMED)) return;
        if (targetState.getValue(PortalFrameBlock.ACTIVATED)) return;

        BlockPos basePos = findBase(level, targetPos, targetState);
        if (basePos == null) return;

        BlockEntity be = level.getBlockEntity(basePos);
        if (be instanceof PortalFrameBlockEntity master) {
            Direction facing = targetState.getValue(PortalFrameBlock.FACING);
            master.activatePortal((ServerLevel) level, facing.getAxis());
            portalBlock.setFrameState(level, basePos, facing, true, true);
            level.playSound(null, targetPos,
                    SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1f, 1f);
        }
    }

    private void spawnHelixParticles(ServerPlayer player, ServerLevel level) {
        int[] colors = {0xFF0000, 0xFF7700, 0xFFFF00, 0x00FF00, 0x0000FF, 0x8B00FF, 0xFF00FF};
        int tick = player.tickCount;

        for (int helix = 0; helix < 2; helix++) {
            for (int i = 0; i < 3; i++) {
                float angle = (float) (tick * 0.3f + i * (Math.PI * 2 / 3) + helix * Math.PI);
                float height = ((tick * 0.05f + i * 0.4f) % 2.5f);

                double x = player.getX() + Math.cos(angle) * 0.8;
                double y = player.getY() + height;
                double z = player.getZ() + Math.sin(angle) * 0.8;

                int color = colors[(tick / 3 + i + helix * 3) % colors.length];
                float r = ((color >> 16) & 0xFF) / 255f;
                float g = ((color >> 8) & 0xFF) / 255f;
                float b = (color & 0xFF) / 255f;

                level.sendParticles(
                        new DustParticleOptions(new org.joml.Vector3f(r, g, b), 1.2f),
                        x, y, z, 1, 0, 0, 0, 0
                );
            }
        }
    }

    private void teleportToSpawn(ServerPlayer player, ServerLevel currentLevel) {
        ServerLevel overworld = player.getServer().getLevel(Level.OVERWORLD);
        if (overworld == null) return;

        BlockPos spawnPos = player.getRespawnPosition();
        Vec3 destination = spawnPos != null
                ? Vec3.atCenterOf(spawnPos)
                : Vec3.atCenterOf(overworld.getSharedSpawnPos());

        spawnHelixParticles(player, currentLevel);

        player.teleportTo(overworld,
                destination.x, destination.y, destination.z,
                player.getYRot(), player.getXRot());
    }

    private BlockPos findBase(Level level, BlockPos hit, BlockState state) {
        Direction facing = state.getValue(PortalFrameBlock.FACING);
        int[][] offsets = {
                {0,0,0},{1,0,0},{2,0,0},{3,0,0},
                {0,1,0},{3,1,0},{0,2,0},{3,2,0},
                {0,3,0},{1,3,0},{2,3,0},{3,3,0}
        };
        for (int[] off : offsets) {
            int dx = off[0], dy = off[1];
            int wx = 0, wz = 0;
            switch (facing) {
                case NORTH -> { wx = -dx; wz = 0; }
                case SOUTH -> { wx =  dx; wz = 0; }
                case WEST  -> { wx =  0;  wz = dx; }
                case EAST  -> { wx =  0;  wz = -dx; }
            }
            BlockPos candidate = hit.offset(-wx, -dy, -wz);
            BlockState cs = level.getBlockState(candidate);
            if (cs.is(state.getBlock())
                    && cs.getValue(PortalFrameBlock.PART) == PortalFramePart.BOTTOM_LEFT
                    && cs.getValue(PortalFrameBlock.FORMED)) {
                return candidate;
            }
        }
        return null;
    }
}