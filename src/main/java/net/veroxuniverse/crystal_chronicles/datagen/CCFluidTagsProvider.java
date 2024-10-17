package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CCFluidTagsProvider extends FluidTagsProvider {
    public CCFluidTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.WATER)
                .add(CCFluids.SOURCE_BLOOD.get())
                .add(CCFluids.FLOWING_BLOOD.get());
    }
}