package net.veroxuniverse.crystal_chronicles.item.armor.electromancer;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.armor.evoker.EvokerArmor;

public class ElectromancerArmorModel extends GeoModel<ElectromancerArmor> {
    @Override
    public ResourceLocation getModelResource(ElectromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/electromancer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ElectromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/electromancer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ElectromancerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
