package net.veroxuniverse.crystal_chronicles.item.weapon.chakram;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class ChakramItemModel extends GeoModel<CCChakramItem> {
    @Override
    public ResourceLocation getModelResource(CCChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/chakram.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/chakram.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
