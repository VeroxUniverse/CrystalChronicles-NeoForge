package net.veroxuniverse.crystal_chronicles.item.paladin;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;

public class PaladinArmorRenderer extends GeoArmorRenderer<PaladinArmor> {
    public PaladinArmorRenderer() {
        super(new PaladinArmorModel());
    }
}
