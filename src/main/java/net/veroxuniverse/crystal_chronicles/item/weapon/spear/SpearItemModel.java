package net.veroxuniverse.crystal_chronicles.item.weapon.spear;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class SpearItemModel extends GeoModel<CCSpearItem> {
    @Override
    public ResourceLocation getModelResource(CCSpearItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/spear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCSpearItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/spear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCSpearItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
