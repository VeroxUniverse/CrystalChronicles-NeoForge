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
    private static final int TICK_RATE = 20;

    public HolyLightBlock(Properties props) {
        super(props);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 1);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean moved) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, moved);
        if (!level.isClientSide) {
            if (level.getServer() != null && neighborPos.getY() < pos.getY()) {
                updateSegments(level, pos, state);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getServer() != null) {
            updateSegments(level, pos, state);
            level.scheduleTick(pos, this, TICK_RATE);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            if (level.getServer() != null) {
                clearSegments(level, pos);
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private void updateSegments(Level level, BlockPos pos, BlockState state) {
        int totalLength = computeLength(level, pos);

        for (int i = 1; i <= Math.min(3, totalLength); i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);

            Block targetBlock = switch (i) {
                case 1 -> CCBlocks.HOLY_LIGHT_1.get();
                case 2 -> CCBlocks.HOLY_LIGHT_2.get();
                case 3 -> CCBlocks.HOLY_LIGHT_3.get();
                default -> null;
            };

            if (targetBlock != null && !belowState.is(targetBlock)) {
                if (belowState.canBeReplaced() || isSegmentBlock(belowState)) {
                    level.setBlock(belowPos, targetBlock.defaultBlockState(), Block.UPDATE_ALL);
                }
            }
        }

        int startY = pos.getY() - 4;
        int endY = pos.getY() - totalLength;

        if (totalLength > 3) {
            for (int y = startY; y > endY; y--) {
                BlockPos segmentPos = new BlockPos(pos.getX(), y, pos.getZ());
                BlockState segmentState = level.getBlockState(segmentPos);

                if (!segmentState.is(CCBlocks.HOLY_LIGHT_4.get())) {
                    if (segmentState.canBeReplaced() || isSegmentBlock(segmentState)) {
                        level.setBlock(segmentPos, CCBlocks.HOLY_LIGHT_4.get().defaultBlockState(), Block.UPDATE_ALL);
                    }
                }
            }
        }

        int cleanupY = pos.getY() - totalLength - 1;
        for (int y = cleanupY; y >= level.getMinBuildHeight(); y--) {
            BlockPos cleanupPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState cleanupState = level.getBlockState(cleanupPos);

            if (isSegmentBlock(cleanupState)) {
                level.setBlock(cleanupPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            } else if (!cleanupState.isAir()) {
                break;
            }
        }
    }

    private void clearSegments(Level level, BlockPos pos) {
        for (int i = 1; ; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);
            if (isSegmentBlock(belowState)) {
                level.setBlock(belowPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            } else {
                break;
            }
        }
    }

    private boolean isSegmentBlock(BlockState state) {
        return state.is(CCBlocks.HOLY_LIGHT_1.get()) || state.is(CCBlocks.HOLY_LIGHT_2.get()) ||
                state.is(CCBlocks.HOLY_LIGHT_3.get()) || state.is(CCBlocks.HOLY_LIGHT_4.get());
    }

    private int computeLength(Level level, BlockPos pos) {
        int length = 0;
        for (int y = pos.getY() - 1; y >= level.getMinBuildHeight(); y--) {
            BlockPos belowPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState belowState = level.getBlockState(belowPos);
            if (isSegmentBlock(belowState)) {
                length++;
                continue;
            }
            boolean isAllowedTransparent = belowState.isAir() ||
                    belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass"))) ||
                    belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass_panes"))) ||
                    belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "transparent")));

            if (isAllowedTransparent) { length++; } else { break; }
        }
        return length;
    }
}