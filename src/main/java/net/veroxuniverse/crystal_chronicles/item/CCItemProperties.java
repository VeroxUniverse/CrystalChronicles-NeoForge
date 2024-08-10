package net.veroxuniverse.crystal_chronicles.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

@OnlyIn(Dist.CLIENT)
public class CCItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(
                CCItems.PALADIN_SHIELD.get(),
                ResourceLocation.withDefaultNamespace("blocking"),
                (p_174575_, p_174576_, p_174577_, p_174578_) -> p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F
        );
    }
}
