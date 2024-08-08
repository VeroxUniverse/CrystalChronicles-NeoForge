package net.veroxuniverse.crystal_chronicles.entity.client.CrystalWolf;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.client.model.data.EntityModelData;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalWolfEntity;

public class CrystalWolfModel extends GeoModel<CrystalWolfEntity> {

    @Override
    public ResourceLocation getModelResource(CrystalWolfEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/crystal_wolf.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalWolfEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_wolf.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalWolfEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/crystal_wolf.animation.json");
    }
}
