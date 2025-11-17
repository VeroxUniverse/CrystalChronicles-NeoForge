package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class CapillaryBlock extends PipeBlock {

    public static final MapCodec<CapillaryBlock> CODEC = simpleCodec(CapillaryBlock::new);

    @Override
    public MapCodec<CapillaryBlock> codec() {
        return CODEC;
    }

    public CapillaryBlock(BlockBehaviour.Properties properties) {
        super(0.3125F, properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(NORTH, false)
                        .setValue(EAST, false)
                        .setValue(SOUTH, false)
                        .setValue(WEST, false)
                        .setValue(UP, false)
                        .setValue(DOWN, false)
        );
    }

    private static boolean connectsTo(BlockState state) {
        return state.is(CCBlocks.ARTREE_BASE.get())
                || state.is(CCBlocks.ARTREE_VEIN.get())
                || state.is(CCBlocks.ARTREE_CAPILLARY.get());
    }

    private static boolean shouldHaveRandomUp(BlockPos pos) {
        long hash = pos.asLong();
        hash ^= (hash >> 33);
        hash *= 0xff51afd7ed558ccdL;
        hash ^= (hash >> 33);
        return (hash & 15L) == 0L;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return getStateWithConnections(ctx.getLevel(), ctx.getClickedPos(), this.defaultBlockState());
    }

    public static BlockState getStateWithConnections(BlockGetter level, BlockPos pos, BlockState baseState) {
        BlockState below = level.getBlockState(pos.below());
        BlockState above = level.getBlockState(pos.above());
        BlockState north = level.getBlockState(pos.north());
        BlockState east  = level.getBlockState(pos.east());
        BlockState south = level.getBlockState(pos.south());
        BlockState west  = level.getBlockState(pos.west());

        boolean connectDown  = connectsTo(below);
        boolean connectNorth = connectsTo(north);
        boolean connectEast  = connectsTo(east);
        boolean connectSouth = connectsTo(south);
        boolean connectWest  = connectsTo(west);

        boolean connectUpToTree = connectsTo(above);
        boolean randomUpStub = above.isAir() && !connectUpToTree && shouldHaveRandomUp(pos);
        boolean connectUp = connectUpToTree || randomUpStub;

        return baseState
                .setValue(DOWN,  connectDown)
                .setValue(UP,    connectUp)
                .setValue(NORTH, connectNorth)
                .setValue(EAST,  connectEast)
                .setValue(SOUTH, connectSouth)
                .setValue(WEST,  connectWest);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {

        if (!state.canSurvive(level, currentPos)) {
            level.scheduleTick(currentPos, this, 1);
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        }

        return getStateWithConnections(level, currentPos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        if (!level.isClientSide) {
            BlockState fixed = getStateWithConnections(level, pos, state);
            if (fixed != state) {
                level.setBlock(pos, fixed, Block.UPDATE_CLIENTS);
            }
        }
    }

}
