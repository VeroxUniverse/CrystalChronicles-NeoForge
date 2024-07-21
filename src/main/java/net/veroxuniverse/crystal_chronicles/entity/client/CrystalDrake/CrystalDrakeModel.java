package net.veroxuniverse.crystal_chronicles.entity.client.CrystalDrake;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.client.model.data.EntityModelData;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalDrakeEntity;

public class CrystalDrakeModel extends GeoModel<CrystalDrakeEntity> {

    @Override
    public ResourceLocation getModelResource(CrystalDrakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/crystal_drake.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalDrakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_drake_red2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalDrakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/crystal_drake.animation.json");
    }

    @Override
    public void setCustomAnimations(CrystalDrakeEntity animatable, long instanceId, AnimationState<CrystalDrakeEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head_1");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
