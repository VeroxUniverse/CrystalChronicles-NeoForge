package net.veroxuniverse.crystal_chronicles.lib;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

import java.util.EnumMap;
import java.util.List;

public class CCArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, CrystalChronicles.MODID);

    public static final Holder<ArmorMaterial> BLOODSTONE =
            ARMOR_MATERIALS.register("bloodstone", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 4);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.HELMET, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.BLOODSTONE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "bloodstone"))),
                    3, 0.1F));
    public static final Holder<ArmorMaterial> VOIDSTONE =
            ARMOR_MATERIALS.register("voidstone", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "voidstone"))),
                    3, 0.1F));
    public static final Holder<ArmorMaterial> CELESTITE =
            ARMOR_MATERIALS.register("celestite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 4);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.CELESTITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "celestite"))),
                    3, 0.5F));
    public static final Holder<ArmorMaterial> LUNARITE =
            ARMOR_MATERIALS.register("lunarite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 4);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.HELMET, 4);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.LUNARITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "lunarite"))),
                    3, 0.1F));
    public static final Holder<ArmorMaterial> TOXITE =
            ARMOR_MATERIALS.register("toxite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.TOXITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "toxite"))),
                    4, 0.1F));
    public static final Holder<ArmorMaterial> PYRONITE =
            ARMOR_MATERIALS.register("pyronite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 9);
                        map.put(ArmorItem.Type.HELMET, 3);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.PYRONITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "pyronite"))),
                    2, 0.4F));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}