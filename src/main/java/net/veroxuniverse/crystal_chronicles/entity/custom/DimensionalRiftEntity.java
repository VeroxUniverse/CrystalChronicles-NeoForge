/*package net.veroxuniverse.crystal_chronicles.entity.custom;

import mod.azure.azurelib.common.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.client.DimensionalRiftEntityDispatcher;

import java.util.List;

public class DimensionalRiftEntity extends Entity {

    public final DimensionalRiftEntityDispatcher dispatcher;
    public final MoveAnalysis moveAnalysis;

    private static final ResourceKey<Level> TARGET_DIMENSION_KEY = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "crystal_cave_dimension")
    );

    private int idleTicks = 0;
    private static final int IDLE_DURATION = 20 * 60; // 1 minute
    private int closingTicks = 0;
    private static final int CLOSING_DURATION = 20 * 3; // 3 seconds
    private static final int OPENING_DURATION = 20 * 3; // 3 seconds
    private boolean isClosing = false;
    private boolean isIdleActive = false;
    private Direction.Axis portalAxis = Direction.Axis.Z;

    private static final String AXIS_TAG = "PortalAxis";

    public DimensionalRiftEntity(EntityType<? extends DimensionalRiftEntity> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
        this.dispatcher = new DimensionalRiftEntityDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if (!this.level().isClientSide) {
            dispatcher.open();
            this.isIdleActive = false;
            this.closingTicks = 0;
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.portalAxis = Direction.Axis.valueOf(tag.getString(AXIS_TAG));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString(AXIS_TAG, this.portalAxis.getName());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    public void tick() {
        super.tick();
        if (this.level() instanceof ServerLevel serverWorld) {

            if (this.isClosing) {
                closingTicks++;
                if (closingTicks >= CLOSING_DURATION) {
                    this.remove(RemovalReason.DISCARDED);
                }

            } else if (!this.isIdleActive) {
                closingTicks++;
                if (closingTicks >= OPENING_DURATION) {
                    this.isIdleActive = true;
                    this.idleTicks = 0;
                    this.dispatcher.idle();
                }

            } else {
                idleTicks++;
                if (idleTicks >= IDLE_DURATION) {
                    startClosingSequence();
                }
                if (isAlive()) {
                    teleportEntities(serverWorld);
                }
            }
        }
    }

    public void startClosingSequence() {
        if (!this.isClosing) {
            this.isClosing = true;
            idleTicks = 0;
            if (!this.level().isClientSide) {
                dispatcher.close();
            }
        }
    }

    public void setPortalAxis(Direction.Axis axis) { this.portalAxis = axis; }
    public Direction.Axis getPortalAxis() { return this.portalAxis; }

    private BlockPos findSafeTeleportLocation(ServerLevel world, BlockPos initialTarget) {
        int searchRadius = 10;
        int maxSearchY = initialTarget.getY() + searchRadius;
        int minSearchY = initialTarget.getY() - searchRadius;

        for (int y = maxSearchY; y >= minSearchY; y--) {
            BlockPos checkPos = new BlockPos(initialTarget.getX(), y, initialTarget.getZ());

            if (world.getBlockState(checkPos.below()).isSolid()) {
                if (world.getBlockState(checkPos).isAir() && world.getBlockState(checkPos.above()).isAir()) {
                    return checkPos;
                }
            }
        }

        return world.getSharedSpawnPos();
    }

    private void teleportEntities(ServerLevel world) {
        AABB teleportBox = this.getBoundingBox().inflate(1.0, 1.0, 0.1);

        List<ServerPlayer> players = world.getEntitiesOfClass(ServerPlayer.class, teleportBox,
                player -> !player.isPassenger()
        );

        ServerLevel targetWorld = world.getServer().getLevel(TARGET_DIMENSION_KEY);

        if (targetWorld == null) {
            return;
        }

        for (ServerPlayer player : players) {


            BlockPos initialTarget = targetWorld.getSharedSpawnPos();
            BlockPos safePos = findSafeTeleportLocation(targetWorld, initialTarget);

            if (safePos != null) {

                player.teleportTo(targetWorld,
                        safePos.getX() + 0.5,
                        safePos.getY(),
                        safePos.getZ() + 0.5,
                        player.getYRot(),
                        player.getXRot());

                player.setPortalCooldown();
            }
        }
    }
}

 */