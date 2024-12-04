package net.veroxuniverse.crystal_chronicles.item.weapon.scythe;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.CCChakramItem;

public class ScytheItemModel extends GeoModel<CCScytheItem> {
    @Override
    public ResourceLocation getModelResource(CCScytheItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/blood_scythe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCScytheItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/blood_scythe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCScytheItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
