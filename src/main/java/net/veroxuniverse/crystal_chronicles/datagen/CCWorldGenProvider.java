package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.worldgen.CCBiomeModifiers;
import net.veroxuniverse.crystal_chronicles.worldgen.CCConfiguredFeatures;
import net.veroxuniverse.crystal_chronicles.worldgen.CCPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CCWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CCConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CCPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CCBiomeModifiers::bootstrap);

    public CCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CrystalChronicles.MODID));
    }
}