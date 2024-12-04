package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class FleshBlock extends Block {
    public static final BooleanProperty HAS_SKIN_ABOVE = BooleanProperty.create("has_skin_above");

    public FleshBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_SKIN_ABOVE, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos posAbove = context.getClickedPos().above();
        boolean hasSkinAbove = level.getBlockState(posAbove).is(CCBlocks.SKIN_LAYER.get());
        return this.defaultBlockState().setValue(HAS_SKIN_ABOVE, hasSkinAbove);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide()) {
            boolean hasSkinAbove = level.getBlockState(pos.above()).is(CCBlocks.SKIN_LAYER.get());
            level.setBlock(pos, state.setValue(HAS_SKIN_ABOVE, hasSkinAbove), 3);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, fromPos, isMoving);

        if (!level.isClientSide()) {
            boolean hasSkinAbove = level.getBlockState(pos.above()).is(CCBlocks.SKIN_LAYER.get());
            level.setBlock(pos, state.setValue(HAS_SKIN_ABOVE, hasSkinAbove), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HAS_SKIN_ABOVE);
    }

}