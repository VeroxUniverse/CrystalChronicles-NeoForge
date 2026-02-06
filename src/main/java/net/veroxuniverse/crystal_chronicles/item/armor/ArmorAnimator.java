package net.veroxuniverse.crystal_chronicles.item.armor;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import org.jetbrains.annotations.NotNull;

public class ArmorAnimator extends AzItemAnimator {

    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "animations/armor/empty.animation.json");

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}
