package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
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
                .add(CCBlocks.CRUSTONE_WALL.get())
                .add(CCBlocks.CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.POLISHED_CRUSTONE_WALL.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_CRUSTONE_WALL.get())
                .add(CCBlocks.CRUSTONE_SLAB.get())
                .add(CCBlocks.CRUSTONE_BRICKS_SLAB.get())
                .add(CCBlocks.POLISHED_CRUSTONE_SLAB.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get())
                .add(CCBlocks.CHISELED_CRUSTONE_SLAB.get())
                .add(CCBlocks.CRUSTONE_STAIRS.get())
                .add(CCBlocks.CRUSTONE_BRICKS_STAIRS.get())
                .add(CCBlocks.POLISHED_CRUSTONE_STAIRS.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get())
                .add(CCBlocks.CHISELED_CRUSTONE_STAIRS.get())
                .add(CCBlocks.CELVER_LIGHT.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE.get())
                .add(CCBlocks.GOLDSTONE.get())
                .add(CCBlocks.HOLY_BEACON.get())
                .add(CCBlocks.HOLY_MARBLE.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS.get())
                .add(CCBlocks.HOLY_MARBLE_PILLAR.get())
                .add(CCBlocks.HOLY_LIGHT_BLOCK.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE.get())
                .add(CCBlocks.HOLY_MARBLE_STAIRS.get())
                .add(CCBlocks.HOLY_MARBLE_SLAB.get())
                .add(CCBlocks.HOLY_MARBLE_WALL.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.GOLDSTONE_STAIRS.get())
                .add(CCBlocks.GOLDSTONE_SLAB.get())
                .add(CCBlocks.GOLDSTONE_WALL.get())
                .add(CCBlocks.CHISELED_PUMICE.get())
                .add(CCBlocks.CRACKED_PUMICE.get())
                .add(CCBlocks.VOLCANITE_BLOCK.get())
                .add(CCBlocks.GREEN_SULPHUR_POOL.get())
                .add(CCBlocks.ORANGE_SULPHUR_POOL.get())
                .add(CCBlocks.PUMICE.get())
                .add(CCBlocks.PIRITE_BLOCK.get())
                .add(CCBlocks.POLISHED_PUMICE.get())
                .add(CCBlocks.PUMICE_BRICKS.get())
                .add(CCBlocks.RED_SULPHUR_POOL.get())
                .add(CCBlocks.RED_SULPHUR_WATER_VENT_BASE.get())
                .add(CCBlocks.RED_SULPHUR_WATER_VENT_TOP.get())
                .add(CCBlocks.SMALL_PIRITE_BLOCK.get())
                .add(CCBlocks.SULPHUR_CRYSTAL.get())
                .add(CCBlocks.SMALL_SULPHUR_CLUSTER.get())
                .add(CCBlocks.MEDIUM_SULPHUR_CLUSTER.get())
                .add(CCBlocks.TALL_SULPHUR_CLUSTER.get())
                .add(CCBlocks.SULPHUR_WATER_VENT_BASE.get())
                .add(CCBlocks.SULPHUR_WATER_VENT_TOP.get())
                .add(CCBlocks.SULPHURIC_SOIL.get())
                .add(CCBlocks.VERMILLION_SULPHUR_POOL.get())
                .add(CCBlocks.YELLOW_SULPHUR_POOL.get())
                .add(CCBlocks.PUMICE_STAIRS.get())
                .add(CCBlocks.PUMICE_SLAB.get())
                .add(CCBlocks.PUMICE_WALL.get())
                .add(CCBlocks.PUMICE_BRICKS_STAIRS.get())
                .add(CCBlocks.PUMICE_BRICKS_SLAB.get())
                .add(CCBlocks.PUMICE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_PUMICE_STAIRS.get())
                .add(CCBlocks.CHISELED_PUMICE_SLAB.get())
                .add(CCBlocks.CHISELED_PUMICE_WALL.get())
                .add(CCBlocks.CRACKED_PUMICE_STAIRS.get())
                .add(CCBlocks.CRACKED_PUMICE_SLAB.get())
                .add(CCBlocks.CRACKED_PUMICE_WALL.get())
                .add(CCBlocks.POLISHED_PUMICE_STAIRS.get())
                .add(CCBlocks.POLISHED_PUMICE_SLAB.get())
                .add(CCBlocks.POLISHED_PUMICE_WALL.get())
                .add(CCBlocks.PIRITE_STAIRS.get())
                .add(CCBlocks.PIRITE_SLAB.get())
                .add(CCBlocks.PIRITE_WALL.get());

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
                .add(CCBlocks.BRONCHUS_FENCE_GATE.get())
                .add(CCBlocks.ARTREE_BASE.get())
                .add(CCBlocks.ARTREE_CAPILLARY.get())
                .add(CCBlocks.ARTREE_VEIN.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(CCBlocks.AXON.get())
                .add(CCBlocks.NEURON_BLOCK.get())
                .add(CCBlocks.EYE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(CCBlocks.SULPHUR_DUST.get())
                .add(CCBlocks.SULPHUR_DUST_LAYER.get())
                .add(CCBlocks.CLOUD_BLOCK.get())
                .add(CCBlocks.DENSE_CLOUDS.get())
                .add(CCBlocks.CLOUD_LAYER.get());

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

        this.tag(BlockTags.STONE_BRICKS)
                .add(CCBlocks.PUMICE_BRICKS.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS.get())
                .add(CCBlocks.CRUSTONE_BRICKS.get());

        this.tag(Tags.Blocks.STONES)
                .add(CCBlocks.CRUSTONE.get())
                .add(CCBlocks.HOLY_MARBLE.get())
                .add(CCBlocks.PUMICE.get())
                .add(CCBlocks.PIRITE_BLOCK.get())
                .add(CCBlocks.GOLDSTONE.get());

        this.tag(BlockTags.WALLS)
                .add(CCBlocks.CRUSTONE_WALL.get())
                .add(CCBlocks.CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.POLISHED_CRUSTONE_WALL.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_CRUSTONE_WALL.get())
                .add(CCBlocks.HOLY_MARBLE_WALL.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.GOLDSTONE_WALL.get())
                .add(CCBlocks.PUMICE_WALL.get())
                .add(CCBlocks.PUMICE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_PUMICE_WALL.get())
                .add(CCBlocks.CRACKED_PUMICE_WALL.get())
                .add(CCBlocks.POLISHED_PUMICE_WALL.get())
                .add(CCBlocks.PIRITE_WALL.get());

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
