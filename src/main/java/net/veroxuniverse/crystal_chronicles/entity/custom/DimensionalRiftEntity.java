package net.veroxuniverse.crystal_chronicles.entity.custom;

import mod.azure.azurelib.common.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.PortalFrameBlock;
import net.veroxuniverse.crystal_chronicles.block.PortalFrameBlockEntity;
import net.veroxuniverse.crystal_chronicles.dimension.AlphaDimensionData;
import net.veroxuniverse.crystal_chronicles.dimension.AlphaSpawnStructure;
import net.veroxuniverse.crystal_chronicles.entity.client.DimensionalRiftEntityDispatcher;

import java.util.List;

public class DimensionalRiftEntity extends Entity {

    private static final String IDLE_TICKS_TAG = "IdleTicks";
    private static final String TRANSITION_TICKS_TAG = "TransitionTicks";
    private static final String IS_IDLE_ACTIVE_TAG = "IsIdleActive";
    private static final String IS_CLOSING_TAG = "IsClosing";
    private static final String PORTAL_AXIS_TAG = "PortalAxis";
    private static final String FRAME_POS_TAG = "FramePos";

    private static final EntityDataAccessor<Boolean> DATA_IDLE =
            SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_CLOSING =
            SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<String> DATA_AXIS =
            SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.STRING);

    public final DimensionalRiftEntityDispatcher dispatcher;
    public final MoveAnalysis moveAnalysis;

    private static final ResourceKey<Level> TARGET_DIMENSION_KEY = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "alpha")
    );

    private int idleTicks = 0;
    private static final int IDLE_DURATION = 300;
    private int transitionTicks = 0;
    private static final int ANIMATION_TIME = 63;

    private BlockPos portalFramePos;

    private boolean hasPlayedOpen = false;
    private boolean hasStartedIdle = false;
    private boolean hasPlayedClose = false;

    public DimensionalRiftEntity(EntityType<? extends DimensionalRiftEntity> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
        this.dispatcher = new DimensionalRiftEntityDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
    }

    public void setPortalFramePos(BlockPos pos) {
        this.portalFramePos = pos;
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains(PORTAL_AXIS_TAG)) {
            setPortalAxis(Direction.Axis.valueOf(tag.getString(PORTAL_AXIS_TAG).toUpperCase()));
        }
        if (tag.contains(FRAME_POS_TAG)) {
            this.portalFramePos = NbtUtils.readBlockPos(tag, FRAME_POS_TAG).orElse(null);
        }
        this.idleTicks = tag.getInt(IDLE_TICKS_TAG);
        this.transitionTicks = tag.getInt(TRANSITION_TICKS_TAG);
        setIdleActive(tag.getBoolean(IS_IDLE_ACTIVE_TAG));
        setIsClosing(tag.getBoolean(IS_CLOSING_TAG));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString(PORTAL_AXIS_TAG, getPortalAxis().getName().toUpperCase());
        if (this.portalFramePos != null) {
            tag.put(FRAME_POS_TAG, NbtUtils.writeBlockPos(portalFramePos));
        }
        tag.putInt(IDLE_TICKS_TAG, this.idleTicks);
        tag.putInt(TRANSITION_TICKS_TAG, this.transitionTicks);
        tag.putBoolean(IS_IDLE_ACTIVE_TAG, this.isIdleActive());
        tag.putBoolean(IS_CLOSING_TAG, this.isClosing());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(DATA_AXIS, Direction.Axis.Z.getName());
        builder.define(DATA_IDLE, false);
        builder.define(DATA_CLOSING, false);
    }

    public boolean isIdleActive() {
        return this.entityData.get(DATA_IDLE);
    }

    public void setIdleActive(boolean active) {
        this.entityData.set(DATA_IDLE, active);
    }

    public boolean isClosing() {
        return this.entityData.get(DATA_CLOSING);
    }

    public void setIsClosing(boolean closing) {
        this.entityData.set(DATA_CLOSING, closing);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            handleClientAnimation();
            return;
        }

        if (this.level() instanceof ServerLevel serverWorld) {
            handleServerLogic(serverWorld);
        }
    }

    private void handleClientAnimation() {
        if (isClosing()) {
            if (!hasPlayedClose) {
                hasPlayedClose = true;
                hasPlayedOpen = false;
                hasStartedIdle = false;
                dispatcher.close();
            }
            return;
        }

        if (isIdleActive()) {
            if (!hasStartedIdle) {
                hasStartedIdle = true;
                hasPlayedOpen = false;
                dispatcher.idle();
            }
            return;
        }

        if (!hasPlayedOpen) {
            hasPlayedOpen = true;
            dispatcher.open();
        }
    }

    private void handleServerLogic(ServerLevel world) {
        if (isClosing()) {
            transitionTicks++;
            if (transitionTicks >= 62) {
                resetPortalFrameState();
                this.remove(RemovalReason.DISCARDED);
            }
            return;
        }

        transitionTicks++;

        if (transitionTicks >= ANIMATION_TIME) {
            if (!isIdleActive()) {
                setIdleActive(true);
            }

            idleTicks++;

            if (idleTicks >= IDLE_DURATION) {
                startClosingSequence();
                return;
            }

            if (isAlive()) {
                teleportEntities(world);
            }
        }
    }

    public void startClosingSequence() {
        if (!isClosing()) {
            setIsClosing(true);
            this.transitionTicks = 0;
        }
    }

    private void resetPortalFrameState() {
        if (portalFramePos == null || this.level().isClientSide) return;

        Level level = this.level();
        BlockState state = level.getBlockState(portalFramePos);

        if (state.getBlock() instanceof PortalFrameBlock block) {
            Direction facing = state.getValue(PortalFrameBlock.FACING);
            block.setFrameState(level, portalFramePos, facing, true, false);

            BlockEntity be = level.getBlockEntity(portalFramePos);
            if (be instanceof PortalFrameBlockEntity master) {
                master.notifyEntityRemoved();
            }
        }
    }

    public void setPortalAxis(Direction.Axis axis) {
        this.entityData.set(DATA_AXIS, axis.getName());
    }

    public Direction.Axis getPortalAxis() {
        return Direction.Axis.valueOf(this.entityData.get(DATA_AXIS).toUpperCase());
    }

    private void teleportEntities(ServerLevel world) {
        double cx = this.getX();
        double cy = this.getY();
        double cz = this.getZ();

        Direction.Axis axis = this.getPortalAxis();

        AABB checkZone = axis == Direction.Axis.X
                ? new AABB(cx - 1.0, cy - 1.0, cz - 0.1, cx + 1.0, cy + 1.0, cz + 0.1)
                : new AABB(cx - 0.1, cy - 1.0, cz - 1.0, cx + 0.1, cy + 1.0, cz + 1.0);

        ServerLevel targetWorld = world.getServer().getLevel(TARGET_DIMENSION_KEY);
        if (targetWorld == null) return;

        List<ServerPlayer> players = world.getEntitiesOfClass(ServerPlayer.class, checkZone,
                player -> !player.isPassenger());

        for (ServerPlayer player : players) {
            AlphaDimensionData data = AlphaDimensionData.get(targetWorld);
            if (!data.isStructureGenerated()) {
                AlphaSpawnStructure.generate(targetWorld);
                data.setStructureGenerated();
            }

            BlockPos spawnPos = AlphaSpawnStructure.getSafeSpawnPos(targetWorld);

            player.teleportTo(targetWorld,
                    spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5,
                    player.getYRot(), player.getXRot());
            player.setPortalCooldown();
        }
    }
}