package net.veroxuniverse.crystal_chronicles.item.weapon.bident;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class BidentItemRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "geo/lightning_bident.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "textures/item/lightning_bident.png"
    );

    public BidentItemRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        //.addRenderLayer(new AzBlockAndItemLayer<>())
                        .build()
        );
    }
}