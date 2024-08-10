package net.veroxuniverse.crystal_chronicles.item.armor.toxic;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class ToxicArmorModel extends GeoModel<ToxicArmor> {
    @Override
    public ResourceLocation getModelResource(ToxicArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/toxic.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ToxicArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/toxic.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ToxicArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
