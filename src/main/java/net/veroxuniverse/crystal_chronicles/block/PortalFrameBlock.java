package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.veroxuniverse.crystal_chronicles.util.PortalFramePart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PortalFrameBlock extends HorizontalCrystalBlock implements EntityBlock {

    public static final BooleanProperty FORMED = BooleanProperty.create("formed");
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public static final EnumProperty<PortalFramePart> PART = EnumProperty.create("part", PortalFramePart.class);

    private static final Set<BlockPos> updatingPositions = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private static final int[][] FRAME_OFFSETS = new int[][]{
            {0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0},
            {0, 1, 0},                         {3, 1, 0},
            {0, 2, 0},                         {3, 2, 0},
            {0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}
    };

    private static final PortalFramePart[] PARTS_BY_INDEX = new PortalFramePart[]{
            PortalFramePart.BOTTOM_LEFT, PortalFramePart.BOTTOM_MID_LEFT, PortalFramePart.BOTTOM_MID_RIGHT, PortalFramePart.BOTTOM_RIGHT,
            PortalFramePart.MID_LOW_LEFT, PortalFramePart.MID_LOW_RIGHT,
            PortalFramePart.MID_HIGH_LEFT, PortalFramePart.MID_HIGH_RIGHT,
            PortalFramePart.TOP_LEFT, PortalFramePart.TOP_MID_LEFT, PortalFramePart.TOP_MID_RIGHT, PortalFramePart.TOP_RIGHT
    };

    public PortalFrameBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, PortalFramePart.BOTTOM_LEFT)
                .setValue(FORMED, false)
                .setValue(ACTIVATED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FORMED, ACTIVATED, PART);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PortalFrameBlockEntity(pos, state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && state.hasProperty(FORMED) && state.getValue(FORMED) && !newState.is(this)) {
            unformFrame(level, pos, state.getValue(FACING));
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide && state.getValue(FORMED)) {
            checkAndForm(level, pos);
        }
    }

    private void checkAndForm(Level level, BlockPos currentPos) {
        BlockState state = level.getBlockState(currentPos);
        if (!state.getValue(FORMED)) return;

        Direction currentFacing = state.getValue(FACING);
        boolean structureStillValid = false;

        for (BlockPos basePos : getPotentialBasePositions(currentPos, currentFacing)) {
            if (canScanFrame(level, basePos, currentFacing, false)) {
                structureStillValid = true;
                break;
            }
        }

        if (!structureStillValid) {
            unformFrame(level, currentPos, currentFacing);
        }
    }

    private boolean canScanFrame(Level level, BlockPos basePos, Direction expectedFacing, boolean isCheckingForNewPortal) {
        for (int[] offset : FRAME_OFFSETS) {
            BlockPos rotatedOffset = getRotatedOffset(offset, expectedFacing);
            BlockPos checkPos = basePos.offset(rotatedOffset);
            BlockState state = level.getBlockState(checkPos);

            if (!state.is(this) || state.getValue(FACING) != expectedFacing) return false;
            if (isCheckingForNewPortal && state.getValue(FORMED)) return false;
        }

        for (int x = 1; x <= 2; x++) {
            for (int y = 1; y <= 2; y++) {
                BlockPos innerPos = basePos.offset(getRotatedOffset(new int[]{x, y, 0}, expectedFacing));
                if (!level.getBlockState(innerPos).isAir()) return false;
            }
        }
        return true;
    }

    private void unformFrame(Level level, BlockPos destroyedPos, Direction commonFacing) {
        for (BlockPos potentialBase : getPotentialBasePositions(destroyedPos, commonFacing)) {
            BlockState baseState = level.getBlockState(potentialBase);

            if (baseState.is(this) && baseState.getValue(FORMED) && baseState.getValue(PART) == PortalFramePart.BOTTOM_LEFT) {
                BlockEntity blockEntity = level.getBlockEntity(potentialBase);
                if (blockEntity instanceof PortalFrameBlockEntity master) {
                    master.deactivatePortal((ServerLevel) level);
                }
                setFrameState(level, potentialBase, commonFacing, false, false);
                return;
            }
        }
    }

    public void setFrameState(Level level, BlockPos basePos, Direction commonFacing, boolean formed, boolean activated) {
        if (!updatingPositions.add(basePos)) return;
        try {
            for (int i = 0; i < FRAME_OFFSETS.length; i++) {
                BlockPos rotatedOffset = getRotatedOffset(FRAME_OFFSETS[i], commonFacing);
                BlockPos partPos = basePos.offset(rotatedOffset);
                BlockState currentState = level.getBlockState(partPos);

                if (currentState.is(this)) {
                    BlockState newState = currentState
                            .setValue(FORMED, formed)
                            .setValue(ACTIVATED, activated)
                            .setValue(FACING, commonFacing)
                            .setValue(PART, PARTS_BY_INDEX[i]);

                    if (currentState != newState) {
                        level.setBlock(partPos, newState, 3);
                    }
                }
            }
        } finally {
            updatingPositions.remove(basePos);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemInHand = player.getItemInHand(hand);
        Direction facing = state.getValue(FACING);

        if (!itemInHand.is(Items.DIAMOND) && !itemInHand.is(Items.EMERALD)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (level.isClientSide) return ItemInteractionResult.SUCCESS;

        if (itemInHand.is(Items.DIAMOND) && !state.getValue(FORMED)) {
            for (BlockPos basePos : getPotentialBasePositions(pos, facing)) {
                if (canScanFrame(level, basePos, facing, true)) {
                    setFrameState(level, basePos, facing, true, false);
                    if (!player.getAbilities().instabuild) itemInHand.shrink(1);
                    level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1f, 1f);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        if (itemInHand.is(Items.EMERALD) && state.getValue(FORMED)) {
            BlockPos basePos = findBaseFromCurrentPart(pos, state, facing);

            if (basePos != null) {
                BlockState baseState = level.getBlockState(basePos);

                if (baseState.is(this) && baseState.getValue(FORMED)) {
                    if (baseState.getValue(ACTIVATED)) {
                        player.sendSystemMessage(Component.literal("The Portal is active already!"));
                        return ItemInteractionResult.SUCCESS;
                    }

                    BlockEntity be = level.getBlockEntity(basePos);
                    if (be instanceof PortalFrameBlockEntity master) {
                        master.activatePortal((ServerLevel) level, facing.getAxis());
                        setFrameState(level, basePos, facing, true, true);
                        if (!player.getAbilities().instabuild) itemInHand.shrink(1);
                        level.playSound(null, pos, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1f, 1f);
                        player.sendSystemMessage(Component.literal("Portal opened!"));
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }

            player.sendSystemMessage(Component.literal("Click, but Master-Block not found!"));
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    private BlockPos findBaseFromCurrentPart(BlockPos currentPos, BlockState state, Direction facing) {
        PortalFramePart currentPart = state.getValue(PART);
        int index = -1;
        for (int i = 0; i < PARTS_BY_INDEX.length; i++) {
            if (PARTS_BY_INDEX[i] == currentPart) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        BlockPos offset = getRotatedOffset(FRAME_OFFSETS[index], facing);
        return currentPos.subtract(offset);
    }

    private BlockPos getRotatedOffset(int[] offset, Direction facing) {
        int dx = offset[0];
        int dy = offset[1];
        int dz = offset[2];

        int worldDx = 0;
        int worldDz = 0;

        switch (facing) {
            case NORTH -> { worldDx = -dx; worldDz = -dz; }
            case SOUTH -> { worldDx = dx;  worldDz = dz;  }
            case WEST  -> { worldDx = -dz; worldDz = dx;  }
            case EAST  -> { worldDx = dz;  worldDz = -dx; }
        }

        return new BlockPos(worldDx, dy, worldDz);
    }

    private List<BlockPos> getPotentialBasePositions(BlockPos currentPos, Direction currentFacing) {
        List<BlockPos> bases = new ArrayList<>();
        for (int[] offset : FRAME_OFFSETS) {
            BlockPos rotatedOffset = getRotatedOffset(offset, currentFacing);
            bases.add(currentPos.offset(-rotatedOffset.getX(), -rotatedOffset.getY(), -rotatedOffset.getZ()));
        }
        return bases;
    }
}