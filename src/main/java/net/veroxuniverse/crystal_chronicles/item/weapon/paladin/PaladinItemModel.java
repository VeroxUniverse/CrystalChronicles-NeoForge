package net.veroxuniverse.crystal_chronicles.item.weapon.paladin;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class PaladinItemModel extends GeoModel<CCPaladinItem> {
    @Override
    public ResourceLocation getModelResource(CCPaladinItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/paladin_sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCPaladinItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/paladin_sword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCPaladinItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
