package net.veroxuniverse.crystal_chronicles.registry;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.armor.mage.MageArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.paladin.PaladinArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.pyromancer.PyromancerArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.rogue.RogueArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.tank.TankArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.toxic.ToxicArmor;
import net.veroxuniverse.crystal_chronicles.item.weapon.AnimatedSwordItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.CCChakramItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.greatsword.CCGreatswordItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.paladin.CCPaladinItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.spear.CCSpearItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.staff.CCStaffItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.sword.CCSwordItem;
import net.veroxuniverse.crystal_chronicles.lib.CCArmorMaterials;
import net.veroxuniverse.crystal_chronicles.lib.CCWeaponTiers;

public class CCItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CrystalChronicles.MODID);

    // RESOURCES

    public static final DeferredItem<Item> BLOODSTONE_SHARD = ITEMS.registerSimpleItem("bloodstone_shard");
    public static final DeferredItem<Item> VOIDSTONE_SHARD = ITEMS.registerSimpleItem("voidstone_shard");
    public static final DeferredItem<Item> LUNARITE_SHARD = ITEMS.registerSimpleItem("lunarite_shard");
    public static final DeferredItem<Item> CELESTITE_SHARD = ITEMS.registerSimpleItem("celestite_shard");
    public static final DeferredItem<Item> TOXITE_SHARD = ITEMS.registerSimpleItem("toxite_shard");
    public static final DeferredItem<Item> PYRONITE_SHARD = ITEMS.registerSimpleItem("pyronite_shard");
    public static final DeferredItem<Item> FAT_TISSUE_BALL = ITEMS.registerSimpleItem("fat_tissue_ball");
    public static final DeferredItem<Item> NEURON = ITEMS.registerSimpleItem("neuron");
    public static final DeferredItem<Item> EYE = ITEMS.registerSimpleItem("eye");

    public static final DeferredItem<Item> NEURON_TORCH_ITEM = ITEMS.register("neuron_torch", () -> new StandingAndWallBlockItem(CCBlocks.NEURON_TORCH.get(), CCBlocks.NEURON_TORCH_WALL.get(), new Item.Properties(), Direction.DOWN));

    // ARMOR

    public static final DeferredHolder<Item, PaladinArmor> PALADIN_HELMET = ITEMS.register(
            "paladin_helmet",
            () -> new PaladinArmor(CCArmorMaterials.LUNARITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_CHESTPLATE = ITEMS.register(
            "paladin_chestplate",
            () -> new PaladinArmor(CCArmorMaterials.LUNARITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_LEGGINGS = ITEMS.register(
            "paladin_leggings",
            () -> new PaladinArmor(CCArmorMaterials.LUNARITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_BOOTS = ITEMS.register(
            "paladin_boots",
            () -> new PaladinArmor(CCArmorMaterials.LUNARITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, TankArmor> TANK_HELMET = ITEMS.register(
            "tank_helmet",
            () -> new TankArmor(CCArmorMaterials.CELESTITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, TankArmor> TANK_CHESTPLATE = ITEMS.register(
            "tank_chestplate",
            () -> new TankArmor(CCArmorMaterials.CELESTITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, TankArmor> TANK_LEGGINGS = ITEMS.register(
            "tank_leggings",
            () -> new TankArmor(CCArmorMaterials.CELESTITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, TankArmor> TANK_BOOTS = ITEMS.register(
            "tank_boots",
            () -> new TankArmor(CCArmorMaterials.CELESTITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_HELMET = ITEMS.register(
            "rogue_helmet",
            () -> new RogueArmor(CCArmorMaterials.BLOODSTONE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_CHESTPLATE = ITEMS.register(
            "rogue_chestplate",
            () -> new RogueArmor(CCArmorMaterials.BLOODSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_LEGGINGS = ITEMS.register(
            "rogue_leggings",
            () -> new RogueArmor(CCArmorMaterials.BLOODSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_BOOTS = ITEMS.register(
            "rogue_boots",
            () -> new RogueArmor(CCArmorMaterials.BLOODSTONE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, MageArmor> MAGE_HELMET = ITEMS.register(
            "mage_helmet",
            () -> new MageArmor(CCArmorMaterials.VOIDSTONE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, MageArmor> MAGE_CHESTPLATE = ITEMS.register(
            "mage_chestplate",
            () -> new MageArmor(CCArmorMaterials.VOIDSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, MageArmor> MAGE_LEGGINGS = ITEMS.register(
            "mage_leggings",
            () -> new MageArmor(CCArmorMaterials.VOIDSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, MageArmor> MAGE_BOOTS = ITEMS.register(
            "mage_boots",
            () -> new MageArmor(CCArmorMaterials.VOIDSTONE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));

    public static final DeferredHolder<Item, PyromancerArmor> PYROMANCER_HELMET = ITEMS.register(
            "pyromancer_helmet",
            () -> new PyromancerArmor(CCArmorMaterials.PYRONITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PyromancerArmor> PYROMANCER_CHESTPLATE = ITEMS.register(
            "pyromancer_chestplate",
            () -> new PyromancerArmor(CCArmorMaterials.PYRONITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PyromancerArmor> PYROMANCER_LEGGINGS = ITEMS.register(
            "pyromancer_leggings",
            () -> new PyromancerArmor(CCArmorMaterials.PYRONITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, PyromancerArmor> PYROMANCER_BOOTS = ITEMS.register(
            "pyromancer_boots",
            () -> new PyromancerArmor(CCArmorMaterials.PYRONITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));

    public static final DeferredHolder<Item, ToxicArmor> TOXIC_HELMET = ITEMS.register(
            "toxic_helmet",
            () -> new ToxicArmor(CCArmorMaterials.TOXITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, ToxicArmor> TOXIC_CHESTPLATE = ITEMS.register(
            "toxic_chestplate",
            () -> new ToxicArmor(CCArmorMaterials.TOXITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, ToxicArmor> TOXIC_LEGGINGS = ITEMS.register(
            "toxic_leggings",
            () -> new ToxicArmor(CCArmorMaterials.TOXITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).fireResistant()));
    public static final DeferredHolder<Item, ToxicArmor> TOXIC_BOOTS = ITEMS.register(
            "toxic_boots",
            () -> new ToxicArmor(CCArmorMaterials.TOXITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).fireResistant()));



    // WEAPONS
    public static final DeferredHolder<Item, Item>  PALADIN_SWORD = ITEMS.register("paladin_sword",
            () -> new CCPaladinItem(
                    CCWeaponTiers.LUNARITE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.LUNARITE)
            ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.HEALING_CIRCLE_SPELL, 8))));
    public static final DeferredItem<ShieldItem> PALADIN_SHIELD = ITEMS.register("paladin_shield",
            () -> new ShieldItem(new Item.Properties().durability(1200).fireResistant()));
    public static final DeferredHolder<Item, Item> SWORD = ITEMS.register("sword",
            () -> new CCSwordItem(
                    CCWeaponTiers.CELESTITE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.CELESTITE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BALL_LIGHTNING_SPELL, 8))));
    public static final DeferredHolder<Item, Item> CHAKRAM = ITEMS.register("chakram",
            () -> new CCChakramItem(
                    CCWeaponTiers.PYRONITE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.PYRONITE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 4))));
    public static final DeferredHolder<Item, Item> SPEAR = ITEMS.register("spear",
            () -> new CCSpearItem(CCWeaponTiers.TOXITE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.TOXITE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.POISON_SPLASH_SPELL, 8))));
    public static final DeferredHolder<Item, Item> STAFF = ITEMS.register("staff",
            () -> new CCStaffItem(CCWeaponTiers.VOIDSTONE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.VOIDSTONE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.MAGIC_MISSILE_SPELL, 8))));
    public static final DeferredHolder<Item, Item> GREATSWORD = ITEMS.register("greatsword",
            () -> new CCGreatswordItem(CCWeaponTiers.BLOODSTONE,
                    ItemPropertiesHelper.equipment(1).attributes(AnimatedSwordItem.createAttributes((IronsWeaponTier) CCWeaponTiers.BLOODSTONE)
                    ).fireResistant(),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BLOOD_SLASH_SPELL, 3))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
