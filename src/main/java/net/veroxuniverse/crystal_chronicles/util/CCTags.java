package net.veroxuniverse.crystal_chronicles.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCTags {

    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_CRYSTAL_TOOL = createTag("incorrect_for_crystal_tool");
        public static final TagKey<Block> NEEDS_CRYSTAL_TOOL = createTag("needs_crystal_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, name));
        }
    }

}
