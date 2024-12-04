package net.veroxuniverse.crystal_chronicles.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

import java.util.List;
public class CCPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BRONCHUS_PLACED_KEY = registerKey("bronchus_placed");
    public static final ResourceKey<PlacedFeature> BRONCHUS_PLACED_CAVE_KEY = registerKey("bronchus_cave");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BRONCHUS_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguredFeatures.BRONCHUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        CCBlocks.ALVEOLUS.get()));

        register(context, BRONCHUS_PLACED_CAVE_KEY, configuredFeatures.getOrThrow(CCConfiguredFeatures.BRONCHUS_KEY),
                List.of(
                        //PlacementUtils.countExtra(3, 0.1f, 2),
                        RarityFilter.onAverageOnceEvery(15),
                        CountOnEveryLayerPlacement.of(7),
                        BiomeFilter.biome()
                ));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
