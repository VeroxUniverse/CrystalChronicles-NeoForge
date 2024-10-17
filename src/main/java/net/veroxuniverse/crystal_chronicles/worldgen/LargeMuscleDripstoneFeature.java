package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.LargeDripstoneFeature;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class LargeMuscleDripstoneFeature extends LargeDripstoneFeature {
    public LargeMuscleDripstoneFeature(Codec<LargeDripstoneConfiguration> pCodec) {
        super(pCodec);
    }
    @Override
    public boolean place(FeaturePlaceContext<LargeDripstoneConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        this.placeMuscleDripstone(world, random, pos);

        return true;
    }

    private void placeMuscleDripstone(WorldGenLevel world, RandomSource random, BlockPos pos) {
        for (int i = 0; i < 10; i++) {
            BlockPos targetPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5), random.nextInt(3) - 1);
            if (world.isEmptyBlock(targetPos)) {
                world.setBlock(targetPos, CCBlocks.MUSCLE_BLOCK.get().defaultBlockState(), 3);
            }
        }
    }
}