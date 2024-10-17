package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CCWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();

    public CCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CrystalChronicles.MODID));
    }
}