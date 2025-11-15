package net.veroxuniverse.crystal_chronicles.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.crystal_chronicles.registry.CCBlockEntities;

public class HolyLightBlockEntity extends BlockEntity {

    private static final TagKey<Block> GLASS =
            BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass"));
    private static final TagKey<Block> GLASS_PANES =
            BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass_panes"));
    private static final TagKey<Block> TRANSPARENT =
            BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "transparent"));

    private int beamLength = 0;

    public HolyLightBlockEntity(BlockPos pos, BlockState state) {
        super(CCBlockEntities.HOLY_LIGHT_BE.get(), pos, state);
    }

    public int getBeamLength() {
        return beamLength;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, HolyLightBlockEntity be) {
        int old = be.beamLength;
        int length = 0;
        boolean blocked = false;

        for (int i = 1; i <= 3; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);

            if (blocked) break;

            boolean isAllowedTransparent =
                    belowState.isAir()
                            || belowState.is(GLASS)
                            || belowState.is(GLASS_PANES)
                            || belowState.is(TRANSPARENT);

            if (!isAllowedTransparent) {
                blocked = true;
                break;
            }

            if (belowState.isAir()) {
                length++;
            }
        }

        if (old != length) {
            be.beamLength = length;
            be.setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
            System.out.println("HolyLight serverTick at " + pos + " -> length = " + length);
        }
    }
}
