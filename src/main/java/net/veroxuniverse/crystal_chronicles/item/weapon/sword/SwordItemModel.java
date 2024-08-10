package net.veroxuniverse.crystal_chronicles.item.weapon.sword;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class SwordItemModel extends GeoModel<CCSwordItem> {
    @Override
    public ResourceLocation getModelResource(CCSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/sword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCSwordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
