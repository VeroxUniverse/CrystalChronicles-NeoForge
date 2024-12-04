package net.veroxuniverse.crystal_chronicles.item.weapon.scythe;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class ScytheItemRenderer extends GeoItemRenderer<CCScytheItem> {
    public ScytheItemRenderer() {
        super(new ScytheItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
