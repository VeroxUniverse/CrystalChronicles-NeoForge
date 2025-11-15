package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class DirectionalClusterBlock extends Block implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final float height;
    private final float aabbOffset;

    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;
    protected final VoxelShape upAabb;
    protected final VoxelShape downAabb;

    public DirectionalClusterBlock(float height, float aabbOffset, BlockBehaviour.Properties properties) {
        super(properties);
        this.height = height;
        this.aabbOffset = aabbOffset;

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false));

        this.upAabb = Block.box(aabbOffset, 0.0, aabbOffset,
                16.0F - aabbOffset, height, 16.0F - aabbOffset);
        this.downAabb = Block.box(aabbOffset, 16.0F - height, aabbOffset,
                16.0F - aabbOffset, 16.0, 16.0F - aabbOffset);
        this.northAabb = Block.box(aabbOffset, aabbOffset, 16.0F - height,
                16.0F - aabbOffset, 16.0F - aabbOffset, 16.0);
        this.southAabb = Block.box(aabbOffset, aabbOffset, 0.0,
                16.0F - aabbOffset, 16.0F - aabbOffset, height);
        this.eastAabb = Block.box(0.0, aabbOffset, aabbOffset,
                height, 16.0F - aabbOffset, 16.0F - aabbOffset);
        this.westAabb = Block.box(16.0F - height, aabbOffset, aabbOffset,
                16.0, 16.0F - aabbOffset, 16.0F - aabbOffset);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case NORTH -> this.northAabb;
            case SOUTH -> this.southAabb;
            case EAST  -> this.eastAabb;
            case WEST  -> this.westAabb;
            case DOWN  -> this.downAabb;
            case UP -> this.upAabb;
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos supportPos = pos.relative(direction.getOpposite());
        return level.getBlockState(supportPos).isFaceSturdy(level, supportPos, direction);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {

        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction == state.getValue(FACING).getOpposite() && !state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return state;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();
        boolean water = level.getFluidState(pos).getType() == Fluids.WATER;

        return this.defaultBlockState().setValue(FACING, face).setValue(WATERLOGGED, water);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }
}
