package net.veroxuniverse.crystal_chronicles;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.common.internal.common.AzureLib;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.veroxuniverse.crystal_chronicles.entity.CCEntityTypes;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalDrake.CrystalDrakeRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalGolem.CrystalGolemRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalScorpion.CrystalScorpionRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalWolf.CrystalWolfRenderer;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.registry.CCTabs;
import org.slf4j.Logger;

@Mod(CrystalChronicles.MODID)
public class CrystalChronicles {
    public static final String MODID = "crystal_chronicles";
    private static final Logger LOGGER = LogUtils.getLogger();


    public CrystalChronicles(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        AzureLib.initialize();
        CCTabs.register(modEventBus);
        CCEntityTypes.register(modEventBus);
        CCBlocks.register(modEventBus);
        CCItems.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            EntityRenderers.register(CCEntityTypes.CRYSTAL_DRAKE.get(), CrystalDrakeRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_SCORPION.get(), CrystalScorpionRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_GOLEM.get(), CrystalGolemRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_WOLF.get(), CrystalWolfRenderer::new);
        }
    }

}
