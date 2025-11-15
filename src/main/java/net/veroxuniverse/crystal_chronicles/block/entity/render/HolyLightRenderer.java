package net.veroxuniverse.crystal_chronicles.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.entity.HolyLightBlockEntity;

public class HolyLightRenderer implements BlockEntityRenderer<HolyLightBlockEntity> {

    private final BlockRenderDispatcher dispatcher;

    private static final ResourceLocation MODEL_SEG1_RL =
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_1");
    private static final ResourceLocation MODEL_SEG2_RL =
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_2");
    private static final ResourceLocation MODEL_SEG3_RL =
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_3");

    private static final ModelResourceLocation MODEL_SEG1_MRL =
            ModelResourceLocation.standalone(MODEL_SEG1_RL);
    private static final ModelResourceLocation MODEL_SEG2_MRL =
            ModelResourceLocation.standalone(MODEL_SEG2_RL);
    private static final ModelResourceLocation MODEL_SEG3_MRL =
            ModelResourceLocation.standalone(MODEL_SEG3_RL);

    public HolyLightRenderer(BlockEntityRendererProvider.Context ctx) {
        this.dispatcher = Minecraft.getInstance().getBlockRenderer();
    }

    @Override
    public void render(HolyLightBlockEntity be, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        var level = be.getLevel();
        if (level == null) return;

        BlockPos pos = be.getBlockPos();
        BlockState state = be.getBlockState();

        int length = 0;
        for (int i = 1; i <= 3; i++) {
            BlockPos belowPos = pos.below(i);
            BlockState belowState = level.getBlockState(belowPos);

            boolean isAllowedTransparent =
                    belowState.isAir()
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass")))
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "glass_panes")))
                            || belowState.is(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "transparent")));

            if (!isAllowedTransparent) {
                break;
            }

            if (belowState.isAir()) {
                length++;
            }
        }

        if (length <= 0) {
            return;
        }

        var modelManager = Minecraft.getInstance().getModelManager();
        BakedModel seg1 = modelManager.getModel(MODEL_SEG1_MRL);
        BakedModel seg2 = modelManager.getModel(MODEL_SEG2_MRL);
        BakedModel seg3 = modelManager.getModel(MODEL_SEG3_MRL);

        poseStack.pushPose();

        for (int i = 1; i <= length; i++) {
            poseStack.pushPose();
            poseStack.translate(0.0D, -i, 0.0D);

            BakedModel segModel = switch (i) {
                case 1 -> seg1;
                case 2 -> seg2;
                case 3 -> seg3;
                default -> null;
            };

            if (segModel != null) {
                dispatcher.getModelRenderer().renderModel(
                        poseStack.last(),
                        buffer.getBuffer(RenderType.translucent()),
                        state,
                        segModel,
                        1.0F, 1.0F, 1.0F,
                        packedLight,
                        packedOverlay
                );
            }

            poseStack.popPose();
        }

        poseStack.popPose();
    }

    @Override
    public AABB getRenderBoundingBox(HolyLightBlockEntity be) {
        BlockPos pos = be.getBlockPos();
        return new AABB(
                pos.getX() - 0.5,
                pos.getY() - 3.5,
                pos.getZ() - 0.5,
                pos.getX() + 1.5,
                pos.getY() + 1.5,
                pos.getZ() + 1.5
        );
    }
}
