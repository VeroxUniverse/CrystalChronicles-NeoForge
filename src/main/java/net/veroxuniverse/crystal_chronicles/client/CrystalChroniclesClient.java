package net.veroxuniverse.crystal_chronicles.client;

import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.CCEntities;
import net.veroxuniverse.crystal_chronicles.entity.client.DimensionalRiftEntityRenderer;
import net.veroxuniverse.crystal_chronicles.fluid.BaseFluidType;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.item.CCItemProperties;
import net.veroxuniverse.crystal_chronicles.item.armor.blood.BloodKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.ender.EnderMageArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.evocation.EvocationKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.fire.FireKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.holy.HolyKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.ice.IceKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.lightning.LightningKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.nature.NatureKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.prismatic.PrismaticKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.blood.BloodScytheItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderSickleItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderStaffItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.evocation.EvocationTwinbladeItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.fire.FireChakramItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.holy.HolySwordItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ice.IceHammerItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.lightning.LightningBidentItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.lightning.LightningStaffItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.nature.NatureSpearItemRenderer;
import net.veroxuniverse.crystal_chronicles.network.RingSwapPayload;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.registry.CCKeybinds;

@EventBusSubscriber(modid = CrystalChronicles.MODID, value = Dist.CLIENT)
public class CrystalChroniclesClient {

    @SubscribeEvent
    public static void onRegisterKeyMappings(net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent event) {
        event.register(CCKeybinds.RING_SWAP_KEY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (CCKeybinds.RING_SWAP_KEY.consumeClick()) {
            PacketDistributor.sendToServer(new RingSwapPayload());
        }
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CCEntities.DIMENSIONAL_RIFT.get(), DimensionalRiftEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        CrystalChronicles.LOGGER.info("HELLO FROM CLIENT SETUP");

        event.enqueueWork(CCItemProperties::addCustomItemProperties);

        ItemBlockRenderTypes.setRenderLayer(CCBlocks.HOLY_LIGHT_1.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CCBlocks.HOLY_LIGHT_2.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CCBlocks.HOLY_LIGHT_3.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CCBlocks.CLOUD_LAYER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CCBlocks.HOLY_BEACON.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CCFluids.SOURCE_BLOOD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CCFluids.FLOWING_BLOOD.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CCFluids.SOURCE_SULPHURIC_WATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CCFluids.FLOWING_REACTIVE_WATER.get(), RenderType.translucent());

        AzItemRendererRegistry.register(LightningBidentItemRenderer::new, CCItems.LIGHTNING_BIDENT.get());
        AzItemRendererRegistry.register(FireChakramItemRenderer::new, CCItems.FIRE_CHAKRAM.get());
        AzItemRendererRegistry.register(IceHammerItemRenderer::new, CCItems.ICE_HAMMER.get());
        AzItemRendererRegistry.register(HolySwordItemRenderer::new, CCItems.HOLY_SWORD.get());
        AzItemRendererRegistry.register(BloodScytheItemRenderer::new, CCItems.BLOOD_SCYTHE.get());
        AzItemRendererRegistry.register(NatureSpearItemRenderer::new, CCItems.NATURE_SPEAR.get());
        AzItemRendererRegistry.register(EnderStaffItemRenderer::new, CCItems.ENDER_STAFF.get());
        AzItemRendererRegistry.register(LightningStaffItemRenderer::new, CCItems.LIGHTNING_STAFF.get());
        AzItemRendererRegistry.register(EvocationTwinbladeItemRenderer::new, CCItems.EVOCATION_TWINBLADE.get());
        AzItemRendererRegistry.register(EnderSickleItemRenderer::new, CCItems.ENDER_SICKLE.get());

        AzArmorRendererRegistry.register(LightningKnightArmorRenderer::new,
                CCItems.LIGHTNING_KNIGHT_HELMET.get(),
                CCItems.LIGHTNING_KNIGHT_CHESTPLATE.get(),
                CCItems.LIGHTNING_KNIGHT_LEGGINGS.get(),
                CCItems.LIGHTNING_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(EvocationKnightArmorRenderer::new,
                CCItems.EVOCATION_KNIGHT_HELMET.get(),
                CCItems.EVOCATION_KNIGHT_CHESTPLATE.get(),
                CCItems.EVOCATION_KNIGHT_LEGGINGS.get(),
                CCItems.EVOCATION_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(EnderMageArmorRenderer::new,
                CCItems.ENDER_MAGE_HELMET.get(),
                CCItems.ENDER_MAGE_CHESTPLATE.get(),
                CCItems.ENDER_MAGE_LEGGINGS.get(),
                CCItems.ENDER_MAGE_BOOTS.get());
        AzArmorRendererRegistry.register(HolyKnightArmorRenderer::new,
                CCItems.HOLY_KNIGHT_HELMET.get(),
                CCItems.HOLY_KNIGHT_CHESTPLATE.get(),
                CCItems.HOLY_KNIGHT_LEGGINGS.get(),
                CCItems.HOLY_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(FireKnightArmorRenderer::new,
                CCItems.FIRE_KNIGHT_HELMET.get(),
                CCItems.FIRE_KNIGHT_CHESTPLATE.get(),
                CCItems.FIRE_KNIGHT_LEGGINGS.get(),
                CCItems.FIRE_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(BloodKnightArmorRenderer::new,
                CCItems.BLOOD_KNIGHT_HELMET.get(),
                CCItems.BLOOD_KNIGHT_CHESTPLATE.get(),
                CCItems.BLOOD_KNIGHT_LEGGINGS.get(),
                CCItems.BLOOD_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(IceKnightArmorRenderer::new,
                CCItems.ICE_KNIGHT_HELMET.get(),
                CCItems.ICE_KNIGHT_CHESTPLATE.get(),
                CCItems.ICE_KNIGHT_LEGGINGS.get(),
                CCItems.ICE_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(NatureKnightArmorRenderer::new,
                CCItems.NATURE_KNIGHT_HELMET.get(),
                CCItems.NATURE_KNIGHT_CHESTPLATE.get(),
                CCItems.NATURE_KNIGHT_LEGGINGS.get(),
                CCItems.NATURE_KNIGHT_BOOTS.get());
        AzArmorRendererRegistry.register(PrismaticKnightArmorRenderer::new,
                CCItems.PRISMATIC_KNIGHT_HELMET.get(),
                CCItems.PRISMATIC_KNIGHT_CHESTPLATE.get(),
                CCItems.PRISMATIC_KNIGHT_LEGGINGS.get(),
                CCItems.PRISMATIC_KNIGHT_BOOTS.get());
    }

    @SubscribeEvent
    public static void onRegisterAdditionalModels(ModelEvent.RegisterAdditional event) {
        var seg1 = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_1");
        var seg2 = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_2");
        var seg3 = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "block/holy_light_3");

        event.register(ModelResourceLocation.standalone(seg1));
        event.register(ModelResourceLocation.standalone(seg2));
        event.register(ModelResourceLocation.standalone(seg3));
    }

    @SubscribeEvent
    public static void onClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(((BaseFluidType) CCFluidTypes.BLOOD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                CCFluidTypes.BLOOD_FLUID_TYPE.get());

        //event.registerFluidType(((ReactiveWaterFluidType) CCFluidTypes.REACTIVE_WATER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
        //        CCFluidTypes.REACTIVE_WATER_FLUID_TYPE.get());
    }
}
