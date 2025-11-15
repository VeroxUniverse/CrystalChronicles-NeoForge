package net.veroxuniverse.crystal_chronicles.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.block.entity.HolyLightBlockEntity;
import net.veroxuniverse.crystal_chronicles.registry.CCBlockEntities;
import org.jetbrains.annotations.Nullable;

public class HolyLightBlock extends BaseEntityBlock {

    public static final MapCodec<HolyLightBlock> CODEC = simpleCodec(HolyLightBlock::new);

    public HolyLightBlock(Properties props) {
        super(props);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HolyLightBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    /*

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return null;
        }

        return type == CCBlockEntities.HOLY_LIGHT_BE.get()
                ? (lvl, pos, st, be) -> {
            if (be instanceof HolyLightBlockEntity lightBe) {
                HolyLightBlockEntity.serverTick(lvl, pos, st, lightBe);
            }
        }
                : null;
    }

     */
}
