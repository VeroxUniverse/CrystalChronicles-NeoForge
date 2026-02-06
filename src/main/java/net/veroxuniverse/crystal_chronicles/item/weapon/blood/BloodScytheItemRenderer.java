package net.veroxuniverse.crystal_chronicles.item.weapon.blood;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class BloodScytheItemRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "geo/weapon/blood_scythe.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "textures/weapon/blood_scythe.png"
    );

    public BloodScytheItemRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        //.addRenderLayer(new AzBlockAndItemLayer<>())
                        .build()
        );
    }
}