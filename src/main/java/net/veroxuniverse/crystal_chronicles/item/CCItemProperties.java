package net.veroxuniverse.crystal_chronicles.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCDataComponents;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

@OnlyIn(Dist.CLIENT)
public class CCItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(
                CCItems.HOLY_SHIELD.get(),
                ResourceLocation.withDefaultNamespace("blocking"),
                (stack, level, entity, seed) ->
                        entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
        );

        ItemProperties.register(
                CCItems.DIFFRACTION_RING.get(),
                ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "spell_school"),
                (stack, level, entity, seed) -> {
                    String school = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");
                    return switch (school) {
                        case "fire" -> 1.0f;
                        case "ice" -> 2.0f;
                        case "lightning" -> 3.0f;
                        case "holy" -> 4.0f;
                        case "ender" -> 5.0f;
                        case "blood" -> 6.0f;
                        case "evocation" -> 7.0f;
                        case "nature" -> 8.0f;
                        default -> 0.0f;
                    };
                }
        );
    }
}