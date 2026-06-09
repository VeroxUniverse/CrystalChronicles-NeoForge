package net.veroxuniverse.crystal_chronicles.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.util.RaycastBuilder;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.veroxuniverse.crystal_chronicles.spells.PrismaticPortalSpell;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class PrismaticLaserBeamRenderer {

    private static final ResourceLocation BEACON =
            ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "textures/entity/ray/beacon_beam.png");
    private static final ResourceLocation TWISTING_GLOW =
            ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "textures/entity/ray/twisting_glow.png");

    public static void render(LivingEntity entity, PoseStack poseStack, MultiBufferSource bufferSource, float partialTicks) {

        var syncedData = ClientMagicData.getSyncedSpellData(entity);
        if (!syncedData.isCasting()) return;
        if (!PrismaticPortalSpell.SPELL_ID.toString().equals(syncedData.getCastingSpellId())) return;
        if (!entity.level().dimension().equals(Level.OVERWORLD)) return;

        HitResult hit = RaycastBuilder.begin(entity.level(), entity)
                .range(20)
                .checkForBlocks(true)
                .build();
        if (hit.getType() != HitResult.Type.BLOCK) return;

        Minecraft mc = Minecraft.getInstance();
        boolean isFirstPerson = entity == mc.player
                && mc.options.getCameraType().isFirstPerson();

        Vec3 rayEnd = hit.getLocation();
        float distance = (float) entity.getEyePosition(partialTicks).distanceTo(rayEnd);

        poseStack.pushPose();

        if (isFirstPerson) {
            poseStack.translate(0, entity.getEyeHeight() * 0.9f, 0);
        } else {
            poseStack.translate(0, entity.getEyeHeight(), 0);
        }

        var pose = poseStack.last();
        Vec3 start = Vec3.ZERO;
        Vec3 end;

        float radius = 0.1f;
        float deltaTicks = entity.tickCount + partialTicks;
        float deltaUV = -deltaTicks % 10;
        float max = Mth.frac(deltaUV * 0.2F - Mth.floor(deltaUV * 0.1F));
        float min = -1.0F + max;

        var dir = entity.getLookAngle().normalize();
        float dx  = (float) dir.x;
        float dz  = (float) dir.z;
        float yRot = (float) Mth.atan2(dz, dx) - 1.5707f;
        float dxz  = Mth.sqrt(dx * dx + dz * dz);
        float dy   = (float) dir.y;
        float xRot = (float) Mth.atan2(dy, dxz);

        poseStack.mulPose(Axis.YP.rotation(-yRot));
        poseStack.mulPose(Axis.XP.rotation(-xRot));

        float hue = (deltaTicks * 0.02f) % 1.0f;

        for (float j = 1; j <= distance; j += 0.5f) {
            float segHue = (hue + j * 0.05f) % 1.0f;
            float[] rgb = hsvToRgb(segHue, 1.0f, 1.0f);
            int r = (int)(rgb[0] * 255);
            int g = (int)(rgb[1] * 255);
            int b = (int)(rgb[2] * 255);
            int a = 230;

            Vec3 wiggle = new Vec3(
                    Mth.sin(deltaTicks * 0.8f) * 0.02f,
                    Mth.sin(deltaTicks * 0.8f + 100) * 0.02f,
                    Mth.cos(deltaTicks * 0.8f) * 0.02f
            );
            end = new Vec3(0, 0, Math.min(j, distance)).add(wiggle);

            VertexConsumer inner = bufferSource.getBuffer(
                    RenderType.entityTranslucent(BEACON, true));
            drawHull(start, end, radius, radius, pose, inner, r, g, b, a, min, max);

            VertexConsumer outer = bufferSource.getBuffer(
                    RenderType.entityTranslucent(TWISTING_GLOW));
            drawQuad(start, end, radius * 4f, 0, pose, outer, r, g, b, a / 2, min, max);
            drawQuad(start, end, 0, radius * 4f, pose, outer, r, g, b, a / 2, min, max);

            start = end;
        }

        poseStack.popPose();
    }

    private static void drawHull(Vec3 from, Vec3 to, float width, float height, PoseStack.Pose pose, VertexConsumer consumer, int r, int g, int b, int a, float uvMin, float uvMax) {
        drawQuad(from.subtract(0, height * .5f, 0), to.subtract(0, height * .5f, 0), width,  0,      pose, consumer, r, g, b, a, uvMin, uvMax);
        drawQuad(from.add(0, height * .5f, 0),      to.add(0, height * .5f, 0),      width,  0,      pose, consumer, r, g, b, a, uvMin, uvMax);
        drawQuad(from.subtract(width * .5f, 0, 0),  to.subtract(width * .5f, 0, 0),  0,      height, pose, consumer, r, g, b, a, uvMin, uvMax);
        drawQuad(from.add(width * .5f, 0, 0),       to.add(width * .5f, 0, 0),       0,      height, pose, consumer, r, g, b, a, uvMin, uvMax);
    }

    private static void drawQuad(Vec3 from, Vec3 to, float width, float height, PoseStack.Pose pose, VertexConsumer consumer, int r, int g, int b, int a, float uvMin, float uvMax) {
        Matrix4f poseMatrix   = pose.pose();
        Matrix3f normalMatrix = pose.normal();

        float hw = width  * .5f;
        float hh = height * .5f;

        consumer.addVertex(poseMatrix, (float)from.x - hw, (float)from.y - hh, (float)from.z)
                .setColor(r, g, b, a).setUv(0f, uvMin)
                .setOverlay(OverlayTexture.NO_OVERLAY).setLight(240).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, (float)from.x + hw, (float)from.y + hh, (float)from.z)
                .setColor(r, g, b, a).setUv(1f, uvMin)
                .setOverlay(OverlayTexture.NO_OVERLAY).setLight(240).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, (float)to.x + hw, (float)to.y + hh, (float)to.z)
                .setColor(r, g, b, a).setUv(1f, uvMax)
                .setOverlay(OverlayTexture.NO_OVERLAY).setLight(240).setNormal(0f, 1f, 0f);
        consumer.addVertex(poseMatrix, (float)to.x - hw, (float)to.y - hh, (float)to.z)
                .setColor(r, g, b, a).setUv(0f, uvMax)
                .setOverlay(OverlayTexture.NO_OVERLAY).setLight(240).setNormal(0f, 1f, 0f);
    }

    private static float[] hsvToRgb(float h, float s, float v) {
        int i = (int)(h * 6);
        float f = h * 6 - i;
        float p = v * (1 - s);
        float q = v * (1 - f * s);
        float t = v * (1 - (1 - f) * s);
        return switch (i % 6) {
            case 0 -> new float[]{v, t, p};
            case 1 -> new float[]{q, v, p};
            case 2 -> new float[]{p, v, t};
            case 3 -> new float[]{p, q, v};
            case 4 -> new float[]{t, p, v};
            default -> new float[]{v, p, q};
        };
    }
}