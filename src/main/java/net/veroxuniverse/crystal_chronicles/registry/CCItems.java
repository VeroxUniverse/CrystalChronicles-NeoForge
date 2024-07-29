package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.paladin.PaladinArmor;

public class CCItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CrystalChronicles.MODID);


    public static final DeferredHolder<Item, PaladinArmor> PALADIN_HELMET = ITEMS.register(
            "paladin_helmet",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_CHESTPLATE = ITEMS.register(
            "paladin_chestplate",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_LEGGINGS = ITEMS.register(
            "paladin_leggings",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_BOOTS = ITEMS.register(
            "paladin_boots",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

}
