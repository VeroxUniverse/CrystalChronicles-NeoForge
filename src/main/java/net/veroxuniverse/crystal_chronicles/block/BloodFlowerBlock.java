package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.util.CCTags;

public class BloodFlowerBlock extends BushBlock {

    public static final MapCodec<BloodFlowerBlock> CODEC = simpleCodec(BloodFlowerBlock::new);

    public BloodFlowerBlock(Properties properties) {
        super(properties);
    }

    public MapCodec<BloodFlowerBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(CCTags.Blocks.CC_BLOOD_BLOCK);
    }

}
