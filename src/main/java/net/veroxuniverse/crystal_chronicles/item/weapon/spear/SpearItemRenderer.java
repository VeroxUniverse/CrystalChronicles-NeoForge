package net.veroxuniverse.crystal_chronicles.item.weapon.spear;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class SpearItemRenderer extends GeoItemRenderer<CCSpearItem> {
    public SpearItemRenderer() {
        super(new SpearItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
