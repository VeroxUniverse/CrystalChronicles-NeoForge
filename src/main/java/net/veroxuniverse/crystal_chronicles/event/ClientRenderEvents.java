package net.veroxuniverse.crystal_chronicles.event;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.client.PrismaticLaserBeamRenderer;

@EventBusSubscriber(modid = CrystalChronicles.MODID, value = Dist.CLIENT)
public class ClientRenderEvents {

    @SubscribeEvent
    public static void afterLivingRender(RenderLivingEvent.Post<? extends LivingEntity, ? extends EntityModel<? extends LivingEntity>> event) {
        PrismaticLaserBeamRenderer.render(
                event.getEntity(),
                event.getPoseStack(),
                event.getMultiBufferSource(),
                event.getPartialTick()
        );
    }
}