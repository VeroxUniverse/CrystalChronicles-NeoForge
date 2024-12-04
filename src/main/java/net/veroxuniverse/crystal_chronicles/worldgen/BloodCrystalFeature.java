package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class BloodCrystalFeature extends Feature<NoneFeatureConfiguration> {

    public BloodCrystalFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos basePos = context.origin();
        RandomSource random = context.random();

        if (!isValidGround(context.level(), basePos.below())) {
            return false;
        }

        int maxHeight = random.nextInt(6) + 8;

        for (int y = 0; y < maxHeight; y++) {
            int radius = Math.max(1, (maxHeight - y) / 3);

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx * dx + dz * dz <= radius * radius) {
                        BlockPos pos = basePos.offset(dx, y, dz);
                        float chance = 0.8f - (y / (float) maxHeight) * 0.5f;

                        if (random.nextFloat() < chance) {
                            context.level().setBlock(pos, CCBlocks.HEMALITE_BLOCK.get().defaultBlockState(), 2);

                            if (random.nextFloat() < 0.3f && y > maxHeight * 0.6) {
                                BlockPos spikePos = pos.above();
                                context.level().setBlock(spikePos, CCBlocks.HEMALITE_BLOCK.get().defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }

            placeAdditionalBlocks(context, basePos, y, radius, random, maxHeight);
        }

        context.level().setBlock(basePos.above(maxHeight), CCBlocks.HEMALITE_BLOCK.get().defaultBlockState(), 2);

        return true;
    }

    private void placeAdditionalBlocks(FeaturePlaceContext<NoneFeatureConfiguration> context, BlockPos basePos, int y, int radius, RandomSource random, int maxHeight) {
        BlockPos[] directions = {
                basePos.north(), basePos.south(), basePos.east(), basePos.west(),
        };

        for (BlockPos direction : directions) {
            BlockPos pos = direction.above(y);

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx * dx + dz * dz <= radius * radius) {
                        BlockPos wallPos = pos.offset(dx, 0, dz);
                        float chance = 0.6f - (y / (float) maxHeight) * 0.4f;

                        if (random.nextFloat() < chance && isValidPlacement(context.level(), wallPos, basePos)) {
                            context.level().setBlock(wallPos, CCBlocks.HEMALITE_BLOCK.get().defaultBlockState(), 2);

                            if (random.nextFloat() < 0.2f) {
                                BlockPos sideSpike = wallPos.above();
                                context.level().setBlock(sideSpike, CCBlocks.HEMALITE_BLOCK.get().defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isValidGround(LevelAccessor world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.is(CCBlocks.FLESH_BLOCK.get()) || state.isSolid();
    }

    private boolean isValidPlacement(LevelAccessor world, BlockPos pos, BlockPos basePos) {
        BlockState state = world.getBlockState(pos);
        boolean isOnGroundLevel = pos.getY() <= basePos.getY();
        return isOnGroundLevel && (state.isAir() || state.isSolid());
    }
}