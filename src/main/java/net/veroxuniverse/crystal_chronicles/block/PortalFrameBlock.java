/*package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
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
import java.util.List;

public class PortalFrameBlock extends HorizontalCrystalBlock implements EntityBlock {

    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public static final EnumProperty<PortalFramePart> PART = EnumProperty.create("part", PortalFramePart.class); // NEU

    private static final int[][] FRAME_OFFSETS = new int[][]{
            // x=0, y=0 (BOTTOM_LEFT)
            {0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}, // Reihe 0
            // x=0, y=1 (MID_LOW_LEFT)
            {0, 1, 0}, {1, 1, 0}, {2, 1, 0}, {3, 1, 0}, // Reihe 1
            // x=0, y=2 (MID_HIGH_LEFT)
            {0, 2, 0}, {1, 2, 0}, {2, 2, 0}, {3, 2, 0}, // Reihe 2
            // x=0, y=3 (TOP_LEFT)
            {0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}  // Reihe 3
    };

    private static final PortalFramePart[] PARTS_BY_INDEX = new PortalFramePart[]{
            // Y=0
            PortalFramePart.BOTTOM_LEFT, PortalFramePart.BOTTOM_MID_LEFT, PortalFramePart.BOTTOM_MID_RIGHT, PortalFramePart.BOTTOM_RIGHT,
            // Y=1
            PortalFramePart.MID_LOW_LEFT, PortalFramePart.MID_LOW_MID_LEFT, PortalFramePart.MID_LOW_MID_RIGHT, PortalFramePart.MID_LOW_RIGHT,
            // Y=2
            PortalFramePart.MID_HIGH_LEFT, PortalFramePart.MID_HIGH_MID_LEFT, PortalFramePart.MID_HIGH_MID_RIGHT, PortalFramePart.MID_HIGH_RIGHT,
            // Y=3
            PortalFramePart.TOP_LEFT, PortalFramePart.TOP_MID_LEFT, PortalFramePart.TOP_MID_RIGHT, PortalFramePart.TOP_RIGHT
    };

    public PortalFrameBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, PortalFramePart.BOTTOM_LEFT)
                .setValue(ACTIVATED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ACTIVATED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PortalFrameBlockEntity(pos, state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            checkAndForm(level, pos);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && state.getValue(ACTIVATED) && !newState.is(this)) {
            unformFrame(level, pos, state.getValue(FACING));
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            checkAndForm(level, pos);
        }
    }

    private void checkAndForm(Level level, BlockPos currentPos) {
        Direction currentFacing = level.getBlockState(currentPos).getValue(FACING);
        for (BlockPos basePos : getPotentialBasePositions(currentPos, currentFacing)) {
            if (canFormFrame(level, basePos, currentFacing)) {
                setFrameState(level, basePos, currentFacing, false);
                return;
            } else {

                unformFrame(level, currentPos, currentFacing);
            }
        }
    }

    private boolean canFormFrame(Level level, BlockPos basePos, Direction expectedFacing) {
        for (int[] offset : FRAME_OFFSETS) {
            BlockPos rotatedOffset = getRotatedOffset(offset, expectedFacing);
            BlockPos checkPos = basePos.offset(rotatedOffset.getX(), rotatedOffset.getY(), rotatedOffset.getZ());
            BlockState state = level.getBlockState(checkPos);

            if (state.getBlock() != this || state.getValue(FACING) != expectedFacing) {
                return false;
            }
        }

        for (int x = 1; x <= 2; x++) {
            for (int y = 1; y <= 2; y++) {
                BlockPos innerPos = basePos.offset(getRotatedOffset(new int[]{x, y, 0}, expectedFacing));
                if (!level.getBlockState(innerPos).isAir()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void unformFrame(Level level, BlockPos destroyedPos, Direction commonFacing) {
        for (BlockPos potentialBase : getPotentialBasePositions(destroyedPos, commonFacing)) {
            BlockEntity blockEntity = level.getBlockEntity(potentialBase);
            if (blockEntity instanceof PortalFrameBlockEntity master) {
                master.deactivatePortal((ServerLevel) level);
                setFrameState(level, potentialBase, commonFacing, false);
                return;
            }
        }
    }

    private void setFrameState(Level level, BlockPos basePos, Direction commonFacing, boolean activated) {
        for (int i = 0; i < FRAME_OFFSETS.length; i++) {
            BlockPos rotatedOffset = getRotatedOffset(FRAME_OFFSETS[i], commonFacing);
            BlockPos partPos = basePos.offset(rotatedOffset.getX(), rotatedOffset.getY(), rotatedOffset.getZ());

            BlockState currentState = level.getBlockState(partPos);

            if (currentState.getBlock() == this) {
                BlockState newState = currentState
                        .setValue(ACTIVATED, activated)
                        .setValue(FACING, commonFacing)
                        .setValue(PART, PARTS_BY_INDEX[i]);

                level.setBlock(partPos, newState, 18);
            }
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) return ItemInteractionResult.SUCCESS;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof PortalFrameBlockEntity)) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        PortalFrameBlockEntity master = (PortalFrameBlockEntity) blockEntity;

        if (state.getValue(ACTIVATED)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (player.getItemInHand(hand).getItem() == Items.DIAMOND) {

            Direction facing = state.getValue(FACING);
            for (BlockPos basePos : getPotentialBasePositions(pos, facing)) {
                if (canFormFrame(level, basePos, facing)) {

                    BlockEntity masterEntity = level.getBlockEntity(basePos);
                    if (masterEntity instanceof PortalFrameBlockEntity masterController) {
                        masterController.activatePortal((ServerLevel) level, facing.getAxis());
                        setFrameState(level, basePos, facing, true);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    private BlockPos getRotatedOffset(int[] offset, Direction facing) {
        int dx = offset[0];
        int dy = offset[1];
        int dz = offset[2];

        int worldDx = 0;
        int worldDz = 0;

        switch (facing) {
            case NORTH:
                worldDx = -dx;
                worldDz = -dz;
                break;
            case SOUTH:
                worldDx = dx;
                worldDz = dz;
                break;
            case WEST:
                worldDx = -dz;
                worldDz = dx;
                break;
            case EAST:
                worldDx = dz;
                worldDz = -dx;
                break;
            default:
                break;
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

 */