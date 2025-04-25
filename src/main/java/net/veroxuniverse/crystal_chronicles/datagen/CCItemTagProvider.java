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

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CCItemTagProvider extends ItemTagsProvider {
    public CCItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(Tags.Items.ARMORS)
                .add(CCItems.PALADIN_BOOTS.get())
                .add(CCItems.PALADIN_LEGGINGS.get())
                .add(CCItems.PALADIN_CHESTPLATE.get())
                .add(CCItems.PALADIN_HELMET.get())
                .add(CCItems.TANK_BOOTS.get())
                .add(CCItems.TANK_LEGGINGS.get())
                .add(CCItems.TANK_CHESTPLATE.get())
                .add(CCItems.TANK_HELMET.get())
                .add(CCItems.MAGE_BOOTS.get())
                .add(CCItems.MAGE_LEGGINGS.get())
                .add(CCItems.MAGE_CHESTPLATE.get())
                .add(CCItems.MAGE_HELMET.get())
                .add(CCItems.PYROMANCER_BOOTS.get())
                .add(CCItems.PYROMANCER_LEGGINGS.get())
                .add(CCItems.PYROMANCER_CHESTPLATE.get())
                .add(CCItems.PYROMANCER_HELMET.get())
                .add(CCItems.TOXIC_BOOTS.get())
                .add(CCItems.TOXIC_LEGGINGS.get())
                .add(CCItems.TOXIC_CHESTPLATE.get())
                .add(CCItems.TOXIC_HELMET.get())
                .add(CCItems.ELECTROMANCER_BOOTS.get())
                .add(CCItems.ELECTROMANCER_LEGGINGS.get())
                .add(CCItems.ELECTROMANCER_CHESTPLATE.get())
                .add(CCItems.ELECTROMANCER_HELMET.get())
                .add(CCItems.EVOKER_BOOTS.get())
                .add(CCItems.EVOKER_LEGGINGS.get())
                .add(CCItems.EVOKER_CHESTPLATE.get())
                .add(CCItems.EVOKER_HELMET.get())
                .add(CCItems.ROGUE_BOOTS.get())
                .add(CCItems.ROGUE_LEGGINGS.get())
                .add(CCItems.ROGUE_CHESTPLATE.get())
                .add(CCItems.ROGUE_HELMET.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(CCItems.PALADIN_HELMET.get())
                .add(CCItems.TANK_HELMET.get())
                .add(CCItems.MAGE_HELMET.get())
                .add(CCItems.PYROMANCER_HELMET.get())
                .add(CCItems.TOXIC_HELMET.get())
                .add(CCItems.ELECTROMANCER_HELMET.get())
                .add(CCItems.EVOKER_HELMET.get())
                .add(CCItems.ROGUE_HELMET.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(CCItems.PALADIN_CHESTPLATE.get())
                .add(CCItems.TANK_CHESTPLATE.get())
                .add(CCItems.MAGE_CHESTPLATE.get())
                .add(CCItems.PYROMANCER_CHESTPLATE.get())
                .add(CCItems.TOXIC_CHESTPLATE.get())
                .add(CCItems.ELECTROMANCER_CHESTPLATE.get())
                .add(CCItems.EVOKER_CHESTPLATE.get())
                .add(CCItems.ROGUE_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(CCItems.PALADIN_LEGGINGS.get())
                .add(CCItems.TANK_LEGGINGS.get())
                .add(CCItems.MAGE_LEGGINGS.get())
                .add(CCItems.PYROMANCER_LEGGINGS.get())
                .add(CCItems.TOXIC_LEGGINGS.get())
                .add(CCItems.ELECTROMANCER_LEGGINGS.get())
                .add(CCItems.EVOKER_LEGGINGS.get())
                .add(CCItems.ROGUE_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(CCItems.PALADIN_BOOTS.get())
                .add(CCItems.TANK_BOOTS.get())
                .add(CCItems.MAGE_BOOTS.get())
                .add(CCItems.PYROMANCER_BOOTS.get())
                .add(CCItems.TOXIC_BOOTS.get())
                .add(CCItems.ELECTROMANCER_BOOTS.get())
                .add(CCItems.EVOKER_BOOTS.get())
                .add(CCItems.ROGUE_BOOTS.get());

        tag(ItemTags.SWORDS)
                .add(CCItems.PALADIN_SWORD.get())
                .add(CCItems.SPEAR.get())
                .add(CCItems.LIGHTNING_BIDENT.get())
                .add(CCItems.CHAKRAM.get())
                .add(CCItems.ICE_HAMMER.get())
                .add(CCItems.STAFF.get())
                .add(CCItems.EVOCATION_TWINBLADE.get())
                .add(CCItems.BLOOD_SCYTHE.get());

        tag(Tags.Items.TOOLS_SHIELD)
                .add(CCItems.PALADIN_SHIELD.get());

        tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(CCItems.PALADIN_BOOTS.get())
                .add(CCItems.PALADIN_LEGGINGS.get())
                .add(CCItems.PALADIN_CHESTPLATE.get())
                .add(CCItems.PALADIN_HELMET.get())
                .add(CCItems.TANK_BOOTS.get())
                .add(CCItems.TANK_LEGGINGS.get())
                .add(CCItems.TANK_CHESTPLATE.get())
                .add(CCItems.TANK_HELMET.get())
                .add(CCItems.MAGE_BOOTS.get())
                .add(CCItems.MAGE_LEGGINGS.get())
                .add(CCItems.MAGE_CHESTPLATE.get())
                .add(CCItems.MAGE_HELMET.get())
                .add(CCItems.PYROMANCER_BOOTS.get())
                .add(CCItems.PYROMANCER_LEGGINGS.get())
                .add(CCItems.PYROMANCER_CHESTPLATE.get())
                .add(CCItems.PYROMANCER_HELMET.get())
                .add(CCItems.TOXIC_BOOTS.get())
                .add(CCItems.TOXIC_LEGGINGS.get())
                .add(CCItems.TOXIC_CHESTPLATE.get())
                .add(CCItems.TOXIC_HELMET.get())
                .add(CCItems.ROGUE_BOOTS.get())
                .add(CCItems.ROGUE_LEGGINGS.get())
                .add(CCItems.ROGUE_LEGGINGS.get())
                .add(CCItems.ROGUE_CHESTPLATE.get())
                .add(CCItems.ROGUE_HELMET.get())
                .add(CCItems.ELECTROMANCER_BOOTS.get())
                .add(CCItems.ELECTROMANCER_LEGGINGS.get())
                .add(CCItems.ELECTROMANCER_CHESTPLATE.get())
                .add(CCItems.ELECTROMANCER_HELMET.get())
                .add(CCItems.EVOKER_BOOTS.get())
                .add(CCItems.EVOKER_LEGGINGS.get())
                .add(CCItems.EVOKER_CHESTPLATE.get())
                .add(CCItems.EVOKER_HELMET.get())
                .add(CCItems.PALADIN_SHIELD.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(CCItems.PALADIN_BOOTS.get())
                .add(CCItems.PALADIN_LEGGINGS.get())
                .add(CCItems.PALADIN_CHESTPLATE.get())
                .add(CCItems.PALADIN_HELMET.get())
                .add(CCItems.TANK_BOOTS.get())
                .add(CCItems.TANK_LEGGINGS.get())
                .add(CCItems.TANK_CHESTPLATE.get())
                .add(CCItems.TANK_HELMET.get())
                .add(CCItems.MAGE_BOOTS.get())
                .add(CCItems.MAGE_LEGGINGS.get())
                .add(CCItems.MAGE_CHESTPLATE.get())
                .add(CCItems.MAGE_HELMET.get())
                .add(CCItems.PYROMANCER_BOOTS.get())
                .add(CCItems.PYROMANCER_LEGGINGS.get())
                .add(CCItems.PYROMANCER_CHESTPLATE.get())
                .add(CCItems.PYROMANCER_HELMET.get())
                .add(CCItems.TOXIC_BOOTS.get())
                .add(CCItems.TOXIC_LEGGINGS.get())
                .add(CCItems.TOXIC_CHESTPLATE.get())
                .add(CCItems.TOXIC_HELMET.get())
                .add(CCItems.ROGUE_BOOTS.get())
                .add(CCItems.ROGUE_LEGGINGS.get())
                .add(CCItems.ROGUE_LEGGINGS.get())
                .add(CCItems.ROGUE_CHESTPLATE.get())
                .add(CCItems.ROGUE_HELMET.get())
                .add(CCItems.ELECTROMANCER_BOOTS.get())
                .add(CCItems.ELECTROMANCER_LEGGINGS.get())
                .add(CCItems.ELECTROMANCER_CHESTPLATE.get())
                .add(CCItems.ELECTROMANCER_HELMET.get())
                .add(CCItems.EVOKER_BOOTS.get())
                .add(CCItems.EVOKER_LEGGINGS.get())
                .add(CCItems.EVOKER_CHESTPLATE.get())
                .add(CCItems.EVOKER_HELMET.get())
                .add(CCItems.PALADIN_SHIELD.get());

    }
    
}
