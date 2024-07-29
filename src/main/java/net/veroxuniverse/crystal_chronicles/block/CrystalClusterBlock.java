package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
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

public class CrystalClusterBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<CrystalClusterBlock> CODEC = RecordCodecBuilder.mapCodec(
            blockInstance -> blockInstance.group(
                            Codec.FLOAT.fieldOf("height").forGetter(clusterBlock -> clusterBlock.height),
                            Codec.FLOAT.fieldOf("aabb_offset").forGetter(crystalClusterBlock -> crystalClusterBlock.aabbOffset),
                            propertiesCodec()
                    )
                    .apply(blockInstance, CrystalClusterBlock::new)
    );
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private final float height;
    private final float aabbOffset;
    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;
    protected final VoxelShape upAabb;
    protected final VoxelShape downAabb;

    @Override
    public MapCodec<CrystalClusterBlock> codec() {
        return CODEC;
    }

    public CrystalClusterBlock(float v, float v1, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP));
        this.upAabb = Block.box((double)v1, 0.0, (double)v1, (double)(16.0F - v1), (double)v, (double)(16.0F - v1));
        this.downAabb = Block.box(
                (double)v1, (double)(16.0F - v), (double)v1, (double)(16.0F - v1), 16.0, (double)(16.0F - v1)
        );
        this.northAabb = Block.box(
                (double)v1, (double)v1, (double)(16.0F - v), (double)(16.0F - v1), (double)(16.0F - v1), 16.0
        );
        this.southAabb = Block.box((double)v1, (double)v1, 0.0, (double)(16.0F - v1), (double)(16.0F - v1), (double)v);
        this.eastAabb = Block.box(0.0, (double)v1, (double)v1, (double)v, (double)(16.0F - v1), (double)(16.0F - v1));
        this.westAabb = Block.box(
                (double)(16.0F - v), (double)v1, (double)v1, 16.0, (double)(16.0F - v1), (double)(16.0F - v1)
        );
        this.height = v;
        this.aabbOffset = v1;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case DOWN:
                return this.downAabb;
            case UP:
            default:
                return this.upAabb;
        }
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos blockpos = pPos.relative(direction.getOpposite());
        return pLevel.getBlockState(blockpos).isFaceSturdy(pLevel, blockpos, direction);
    }

    @Override
    protected BlockState updateShape(
            BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos
    ) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER))
                .setValue(FACING, pContext.getClickedFace());
    }

    @Override
    protected BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, FACING);
    }
}
