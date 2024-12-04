package net.veroxuniverse.crystal_chronicles.worldgen.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class ArtreeFeature extends Feature<NoneFeatureConfiguration> {



    public ArtreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        int baseHeight = 3;
        int middleHeight = 2;
        int tipHeight = 1;

        placeBranch(world, pos, baseHeight, random, CCBlocks.ARTREE_BASE.get());

        placeBranch(world, pos.above(baseHeight), middleHeight, random, CCBlocks.ARTREE_VEIN.get());

        placeBranch(world, pos.above(baseHeight + middleHeight), tipHeight, random, CCBlocks.ARTREE_CAPILLARY.get());

        return true;
    }

    private void placeBranch(WorldGenLevel world, BlockPos basePos, int height, RandomSource random, Block block) {
        for (int y = 0; y < height; y++) {
            BlockPos branchPos = basePos.above(y);
            world.setBlock(branchPos, BlockStateProvider.simple(block).getState(random, branchPos), 3);
        }
    }
}