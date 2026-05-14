package net.veroxuniverse.crystal_chronicles.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCTags {

    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_CRYSTAL_TOOL = createTag("incorrect_for_crystal_tool");
        public static final TagKey<Block> NEEDS_CRYSTAL_TOOL = createTag("needs_crystal_tool");
        public static final TagKey<Block> CC_BLOOD_BLOCK = createTag("cc_blood_block");
        public static final TagKey<Block> CC_ARTREE_BLOCK = createTag("cc_artree_block");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ARMORS = createTag("armors");
        public static final TagKey<Item> CRYSTALS = createTag("crystals");
        public static final TagKey<Item> CRYSTAL_TOOL = createTag("crystal_tool");
        public static final TagKey<Item> STAFF = createTag("staff");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, name));
        }
    }

}
