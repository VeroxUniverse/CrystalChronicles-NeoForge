package net.veroxuniverse.crystal_chronicles.entity.client.CrystalGolem;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalGolemEntity;

public class CrystalGolemRenderer extends GeoEntityRenderer<CrystalGolemEntity> {
    public CrystalGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalGolemModel());
        this.shadowRadius = 0.4f;
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public void render(CrystalGolemEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_golem.png");
    }

}
