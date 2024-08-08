package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalChronicles.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB_BLOCKS = CREATIVE_MODE_TABS.register("cc_tab_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blocks." + CrystalChronicles.MODID))
            .icon(() -> CCBlocks.LUNARITE_CLUSTER.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CCBlocks.BLOODSTONE_CLUSTER.get());
                output.accept(CCBlocks.BLOODSTONE_BLOCK.get());
                output.accept(CCBlocks.BLOODSTONE_BUDDING.get());
                output.accept(CCBlocks.VOIDSTONE_CLUSTER.get());
                output.accept(CCBlocks.VOIDSTONE_BLOCK.get());
                output.accept(CCBlocks.VOIDSTONE_BUDDING.get());
                output.accept(CCBlocks.LUNARITE_CLUSTER.get());
                output.accept(CCBlocks.LUNARITE_BLOCK.get());
                output.accept(CCBlocks.LUNARITE_BUDDING.get());
                output.accept(CCBlocks.CELESTITE_CLUSTER.get());
                output.accept(CCBlocks.CELESTITE_BLOCK.get());
                output.accept(CCBlocks.CELESTITE_BUDDING.get());
                output.accept(CCBlocks.TOXITE_CLUSTER.get());
                output.accept(CCBlocks.TOXITE_BLOCK.get());
                output.accept(CCBlocks.TOXITE_BUDDING.get());
                output.accept(CCBlocks.PYRONITE_CLUSTER.get());
                output.accept(CCBlocks.PYRONITE_BLOCK.get());
                output.accept(CCBlocks.PYRONITE_BUDDING.get());
                output.accept(CCBlocks.SHALE.get());
                output.accept(CCBlocks.INFECTED_SHALE.get());
                output.accept(CCBlocks.MAGNETITE.get());
                output.accept(CCBlocks.HEMATITE.get());
                output.accept(CCBlocks.MARBLE.get());
                output.accept(CCBlocks.BLUE_MUSHROOM.get());
                output.accept(CCBlocks.BLUE_VINES.get());
                output.accept(CCBlocks.PURPLE_MUSHROOM.get());
                output.accept(CCBlocks.PURPLE_GRASS.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB_ITEMS = CREATIVE_MODE_TABS.register("cc_tab_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.items." + CrystalChronicles.MODID))
            .icon(() -> CCItems.LUNARITE_SHARD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CCItems.BLOODSTONE_SHARD.get());
                output.accept(CCItems.VOIDSTONE_SHARD.get());
                output.accept(CCItems.LUNARITE_SHARD.get());
                output.accept(CCItems.CELESTITE_SHARD.get());
                output.accept(CCItems.TOXITE_SHARD.get());
                output.accept(CCItems.PYRONITE_SHARD.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB_ARMORY = CREATIVE_MODE_TABS.register("cc_tab_armory", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.armory." + CrystalChronicles.MODID))
            .icon(() -> CCItems.PALADIN_SWORD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CCItems.PALADIN_HELMET.get());
                output.accept(CCItems.PALADIN_CHESTPLATE.get());
                output.accept(CCItems.PALADIN_LEGGINGS.get());
                output.accept(CCItems.PALADIN_BOOTS.get());
                output.accept(CCItems.PALADIN_SWORD.get());
                output.accept(CCItems.PALADIN_SHIELD.get());
                output.accept(CCItems.TANK_HELMET.get());
                output.accept(CCItems.TANK_CHESTPLATE.get());
                output.accept(CCItems.TANK_LEGGINGS.get());
                output.accept(CCItems.TANK_BOOTS.get());
                output.accept(CCItems.SWORD.get());
                output.accept(CCItems.MAGE_HELMET.get());
                output.accept(CCItems.MAGE_CHESTPLATE.get());
                output.accept(CCItems.MAGE_LEGGINGS.get());
                output.accept(CCItems.MAGE_BOOTS.get());
                output.accept(CCItems.STAFF.get());
                output.accept(CCItems.ROGUE_HELMET.get());
                output.accept(CCItems.ROGUE_CHESTPLATE.get());
                output.accept(CCItems.ROGUE_LEGGINGS.get());
                output.accept(CCItems.ROGUE_BOOTS.get());
                output.accept(CCItems.GREATSWORD.get());
                output.accept(CCItems.CHAKRAM.get());
                output.accept(CCItems.SPEAR.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
