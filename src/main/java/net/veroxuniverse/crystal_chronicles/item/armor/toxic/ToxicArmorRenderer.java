package net.veroxuniverse.crystal_chronicles.item.armor.toxic;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class ToxicArmorRenderer extends GeoArmorRenderer<ToxicArmor> {
    public ToxicArmorRenderer() {
        super(new ToxicArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
