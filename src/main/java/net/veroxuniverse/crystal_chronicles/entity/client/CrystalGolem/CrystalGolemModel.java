package net.veroxuniverse.crystal_chronicles.entity.client.CrystalGolem;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalGolemEntity;

public class CrystalGolemModel extends GeoModel<CrystalGolemEntity> {

    @Override
    public ResourceLocation getModelResource(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/crystal_golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_golem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/crystal_golem.animation.json");
    }

}
