package net.veroxuniverse.crystal_chronicles.entity.custom;

import mod.azure.azurelib.common.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
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
import net.veroxuniverse.crystal_chronicles.entity.client.DimensionalRiftEntityDispatcher;

import java.util.List;

public class DimensionalRiftEntity extends Entity {

    private boolean closeAnimationTriggered = false;

    private static final String IDLE_TICKS_TAG = "IdleTicks";
    private static final String IS_IDLE_ACTIVE_TAG = "IsIdleActive";
    private static final String IS_CLOSING_TAG = "IsClosing";
    private static final EntityDataAccessor<Boolean> DATA_IDLE = SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_CLOSING = SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<String> DATA_AXIS = SynchedEntityData.defineId(DimensionalRiftEntity.class, EntityDataSerializers.STRING);
    public final DimensionalRiftEntityDispatcher dispatcher;
    public final MoveAnalysis moveAnalysis;

    private static final ResourceKey<Level> TARGET_DIMENSION_KEY = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "alpha")
    );

    private int idleTicks = 0;
    private static final int IDLE_DURATION = 300;//20 * 60;
    private int transitionTicks = 0;
    private static final int ANIMATION_TIME = 60;

    private BlockPos portalFramePos;

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
        if (this.level().isClientSide) {
            dispatcher.open();
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("PortalAxis")) {
            setPortalAxis(Direction.Axis.valueOf(tag.getString("PortalAxis").toUpperCase()));
        }
        if (tag.contains("FrameX")) {
            this.portalFramePos = new BlockPos(tag.getInt("FrameX"), tag.getInt("FrameY"), tag.getInt("FrameZ"));
        }

        this.idleTicks = tag.getInt(IDLE_TICKS_TAG);
        setIdleActive(tag.getBoolean(IS_IDLE_ACTIVE_TAG));
        setIsClosing(tag.getBoolean(IS_CLOSING_TAG));

        if (this.isIdleActive()) {
            this.transitionTicks = ANIMATION_TIME;
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("PortalAxis", getPortalAxis().getName().toUpperCase());
        if (this.portalFramePos != null) {
            tag.putInt("FrameX", portalFramePos.getX());
            tag.putInt("FrameY", portalFramePos.getY());
            tag.putInt("FrameZ", portalFramePos.getZ());
        }

        tag.putInt(IDLE_TICKS_TAG, this.idleTicks);
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
            if (this.tickCount == 1) {
                if (isClosing()) {
                    dispatcher.close();
                    this.closeAnimationTriggered = true;
                } else if (isIdleActive()) {
                    dispatcher.idle();
                } else {
                    dispatcher.open();
                }
            }

            if (isClosing() && !closeAnimationTriggered) {
                dispatcher.close();
                this.closeAnimationTriggered = true;
                this.transitionTicks = 0;
            }

            handleClientAnimation();
        }

        if (!this.level().isClientSide && this.level() instanceof ServerLevel serverWorld) {
            handleServerLogic(serverWorld);
        }
    }

    private void handleClientAnimation() {
        if (isClosing()) {
            transitionTicks++;
        } else if (!isIdleActive()) {
            transitionTicks++;
            if (transitionTicks >= ANIMATION_TIME) {
                dispatcher.idle();
            }
        }
    }

    private void handleServerLogic(ServerLevel world) {
        if (this.isClosing()) {
            transitionTicks++;
            if (transitionTicks >= (ANIMATION_TIME - 5)) {
                resetPortalFrameState();
                this.remove(RemovalReason.DISCARDED);
            }
        } else if (isIdleActive() || transitionTicks >= ANIMATION_TIME) {
            setIdleActive(true);
            idleTicks++;

            if (idleTicks >= IDLE_DURATION) {
                startClosingSequence();
            }

            if (isAlive()) {
                teleportEntities(world);
            }
        } else {
            transitionTicks++;
        }
    }

    public void startClosingSequence() {
        if (!this.isClosing()) {
            setIsClosing(true);
            this.transitionTicks = 0;
        }
    }

    private void resetPortalFrameState() {
        if (this.portalFramePos != null && !this.level().isClientSide) {
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
    }

    public void setPortalAxis(Direction.Axis axis) {
        this.entityData.set(DATA_AXIS, axis.getName());
    }

    public Direction.Axis getPortalAxis() {
        return Direction.Axis.valueOf(this.entityData.get(DATA_AXIS).toUpperCase());
    }

    private BlockPos findSafeTeleportLocation(ServerLevel world, BlockPos initialTarget) {
        for (int y = 20; y < 100; y++) {
            BlockPos checkPos = new BlockPos(initialTarget.getX(), y, initialTarget.getZ());
            if (world.getBlockState(checkPos).isAir() && world.getBlockState(checkPos.above()).isAir() && world.getBlockState(checkPos.below()).isSolid()) {
                return checkPos;
            }
        }
        return world.getSharedSpawnPos();
    }

    private void teleportEntities(ServerLevel world) {
        double cx = this.getX();
        double cy = this.getY();
        double cz = this.getZ();

        AABB checkZone;
        Direction.Axis axis = this.getPortalAxis();

        if (axis == Direction.Axis.X) {
            checkZone = new AABB(cx - 1.0, cy - 1.0, cz - 0.1, cx + 1.0, cy + 1.0, cz + 0.1);
        } else {
            checkZone = new AABB(cx - 0.1, cy - 1.0, cz - 1.0, cx + 0.1, cy + 1.0, cz + 1.0);
        }

        List<ServerPlayer> players = world.getEntitiesOfClass(ServerPlayer.class, checkZone, player -> !player.isPassenger());

        ServerLevel targetWorld = world.getServer().getLevel(TARGET_DIMENSION_KEY);
        if (targetWorld == null) return;

        for (ServerPlayer player : players) {
            BlockPos spawn = findSafeTeleportLocation(targetWorld, player.blockPosition());
            player.teleportTo(targetWorld, spawn.getX() + 0.5, spawn.getY(), spawn.getZ() + 0.5, player.getYRot(), player.getXRot());
            player.setPortalCooldown();
        }
    }
}