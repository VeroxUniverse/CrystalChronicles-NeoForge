package net.veroxuniverse.crystal_chronicles.item.armor.rogue;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;

public class RogueArmorRenderer extends GeoArmorRenderer<RogueArmor> {
    public RogueArmorRenderer() {
        super(new RogueArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
