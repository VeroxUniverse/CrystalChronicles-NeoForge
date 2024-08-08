package net.veroxuniverse.crystal_chronicles.entity.client.CrystalWolf;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalWolfEntity;

public class CrystalWolfRenderer extends GeoEntityRenderer<CrystalWolfEntity> {
    public CrystalWolfRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalWolfModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public void render(CrystalWolfEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalWolfEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_wolf.png");
    }

}
