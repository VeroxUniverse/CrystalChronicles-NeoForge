package net.veroxuniverse.crystal_chronicles.entity.client.CrystalScorpion;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.client.model.data.EntityModelData;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalScorpionEntity;

public class CrystalScorpionModel extends GeoModel<CrystalScorpionEntity> {

    @Override
    public ResourceLocation getModelResource(CrystalScorpionEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/crystal_scorpion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalScorpionEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_scorpion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalScorpionEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/crystal_scorpion.animation.json");
    }

    @Override
    public void setCustomAnimations(CrystalScorpionEntity animatable, long instanceId, AnimationState<CrystalScorpionEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
