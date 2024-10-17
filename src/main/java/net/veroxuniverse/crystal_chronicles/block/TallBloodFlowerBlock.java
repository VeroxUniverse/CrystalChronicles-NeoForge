package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.util.CCTags;

public class TallBloodFlowerBlock extends TallFlowerBlock {

    public TallBloodFlowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(CCTags.Blocks.CC_BLOOD_BLOCK);
    }

}
