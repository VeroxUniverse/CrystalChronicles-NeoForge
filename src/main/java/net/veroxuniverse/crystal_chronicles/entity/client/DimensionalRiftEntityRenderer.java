/*package net.veroxuniverse.crystal_chronicles.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.DimensionalRiftEntity;

public class DimensionalRiftEntityRenderer extends AzEntityRenderer<DimensionalRiftEntity> {

    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "geo/dimensionalrift.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "textures/entity/dimensionalrift.png"
    );


    @Override
    public void render(DimensionalRiftEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        poseStack.pushPose();
        Direction.Axis axis = entity.getPortalAxis();
        poseStack.scale(2.0f, 2.0f, 2.0f);

        if (axis == Direction.Axis.X) {

            poseStack.mulPose(Axis.YP.rotationDegrees(90));

        }

        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    public DimensionalRiftEntityRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<DimensionalRiftEntity>builder(GEO, TEX)
                        .setAnimatorProvider(DimensionalRiftEntityAnimator::new)
                        .setShadowRadius(0.25f)
                        .build(),
                context
        );
    }

}

 */