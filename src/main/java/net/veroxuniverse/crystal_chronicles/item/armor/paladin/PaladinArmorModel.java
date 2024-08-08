package net.veroxuniverse.crystal_chronicles.item.armor.paladin;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class PaladinArmorModel extends GeoModel<PaladinArmor> {
    @Override
    public ResourceLocation getModelResource(PaladinArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/paladin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PaladinArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/paladin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PaladinArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
