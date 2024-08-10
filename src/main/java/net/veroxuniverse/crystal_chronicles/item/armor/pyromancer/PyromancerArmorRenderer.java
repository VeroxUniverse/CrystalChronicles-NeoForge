package net.veroxuniverse.crystal_chronicles.item.armor.pyromancer;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class PyromancerArmorRenderer extends GeoArmorRenderer<PyromancerArmor> {
    public PyromancerArmorRenderer() {
        super(new PyromancerArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
