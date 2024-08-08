package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.armor.mage.MageArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.paladin.PaladinArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.rogue.RogueArmor;
import net.veroxuniverse.crystal_chronicles.item.armor.tank.TankArmor;

import java.util.function.Supplier;

public class CCItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CrystalChronicles.MODID);

    // RESOURCES

    public static final DeferredItem<Item> BLOODSTONE_SHARD = ITEMS.registerSimpleItem("bloodstone_shard");
    public static final DeferredItem<Item> VOIDSTONE_SHARD = ITEMS.registerSimpleItem("voidstone_shard");
    public static final DeferredItem<Item> LUNARITE_SHARD = ITEMS.registerSimpleItem("lunarite_shard");
    public static final DeferredItem<Item> CELESTITE_SHARD = ITEMS.registerSimpleItem("celestite_shard");
    public static final DeferredItem<Item> TOXITE_SHARD = ITEMS.registerSimpleItem("toxite_shard");
    public static final DeferredItem<Item> PYRONITE_SHARD = ITEMS.registerSimpleItem("pyronite_shard");

    // ARMOR

    public static final DeferredHolder<Item, PaladinArmor> PALADIN_HELMET = ITEMS.register(
            "paladin_helmet",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_CHESTPLATE = ITEMS.register(
            "paladin_chestplate",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_LEGGINGS = ITEMS.register(
            "paladin_leggings",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, PaladinArmor> PALADIN_BOOTS = ITEMS.register(
            "paladin_boots",
            () -> new PaladinArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, TankArmor> TANK_HELMET = ITEMS.register(
            "tank_helmet",
            () -> new TankArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, TankArmor> TANK_CHESTPLATE = ITEMS.register(
            "tank_chestplate",
            () -> new TankArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, TankArmor> TANK_LEGGINGS = ITEMS.register(
            "tank_leggings",
            () -> new TankArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, TankArmor> TANK_BOOTS = ITEMS.register(
            "tank_boots",
            () -> new TankArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_HELMET = ITEMS.register(
            "rogue_helmet",
            () -> new RogueArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_CHESTPLATE = ITEMS.register(
            "rogue_chestplate",
            () -> new RogueArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_LEGGINGS = ITEMS.register(
            "rogue_leggings",
            () -> new RogueArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, RogueArmor> ROGUE_BOOTS = ITEMS.register(
            "rogue_boots",
            () -> new RogueArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, MageArmor> MAGE_HELMET = ITEMS.register(
            "mage_helmet",
            () -> new MageArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, MageArmor> MAGE_CHESTPLATE = ITEMS.register(
            "mage_chestplate",
            () -> new MageArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, MageArmor> MAGE_LEGGINGS = ITEMS.register(
            "mage_leggings",
            () -> new MageArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, MageArmor> MAGE_BOOTS = ITEMS.register(
            "mage_boots",
            () -> new MageArmor(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    // WEAPONS
    public static final Supplier<SwordItem> PALADIN_SWORD = ITEMS.register("paladin_sword",
            () -> new SwordItem(
            Tiers.DIAMOND,
            new Item.Properties().attributes(
                    SwordItem.createAttributes(
                            Tiers.DIAMOND,
                            3,
                            -2.4f
                            )
            )
    ));
    public static final DeferredItem<ShieldItem> PALADIN_SHIELD = ITEMS.register("paladin_shield",
            () -> new ShieldItem(new Item.Properties()));
    public static final Supplier<SwordItem> SWORD = ITEMS.register("sword",
            () -> new SwordItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    Tiers.DIAMOND,
                                    3,
                                    -2.4f
                            )
                    )
            ));
    public static final Supplier<TridentItem> CHAKRAM = ITEMS.register("chakram",
            () -> new TridentItem(
                    //Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    Tiers.DIAMOND,
                                    3,
                                    -2.4f
                            )
                    )
            ));
    public static final Supplier<SwordItem> SPEAR = ITEMS.register("spear",
            () -> new SwordItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    Tiers.DIAMOND,
                                    3,
                                    -2.4f
                            )
                    )
            ));
    public static final Supplier<SwordItem> STAFF = ITEMS.register("staff",
            () -> new SwordItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    Tiers.DIAMOND,
                                    3,
                                    -2.4f
                            )
                    )
            ));
    public static final Supplier<SwordItem> GREATSWORD = ITEMS.register("greatsword",
            () -> new SwordItem(
                    Tiers.DIAMOND,
                    new Item.Properties().attributes(
                            SwordItem.createAttributes(
                                    Tiers.DIAMOND,
                                    3,
                                    -2.4f
                            )
                    )
            ));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
