package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class HolyLightFeature extends Feature<NoneFeatureConfiguration> {

    public HolyLightFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();

        BlockState holyLight = CCBlocks.HOLY_LIGHT_BLOCK.get().defaultBlockState();

        if (!level.getBlockState(origin).canBeReplaced()) {
            return false;
        }

        return level.setBlock(
                origin,
                holyLight,
                Block.UPDATE_CLIENTS
        );
    }
}