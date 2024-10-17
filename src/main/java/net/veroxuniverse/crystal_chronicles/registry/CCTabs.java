package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;

public class CCTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalChronicles.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB_BLOCKS = CREATIVE_MODE_TABS.register("cc_tab_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blocks." + CrystalChronicles.MODID))
            .icon(() -> CCBlocks.FAT_TISSUE_BLOCK.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CCBlocks.BLOOD_BASES.get());
                output.accept(CCBlocks.TALL_BLOOD_BASES.get());
                output.accept(CCBlocks.FLESH_BLOCK.get());
                output.accept(CCBlocks.MUSCLE_BLOCK.get());
                output.accept(CCBlocks.ALVEOLUS_BLOCK.get());
                output.accept(CCBlocks.FAT_TISSUE_BLOCK.get());
                output.accept(CCBlocks.ARTREE_BASE.get());
                output.accept(CCBlocks.ARTREE_VEIN.get());
                output.accept(CCBlocks.ARTREE_CAPILLARY.get());
                output.accept(CCBlocks.NEURON_BLOCK.get());
                output.accept(CCBlocks.AXON.get());
                output.accept(CCItems.NEURON_TORCH_ITEM.get());
                output.accept(CCBlocks.BRONCHUS.get());
                output.accept(CCBlocks.BRONCHUS_PLANKS.get());
                output.accept(CCBlocks.BRONCHUS_STAIRS.get());
                output.accept(CCBlocks.BRONCHUS_SLAB.get());
                output.accept(CCBlocks.BRONCHUS_FENCE.get());
                output.accept(CCBlocks.BRONCHUS_FENCE_GATE.get());
                output.accept(CCBlocks.BRONCHUS_BUTTON.get());
                output.accept(CCBlocks.BRONCHUS_PRESSURE_PLATE.get());
                output.accept(CCBlocks.BRONCHUS_DOOR.get());
                output.accept(CCBlocks.BRONCHUS_TRAPDOOR.get());
                output.accept(CCBlocks.CRUSTONE.get());
                output.accept(CCBlocks.CRUSTONE_BRICKS.get());
                output.accept(CCBlocks.CRACKED_CRUSTONE_BRICKS.get());
                output.accept(CCBlocks.POLISHED_CRUSTONE.get());
                output.accept(CCBlocks.CHISELED_CRUSTONE.get());
                output.accept(CCBlocks.EYE_BLOCK.get());
                output.accept(CCBlocks.CELVER_LIGHT.get());
                output.accept(CCBlocks.SKIN_LAYER.get());
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
                output.accept(CCItems.FAT_TISSUE_BALL.get());
                output.accept(CCItems.NEURON.get());
                output.accept(CCItems.EYE.get());
                output.accept(CCFluids.BLOOD_BUCKET.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB_ARMORY = CREATIVE_MODE_TABS.register("cc_tab_armory", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.armory." + CrystalChronicles.MODID))
            .icon(() -> CCItems.PALADIN_HELMET.get().getDefaultInstance())
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
                output.accept(CCItems.PYROMANCER_HELMET.get());
                output.accept(CCItems.PYROMANCER_CHESTPLATE.get());
                output.accept(CCItems.PYROMANCER_LEGGINGS.get());
                output.accept(CCItems.PYROMANCER_BOOTS.get());
                output.accept(CCItems.CHAKRAM.get());
                output.accept(CCItems.TOXIC_HELMET.get());
                output.accept(CCItems.TOXIC_CHESTPLATE.get());
                output.accept(CCItems.TOXIC_LEGGINGS.get());
                output.accept(CCItems.TOXIC_BOOTS.get());
                output.accept(CCItems.SPEAR.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
