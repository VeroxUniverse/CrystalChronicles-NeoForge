package net.veroxuniverse.crystal_chronicles.entity.client.CrystalScorpion;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.api.client.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalScorpionEntity;

public class CrystalScorpionRenderer extends GeoEntityRenderer<CrystalScorpionEntity> {
    public CrystalScorpionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalScorpionModel());
        this.shadowRadius = 1.0f;
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public void render(CrystalScorpionEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalScorpionEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/entity/crystal_scorpion.png");
    }

}
