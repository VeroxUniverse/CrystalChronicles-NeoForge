package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.veroxuniverse.crystal_chronicles.util.CrystalPart;

import java.util.ArrayList;
import java.util.List;

public class BismuthCrystalBlock extends HorizontalCrystalBlock {

    public static final EnumProperty<CrystalPart> PART = EnumProperty.create("part", CrystalPart.class);
    public static final BooleanProperty FORMED = BooleanProperty.create("formed");


    public BismuthCrystalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, CrystalPart.DOWN_BACK_LEFT)
                .setValue(FORMED, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PART, FORMED);
    }

    @Override
    public void playerWillDestroy(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide && state.getValue(FORMED)) {
            // Starte den Zerstörungsprozess des geformten Kubus.
            // Wir übergeben die aktuelle FACING, da sie für den Kubus-Bau verwendet wurde.
            unformCuboid(level, pos, state.getValue(FACING));
        }
        super.playerWillDestroy(state, level, pos, player);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        // Diese Methode wird nach playerWillDestroy aufgerufen, wenn der Block tatsächlich entfernt wird.
        // Wir können die unformCuboid-Logik auch hier verwenden, um eine zuverlässigere Zerstörung zu gewährleisten.
        if (!level.isClientSide && state.getValue(FORMED) && !newState.is(this)) {
            unformCuboid(level, pos, state.getValue(FACING));
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            checkAndForm(level, pos);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            if (state.getValue(FORMED)) {
                checkAndUnform(level, pos);
            }
            checkAndForm(level, pos);
        }
    }

    private void checkAndForm(Level level, BlockPos currentPos) {
        Direction currentFacing = level.getBlockState(currentPos).getValue(FACING);
        for (BlockPos basePos : getPotentialBasePositions(currentPos, currentFacing)) {
            if (canFormCuboid(level, basePos, currentFacing)) {
                setCuboidState(level, basePos, currentFacing, true);
                return;
            }
        }
    }

    private static final int[][] CUBE_OFFSETS = new int[][]{
            {0, 0, 0}, {1, 0, 0}, {0, 1, 0}, {1, 1, 0},
            {0, 0, 1}, {1, 0, 1}, {0, 1, 1}, {1, 1, 1}
    };

    private static final CrystalPart[] PARTS_BY_INDEX = new CrystalPart[]{
            CrystalPart.DOWN_BACK_LEFT,  // 0, 0, 0
            CrystalPart.DOWN_BACK_RIGHT, // 1, 0, 0
            CrystalPart.UP_BACK_LEFT,    // 0, 1, 0
            CrystalPart.UP_BACK_RIGHT,   // 1, 1, 0
            CrystalPart.DOWN_FRONT_LEFT, // 0, 0, 1
            CrystalPart.DOWN_FRONT_RIGHT,// 1, 0, 1
            CrystalPart.UP_FRONT_LEFT,   // 0, 1, 1
            CrystalPart.UP_FRONT_RIGHT   // 1, 1, 1
    };

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

        for (int[] offset : CUBE_OFFSETS) {
            BlockPos rotatedOffset = getRotatedOffset(offset, currentFacing);
            bases.add(currentPos.offset(-rotatedOffset.getX(), -rotatedOffset.getY(), -rotatedOffset.getZ()));
        }
        return bases;
    }

    private boolean canFormCuboid(Level level, BlockPos basePos, Direction expectedFacing) {

        for (int[] offset : CUBE_OFFSETS) {
            BlockPos rotatedOffset = getRotatedOffset(offset, expectedFacing);
            BlockPos checkPos = basePos.offset(rotatedOffset.getX(), rotatedOffset.getY(), rotatedOffset.getZ());
            BlockState state = level.getBlockState(checkPos);

            if (state.getBlock() != this) {
                return false;
            }

            if (state.getValue(FACING) != expectedFacing) {
                return false;
            }
        }
        return true;
    }

    private void setCuboidState(Level level, BlockPos basePos, Direction commonFacing, boolean formed) {

        if (!formed && !level.getBlockState(basePos).getValue(FORMED)) {
            return;
        }

        for (int i = 0; i < CUBE_OFFSETS.length; i++) {
            int[] offset = CUBE_OFFSETS[i];

            BlockPos rotatedOffset = getRotatedOffset(offset, commonFacing);
            BlockPos partPos = basePos.offset(rotatedOffset.getX(), rotatedOffset.getY(), rotatedOffset.getZ());

            BlockState currentState = level.getBlockState(partPos);

            if (currentState.getBlock() == this) {
                BlockState newState = currentState
                        .setValue(FORMED, formed)
                        .setValue(FACING, commonFacing)
                        .setValue(PART, PARTS_BY_INDEX[i]);

                level.setBlock(partPos, newState, 18);
            }
        }
    }

    private void checkAndUnform(Level level, BlockPos currentPos) {

        if (!level.getBlockState(currentPos).getValue(FORMED)) {
            return;
        }

        Direction currentFacing = level.getBlockState(currentPos).getValue(FACING);

        for (BlockPos basePos : getPotentialBasePositions(currentPos, currentFacing)) {
            if (canFormCuboid(level, basePos, currentFacing)) {
                return;
            }
        }

        BlockState unformedState = this.defaultBlockState()
                .setValue(FORMED, false)
                .setValue(PART, CrystalPart.DOWN_BACK_LEFT)
                .setValue(FACING, level.getBlockState(currentPos).getValue(FACING));

        level.setBlock(currentPos, unformedState, 3);
    }
}