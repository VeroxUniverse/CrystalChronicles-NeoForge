package net.veroxuniverse.crystal_chronicles.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSCLE_DRIPSTONE_KEY = registerKey("muscle_dripstone");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, MUSCLE_DRIPSTONE_KEY, new LargeMuscleDripstoneFeature(LargeDripstoneConfiguration.CODEC),
                new LargeDripstoneConfiguration(
                        1,
                        ConstantInt.of(5),
                        ConstantFloat.of(1.0f),
                        1.0f,
                        UniformFloat.of(0.5f, 1.5f),
                        UniformFloat.of(0.5f, 1.5f),
                        ConstantFloat.of(1.0f),
                        3,
                        0.5f
                ));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}