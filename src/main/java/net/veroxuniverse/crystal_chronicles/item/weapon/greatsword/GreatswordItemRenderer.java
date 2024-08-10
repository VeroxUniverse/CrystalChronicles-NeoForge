package net.veroxuniverse.crystal_chronicles.item.weapon.greatsword;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class GreatswordItemRenderer extends GeoItemRenderer<CCGreatswordItem> {
    public GreatswordItemRenderer() {
        super(new GreatswordItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
