package net.veroxuniverse.crystal_chronicles.item.weapon.hammer;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class HammerItemRenderer extends GeoItemRenderer<CCHammerItem> {
    public HammerItemRenderer() {
        super(new HammerItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
