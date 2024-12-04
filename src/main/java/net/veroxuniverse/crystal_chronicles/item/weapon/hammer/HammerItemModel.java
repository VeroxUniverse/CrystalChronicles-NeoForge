package net.veroxuniverse.crystal_chronicles.item.weapon.hammer;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class HammerItemModel extends GeoModel<CCHammerItem> {
    @Override
    public ResourceLocation getModelResource(CCHammerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/ice_hammer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCHammerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/ice_hammer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCHammerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
