package net.veroxuniverse.crystal_chronicles.item.weapon.bident;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class BidentItemRenderer extends GeoItemRenderer<CCBidentItem> {
    public BidentItemRenderer() {
        super(new BidentItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
