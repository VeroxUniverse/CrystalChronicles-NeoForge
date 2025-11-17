package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.block.FleshBlock;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class SkinLayerFeature extends Feature<NoneFeatureConfiguration> {

    public SkinLayerFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        RandomSource random = ctx.random();
        BlockPos origin = ctx.origin();

        int radius = 2 + random.nextInt(2);
        boolean placedSomething = false;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {

                BlockPos pos = origin.offset(dx, 0, dz);
                BlockPos below = pos.below();

                if (!level.isEmptyBlock(pos)) {
                    continue;
                }

                BlockState belowState = level.getBlockState(below);

                if (!(belowState.getBlock() instanceof FleshBlock)) {
                    continue;
                }

                BlockState skinState = CCBlocks.SKIN_LAYER.get().defaultBlockState();
                level.setBlock(pos, skinState, Block.UPDATE_ALL);

                if (belowState.hasProperty(FleshBlock.HAS_SKIN_ABOVE)
                        && !belowState.getValue(FleshBlock.HAS_SKIN_ABOVE)) {

                    level.setBlock(
                            below,
                            belowState.setValue(FleshBlock.HAS_SKIN_ABOVE, true),
                            Block.UPDATE_ALL
                    );
                }

                placedSomething = true;
            }
        }

        return placedSomething;
    }

}
