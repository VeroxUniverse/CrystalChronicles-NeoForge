package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class NeuronBlock extends HalfTransparentBlock {

    public static final VoxelShape SHAPE_BASE = Block.box(3.0D, 3.0D, 3.0D, 13.0D, 13.0D, 13.0D);

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    // random interval: 5 - 20 seconds (in ticks) for off state
    private static final int MIN_TICK_INTERVAL = 5 * 20;  // 5 seconds
    private static final int MAX_TICK_INTERVAL = 5 * 20;  // 20 seconds

    // random interval: 5 - 10 seconds (in ticks) for on state
    private static final int MIN_LIGHT_DURATION = 5 * 20;  // 5 seconds
    private static final int MAX_LIGHT_DURATION = 5 * 20; // 10 seconds

    private static final int MAX_AXONS = 10;

    public NeuronBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
    }

    // BLOCKSTATE

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        // starts the first tick
        if (!pLevel.isClientSide) {
            pLevel.scheduleTick(pPos, this, getRandomInterval(MIN_TICK_INTERVAL, MAX_TICK_INTERVAL));
        }
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(LIT, Boolean.valueOf(false));
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int tickInterval = MIN_TICK_INTERVAL + pRandom.nextInt(MAX_TICK_INTERVAL - MIN_TICK_INTERVAL + 1);
        int lightDuration = MIN_LIGHT_DURATION + pRandom.nextInt(MAX_LIGHT_DURATION - MIN_LIGHT_DURATION + 1);

        boolean shouldBeLit = !pState.getValue(LIT);
        pLevel.setBlock(pPos, pState.setValue(LIT, shouldBeLit), 3);

        updateAboveBlocks(pLevel, pPos);

        pLevel.scheduleTick(pPos, this, tickInterval);
    }

    // Method to update all AxonBlocks
    private void updateAboveBlocks(ServerLevel pLevel, BlockPos pPos) {
        BlockPos currentPos = pPos.above();
        int count = 0; // Counter for the number of AxonBlocks updated

        while (currentPos != null && count < MAX_AXONS) {
            BlockState currentState = pLevel.getBlockState(currentPos);

            if (currentState.getBlock() instanceof AxonBlock) {
                boolean shouldBeLit = pLevel.getBlockState(pPos).getValue(LIT);
                if (currentState.getValue(AxonBlock.LIT) != shouldBeLit) {
                    pLevel.setBlock(currentPos, currentState.setValue(AxonBlock.LIT, shouldBeLit), 3);
                    count++;
                }
            } else {
                // Stop if we reach a non-AxonBlocks
                break;
            }

            // Move to the next block above
            currentPos = currentPos.above();
        }
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return state.getLightEmission(); // check light level
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

    // helper method to generate a random value between min and max
    private int getRandomInterval(int minTicks, int maxTicks) {
        Random random = new Random();
        return minTicks + random.nextInt(maxTicks - minTicks + 1);
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
