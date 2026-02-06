package net.veroxuniverse.crystal_chronicles;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.veroxuniverse.crystal_chronicles.effect.CCEffects;
import net.veroxuniverse.crystal_chronicles.fluid.BaseFluidType;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.item.CCItemProperties;
import net.veroxuniverse.crystal_chronicles.item.armor.lightning.LightningKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.evocation.EvocationKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.ender.EnderMageArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.holy.HolyKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.fire.FireKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.blood.BloodKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.ice.IceKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.nature.NatureKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.prismatic.PrismaticKnightArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.lightning.LightningBidentItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.fire.FireChakramItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ice.IceHammerItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.holy.HolySwordItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.blood.BloodScytheItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderSickleItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.nature.NatureSpearItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.ender.EnderStaffItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.evocation.EvocationTwinbladeItemRenderer;
import net.veroxuniverse.crystal_chronicles.lib.CCArmorMaterials;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.registry.CCTabs;
import net.veroxuniverse.crystal_chronicles.spells.CCSpells;
import net.veroxuniverse.crystal_chronicles.spells.PrismaticSchools;
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
        PrismaticSchools.register(modEventBus);
        CCSpells.register(modEventBus);
        //CCEntities.register(modEventBus);
        //CCBlockEntities.register(modEventBus);
        modEventBus.addListener(this::registerResourcePack);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        AzIdentityRegistry.register(CCItems.ENDER_STAFF.get());
        AzIdentityRegistry.register(CCItems.PRISMATIC_KNIGHT_HELMET.get());
        AzIdentityRegistry.register(CCItems.PRISMATIC_KNIGHT_CHESTPLATE.get());
        AzIdentityRegistry.register(CCItems.PRISMATIC_KNIGHT_LEGGINGS.get());
        AzIdentityRegistry.register(CCItems.PRISMATIC_KNIGHT_BOOTS.get());
        LOGGER.info("HELLO from server starting");
    }

    private void registerResourcePack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var modFile = net.neoforged.fml.ModList.get().getModFileById(MODID).getFile();
            var resourcePath = modFile.findResource("resourcepacks/CrystalChroniclesArmorReplacement");

            if (resourcePath == null) {
                LOGGER.error("Resourcepack Path not found: resourcepacks/CrystalChroniclesArmorReplacement");
                return;
            }

            var locationInfo = new net.minecraft.server.packs.PackLocationInfo(
                    MODID + ":armor_replacement",
                    Component.literal("Crystal Chronicles - Old Armor Models"),
                    PackSource.BUILT_IN,
                    java.util.Optional.empty()
            );

            var pack = Pack.readMetaAndCreate(
                    locationInfo,
                    new Pack.ResourcesSupplier() {
                        @Override
                        public net.minecraft.server.packs.PackResources openPrimary(net.minecraft.server.packs.PackLocationInfo info) {
                            return new net.minecraft.server.packs.PathPackResources(info, resourcePath);
                        }

                        @Override
                        public net.minecraft.server.packs.PackResources openFull(net.minecraft.server.packs.PackLocationInfo info, Pack.Metadata metadata) {
                            return openPrimary(info);
                        }
                    },
                    PackType.CLIENT_RESOURCES,
                    new net.minecraft.server.packs.PackSelectionConfig(false, Pack.Position.TOP, false)
            );

            if (pack != null) {
                event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
            }
        }
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            CCItemProperties.addCustomItemProperties();

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
            AzItemRendererRegistry.register(EvocationTwinbladeItemRenderer::new, CCItems.EVOCATION_TWINBLADE.get());
            AzItemRendererRegistry.register(EnderSickleItemRenderer::new, CCItems.ENDER_SICKLE.get());

            //EntityRenderers.register(CCEntities.DIMENSIONAL_RIFT.get(), DimensionalRiftEntityRenderer::new);

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

}
