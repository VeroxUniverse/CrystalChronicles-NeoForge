package net.veroxuniverse.crystal_chronicles.item.weapon.staff;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class StaffItemRenderer extends GeoItemRenderer<CCStaffItem> {
    public StaffItemRenderer() {
        super(new StaffItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
