package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.entity.CCBlockEntities;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class HolyLightBlockEntity extends BlockEntity {

    private static final int TICK_RATE = 20;
    private int ticker = 0;

    public HolyLightBlockEntity(BlockPos pos, BlockState state) {
        super(CCBlockEntities.HOLY_LIGHT_BE.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, HolyLightBlockEntity be) {
        if (be.ticker > 0) {
            be.ticker--;
            return;
        }
        be.ticker = TICK_RATE;
        be.updateSegments(level, pos);
    }

    private void updateSegments(Level level, BlockPos pos) {
        if (!level.isLoaded(pos)) return;

        int totalLength = computeLength(level, pos);

        for (int i = 1; i <= Math.min(3, totalLength); i++) {
            BlockPos belowPos = pos.below(i);
            if (!level.isLoaded(belowPos)) break;
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
                if (!level.isLoaded(segmentPos)) break;
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
            if (!level.isLoaded(cleanupPos)) break;
            BlockState cleanupState = level.getBlockState(cleanupPos);

            if (isSegmentBlock(cleanupState)) {
                level.setBlock(cleanupPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            } else if (!cleanupState.isAir()) {
                break;
            }
        }
    }

    public void clearSegments(Level level, BlockPos pos) {
        for (int i = 1; ; i++) {
            BlockPos belowPos = pos.below(i);
            if (!level.isLoaded(belowPos)) break;
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
            if (!level.isLoaded(belowPos)) break;
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