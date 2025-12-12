/*package net.veroxuniverse.crystal_chronicles.entity.client;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.DimensionalRiftEntity;
import org.jetbrains.annotations.NotNull;

public class DimensionalRiftEntityAnimator extends AzEntityAnimator<DimensionalRiftEntity> {

    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "animations/dimensionalrift.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<DimensionalRiftEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(DimensionalRiftEntity animatable) {
        return ANIMATIONS;
    }
}

 */
