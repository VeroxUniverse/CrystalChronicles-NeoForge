package net.veroxuniverse.crystal_chronicles.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class CloudPatchFeature extends Feature<NoneFeatureConfiguration> {

    public CloudPatchFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        BlockPos.MutableBlockPos pos = context.origin().mutable();

        boolean foundFloor = false;

        for (int i = 0; i < 16; i++) {
            BlockState floorState = level.getBlockState(pos);
            BlockState aboveState = level.getBlockState(pos.above());

            if (isValidFloor(floorState) && aboveState.isAir()) {
                foundFloor = true;
                break;
            }

            pos.move(0, -1, 0);
        }

        if (!foundFloor) {
            return false;
        }

        BlockPos center = pos.immutable();
        int radius = 2 + random.nextInt(3);

        boolean placedAny = false;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                double distanceSquared = dx * dx + dz * dz;

                double edgeNoise = 0.75D + random.nextDouble() * 0.5D;
                double maximumDistance = radius * radius * edgeNoise;

                if (distanceSquared > maximumDistance) {
                    continue;
                }

                BlockPos target = center.offset(dx, 0, dz);

                BlockState floorState = level.getBlockState(target);
                BlockState aboveState = level.getBlockState(target.above());
                BlockState belowState = level.getBlockState(target.below());

                if (!isValidFloor(floorState)) {
                    continue;
                }

                if (!aboveState.isAir()) {
                    continue;
                }

                if (!belowState.isSolidRender(level, target.below())) {
                    continue;
                }

                level.setBlock(
                        target,
                        CCBlocks.CLOUD_LAYER.get().defaultBlockState(),
                        2
                );

                placedAny = true;
            }
        }

        return placedAny;
    }

    private boolean isValidFloor(BlockState state) {
        return state.is(CCBlocks.HOLY_MARBLE.get());
    }
}