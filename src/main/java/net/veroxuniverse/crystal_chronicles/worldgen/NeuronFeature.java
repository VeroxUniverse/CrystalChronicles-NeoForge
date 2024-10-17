package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class NeuronFeature extends Feature<NoneFeatureConfiguration> {

    public NeuronFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos startPos = context.origin();

        BlockPos abovePos = startPos.above();
        BlockState blockAbove = world.getBlockState(abovePos);

        if (!blockAbove.is(CCBlocks.FLESH_BLOCK.get())) {
            return false;
        }

        int chance = context.random().nextInt(100);
        int axonCount;

        if (chance < 85) {
            axonCount = 2 + context.random().nextInt(5);
        } else {
            axonCount = 2 + context.random().nextInt(9);
        }

        BlockPos currentPos = startPos;
        BlockPos lastAxonPos = null;

        for (int i = 0; i < axonCount; i++) {
            BlockState axonBlockState = CCBlocks.AXON.get().defaultBlockState();

            if (world.isEmptyBlock(currentPos)) {
                world.setBlock(currentPos, axonBlockState, 3);
                world.scheduleTick(currentPos, CCBlocks.AXON.get(), 1);

                lastAxonPos = currentPos;
            } else {
                break;
            }

            currentPos = currentPos.below();
        }

        BlockPos neuronPos = (lastAxonPos != null) ? currentPos : startPos.below();
        BlockState neuronBlockState = CCBlocks.NEURON_BLOCK.get().defaultBlockState();

        if (world.isEmptyBlock(neuronPos)) {
            world.setBlock(neuronPos, neuronBlockState, 3);
            world.scheduleTick(neuronPos, CCBlocks.NEURON_BLOCK.get(), 1);
        }

        return true;
    }

}