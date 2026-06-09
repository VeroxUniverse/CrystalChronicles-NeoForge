package net.veroxuniverse.crystal_chronicles.registry;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.BismuthChiselItem;
import net.veroxuniverse.crystal_chronicles.item.armor.lightning.LightningKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.evocation.EvocationKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.ender.EnderMageArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.holy.HolyKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.fire.FireKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.blood.BloodKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.ice.IceKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.nature.NatureKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.prismatic.PrismaticKnightArmor;
import net.veroxuniverse.crystal_chronicles.item.curios.PrismaticSchoolRing;
import net.veroxuniverse.crystal_chronicles.item.weapon.AnimatedSwordItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderSickleItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.ice.IceHammerItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.lightning.LightningBidentItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.fire.FireChakramItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.holy.HolySwordItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.blood.BloodScytheItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.lightning.LightningStaffItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.nature.NatureSpearItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderStaffItem;
import net.veroxuniverse.crystal_chronicles.lib.CCArmorMaterials;
import net.veroxuniverse.crystal_chronicles.lib.CCStaffTiers;
import net.veroxuniverse.crystal_chronicles.lib.CCWeaponTiers;

public class CCItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CrystalChronicles.MODID);

    // SPELLS

    public static final DeferredItem<Item> BISMUTH_CHISEL = ITEMS.register("bismuth_chisel",
            () -> new BismuthChiselItem(new Item.Properties().stacksTo(1).durability(64)));

    // RESOURCES

    public static final DeferredItem<Item> HEMALITE_SHARD = ITEMS.registerSimpleItem("hemalite_shard");
    public static final DeferredItem<Item> VOIDSTONE_SHARD = ITEMS.registerSimpleItem("voidstone_shard");
    public static final DeferredItem<Item> DIVINITE_SHARD = ITEMS.registerSimpleItem("divinite_shard");
    public static final DeferredItem<Item> VOLTITE_SHARD = ITEMS.registerSimpleItem("voltite_shard");
    public static final DeferredItem<Item> FLORALITE_SHARD = ITEMS.registerSimpleItem("floralite_shard");
    public static final DeferredItem<Item> VOLCANITE_SHARD = ITEMS.registerSimpleItem("volcanite_shard");
    public static final DeferredItem<Item> ICE_SHARD = ITEMS.registerSimpleItem("ice_shard");
    public static final DeferredItem<Item> PERFECTED_EMERALD = ITEMS.registerSimpleItem("perfected_emerald");
    public static final DeferredItem<Item> FAT_TISSUE_BALL = ITEMS.registerSimpleItem("fat_tissue_ball");
    public static final DeferredItem<Item> NEURON = ITEMS.registerSimpleItem("neuron");
    public static final DeferredItem<Item> EYE = ITEMS.registerSimpleItem("eye");

    public static final DeferredItem<Item> BISMUTH_CANDY = ITEMS.register("bismuth_candy",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationModifier(0.3f)
                            .build()
            )));

    public static final DeferredItem<Item> NEURON_TORCH_ITEM = ITEMS.register("neuron_torch", () -> new StandingAndWallBlockItem(CCBlocks.NEURON_TORCH.get(), CCBlocks.NEURON_TORCH_WALL.get(), new Item.Properties(), Direction.DOWN));

    public static final DeferredItem<Item> CLOUD_BUCKET = ITEMS.register("cloud_bucket",
            () -> new SolidBucketItem(CCBlocks.CLOUD_LAYER.get(), SoundEvents.BUCKET_EMPTY_POWDER_SNOW,new Item.Properties().stacksTo(1)));

    // CURIOS

    // CURIOS / ACCESSORIES
    public static final DeferredItem<Item> DIFFRACTION_RING = ITEMS.register("diffraction_ring",
            () -> new PrismaticSchoolRing(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    // ARMOR

    public static final DeferredHolder<Item, HolyKnightArmor> HOLY_KNIGHT_HELMET = ITEMS.register(
            "holy_knight_helmet",
            () -> new HolyKnightArmor(CCArmorMaterials.HOLY, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, HolyKnightArmor> HOLY_KNIGHT_CHESTPLATE = ITEMS.register(
            "holy_knight_chestplate",
            () -> new HolyKnightArmor(CCArmorMaterials.HOLY, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, HolyKnightArmor> HOLY_KNIGHT_LEGGINGS = ITEMS.register(
            "holy_knight_leggings",
            () -> new HolyKnightArmor(CCArmorMaterials.HOLY, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, HolyKnightArmor> HOLY_KNIGHT_BOOTS = ITEMS.register(
            "holy_knight_boots",
            () -> new HolyKnightArmor(CCArmorMaterials.HOLY, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));
    public static final DeferredHolder<Item, IceKnightArmor> ICE_KNIGHT_HELMET = ITEMS.register(
            "ice_knight_helmet",
            () -> new IceKnightArmor(CCArmorMaterials.ICE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, IceKnightArmor> ICE_KNIGHT_CHESTPLATE = ITEMS.register(
            "ice_knight_chestplate",
            () -> new IceKnightArmor(CCArmorMaterials.ICE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, IceKnightArmor> ICE_KNIGHT_LEGGINGS = ITEMS.register(
            "ice_knight_leggings",
            () -> new IceKnightArmor(CCArmorMaterials.ICE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, IceKnightArmor> ICE_KNIGHT_BOOTS = ITEMS.register(
            "ice_knight_boots",
            () -> new IceKnightArmor(CCArmorMaterials.ICE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));
    public static final DeferredHolder<Item, BloodKnightArmor> BLOOD_KNIGHT_HELMET = ITEMS.register(
            "blood_knight_helmet",
            () -> new BloodKnightArmor(CCArmorMaterials.BLOOD, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, BloodKnightArmor> BLOOD_KNIGHT_CHESTPLATE = ITEMS.register(
            "blood_knight_chestplate",
            () -> new BloodKnightArmor(CCArmorMaterials.BLOOD, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, BloodKnightArmor> BLOOD_KNIGHT_LEGGINGS = ITEMS.register(
            "blood_knight_leggings",
            () -> new BloodKnightArmor(CCArmorMaterials.BLOOD, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, BloodKnightArmor> BLOOD_KNIGHT_BOOTS = ITEMS.register(
            "blood_knight_boots",
            () -> new BloodKnightArmor(CCArmorMaterials.BLOOD, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));
    public static final DeferredHolder<Item, EnderMageArmor> ENDER_MAGE_HELMET = ITEMS.register(
            "ender_mage_helmet",
            () -> new EnderMageArmor(CCArmorMaterials.ENDER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, EnderMageArmor> ENDER_MAGE_CHESTPLATE = ITEMS.register(
            "ender_mage_chestplate",
            () -> new EnderMageArmor(CCArmorMaterials.ENDER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, EnderMageArmor> ENDER_MAGE_LEGGINGS = ITEMS.register(
            "ender_mage_leggings",
            () -> new EnderMageArmor(CCArmorMaterials.ENDER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, EnderMageArmor> ENDER_MAGE_BOOTS = ITEMS.register(
            "ender_mage_boots",
            () -> new EnderMageArmor(CCArmorMaterials.ENDER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    public static final DeferredHolder<Item, FireKnightArmor> FIRE_KNIGHT_HELMET = ITEMS.register(
            "fire_knight_helmet",
            () -> new FireKnightArmor(CCArmorMaterials.FIRE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, FireKnightArmor> FIRE_KNIGHT_CHESTPLATE = ITEMS.register(
            "fire_knight_chestplate",
            () -> new FireKnightArmor(CCArmorMaterials.FIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, FireKnightArmor> FIRE_KNIGHT_LEGGINGS = ITEMS.register(
            "fire_knight_leggings",
            () -> new FireKnightArmor(CCArmorMaterials.FIRE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, FireKnightArmor> FIRE_KNIGHT_BOOTS = ITEMS.register(
            "fire_knight_boots",
            () -> new FireKnightArmor(CCArmorMaterials.FIRE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    public static final DeferredHolder<Item, NatureKnightArmor> NATURE_KNIGHT_HELMET = ITEMS.register(
            "nature_knight_helmet",
            () -> new NatureKnightArmor(CCArmorMaterials.NATURE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, NatureKnightArmor> NATURE_KNIGHT_CHESTPLATE = ITEMS.register(
            "nature_knight_chestplate",
            () -> new NatureKnightArmor(CCArmorMaterials.NATURE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, NatureKnightArmor> NATURE_KNIGHT_LEGGINGS = ITEMS.register(
            "nature_knight_leggings",
            () -> new NatureKnightArmor(CCArmorMaterials.NATURE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, NatureKnightArmor> NATURE_KNIGHT_BOOTS = ITEMS.register(
            "nature_knight_boots",
            () -> new NatureKnightArmor(CCArmorMaterials.NATURE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    public static final DeferredHolder<Item, EvocationKnightArmor> EVOCATION_KNIGHT_HELMET = ITEMS.register(
            "evocation_knight_helmet",
            () -> new EvocationKnightArmor(CCArmorMaterials.EVOCATION, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, EvocationKnightArmor> EVOCATION_KNIGHT_CHESTPLATE = ITEMS.register(
            "evocation_knight_chestplate",
            () -> new EvocationKnightArmor(CCArmorMaterials.EVOCATION, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, EvocationKnightArmor> EVOCATION_KNIGHT_LEGGINGS = ITEMS.register(
            "evocation_knight_leggings",
            () -> new EvocationKnightArmor(CCArmorMaterials.EVOCATION, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, EvocationKnightArmor> EVOCATION_KNIGHT_BOOTS = ITEMS.register(
            "evocation_knight_boots",
            () -> new EvocationKnightArmor(CCArmorMaterials.EVOCATION, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    public static final DeferredHolder<Item, LightningKnightArmor> LIGHTNING_KNIGHT_HELMET = ITEMS.register(
            "lightning_knight_helmet",
            () -> new LightningKnightArmor(CCArmorMaterials.LIGHTNING, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(53))));
    public static final DeferredHolder<Item, LightningKnightArmor> LIGHTNING_KNIGHT_CHESTPLATE = ITEMS.register(
            "lightning_knight_chestplate",
            () -> new LightningKnightArmor(CCArmorMaterials.LIGHTNING, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(53))));
    public static final DeferredHolder<Item, LightningKnightArmor> LIGHTNING_KNIGHT_LEGGINGS = ITEMS.register(
            "lightning_knight_leggings",
            () -> new LightningKnightArmor(CCArmorMaterials.LIGHTNING, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(53))));
    public static final DeferredHolder<Item, LightningKnightArmor> LIGHTNING_KNIGHT_BOOTS = ITEMS.register(
            "lightning_knight_boots",
            () -> new LightningKnightArmor(CCArmorMaterials.LIGHTNING, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(53))));

    public static final DeferredHolder<Item, PrismaticKnightArmor> PRISMATIC_KNIGHT_HELMET = ITEMS.register(
            "prismatic_knight_helmet",
            () -> new PrismaticKnightArmor(CCArmorMaterials.PRISMATIC, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PrismaticKnightArmor> PRISMATIC_KNIGHT_CHESTPLATE = ITEMS.register(
            "prismatic_knight_chestplate",
            () -> new PrismaticKnightArmor(CCArmorMaterials.PRISMATIC, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PrismaticKnightArmor> PRISMATIC_KNIGHT_LEGGINGS = ITEMS.register(
            "prismatic_knight_leggings",
            () -> new PrismaticKnightArmor(CCArmorMaterials.PRISMATIC, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PrismaticKnightArmor> PRISMATIC_KNIGHT_BOOTS = ITEMS.register(
            "prismatic_knight_boots",
            () -> new PrismaticKnightArmor(CCArmorMaterials.PRISMATIC, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));

    // WEAPONS
    public static final DeferredHolder<Item, Item> HOLY_SWORD = ITEMS.register("holy_sword",
            () -> new HolySwordItem(
                    CCWeaponTiers.HOLY_SWORD,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.HOLY_SWORD)
            ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.HEALING_CIRCLE_SPELL, 8))));
    public static final DeferredItem<ShieldItem> HOLY_SHIELD = ITEMS.register("holy_shield",
            () -> new ShieldItem(new Item.Properties().durability(1200).fireResistant()));
    public static final DeferredHolder<Item, Item> ICE_HAMMER = ITEMS.register("ice_hammer",
            () -> new IceHammerItem(
                    CCWeaponTiers.ICE_HAMMER,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.ICE_HAMMER)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FROSTWAVE_SPELL, 8))));
    public static final DeferredHolder<Item, Item> FIRE_CHAKRAM = ITEMS.register("fire_chakram",
            () -> new FireChakramItem(
                    CCWeaponTiers.FIRE_CHAKRAM,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.FIRE_CHAKRAM)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 4))));
    public static final DeferredHolder<Item, Item> NATURE_SPEAR = ITEMS.register("nature_spear",
            () -> new NatureSpearItem(CCWeaponTiers.NATURE_SPEAR,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.NATURE_SPEAR)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.POISON_SPLASH_SPELL, 8))));
    public static final DeferredHolder<Item, Item> ENDER_STAFF = ITEMS.register("ender_staff",
            () -> new EnderStaffItem(ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes(CCStaffTiers.ENDER_STAFF)).rarity(Rarity.UNCOMMON),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.MAGIC_MISSILE_SPELL, 8))));
    public static final DeferredHolder<Item, Item> ENDER_SICKLE = ITEMS.register("ender_sickle",
            () -> new EnderSickleItem(CCWeaponTiers.ENDER_SICKLE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.ENDER_SICKLE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.TELEPORT_SPELL, 3))));
    public static final DeferredHolder<Item, Item> BLOOD_SCYTHE = ITEMS.register("blood_scythe",
            () -> new BloodScytheItem(CCWeaponTiers.BLOOD_SCYTHE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.BLOOD_SCYTHE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BLOOD_SLASH_SPELL, 3))));
    public static final DeferredHolder<Item, Item> LIGHTNING_BIDENT = ITEMS.register("lightning_bident",
            () -> new LightningBidentItem(CCWeaponTiers.LIGHTNING_BIDENT,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.LIGHTNING_BIDENT)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.VOLT_STRIKE_SPELL, 8))));
    public static final DeferredHolder<Item, Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff",
            () -> new LightningStaffItem(ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes(CCStaffTiers.LIGHTNING_STAFF)).rarity(Rarity.UNCOMMON),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BALL_LIGHTNING_SPELL, 8))));

    public static final DeferredHolder<Item, Item> EVOCATION_TWINBLADE = ITEMS.register("evocation_twinblade",
            () -> new LightningBidentItem(CCWeaponTiers.EVOCATION_TWINBLADE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.EVOCATION_TWINBLADE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SHIELD_SPELL, 6))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
