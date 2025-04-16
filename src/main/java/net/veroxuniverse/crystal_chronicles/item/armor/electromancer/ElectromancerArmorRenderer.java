package net.veroxuniverse.crystal_chronicles.item.armor.electromancer;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class ElectromancerArmorRenderer extends GeoArmorRenderer<ElectromancerArmor> {
    public ElectromancerArmorRenderer() {
        super(new ElectromancerArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
