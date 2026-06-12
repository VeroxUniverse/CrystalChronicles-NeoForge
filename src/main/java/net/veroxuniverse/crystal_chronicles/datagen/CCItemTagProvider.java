package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.util.CCTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CCItemTagProvider extends ItemTagsProvider {
    public CCItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(CCTags.Items.ARMORS)
                .add(CCItems.HOLY_KNIGHT_BOOTS.get())
                .add(CCItems.HOLY_KNIGHT_LEGGINGS.get())
                .add(CCItems.HOLY_KNIGHT_CHESTPLATE.get())
                .add(CCItems.HOLY_KNIGHT_HELMET.get())
                .add(CCItems.ICE_KNIGHT_BOOTS.get())
                .add(CCItems.ICE_KNIGHT_LEGGINGS.get())
                .add(CCItems.ICE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.ICE_KNIGHT_HELMET.get())
                .add(CCItems.ENDER_MAGE_BOOTS.get())
                .add(CCItems.ENDER_MAGE_LEGGINGS.get())
                .add(CCItems.ENDER_MAGE_CHESTPLATE.get())
                .add(CCItems.ENDER_MAGE_HELMET.get())
                .add(CCItems.FIRE_KNIGHT_BOOTS.get())
                .add(CCItems.FIRE_KNIGHT_LEGGINGS.get())
                .add(CCItems.FIRE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.FIRE_KNIGHT_HELMET.get())
                .add(CCItems.NATURE_KNIGHT_BOOTS.get())
                .add(CCItems.NATURE_KNIGHT_LEGGINGS.get())
                .add(CCItems.NATURE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.NATURE_KNIGHT_HELMET.get())
                .add(CCItems.LIGHTNING_KNIGHT_BOOTS.get())
                .add(CCItems.LIGHTNING_KNIGHT_LEGGINGS.get())
                .add(CCItems.LIGHTNING_KNIGHT_CHESTPLATE.get())
                .add(CCItems.LIGHTNING_KNIGHT_HELMET.get())
                .add(CCItems.EVOCATION_KNIGHT_BOOTS.get())
                .add(CCItems.EVOCATION_KNIGHT_LEGGINGS.get())
                .add(CCItems.EVOCATION_KNIGHT_CHESTPLATE.get())
                .add(CCItems.EVOCATION_KNIGHT_HELMET.get())
                .add(CCItems.BLOOD_KNIGHT_BOOTS.get())
                .add(CCItems.BLOOD_KNIGHT_LEGGINGS.get())
                .add(CCItems.BLOOD_KNIGHT_CHESTPLATE.get())
                .add(CCItems.BLOOD_KNIGHT_HELMET.get())
                .add(CCItems.PRISMATIC_KNIGHT_BOOTS.get())
                .add(CCItems.PRISMATIC_KNIGHT_LEGGINGS.get())
                .add(CCItems.PRISMATIC_KNIGHT_CHESTPLATE.get())
                .add(CCItems.PRISMATIC_KNIGHT_HELMET.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(CCItems.HOLY_KNIGHT_HELMET.get())
                .add(CCItems.ICE_KNIGHT_HELMET.get())
                .add(CCItems.ENDER_MAGE_HELMET.get())
                .add(CCItems.FIRE_KNIGHT_HELMET.get())
                .add(CCItems.NATURE_KNIGHT_HELMET.get())
                .add(CCItems.LIGHTNING_KNIGHT_HELMET.get())
                .add(CCItems.EVOCATION_KNIGHT_HELMET.get())
                .add(CCItems.BLOOD_KNIGHT_HELMET.get())
                .add(CCItems.PRISMATIC_KNIGHT_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(CCItems.HOLY_KNIGHT_CHESTPLATE.get())
                .add(CCItems.ICE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.ENDER_MAGE_CHESTPLATE.get())
                .add(CCItems.FIRE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.NATURE_KNIGHT_CHESTPLATE.get())
                .add(CCItems.LIGHTNING_KNIGHT_CHESTPLATE.get())
                .add(CCItems.EVOCATION_KNIGHT_CHESTPLATE.get())
                .add(CCItems.BLOOD_KNIGHT_CHESTPLATE.get())
                .add(CCItems.PRISMATIC_KNIGHT_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(CCItems.HOLY_KNIGHT_LEGGINGS.get())
                .add(CCItems.ICE_KNIGHT_LEGGINGS.get())
                .add(CCItems.ENDER_MAGE_LEGGINGS.get())
                .add(CCItems.FIRE_KNIGHT_LEGGINGS.get())
                .add(CCItems.NATURE_KNIGHT_LEGGINGS.get())
                .add(CCItems.LIGHTNING_KNIGHT_LEGGINGS.get())
                .add(CCItems.EVOCATION_KNIGHT_LEGGINGS.get())
                .add(CCItems.BLOOD_KNIGHT_LEGGINGS.get())
                .add(CCItems.PRISMATIC_KNIGHT_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(CCItems.HOLY_KNIGHT_BOOTS.get())
                .add(CCItems.ICE_KNIGHT_BOOTS.get())
                .add(CCItems.ENDER_MAGE_BOOTS.get())
                .add(CCItems.FIRE_KNIGHT_BOOTS.get())
                .add(CCItems.NATURE_KNIGHT_BOOTS.get())
                .add(CCItems.LIGHTNING_KNIGHT_BOOTS.get())
                .add(CCItems.EVOCATION_KNIGHT_BOOTS.get())
                .add(CCItems.BLOOD_KNIGHT_BOOTS.get())
                .add(CCItems.PRISMATIC_KNIGHT_BOOTS.get());

        tag(ItemTags.SWORDS)
                .add(CCItems.HOLY_SWORD.get())
                .add(CCItems.NATURE_SPEAR.get())
                .add(CCItems.LIGHTNING_BIDENT.get())
                .add(CCItems.FIRE_CHAKRAM.get())
                .add(CCItems.ICE_HAMMER.get())
                .add(CCItems.ENDER_STAFF.get())
                .add(CCItems.EVOCATION_TWINBLADE.get())
                .add(CCItems.BLOOD_SCYTHE.get());

        tag(Tags.Items.GEMS)
                .add(CCItems.AVARICITE_SHARD.get())
                .add(CCItems.ICE_SHARD.get())
                .add(CCItems.VOLTITE_SHARD.get())
                .add(CCItems.DIVINITE_SHARD.get())
                .add(CCItems.VOLCANITE_SHARD.get())
                .add(CCItems.VOIDSTONE_SHARD.get())
                .add(CCItems.HEMALITE_SHARD.get())
                .add(CCItems.FLORALITE_SHARD.get());

        tag(Tags.Items.TOOLS_SHIELD)
                .add(CCItems.HOLY_SHIELD.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(CCItems.HOLY_SHIELD.get());

        tag(CCTags.Items.STAFF)
                .add(CCItems.LIGHTNING_STAFF.get())
                .add(CCItems.ENDER_STAFF.get());

    }
    
}
