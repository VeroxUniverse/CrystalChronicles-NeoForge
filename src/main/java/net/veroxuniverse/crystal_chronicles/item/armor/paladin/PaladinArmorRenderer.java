package net.veroxuniverse.crystal_chronicles.item.armor.paladin;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class PaladinArmorRenderer extends GeoArmorRenderer<PaladinArmor> {
    public PaladinArmorRenderer() {
        super(new PaladinArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
