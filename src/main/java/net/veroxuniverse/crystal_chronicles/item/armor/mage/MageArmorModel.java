package net.veroxuniverse.crystal_chronicles.item.armor.mage;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class MageArmorModel extends GeoModel<MageArmor> {
    @Override
    public ResourceLocation getModelResource(MageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/mage.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/mage.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MageArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
