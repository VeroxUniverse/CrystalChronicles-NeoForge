package net.veroxuniverse.crystal_chronicles;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.*;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
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
//import net.veroxuniverse.crystal_chronicles.entity.CCBlockEntities;
//import net.veroxuniverse.crystal_chronicles.entity.CCEntities;
//import net.veroxuniverse.crystal_chronicles.entity.client.DimensionalRiftEntityRenderer;
import net.veroxuniverse.crystal_chronicles.fluid.BaseFluidType;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.item.CCItemProperties;
import net.veroxuniverse.crystal_chronicles.item.armor.electromancer.ElectromancerArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.evoker.EvokerArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.mage.MageArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.paladin.PaladinArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.pyromancer.PyromancerArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.rogue.RogueArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.tank.TankArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.armor.toxic.ToxicArmorRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.bident.BidentItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.chakram.ChakramItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.hammer.HammerItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.paladin.PaladinItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.scythe.ScytheItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.spear.SpearItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.staff.StaffItemRenderer;
import net.veroxuniverse.crystal_chronicles.item.weapon.twinblade.TwinbladeItemRenderer;
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
        AzIdentityRegistry.register(CCItems.STAFF.get());
        LOGGER.info("HELLO from server starting");
    }

    private void registerResourcePack(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            var modFile = net.neoforged.fml.ModList.get().getModFileById(MODID).getFile();
            var resourcePath = modFile.findResource("resourcepacks/CrystalChroniclesArmorReplacement");

            if (resourcePath == null) {
                LOGGER.error("Resourcepack Path not found!");
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
                        public PackResources openPrimary(PackLocationInfo info) {
                            return new PathPackResources(info, resourcePath);
                        }

                        @Override
                        public PackResources openFull(PackLocationInfo info, Pack.Metadata metadata) {
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

            ItemBlockRenderTypes.setRenderLayer(CCFluids.SOURCE_REACTIVE_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(CCFluids.FLOWING_REACTIVE_WATER.get(), RenderType.translucent());

            AzItemRendererRegistry.register(BidentItemRenderer::new, CCItems.LIGHTNING_BIDENT.get());
            AzItemRendererRegistry.register(ChakramItemRenderer::new, CCItems.CHAKRAM.get());
            // AzItemRendererRegistry.register(GreatswordItemRenderer::new, CCItems.GREATSWORD.get()); /// REMOVED
            AzItemRendererRegistry.register(HammerItemRenderer::new, CCItems.ICE_HAMMER.get());
            AzItemRendererRegistry.register(PaladinItemRenderer::new, CCItems.PALADIN_SWORD.get());
            AzItemRendererRegistry.register(ScytheItemRenderer::new, CCItems.BLOOD_SCYTHE.get());
            AzItemRendererRegistry.register(SpearItemRenderer::new, CCItems.SPEAR.get());
            AzItemRendererRegistry.register(StaffItemRenderer::new, CCItems.STAFF.get());
            AzItemRendererRegistry.register(TwinbladeItemRenderer::new, CCItems.EVOCATION_TWINBLADE.get());
            // AzItemRendererRegistry.register(SwordItemRenderer::new, CCItems.SWORD.get()); /// REMOVED

            //EntityRenderers.register(CCEntities.DIMENSIONAL_RIFT.get(), DimensionalRiftEntityRenderer::new);

            AzArmorRendererRegistry.register(ElectromancerArmorRenderer::new,
                    CCItems.ELECTROMANCER_HELMET.get(),
                    CCItems.ELECTROMANCER_CHESTPLATE.get(),
                    CCItems.ELECTROMANCER_LEGGINGS.get(),
                    CCItems.ELECTROMANCER_BOOTS.get());
            AzArmorRendererRegistry.register(EvokerArmorRenderer::new,
                    CCItems.EVOKER_HELMET.get(),
                    CCItems.EVOKER_CHESTPLATE.get(),
                    CCItems.EVOKER_LEGGINGS.get(),
                    CCItems.EVOKER_BOOTS.get());
            AzArmorRendererRegistry.register(MageArmorRenderer::new,
                    CCItems.MAGE_HELMET.get(),
                    CCItems.MAGE_CHESTPLATE.get(),
                    CCItems.MAGE_LEGGINGS.get(),
                    CCItems.MAGE_BOOTS.get());
            AzArmorRendererRegistry.register(PaladinArmorRenderer::new,
                    CCItems.PALADIN_HELMET.get(),
                    CCItems.PALADIN_CHESTPLATE.get(),
                    CCItems.PALADIN_LEGGINGS.get(),
                    CCItems.PALADIN_BOOTS.get());
            AzArmorRendererRegistry.register(PyromancerArmorRenderer::new,
                    CCItems.PYROMANCER_HELMET.get(),
                    CCItems.PYROMANCER_CHESTPLATE.get(),
                    CCItems.PYROMANCER_LEGGINGS.get(),
                    CCItems.PYROMANCER_BOOTS.get());
            AzArmorRendererRegistry.register(RogueArmorRenderer::new,
                    CCItems.ROGUE_HELMET.get(),
                    CCItems.ROGUE_CHESTPLATE.get(),
                    CCItems.ROGUE_LEGGINGS.get(),
                    CCItems.ROGUE_BOOTS.get());
            AzArmorRendererRegistry.register(TankArmorRenderer::new,
                    CCItems.TANK_HELMET.get(),
                    CCItems.TANK_CHESTPLATE.get(),
                    CCItems.TANK_LEGGINGS.get(),
                    CCItems.TANK_BOOTS.get());
            AzArmorRendererRegistry.register(ToxicArmorRenderer::new,
                    CCItems.TOXIC_HELMET.get(),
                    CCItems.TOXIC_CHESTPLATE.get(),
                    CCItems.TOXIC_LEGGINGS.get(),
                    CCItems.TOXIC_BOOTS.get());
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
