package net.veroxuniverse.crystal_chronicles.dimension;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;

public class AlphaSpawnStructure {

    public static final BlockPos STRUCTURE_CENTER = new BlockPos(0, 60, 0);
    private static final int RADIUS = 2;

    public static void generate(ServerLevel level) {
        BlockPos center = STRUCTURE_CENTER;

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {
                level.setBlock(
                        new BlockPos(center.getX() + x, center.getY() - 1, center.getZ() + z),
                        Blocks.OBSIDIAN.defaultBlockState(), 3
                );
            }
        }

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {
                for (int y = 0; y <= 2; y++) {
                    level.setBlock(
                            new BlockPos(center.getX() + x, center.getY() + y, center.getZ() + z),
                            Blocks.AIR.defaultBlockState(), 3
                    );
                }
            }
        }
    }

    public static BlockPos getSafeSpawnPos(ServerLevel level) {
        BlockPos center = STRUCTURE_CENTER;

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {
                BlockPos candidate = new BlockPos(
                        center.getX() + x,
                        center.getY(),
                        center.getZ() + z
                );
                if (level.getBlockState(candidate).isAir()
                        && level.getBlockState(candidate.above()).isAir()) {
                    return candidate;
                }
            }
        }

        return center;
    }
}