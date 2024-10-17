package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.util.CCTags;

public class VeinBlock extends PipeBlock {

    public static final MapCodec<VeinBlock> CODEC = simpleCodec(VeinBlock::new);

    @Override
    public MapCodec<VeinBlock> codec() {
        return CODEC;
    }

    public VeinBlock(BlockBehaviour.Properties properties) {
        super(0.3125F, properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(NORTH, Boolean.valueOf(false))
                        .setValue(EAST, Boolean.valueOf(false))
                        .setValue(SOUTH, Boolean.valueOf(false))
                        .setValue(WEST, Boolean.valueOf(false))
                        .setValue(UP, Boolean.valueOf(false))
                        .setValue(DOWN, Boolean.valueOf(false))
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return getStateWithConnections(pContext.getLevel(), pContext.getClickedPos(), this.defaultBlockState());
    }

    public static BlockState getStateWithConnections(BlockGetter getter, BlockPos pos, BlockState state) {
        BlockState blockstate = getter.getBlockState(pos.below());
        BlockState blockstate1 = getter.getBlockState(pos.above());
        BlockState blockstate2 = getter.getBlockState(pos.north());
        BlockState blockstate3 = getter.getBlockState(pos.east());
        BlockState blockstate4 = getter.getBlockState(pos.south());
        BlockState blockstate5 = getter.getBlockState(pos.west());
        Block block = state.getBlock();
        net.neoforged.neoforge.common.util.TriState soilDecision = blockstate.canSustainPlant(getter, pos.below(), Direction.UP, state);
        return state
                .trySetValue(DOWN, Boolean.valueOf(blockstate.is(block) || blockstate.is(CCBlocks.ARTREE_CAPILLARY)  || blockstate.is(CCBlocks.ARTREE_BASE) || soilDecision.isTrue()))
                .trySetValue(UP, Boolean.valueOf(blockstate1.is(block) || blockstate1.is(CCBlocks.ARTREE_CAPILLARY)))
                .trySetValue(NORTH, Boolean.valueOf(blockstate2.is(block) || blockstate2.is(CCBlocks.ARTREE_CAPILLARY)))
                .trySetValue(EAST, Boolean.valueOf(blockstate3.is(block) || blockstate3.is(CCBlocks.ARTREE_CAPILLARY)))
                .trySetValue(SOUTH, Boolean.valueOf(blockstate4.is(block) || blockstate4.is(CCBlocks.ARTREE_CAPILLARY)))
                .trySetValue(WEST, Boolean.valueOf(blockstate5.is(block) || blockstate5.is(CCBlocks.ARTREE_CAPILLARY)));
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            boolean flag = pFacingState.is(this) || (pFacingState.is(CCBlocks.ARTREE_BASE) || pFacingState.is(CCBlocks.ARTREE_CAPILLARY));
            if (pFacing == Direction.DOWN) {
                net.neoforged.neoforge.common.util.TriState soilDecision = pFacingState.canSustainPlant(pLevel, pFacingPos.relative(pFacing), pFacing.getOpposite(), pState);
                if (!soilDecision.isDefault()) {
                    flag = soilDecision.isTrue();
                }
            }
            return pState.setValue(PROPERTY_BY_DIRECTION.get(pFacing), Boolean.valueOf(flag));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }
}