package net.veroxuniverse.crystal_chronicles.worldgen.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.veroxuniverse.crystal_chronicles.block.CapillaryBlock;
import net.veroxuniverse.crystal_chronicles.block.VeinBlock;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

import java.util.HashSet;
import java.util.Set;

public class ArtreeFeature extends Feature<NoneFeatureConfiguration> {

    private static final int MIN_STEM_HEIGHT = 3;
    private static final int MAX_STEM_HEIGHT = 5;

    private static final int MIN_BRANCH_LENGTH = 1;
    private static final int MAX_BRANCH_LENGTH = 2;
    private static final int MIN_BRANCHES = 2;
    private static final int MAX_BRANCHES = 4;
    private static final float BRANCH_CHANCE_PER_LEVEL = 0.4f;

    private static final int MIN_CAP_CLUSTER = 3;
    private static final int MAX_CAP_CLUSTER = 4;

    private static final int MAX_NEIGHBOR_ARTREE = 4;
    private static final int MAX_NEIGHBOR_CAPILLARY = 1;

    public ArtreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        RandomSource random = ctx.random();
        BlockPos origin = ctx.origin();

        if (!level.getBlockState(origin.below()).is(CCBlocks.FLESH_BLOCK.get())) {
            return false;
        }

        Set<BlockPos> veinPositions = new HashSet<>();
        Set<BlockPos> capillaryPositions = new HashSet<>();
        Set<BlockPos> capillaryCenters = new HashSet<>();

        BlockPos basePos = origin;
        BlockState baseState = CCBlocks.ARTREE_BASE.get().defaultBlockState();
        level.setBlock(basePos, baseState, 3);

        int stemHeight = MIN_STEM_HEIGHT + random.nextInt(MAX_STEM_HEIGHT - MIN_STEM_HEIGHT + 1);
        BlockPos stemPos = basePos.above();
        BlockPos topStemPos = stemPos;

        Direction[] horiz = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};

        int maxBranches = MIN_BRANCHES + random.nextInt(MAX_BRANCHES - MIN_BRANCHES + 1);
        int madeBranches = 0;

        for (int y = 0; y < stemHeight; y++) {
            if (!level.isEmptyBlock(stemPos)) {
                break;
            }

            BlockState stemVein = CCBlocks.ARTREE_VEIN.get().defaultBlockState();
            level.setBlock(stemPos, stemVein, 3);
            veinPositions.add(stemPos);
            topStemPos = stemPos;

            if (madeBranches < maxBranches && random.nextFloat() < BRANCH_CHANCE_PER_LEVEL) {
                Direction dir = horiz[random.nextInt(horiz.length)];
                BlockPos branchEnd = growStraightBranch(level, random, stemPos, dir, veinPositions);
                if (branchEnd != null) {
                    capillaryCenters.add(branchEnd);
                    madeBranches++;
                }
            }

            stemPos = stemPos.above();
        }

        capillaryCenters.add(topStemPos);

        for (BlockPos center : capillaryCenters) {
            placeCapillaryCluster(level, random, center, capillaryPositions);
        }

        for (BlockPos pos : veinPositions) {
            BlockState state = level.getBlockState(pos);
            if (state.is(CCBlocks.ARTREE_VEIN.get())) {
                BlockState fixed = VeinBlock.getStateWithConnections(level, pos, state);
                level.setBlock(pos, fixed, 3);
            }
        }

        for (BlockPos pos : capillaryPositions) {
            BlockState state = level.getBlockState(pos);
            if (state.is(CCBlocks.ARTREE_CAPILLARY.get())) {
                BlockState fixed = CapillaryBlock.getStateWithConnections(level, pos, state);
                level.setBlock(pos, fixed, 3);
            }
        }

        return true;
    }

    private BlockPos growStraightBranch(WorldGenLevel level, RandomSource random,
                                        BlockPos start, Direction dir,
                                        Set<BlockPos> veins) {

        int length = MIN_BRANCH_LENGTH
                + random.nextInt(MAX_BRANCH_LENGTH - MIN_BRANCH_LENGTH + 1); // 1–2

        BlockPos current = start.relative(dir);
        BlockPos lastPlaced = null;

        for (int i = 0; i < length; i++) {
            if (!level.isEmptyBlock(current)) {
                break;
            }

            BlockState vein = CCBlocks.ARTREE_VEIN.get().defaultBlockState();
            level.setBlock(current, vein, 3);
            veins.add(current);
            lastPlaced = current;

            current = current.relative(dir);
        }

        return lastPlaced;
    }

    private void placeCapillaryCluster(WorldGenLevel level, RandomSource random,
                                       BlockPos center, Set<BlockPos> caps) {

        int count = MIN_CAP_CLUSTER + random.nextInt(MAX_CAP_CLUSTER - MIN_CAP_CLUSTER + 1);

        Direction[] dirs = {
                Direction.UP,
                Direction.NORTH, Direction.SOUTH,
                Direction.EAST, Direction.WEST
        };

        for (int i = 0; i < count; i++) {
            Direction d = dirs[random.nextInt(dirs.length)];
            BlockPos capPos = center.relative(d);

            if (canPlaceCapillaryAt(level, capPos)) {
                placeCapillary(level, capPos, caps);

                if (d == Direction.UP && random.nextFloat() < 0.4f) {
                    BlockPos up2 = capPos.above();
                    if (canPlaceCapillaryAt(level, up2)) {
                        placeCapillary(level, up2, caps);
                    }
                }
            }
        }
    }

    private void placeCapillary(WorldGenLevel level, BlockPos pos, Set<BlockPos> caps) {
        BlockState cap = CCBlocks.ARTREE_CAPILLARY.get().defaultBlockState();
        level.setBlock(pos, cap, 3);
        caps.add(pos);
    }

    private boolean canPlaceCapillaryAt(WorldGenLevel level, BlockPos pos) {
        if (!level.isEmptyBlock(pos)) {
            return false;
        }

        int artreeNeighbors = countArtreeNeighbors(level, pos);
        if (artreeNeighbors > MAX_NEIGHBOR_ARTREE) {
            return false;
        }

        int capNeighbors = countCapillaryNeighbors(level, pos);
        return capNeighbors <= MAX_NEIGHBOR_CAPILLARY;
    }

    private int countArtreeNeighbors(WorldGenLevel level, BlockPos pos) {
        int count = 0;
        for (Direction d : Direction.values()) {
            BlockPos nPos = pos.relative(d);
            BlockState nState = level.getBlockState(nPos);
            if (isArtreeBlock(nState)) {
                count++;
            }
        }
        return count;
    }

    private int countCapillaryNeighbors(WorldGenLevel level, BlockPos pos) {
        int count = 0;
        for (Direction d : Direction.values()) {
            BlockPos nPos = pos.relative(d);
            BlockState nState = level.getBlockState(nPos);
            if (nState.is(CCBlocks.ARTREE_CAPILLARY.get())) {
                count++;
            }
        }
        return count;
    }

    private boolean isArtreeBlock(BlockState state) {
        return state.is(CCBlocks.ARTREE_BASE.get())
                || state.is(CCBlocks.ARTREE_VEIN.get())
                || state.is(CCBlocks.ARTREE_CAPILLARY.get());
    }
}
