package net.veroxuniverse.crystal_chronicles.item.armor.tank;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class TankArmorRenderer extends GeoArmorRenderer<TankArmor> {
    public TankArmorRenderer() {
        super(new TankArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
