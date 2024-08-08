package net.veroxuniverse.crystal_chronicles.item.armor.mage;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class MageArmorRenderer extends GeoArmorRenderer<MageArmor> {
    public MageArmorRenderer() {
        super(new MageArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
