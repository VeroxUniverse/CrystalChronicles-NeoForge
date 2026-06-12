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

    private static final int LOCAL_SEARCH_UP = 2;
    private static final int LOCAL_SEARCH_DOWN = 4;

    private static final int BUILD_HEIGHT_MARGIN = 1;

    public CloudPatchFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();

        BlockPos centerFloor = findFloorBelow(
                level,
                context.origin()
        );

        if (centerFloor == null) {
            return false;
        }

        int radiusX = 2 + random.nextInt(3); // 2 bis 4
        int radiusZ = 2 + random.nextInt(3); // 2 bis 4

        boolean placedAny = false;

        BlockPos.MutableBlockPos searchPos =
                new BlockPos.MutableBlockPos();

        for (int dx = -radiusX; dx <= radiusX; dx++) {
            for (int dz = -radiusZ; dz <= radiusZ; dz++) {


                double normalizedX = dx / (double) radiusX;
                double normalizedZ = dz / (double) radiusZ;

                double distanceSquared =
                        normalizedX * normalizedX
                                + normalizedZ * normalizedZ;

                if (distanceSquared > 1.0D) {
                    continue;
                }

                if (distanceSquared > 0.55D
                        && random.nextFloat() < 0.30F) {
                    continue;
                }

                int targetX = centerFloor.getX() + dx;
                int targetZ = centerFloor.getZ() + dz;


                BlockPos floorPos = findNearbyFloor(level, searchPos, targetX, centerFloor.getY(), targetZ);

                if (floorPos == null) {
                    continue;
                }

                if (!level.ensureCanWrite(floorPos)) {
                    continue;
                }

                level.setBlock(
                        floorPos,
                        CCBlocks.CLOUD_LAYER
                                .get()
                                .defaultBlockState(),
                        2
                );

                placedAny = true;
            }
        }

        return placedAny;
    }

    private BlockPos findFloorBelow(WorldGenLevel level, BlockPos origin) {
        int minimumY =
                level.getMinBuildHeight() + BUILD_HEIGHT_MARGIN;

        int maximumY =
                level.getMaxBuildHeight() - BUILD_HEIGHT_MARGIN;

        int startY = Math.min(origin.getY(), maximumY);

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos(
                        origin.getX(),
                        startY,
                        origin.getZ()
                );

        while (pos.getY() >= minimumY) {
            if (isValidSurface(level, pos)) {
                return pos.immutable();
            }

            pos.move(0, -1, 0);
        }

        return null;
    }

    private BlockPos findNearbyFloor(WorldGenLevel level, BlockPos.MutableBlockPos mutable, int x, int centerY, int z) {
        int maximumY = Math.min(
                centerY + LOCAL_SEARCH_UP,
                level.getMaxBuildHeight()
                        - BUILD_HEIGHT_MARGIN
        );

        int minimumY = Math.max(
                centerY - LOCAL_SEARCH_DOWN,
                level.getMinBuildHeight()
                        + BUILD_HEIGHT_MARGIN
        );

        for (int y = maximumY; y >= minimumY; y--) {
            mutable.set(x, y, z);

            if (!level.ensureCanWrite(mutable)) {
                continue;
            }

            if (isValidSurface(level, mutable)) {
                return mutable.immutable();
            }
        }

        return null;
    }

    private boolean isValidSurface(WorldGenLevel level, BlockPos floorPos) {
        BlockState floorState = level.getBlockState(floorPos);

        if (!isValidFloor(floorState)) {
            return false;
        }

        BlockState aboveState =
                level.getBlockState(floorPos.above());

        if (!aboveState.isAir()) {
            return false;
        }

        BlockState belowState =
                level.getBlockState(floorPos.below());

        return !belowState.isAir()
                && belowState.getFluidState().isEmpty();
    }

    private boolean isValidFloor(BlockState state) {
        return state.is(CCBlocks.CLOUD_BLOCK.get());
    }
}