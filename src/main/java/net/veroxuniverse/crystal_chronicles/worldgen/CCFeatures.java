package net.veroxuniverse.crystal_chronicles.worldgen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.worldgen.tree.ArtreeFeature;
import net.veroxuniverse.crystal_chronicles.worldgen.tree.BronchusTreeFeature;

public class CCFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, CrystalChronicles.MODID);

    public static final DeferredHolder<Feature<?>, LargeMuscleDripstoneFeature> LARGE_MUSCLE_DRIPSTONE =
            FEATURES.register("large_muscle_dripstone", () -> new LargeMuscleDripstoneFeature(LargeMuscleDripstoneConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, LargeTendonDripstoneFeature> LARGE_TENDON_DRIPSTONE =
            FEATURES.register("large_tendon_dripstone", () -> new LargeTendonDripstoneFeature(LargeMuscleDripstoneConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, NeuronFeature> NEURON_FEATURE =
            FEATURES.register("neuron_feature", () -> new NeuronFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, BloodCrystalFeature> BLOODSTONE_FEATURE =
            FEATURES.register("bloodstone_feature", () -> new BloodCrystalFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, BronchusTreeFeature> BRONCHUS_TREE_FEATURE =
            FEATURES.register("bronchus_tree_feature", () -> new BronchusTreeFeature(TreeConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, ArtreeFeature> ARTREE_FEATURE =
            FEATURES.register("artree_feature", () -> new ArtreeFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, HolyLightFeature> HOLY_LIGHT_FEATURE =
            FEATURES.register("holy_light_feature", () -> new HolyLightFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, SkinLayerFeature> SKIN_LAYER_FEATURE =
            FEATURES.register("skin_layer_feature", () -> new SkinLayerFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, TallClusterFeature> TALL_CLUSTER_FEATURE =
            FEATURES.register("tall_cluster_feature", () -> new TallClusterFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);
    }
}