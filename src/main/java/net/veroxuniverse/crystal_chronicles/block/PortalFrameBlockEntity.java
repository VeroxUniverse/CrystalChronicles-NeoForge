package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.entity.CCBlockEntities;
import net.veroxuniverse.crystal_chronicles.entity.CCEntities;
import net.veroxuniverse.crystal_chronicles.entity.custom.DimensionalRiftEntity;

public class PortalFrameBlockEntity extends BlockEntity {

    private int riftEntityId = -1;
    private static final String RIFT_ID_TAG = "RiftEntityId";

    public PortalFrameBlockEntity(BlockPos pos, BlockState state) {
        super(CCBlockEntities.PORTAL_FRAME_BE.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putInt(RIFT_ID_TAG, this.riftEntityId);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.riftEntityId = tag.getInt(RIFT_ID_TAG);
    }

    public void activatePortal(ServerLevel world, Direction.Axis axis) {
        if (this.riftEntityId != -1) {
            Entity existing = world.getEntity(this.riftEntityId);
            if (existing != null && existing.isAlive()) {
                return;
            } else {
                this.riftEntityId = -1;
            }
        }

        BlockPos masterPos = this.getBlockPos();
        Direction facing = this.getBlockState().getValue(PortalFrameBlock.FACING);

        double spawnX = masterPos.getX() + 0.5;
        double spawnY = masterPos.getY() + 2.0;
        double spawnZ = masterPos.getZ() + 0.5;

        switch (facing) {
            case NORTH -> spawnX -= 1.5;
            case SOUTH -> spawnX += 1.5;
            case WEST -> spawnZ += 1.5;
            case EAST -> spawnZ -= 1.5;
        }

        DimensionalRiftEntity rift = new DimensionalRiftEntity(CCEntities.DIMENSIONAL_RIFT.get(), world);
        rift.setPos(spawnX, spawnY, spawnZ);
        rift.setPortalAxis(axis);
        rift.setPortalFramePos(this.getBlockPos());

        world.addFreshEntity(rift);
        this.riftEntityId = rift.getId();
        setChanged();
    }

    public void notifyEntityRemoved() {
        this.riftEntityId = -1;
        setChanged();
    }

    public void deactivatePortal(ServerLevel world) {
        if (world.isClientSide || this.riftEntityId == -1) return;

        Entity rift = world.getEntity(this.riftEntityId);
        if (rift instanceof DimensionalRiftEntity riftEntity) {
            riftEntity.startClosingSequence();
        }

        this.riftEntityId = -1;
        setChanged();

        BlockState currentState = getBlockState();
        if (currentState.hasProperty(PortalFrameBlock.ACTIVATED) && currentState.getValue(PortalFrameBlock.ACTIVATED)) {
            world.setBlock(getBlockPos(), currentState.setValue(PortalFrameBlock.ACTIVATED, false), 3);
        }
    }
}