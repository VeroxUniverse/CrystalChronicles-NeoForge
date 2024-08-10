package net.veroxuniverse.crystal_chronicles.item.weapon.paladin;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class PaladinItemRenderer extends GeoItemRenderer<CCPaladinItem> {
    public PaladinItemRenderer() {
        super(new PaladinItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
