package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.util.CCTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CCBlockTagProvider extends BlockTagsProvider {
    public CCBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CCBlocks.CRUSTONE.get())
                .add(CCBlocks.CRUSTONE_BRICKS.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS.get())
                .add(CCBlocks.POLISHED_CRUSTONE.get())
                .add(CCBlocks.CHISELED_CRUSTONE.get())
                .add(CCBlocks.CELVER_LIGHT.get())
                .add(CCBlocks.FAT_TISSUE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(CCBlocks.BRONCHUS.get())
                .add(CCBlocks.BRONCHUS_PLANKS.get())
                .add(CCBlocks.BRONCHUS_STAIRS.get())
                .add(CCBlocks.BRONCHUS_SLAB.get())
                .add(CCBlocks.BRONCHUS_FENCE.get())
                .add(CCBlocks.BRONCHUS_FENCE_GATE.get())
                .add(CCBlocks.BRONCHUS_BUTTON.get())
                .add(CCBlocks.BRONCHUS_PRESSURE_PLATE.get())
                .add(CCBlocks.BRONCHUS_DOOR.get())
                .add(CCBlocks.BRONCHUS_TRAPDOOR.get())
                .add(CCBlocks.BRONCHUS_FENCE_GATE.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(CCBlocks.AXON.get())
                .add(CCBlocks.NEURON_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.FENCES)
                .add(CCBlocks.BRONCHUS_FENCE.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(CCBlocks.BRONCHUS_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(CCBlocks.BRONCHUS_FENCE_GATE.get());

        this.tag(BlockTags.PLANKS)
                .add(CCBlocks.BRONCHUS_PLANKS.get());

        this.tag(CCTags.Blocks.CC_BLOOD_BLOCK)
                .add(CCBlocks.FLESH_BLOCK.get())
                .add(CCBlocks.MUSCLE_BLOCK.get())
                .add(CCBlocks.FAT_TISSUE_BLOCK.get());

        this.tag(CCTags.Blocks.CC_ARTREE_BLOCK)
                .add(CCBlocks.ARTREE_BASE.get())
                .add(CCBlocks.ARTREE_CAPILLARY.get())
                .add(CCBlocks.ARTREE_VEIN.get());

    }
}
