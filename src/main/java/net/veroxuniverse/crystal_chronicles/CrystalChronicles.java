package net.veroxuniverse.crystal_chronicles;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.veroxuniverse.crystal_chronicles.effect.CCEffects;
import net.veroxuniverse.crystal_chronicles.entity.CCBlockEntities;
import net.veroxuniverse.crystal_chronicles.entity.CCEntities;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.lib.CCArmorMaterials;
import net.veroxuniverse.crystal_chronicles.network.RingSwapPayload;
import net.veroxuniverse.crystal_chronicles.registry.*;
import net.veroxuniverse.crystal_chronicles.spells.CCSpells;
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
        CCAttributes.register(modEventBus);
        CCBlocks.register(modEventBus);
        CCItems.register(modEventBus);
        CCArmorMaterials.register(modEventBus);
        CCEffects.register(modEventBus);
        CCFluids.register(modEventBus);
        CCFluidTypes.register(modEventBus);
        CCFeatures.register(modEventBus);
        CCSchools.register(modEventBus);
        CCSpells.register(modEventBus);
        CCDataComponents.register(modEventBus);
        CCEntities.register(modEventBus);
        CCBlockEntities.register(modEventBus);
        modEventBus.addListener(this::registerResourcePack);
        modEventBus.addListener(this::registerPayloads);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        AzIdentityRegistry.register(CCItems.ENDER_STAFF.get());
        AzIdentityRegistry.register(CCItems.LIGHTNING_STAFF.get());
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

    private void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MODID);

        registrar.playToServer(
                RingSwapPayload.TYPE,
                RingSwapPayload.STREAM_CODEC,
                RingSwapPayload::handle
        );
    }

}
