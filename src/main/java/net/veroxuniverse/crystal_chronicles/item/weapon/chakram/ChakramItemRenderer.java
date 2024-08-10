package net.veroxuniverse.crystal_chronicles.item.weapon.chakram;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class ChakramItemRenderer extends GeoItemRenderer<CCChakramItem> {
    public ChakramItemRenderer() {
        super(new ChakramItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
