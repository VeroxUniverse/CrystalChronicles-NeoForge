package net.veroxuniverse.crystal_chronicles.item.armor.evoker;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class EvokerArmorRenderer extends GeoArmorRenderer<EvokerArmor> {
    public EvokerArmorRenderer() {
        super(new EvokerArmorModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
