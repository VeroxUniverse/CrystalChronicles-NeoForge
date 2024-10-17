package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BronchusBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public BronchusBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case NORTH:
            default:
                return makeShapeNorthSouth();
            case SOUTH:
                return makeShapeNorthSouth();
            case EAST, WEST:
                return makeShapeEastWest();
            case DOWN, UP:
                return makeShapeUpDown();
        }
    }

    public VoxelShape makeShapeUpDown(){
        VoxelShape shape1 = Shapes.empty();
        shape1 = Shapes.join(shape1, Shapes.box(0, 0, 0, 1, 1, 0.125), BooleanOp.OR);
        shape1 = Shapes.join(shape1, Shapes.box(0, 0, 0.875, 1, 1, 1), BooleanOp.OR);
        shape1 = Shapes.join(shape1, Shapes.box(0.875, 0, 0.125, 1, 1, 0.875), BooleanOp.OR);
        shape1 = Shapes.join(shape1, Shapes.box(0, 0, 0.125, 0.125, 1, 0.875), BooleanOp.OR);

        return shape1;
    }

    public VoxelShape makeShapeEastWest(){
        VoxelShape shape2 = Shapes.empty();
        shape2 = Shapes.join(shape2, Shapes.box(0, 0, 0, 1, 1, 0.125), BooleanOp.OR);
        shape2 = Shapes.join(shape2, Shapes.box(0, 0, 0.875, 1, 1, 1), BooleanOp.OR);
        shape2 = Shapes.join(shape2, Shapes.box(0, 0.875, 0.125, 1, 1, 0.875), BooleanOp.OR);
        shape2 = Shapes.join(shape2, Shapes.box(0, 0, 0.125, 1, 0.125, 0.875), BooleanOp.OR);

        return shape2;
    }

    public VoxelShape makeShapeNorthSouth(){
        VoxelShape shape3 = Shapes.empty();
        shape3 = Shapes.join(shape3, Shapes.box(0, 0, 0, 0.125, 1, 1), BooleanOp.OR);
        shape3 = Shapes.join(shape3, Shapes.box(0.875, 0, 0, 1, 1, 1), BooleanOp.OR);
        shape3 = Shapes.join(shape3, Shapes.box(0.125, 0.875, 0, 0.875, 1, 1), BooleanOp.OR);
        shape3 = Shapes.join(shape3, Shapes.box(0.125, 0, 0, 0.875, 0.125, 1), BooleanOp.OR);

        return shape3;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getClickedFace());
    }

    @Override
    protected BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public @NotNull VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case NORTH:
            default:
                return makeShapeNorthSouth();
            case SOUTH:
                return makeShapeNorthSouth();
            case EAST, WEST:
                return makeShapeEastWest();
            case DOWN, UP:
                return makeShapeUpDown();
        }
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    public @NotNull VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case NORTH:
            default:
                return makeShapeNorthSouth();
            case SOUTH:
                return makeShapeNorthSouth();
            case EAST, WEST:
                return makeShapeEastWest();
            case DOWN, UP:
                return makeShapeUpDown();
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

}
