package net.veroxuniverse.crystal_chronicles.item.armor.evoker;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class EvokerArmorModel extends GeoModel<EvokerArmor> {
    @Override
    public ResourceLocation getModelResource(EvokerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/evoker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EvokerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/evoker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EvokerArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
