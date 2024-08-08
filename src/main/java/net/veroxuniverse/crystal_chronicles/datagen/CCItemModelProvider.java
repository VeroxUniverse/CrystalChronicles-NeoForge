package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

public class CCItemModelProvider extends ItemModelProvider {
    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CCItems.TANK_HELMET.get());
        basicItem(CCItems.TANK_CHESTPLATE.get());
        basicItem(CCItems.TANK_LEGGINGS.get());
        basicItem(CCItems.TANK_BOOTS.get());
        basicItem(CCItems.ROGUE_HELMET.get());
        basicItem(CCItems.ROGUE_CHESTPLATE.get());
        basicItem(CCItems.ROGUE_LEGGINGS.get());
        basicItem(CCItems.ROGUE_BOOTS.get());
        basicItem(CCItems.MAGE_HELMET.get());
        basicItem(CCItems.MAGE_CHESTPLATE.get());
        basicItem(CCItems.MAGE_LEGGINGS.get());
        basicItem(CCItems.MAGE_BOOTS.get());
        basicItem(CCItems.PALADIN_HELMET.get());
        basicItem(CCItems.PALADIN_CHESTPLATE.get());
        basicItem(CCItems.PALADIN_LEGGINGS.get());
        basicItem(CCItems.PALADIN_BOOTS.get());
        basicItem(CCItems.BLOODSTONE_SHARD.get());
        basicItem(CCItems.VOIDSTONE_SHARD.get());
        basicItem(CCItems.LUNARITE_SHARD.get());
        basicItem(CCItems.CELESTITE_SHARD.get());
        basicItem(CCItems.TOXITE_SHARD.get());
        basicItem(CCItems.PYRONITE_SHARD.get());
        
    }
}
