package net.veroxuniverse.crystal_chronicles.worldgen.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class BronchusTreeFeature extends Feature<TreeConfiguration> {

    public BronchusTreeFeature(Codec<TreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        TreeConfiguration config = context.config();

        if (!isValidGround(world, pos.below())) {
            return false;
        }

        int trunkHeight = 4 + random.nextInt(4);

        for (int y = 0; y < trunkHeight; y++) {
            BlockPos trunkPos = pos.above(y);
            world.setBlock(trunkPos, config.trunkProvider.getState(random, trunkPos), 3);
        }

        placeRandomFoliage(world, pos.above(trunkHeight), random, config);

        return true;
    }

    private void placeRandomFoliage(WorldGenLevel world, BlockPos topPos, RandomSource random, TreeConfiguration config) {
        int chance = random.nextInt(100);

        if (chance < 30) {
            place3x3CubeWithPlus(world, topPos, random, config);
        } else {
            placeLeafLayers(world, topPos, random, config);
        }
    }

    private void placeLeafLayers(WorldGenLevel world, BlockPos topPos, RandomSource random, TreeConfiguration config) {
        placePlusShape(world, topPos, random, config);
        place3x3Square(world, topPos.above(1), random, config);
        placePlusShape(world, topPos.above(2), random, config);
    }

    private void placePlusShape(WorldGenLevel world, BlockPos centerPos, RandomSource random, TreeConfiguration config) {
        world.setBlock(centerPos, config.foliageProvider.getState(random, centerPos), 3);
        world.setBlock(centerPos.north(), config.foliageProvider.getState(random, centerPos.north()), 3);
        world.setBlock(centerPos.south(), config.foliageProvider.getState(random, centerPos.south()), 3);
        world.setBlock(centerPos.east(), config.foliageProvider.getState(random, centerPos.east()), 3);
        world.setBlock(centerPos.west(), config.foliageProvider.getState(random, centerPos.west()), 3);
    }

    private void place3x3Square(WorldGenLevel world, BlockPos centerPos, RandomSource random, TreeConfiguration config) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos foliagePos = centerPos.offset(dx, 0, dz);
                world.setBlock(foliagePos, config.foliageProvider.getState(random, foliagePos), 3);
            }
        }
    }

    private void place3x3CubeWithPlus(WorldGenLevel world, BlockPos centerPos, RandomSource random, TreeConfiguration config) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos foliagePos = centerPos.offset(dx, dy, dz);
                    world.setBlock(foliagePos, config.foliageProvider.getState(random, foliagePos), 3);
                }
            }
        }

        placeRotatedPlus(world, centerPos.above(2), random, config, 'Y');   // Oben
        placeRotatedPlus(world, centerPos.below(2), random, config, 'Y');   // Unten
        placeRotatedPlus(world, centerPos.north(2), random, config, 'Z');   // Vorne (Norden)
        placeRotatedPlus(world, centerPos.south(2), random, config, 'Z');   // Hinten (Süden)
        placeRotatedPlus(world, centerPos.east(2), random, config, 'X');    // Rechts (Osten)
        placeRotatedPlus(world, centerPos.west(2), random, config, 'X');    // Links (Westen)
    }

    private void placeRotatedPlus(WorldGenLevel world, BlockPos centerPos, RandomSource random, TreeConfiguration config, char axis) {
        world.setBlock(centerPos, config.foliageProvider.getState(random, centerPos), 3);

        switch (axis) {
            case 'X':
                world.setBlock(centerPos.above(), config.foliageProvider.getState(random, centerPos.above()), 3);
                world.setBlock(centerPos.below(), config.foliageProvider.getState(random, centerPos.below()), 3);
                world.setBlock(centerPos.north(), config.foliageProvider.getState(random, centerPos.north()), 3);
                world.setBlock(centerPos.south(), config.foliageProvider.getState(random, centerPos.south()), 3);
                break;
            case 'Y':
                world.setBlock(centerPos.east(), config.foliageProvider.getState(random, centerPos.east()), 3);
                world.setBlock(centerPos.west(), config.foliageProvider.getState(random, centerPos.west()), 3);
                world.setBlock(centerPos.north(), config.foliageProvider.getState(random, centerPos.north()), 3);
                world.setBlock(centerPos.south(), config.foliageProvider.getState(random, centerPos.south()), 3);
                break;
            case 'Z':
                world.setBlock(centerPos.above(), config.foliageProvider.getState(random, centerPos.above()), 3);
                world.setBlock(centerPos.below(), config.foliageProvider.getState(random, centerPos.below()), 3);
                world.setBlock(centerPos.east(), config.foliageProvider.getState(random, centerPos.east()), 3);
                world.setBlock(centerPos.west(), config.foliageProvider.getState(random, centerPos.west()), 3);
                break;
        }
    }

    private boolean isValidGround(WorldGenLevel world, BlockPos groundPos) {
        BlockState blockState = world.getBlockState(groundPos);
        return blockState.is(CCBlocks.FLESH_BLOCK);
    }
}