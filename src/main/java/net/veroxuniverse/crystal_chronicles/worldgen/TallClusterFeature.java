package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.block.TallSulphurClusterBlock;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class TallClusterFeature
        extends Feature<NoneFeatureConfiguration> {

    public TallClusterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos lowerPos = context.origin();
        BlockPos upperPos = lowerPos.above();

        if (!level.getBlockState(lowerPos).canBeReplaced()) {
            return false;
        }

        if (!level.getBlockState(upperPos).canBeReplaced()) {
            return false;
        }

        BlockState state = CCBlocks.TALL_SULPHUR_CLUSTER.get()
                .defaultBlockState();

        BlockState lowerState = state.setValue(
                TallSulphurClusterBlock.HALF,
                DoubleBlockHalf.LOWER
        );

        BlockState upperState = state.setValue(
                TallSulphurClusterBlock.HALF,
                DoubleBlockHalf.UPPER
        );

        level.setBlock(
                lowerPos,
                lowerState,
                Block.UPDATE_CLIENTS
        );

        level.setBlock(
                upperPos,
                upperState,
                Block.UPDATE_CLIENTS
        );

        return true;
    }
}