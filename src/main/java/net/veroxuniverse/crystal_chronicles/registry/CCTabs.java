package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalChronicles.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CC_TAB = CREATIVE_MODE_TABS.register("cc_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + CrystalChronicles.MODID))
            .icon(() -> CCBlocks.ROSE_CLUSTER_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CCBlocks.ROSE_CLUSTER_ITEM.get());
                output.accept(CCItems.PALADIN_HELMET.get());
                output.accept(CCItems.PALADIN_CHESTPLATE.get());
                output.accept(CCItems.PALADIN_LEGGINGS.get());
                output.accept(CCItems.PALADIN_BOOTS.get());
            }).build());

}
