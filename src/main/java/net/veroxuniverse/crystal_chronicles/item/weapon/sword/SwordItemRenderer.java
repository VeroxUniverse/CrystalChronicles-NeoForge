package net.veroxuniverse.crystal_chronicles.item.weapon.sword;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.CCChakramItem;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.ChakramItemModel;

public class SwordItemRenderer extends GeoItemRenderer<CCSwordItem> {
    public SwordItemRenderer() {
        super(new SwordItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
