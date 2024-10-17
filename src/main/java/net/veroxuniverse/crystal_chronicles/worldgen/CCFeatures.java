package net.veroxuniverse.crystal_chronicles.worldgen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, CrystalChronicles.MODID);

    public static final DeferredHolder<Feature<?>, LargeMuscleDripstoneFeature> LARGE_MUSCLE_DRIPSTONE =
            FEATURES.register("large_muscle_dripstone", () -> new LargeMuscleDripstoneFeature(LargeMuscleDripstoneConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, NeuronFeature> NEURON_FEATURE =
            FEATURES.register("neuron_feature", () -> new NeuronFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}