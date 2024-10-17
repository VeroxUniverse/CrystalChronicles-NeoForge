package net.veroxuniverse.crystal_chronicles.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class MuscleUtils {
    public static double getDripstoneHeight(double pRadius, double pMaxRadius, double pScale, double pMinRadius) {
        if (pRadius < pMinRadius) {
            pRadius = pMinRadius;
        }

        double d0 = 0.384;
        double d1 = pRadius / pMaxRadius * 0.384;
        double d2 = 0.75 * Math.pow(d1, 1.3333333333333333);
        double d3 = Math.pow(d1, 0.6666666666666666);
        double d4 = 0.3333333333333333 * Math.log(d1);
        double d5 = pScale * (d2 - d3 - d4);
        d5 = Math.max(d5, 0.0);
        return d5 / 0.384 * pMaxRadius;
    }

    public static boolean isCircleMostlyEmbeddedInStone(WorldGenLevel pLevel, BlockPos pPos, int pRadius) {
        if (isEmptyOrWaterOrLava(pLevel, pPos)) {
            return false;
        } else {
            float f = 6.0F;
            float f1 = 6.0F / (float)pRadius;

            for (float f2 = 0.0F; f2 < (float) (Math.PI * 2); f2 += f1) {
                int i = (int)(Mth.cos(f2) * (float)pRadius);
                int j = (int)(Mth.sin(f2) * (float)pRadius);
                if (isEmptyOrWaterOrLava(pLevel, pPos.offset(i, 0, j))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isEmptyOrWater(LevelAccessor pLevel, BlockPos pPos) {
        return pLevel.isStateAtPosition(pPos, MuscleUtils::isEmptyOrWater);
    }

    public static boolean isEmptyOrWaterOrLava(LevelAccessor pLevel, BlockPos pPos) {
        return pLevel.isStateAtPosition(pPos, MuscleUtils::isEmptyOrWaterOrLava);
    }


    protected static boolean placeMuscleBlockIfPossible(LevelAccessor pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos);
        if (blockstate.is(CCBlocks.FLESH_BLOCK.get())) {
            pLevel.setBlock(pPos, CCBlocks.MUSCLE_BLOCK.get().defaultBlockState(), 2);
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMuscleBaseOrLava(BlockState pState) {
        return isMuscleBase(pState) || pState.is(Blocks.LAVA);
    }

    public static boolean isMuscleBase(BlockState pState) {
        return pState.is(CCBlocks.MUSCLE_BLOCK.get()) || pState.is(CCBlocks.FLESH_BLOCK.get());
    }

    public static boolean isEmptyOrWater(BlockState p_159665_) {
        return p_159665_.isAir() || p_159665_.is(Blocks.WATER);
    }

    public static boolean isNeitherEmptyNorWater(BlockState pState) {
        return !pState.isAir() && !pState.is(Blocks.WATER);
    }

    public static boolean isEmptyOrWaterOrLava(BlockState p_159667_) {
        return p_159667_.isAir() || p_159667_.is(Blocks.WATER) || p_159667_.is(Blocks.LAVA);
    }
}
