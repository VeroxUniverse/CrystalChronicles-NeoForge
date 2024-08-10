package net.veroxuniverse.crystal_chronicles.item.weapon.staff;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class StaffItemModel extends GeoModel<CCStaffItem> {
    @Override
    public ResourceLocation getModelResource(CCStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/staff.animation.json");
    }
}
