package net.veroxuniverse.crystal_chronicles.item.armor.pyromancer;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class PyromancerArmorModel extends GeoModel<PyromancerArmor> {
    @Override
    public ResourceLocation getModelResource(PyromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/pyromancer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PyromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/pyromancer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PyromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
