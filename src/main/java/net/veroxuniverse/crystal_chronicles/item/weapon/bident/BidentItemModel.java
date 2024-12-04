package net.veroxuniverse.crystal_chronicles.item.weapon.bident;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class BidentItemModel extends GeoModel<CCBidentItem> {
    @Override
    public ResourceLocation getModelResource(CCBidentItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/lightning_bident.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CCBidentItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/item/lightning_bident.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CCBidentItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
