package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class HolyLightBlock extends Block {

    public HolyLightBlock(Properties props) {
        super(props);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos,
                        BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            updateSegments(level, pos, state);
            level.scheduleTick(pos, this, 1);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean moved) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, moved);
        if (!level.isClientSide) {
            if (neighborPos.getY() < pos.getY()) {
                updateSegments(level, pos, state);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        updateSegments(level, pos, state);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos,
                         BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            clearSegments(level, pos);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private void updateSegments(Level level, BlockPos pos, BlockState state) {
        int length = computeLength(level, pos);

        for (int i = 1; i <= 3; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);

            if (i <= length) {
                Block targetBlock = switch (i) {
                    case 1 -> CCBlocks.HOLY_LIGHT_1.get();
                    case 2 -> CCBlocks.HOLY_LIGHT_2.get();
                    case 3 -> CCBlocks.HOLY_LIGHT_3.get();
                    default -> null;
                };

                if (targetBlock != null && !belowState.is(targetBlock)) {
                    if (belowState.canBeReplaced()) {
                        level.setBlock(belowPos, targetBlock.defaultBlockState(), Block.UPDATE_ALL);
                    }
                }
            } else {
                if (isSegmentBlock(belowState)) {
                    level.setBlock(belowPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                }
            }
        }
    }

    private void clearSegments(Level level, BlockPos pos) {
        for (int i = 1; i <= 3; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);
            if (isSegmentBlock(belowState)) {
                level.setBlock(belowPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }

    private boolean isSegmentBlock(BlockState state) {
        return state.is(CCBlocks.HOLY_LIGHT_1.get())
                || state.is(CCBlocks.HOLY_LIGHT_2.get())
                || state.is(CCBlocks.HOLY_LIGHT_3.get());
    }

    private int computeLength(Level level, BlockPos pos) {
        int length = 0;

        for (int i = 1; i <= 3; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);

            if (isSegmentBlock(belowState)) {
                length++;
                continue;
            }

            boolean isAllowedTransparent =
                    belowState.isAir()
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass")))
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass_panes")))
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "transparent")));

            if (!isAllowedTransparent) {
                break;
            }

            if (belowState.isAir()) {
                length++;
            }
        }

        return length;
    }
}
