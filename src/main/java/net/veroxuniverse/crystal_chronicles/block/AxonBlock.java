package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import org.jetbrains.annotations.NotNull;

public class AxonBlock extends HalfTransparentBlock {

    public static final VoxelShape SHAPE_BASE = Block.box(6.0D, 0, 6.0D, 10.0D, 16.0D, 10.0D);

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public AxonBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
    }

    // BLOCKSTATE

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pLevel.isClientSide){
            // immediately check nearby NeuronBlock when placed
            updateBlocks(pLevel, pPos);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        // Periodically check and sync with the block below
        updateBlocks(pLevel, pPos);
        // Schedule the next tick after 10 ticks (0.5 seconds)
        pLevel.scheduleTick(pPos, this, 10);
    }

    // Method to update all AxonBlocks above the NeuronBlock, with a maximum of MAX_AXONS blocks
    private void updateBlocks(Level pLevel, BlockPos pPos) {
        BlockPos blockBelow = pPos.below();
        BlockState belowState = pLevel.getBlockState(blockBelow);

        if (belowState.getBlock() instanceof NeuronBlock) {
            boolean shouldBeLit = belowState.getValue(NeuronBlock.LIT);
            BlockState currentState = pLevel.getBlockState(pPos);

            if (currentState.getValue(LIT) != shouldBeLit) {
                pLevel.setBlock(pPos, currentState.setValue(LIT, shouldBeLit), 3);
            }
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return false; // disables redstone interactions
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

    // SHAPE

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public @NotNull VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return SHAPE_BASE;
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    public @NotNull VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BASE;
    }


    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPE_BASE;
    }
}
