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

    private static final int MIN_STEM_HEIGHT = 2;
    private static final int MAX_STEM_HEIGHT = 4;

    private static final int MIN_BRANCH_LENGTH = 3;
    private static final int MAX_BRANCH_LENGTH = 6;

    private static final int MAX_BRANCH_DEPTH = 3;          // wie tief Unteräste gehen dürfen
    private static final float SUB_BRANCH_CHANCE = 0.25f;   // Chance für Unterast
    private static final float DIR_SHIFT_CHANCE   = 0.2f;   // Chance, die horizontale Richtung zu wechseln
    private static final float UP_DRIFT_CHANCE    = 0.4f;   // Chance, beim Wachsen einen Block hochzugehen

    private static final int MAX_NEIGHBOR_CONNECTIONS = 3;  // begrenzt Klumpen
    private static final float SIDE_CAP_CHANCE = 0.6f;      // Wahrscheinlichkeit für seitliche Capillaries

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

        int stemHeight = MIN_STEM_HEIGHT + random.nextInt(MAX_STEM_HEIGHT - MIN_STEM_HEIGHT + 1);
        BlockPos stemPos = origin;

        for (int i = 0; i < stemHeight; i++) {
            BlockState baseState = CCBlocks.ARTREE_BASE.get().defaultBlockState();
            level.setBlock(stemPos, baseState, 3);
            veinPositions.add(stemPos);

            stemPos = stemPos.above();
        }

        BlockPos stemTop = stemPos;

        for (int y = 0; y < stemHeight; y++) {
            BlockPos branchStart = origin.above(y);
            int branchCount = 1 + random.nextInt(3);

            for (int i = 0; i < branchCount; i++) {
                growBranch(level, random, branchStart, veinPositions, capillaryPositions, 0);
            }
        }

        if (random.nextBoolean()) {
            growBranch(level, random, stemTop, veinPositions, capillaryPositions, 0);
        }

        for (BlockPos pos : veinPositions) {
            BlockState state = level.getBlockState(pos);
            if (state.is(CCBlocks.ARTREE_VEIN.get()) || state.is(CCBlocks.ARTREE_BASE.get())) {
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

    private void growBranch(WorldGenLevel level, RandomSource random, BlockPos start, Set<BlockPos> veins, Set<BlockPos> caps, int depth) {

        if (depth > MAX_BRANCH_DEPTH) {
            return;
        }

        int length = MIN_BRANCH_LENGTH + random.nextInt(MAX_BRANCH_LENGTH - MIN_BRANCH_LENGTH + 1);
        BlockPos current = start;

        Direction mainDir = randomHorizontal(random);

        for (int i = 0; i < length; i++) {

            if (random.nextFloat() < UP_DRIFT_CHANCE) {
                current = current.above();
            }

            current = current.relative(mainDir);

            if (!level.isEmptyBlock(current)) {
                break;
            }

            boolean isLastSegment = (i == length - 1);

            if (isLastSegment) {
                placeCapillaryCluster(level, random, current, veins, caps);
            } else {
                BlockState veinState = CCBlocks.ARTREE_VEIN.get().defaultBlockState();
                level.setBlock(current, veinState, 3);
                veins.add(current);

                if (random.nextFloat() < SUB_BRANCH_CHANCE) {
                    growBranch(level, random, current, veins, caps, depth + 1);
                }
            }

            if (random.nextFloat() < DIR_SHIFT_CHANCE) {
                mainDir = randomHorizontal(random);
            }
        }
    }

    private void placeCapillaryCluster(WorldGenLevel level, RandomSource random, BlockPos veinPos, Set<BlockPos> veins, Set<BlockPos> caps) {

        if (level.isEmptyBlock(veinPos)) {
            BlockState veinState = CCBlocks.ARTREE_VEIN.get().defaultBlockState();
            level.setBlock(veinPos, veinState, 3);
            veins.add(veinPos);
        }

        BlockPos upPos = veinPos.above();
        if (canPlaceCapillaryAt(level, upPos)) {
            placeCapillary(level, upPos, caps);
        }

        Direction[] horizontals = new Direction[]{
                Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST
        };

        for (Direction dir : horizontals) {
            if (random.nextFloat() > SIDE_CAP_CHANCE) continue;

            BlockPos sidePos = veinPos.relative(dir);

            if (!canPlaceCapillaryAt(level, sidePos)) continue;

            placeCapillary(level, sidePos, caps);

            if (random.nextFloat() < 0.3f) {
                BlockPos sideUp = sidePos.above();
                if (canPlaceCapillaryAt(level, sideUp)) {
                    placeCapillary(level, sideUp, caps);
                }
            }
        }
    }

    private void placeCapillary(WorldGenLevel level, BlockPos pos, Set<BlockPos> caps) {
        BlockState capState = CCBlocks.ARTREE_CAPILLARY.get().defaultBlockState();
        level.setBlock(pos, capState, 3);
        caps.add(pos);
    }

    private boolean canPlaceCapillaryAt(WorldGenLevel level, BlockPos pos) {
        if (!level.isEmptyBlock(pos)) {
            return false;
        }

        int neighborArtreeCount = countArtreeNeighbors(level, pos);
        return neighborArtreeCount <= MAX_NEIGHBOR_CONNECTIONS;
    }

    private int countArtreeNeighbors(WorldGenLevel level, BlockPos pos) {
        int count = 0;
        for (Direction dir : Direction.values()) {
            BlockPos nPos = pos.relative(dir);
            BlockState nState = level.getBlockState(nPos);
            if (isArtreeBlock(nState)) {
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

    private Direction randomHorizontal(RandomSource rnd) {
        Direction[] d = {
                Direction.NORTH, Direction.SOUTH,
                Direction.EAST, Direction.WEST
        };
        return d[rnd.nextInt(d.length)];
    }
}
