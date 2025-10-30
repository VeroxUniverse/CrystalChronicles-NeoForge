package net.veroxuniverse.crystal_chronicles;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.azurelib.rewrite.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.veroxuniverse.crystal_chronicles.effect.CCEffects;
import net.veroxuniverse.crystal_chronicles.entity.CCEntityTypes;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalDrake.CrystalDrakeRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalGolem.CrystalGolemRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalScorpion.CrystalScorpionRenderer;
import net.veroxuniverse.crystal_chronicles.entity.client.CrystalWolf.CrystalWolfRenderer;
import net.veroxuniverse.crystal_chronicles.fluid.BaseFluidType;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.item.CCItemProperties;
import net.veroxuniverse.crystal_chronicles.item.weapon.bident.BidentItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.ChakramItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.greatsword.GreatswordItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.hammer.HammerItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.paladin.PaladinItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.scythe.ScytheItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.spear.SpearItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.staff.StaffItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.sword.SwordItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.twinblade.TwinbladeItemRenderer;
import net.veroxuniverse.crystal_chronicles.lib.CCArmorMaterials;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.registry.CCTabs;
import net.veroxuniverse.crystal_chronicles.worldgen.CCFeatures;
import org.slf4j.Logger;

@Mod(CrystalChronicles.MODID)
public class CrystalChronicles {
    public static final String MODID = "crystal_chronicles";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CrystalChronicles(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        AzureLib.initialize();
        CCTabs.register(modEventBus);
        //CCEntityTypes.register(modEventBus);
        CCBlocks.register(modEventBus);
        CCItems.register(modEventBus);
        CCArmorMaterials.register(modEventBus);
        CCEffects.register(modEventBus);
        CCFluids.register(modEventBus);
        CCFluidTypes.register(modEventBus);
        CCFeatures.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

        AzIdentityRegistry.register(CCItems.STAFF.get());

        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            CCItemProperties.addCustomItemProperties();

            ItemBlockRenderTypes.setRenderLayer(CCFluids.SOURCE_BLOOD.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(CCFluids.FLOWING_BLOOD.get(), RenderType.translucent());

            EntityRenderers.register(CCEntityTypes.CRYSTAL_DRAKE.get(), CrystalDrakeRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_SCORPION.get(), CrystalScorpionRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_GOLEM.get(), CrystalGolemRenderer::new);
            EntityRenderers.register(CCEntityTypes.CRYSTAL_WOLF.get(), CrystalWolfRenderer::new);

            AzItemRendererRegistry.register(BidentItemRenderer::new, CCItems.LIGHTNING_BIDENT.get());
            AzItemRendererRegistry.register(ChakramItemRenderer::new, CCItems.CHAKRAM.get());
            //AzItemRendererRegistry.register(GreatswordItemRenderer::new, CCItems.GREATSWORD.get());
            AzItemRendererRegistry.register(HammerItemRenderer::new, CCItems.ICE_HAMMER.get());
            AzItemRendererRegistry.register(PaladinItemRenderer::new, CCItems.PALADIN_SWORD.get());
            AzItemRendererRegistry.register(ScytheItemRenderer::new, CCItems.BLOOD_SCYTHE.get());
            AzItemRendererRegistry.register(SpearItemRenderer::new, CCItems.SPEAR.get());
            AzItemRendererRegistry.register(StaffItemRenderer::new, CCItems.STAFF.get());
            AzItemRendererRegistry.register(TwinbladeItemRenderer::new, CCItems.EVOCATION_TWINBLADE.get());
            //AzItemRendererRegistry.register(SwordItemRenderer::new, CCItems.SWORD.get());
        }

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) CCFluidTypes.BLOOD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    CCFluidTypes.BLOOD_FLUID_TYPE.get());
        }
    }

}
