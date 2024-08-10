package net.veroxuniverse.crystal_chronicles.item.weapon.greatsword;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class GreatswordItemModel extends GeoModel<CCGreatswordItem> {
    @Override
    public ResourceLocation getModelResource(CCGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/greatsword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/greatsword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
