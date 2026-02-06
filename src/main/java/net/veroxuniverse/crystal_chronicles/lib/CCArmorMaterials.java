package net.veroxuniverse.crystal_chronicles.lib;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
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

    public static final Holder<ArmorMaterial> BLOOD =
            ARMOR_MATERIALS.register("blood", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.HEMALITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "blood"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> ENDER =
            ARMOR_MATERIALS.register("ender", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "ender"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> LIGHTNING =
            ARMOR_MATERIALS.register("lightning", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.VOLTITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "lightning"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> HOLY =
            ARMOR_MATERIALS.register("holy", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.DIVINITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "holy"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> NATURE =
            ARMOR_MATERIALS.register("nature", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.FLORALITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "nature"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> FIRE =
            ARMOR_MATERIALS.register("fire", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.VOLCANITE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "fire"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> ICE =
            ARMOR_MATERIALS.register("ice", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(CCItems.ICE_SHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "ice"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> EVOCATION =
            ARMOR_MATERIALS.register("evocation", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 5);
                        map.put(ArmorItem.Type.LEGGINGS, 8);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 5);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Items.TOTEM_OF_UNDYING),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "evocation"))),
                    3, 0.2F));
    public static final Holder<ArmorMaterial> PRISMATIC =
            ARMOR_MATERIALS.register("PRISMATIC", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 6);
                        map.put(ArmorItem.Type.LEGGINGS, 9);
                        map.put(ArmorItem.Type.CHESTPLATE, 12);
                        map.put(ArmorItem.Type.HELMET, 6);
                    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(ItemRegistry.DIVINE_SOULSHARD.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "prismatic"))),
                    3, 0.2F));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}