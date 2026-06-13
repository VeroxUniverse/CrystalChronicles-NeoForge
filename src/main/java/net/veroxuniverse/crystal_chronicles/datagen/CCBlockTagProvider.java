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

        // --- MINEABLE WITH PICKAXE ---
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CCBlocks.POLISHED_STONE_BRICKS.get())
                // Lightning
                .add(CCBlocks.THUNDERSTONE.get())
                .add(CCBlocks.CHARGED_THUNDERSTONE.get())
                .add(CCBlocks.THUNDERSTONE_BRICKS.get())
                .add(CCBlocks.CHISELED_THUNDERSTONE.get())
                .add(CCBlocks.POLISHED_THUNDERSTONE.get())
                .add(CCBlocks.THUNDERSTONE_STAIRS.get(), CCBlocks.THUNDERSTONE_SLAB.get(), CCBlocks.THUNDERSTONE_WALL.get())
                .add(CCBlocks.CHISELED_THUNDERSTONE_STAIRS.get(), CCBlocks.CHISELED_THUNDERSTONE_SLAB.get(), CCBlocks.CHISELED_THUNDERSTONE_WALL.get())
                .add(CCBlocks.THUNDERSTONE_BRICKS_STAIRS.get(), CCBlocks.THUNDERSTONE_BRICKS_SLAB.get(), CCBlocks.THUNDERSTONE_BRICKS_WALL.get())
                .add(CCBlocks.POLISHED_THUNDERSTONE_STAIRS.get(), CCBlocks.POLISHED_THUNDERSTONE_SLAB.get(), CCBlocks.POLISHED_THUNDERSTONE_WALL.get())
                // Bismuth / End
                .add(CCBlocks.PORTAL_FRAME_BLOCK.get())
                .add(CCBlocks.BLUE_BISMUTH_CRYSTAL.get(), CCBlocks.PURPLE_BISMUTH_CRYSTAL.get(), CCBlocks.RAINBOW_BISMUTH_CRYSTAL.get(), CCBlocks.VIOLET_BISMUTH_CRYSTAL.get(), CCBlocks.YELLOW_BISMUTH_CRYSTAL.get())
                .add(CCBlocks.BISMITE.get(), CCBlocks.BISMITE_BRICKS.get(), CCBlocks.CHISELED_BISMITE.get(), CCBlocks.CRACKED_BISMITE.get(), CCBlocks.POLISHED_BISMITE.get())
                .add(CCBlocks.BISMITE_STAIRS.get(), CCBlocks.BISMITE_SLAB.get(), CCBlocks.BISMITE_WALL.get())
                .add(CCBlocks.CHISELED_BISMITE_STAIRS.get(), CCBlocks.CHISELED_BISMITE_SLAB.get(), CCBlocks.CHISELED_BISMITE_WALL.get())
                .add(CCBlocks.CRACKED_BISMITE_STAIRS.get(), CCBlocks.CRACKED_BISMITE_SLAB.get(), CCBlocks.CRACKED_BISMITE_WALL.get())
                .add(CCBlocks.POLISHED_BISMITE_STAIRS.get(), CCBlocks.POLISHED_BISMITE_SLAB.get(), CCBlocks.POLISHED_BISMITE_WALL.get())
                .add(CCBlocks.BISMITE_BRICKS_STAIRS.get(), CCBlocks.BISMITE_BRICKS_SLAB.get(), CCBlocks.BISMITE_BRICKS_WALL.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS.get(), CCBlocks.PURPLE_BISMUTH_BRICKS.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS.get(), CCBlocks.VIOLET_BISMUTH_BRICKS.get(), CCBlocks.YELLOW_BISMUTH_BRICKS.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.BLUE_BISMUTH_BRICKS_SLAB.get(), CCBlocks.BLUE_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.PURPLE_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.PURPLE_BISMUTH_BRICKS_SLAB.get(), CCBlocks.PURPLE_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.YELLOW_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.YELLOW_BISMUTH_BRICKS_SLAB.get(), CCBlocks.YELLOW_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.RAINBOW_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS_SLAB.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.VIOLET_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.VIOLET_BISMUTH_BRICKS_SLAB.get(), CCBlocks.VIOLET_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.BLUE_BISMUTH.get(), CCBlocks.PURPLE_BISMUTH.get(), CCBlocks.VIOLET_BISMUTH.get(), CCBlocks.YELLOW_BISMUTH.get(), CCBlocks.RAINBOW_BISMUTH.get())
                .add(CCBlocks.BLUE_BISMUTH_STAIRS.get(), CCBlocks.BLUE_BISMUTH_SLAB.get(), CCBlocks.BLUE_BISMUTH_WALL.get())
                .add(CCBlocks.PURPLE_BISMUTH_STAIRS.get(), CCBlocks.PURPLE_BISMUTH_SLAB.get(), CCBlocks.PURPLE_BISMUTH_WALL.get())
                .add(CCBlocks.YELLOW_BISMUTH_STAIRS.get(), CCBlocks.YELLOW_BISMUTH_SLAB.get(), CCBlocks.YELLOW_BISMUTH_WALL.get())
                .add(CCBlocks.VIOLET_BISMUTH_STAIRS.get(), CCBlocks.VIOLET_BISMUTH_SLAB.get(), CCBlocks.VIOLET_BISMUTH_WALL.get())
                .add(CCBlocks.RAINBOW_BISMUTH_STAIRS.get(), CCBlocks.RAINBOW_BISMUTH_SLAB.get(), CCBlocks.RAINBOW_BISMUTH_WALL.get())
                // Blood / Flesh (Stone-based ones)
                .add(CCBlocks.CRUSTONE.get(), CCBlocks.CRUSTONE_BRICKS.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS.get(), CCBlocks.POLISHED_CRUSTONE.get(), CCBlocks.CHISELED_CRUSTONE.get())
                .add(CCBlocks.CRUSTONE_STAIRS.get(), CCBlocks.CRUSTONE_SLAB.get(), CCBlocks.CRUSTONE_WALL.get())
                .add(CCBlocks.CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get())
                .add(CCBlocks.POLISHED_CRUSTONE_STAIRS.get(), CCBlocks.POLISHED_CRUSTONE_SLAB.get(), CCBlocks.POLISHED_CRUSTONE_WALL.get())
                .add(CCBlocks.CHISELED_CRUSTONE_STAIRS.get(), CCBlocks.CHISELED_CRUSTONE_SLAB.get(), CCBlocks.CHISELED_CRUSTONE_WALL.get())
                .add(CCBlocks.HEMALITE_BLOCK.get())
                .add(CCBlocks.PLAYER_SENSOR.get())
                // Holy
                .add(CCBlocks.HOLY_MARBLE.get(), CCBlocks.CHISELED_HOLY_MARBLE.get(), CCBlocks.CRACKED_HOLY_MARBLE.get(), CCBlocks.POLISHED_HOLY_MARBLE.get(), CCBlocks.HOLY_MARBLE_BRICKS.get())
                .add(CCBlocks.HOLY_MARBLE_PILLAR.get(), CCBlocks.GOLDSTONE.get(), CCBlocks.HOLY_BEACON.get())
                .add(CCBlocks.HOLY_MARBLE_STAIRS.get(), CCBlocks.HOLY_MARBLE_SLAB.get(), CCBlocks.HOLY_MARBLE_WALL.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get(), CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get(), CCBlocks.HOLY_MARBLE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get(), CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get(), CCBlocks.CHISELED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get(), CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get(), CCBlocks.CRACKED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get(), CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get(), CCBlocks.POLISHED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.GOLDSTONE_STAIRS.get(), CCBlocks.GOLDSTONE_SLAB.get(), CCBlocks.GOLDSTONE_WALL.get())
                // Fire / Volcanic
                .add(CCBlocks.VOLCANITE_BLOCK.get(), CCBlocks.PYRITE.get(), CCBlocks.PUMICE.get(), CCBlocks.PUMICE_BRICKS.get(), CCBlocks.CHISELED_PUMICE.get(), CCBlocks.CRACKED_PUMICE.get(), CCBlocks.POLISHED_PUMICE.get())
                .add(CCBlocks.GREEN_SULPHUR_POOL.get(), CCBlocks.ORANGE_SULPHUR_POOL.get(), CCBlocks.RED_SULPHUR_POOL.get(), CCBlocks.YELLOW_SULPHUR_POOL.get(), CCBlocks.VERMILLION_SULPHUR_POOL.get())
                .add(CCBlocks.SULPHUR_CRYSTAL.get(), CCBlocks.RED_SULPHUR_WATER_VENT_BASE.get(), CCBlocks.RED_SULPHUR_WATER_VENT_TOP.get(), CCBlocks.SULPHUR_WATER_VENT_BASE.get(), CCBlocks.SULPHUR_WATER_VENT_TOP.get())
                .add(CCBlocks.PYRITE_CHUNK.get(), CCBlocks.SMALL_SULPHUR_CLUSTER.get(), CCBlocks.MEDIUM_SULPHUR_CLUSTER.get(), CCBlocks.TALL_SULPHUR_CLUSTER.get())
                .add(CCBlocks.PUMICE_STAIRS.get(), CCBlocks.PUMICE_SLAB.get(), CCBlocks.PUMICE_WALL.get())
                .add(CCBlocks.PUMICE_BRICKS_STAIRS.get(), CCBlocks.PUMICE_BRICKS_SLAB.get(), CCBlocks.PUMICE_BRICKS_WALL.get())
                .add(CCBlocks.CHISELED_PUMICE_STAIRS.get(), CCBlocks.CHISELED_PUMICE_SLAB.get(), CCBlocks.CHISELED_PUMICE_WALL.get())
                .add(CCBlocks.CRACKED_PUMICE_STAIRS.get(), CCBlocks.CRACKED_PUMICE_SLAB.get(), CCBlocks.CRACKED_PUMICE_WALL.get())
                .add(CCBlocks.POLISHED_PUMICE_STAIRS.get(), CCBlocks.POLISHED_PUMICE_SLAB.get(), CCBlocks.POLISHED_PUMICE_WALL.get())
                .add(CCBlocks.PYRITE_STAIRS.get(), CCBlocks.PYRITE_SLAB.get(), CCBlocks.PYRITE_WALL.get());

        // --- MINEABLE WITH AXE ---
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
                .add(CCBlocks.ARTREE_BASE.get())
                .add(CCBlocks.ARTREE_CAPILLARY.get())
                .add(CCBlocks.ARTREE_VEIN.get());

        // --- MINEABLE WITH HOE ---
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(CCBlocks.AXON.get())
                .add(CCBlocks.NEURON_BLOCK.get())
                .add(CCBlocks.EYE_BLOCK.get())
                .add(CCBlocks.NEURON_TORCH.get())
                .add(CCBlocks.NEURON_TORCH_WALL.get());

        // --- MINEABLE WITH SHOVEL ---
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(CCBlocks.SULPHUR_POWDER.get())
                .add(CCBlocks.SULPHUR_DUST_LAYER.get())
                .add(CCBlocks.CLOUD_BLOCK.get())
                .add(CCBlocks.DENSE_CLOUDS.get())
                .add(CCBlocks.CLOUD_LAYER.get())
                .add(CCBlocks.SULPHURIC_SOIL.get())
                .add(CCBlocks.ALVEOLUS_BLOCK.get());

        // --- TOOL LEVELS ---
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CCBlocks.BISMITE.get(), CCBlocks.BISMITE_BRICKS.get(), CCBlocks.CHISELED_BISMITE.get(), CCBlocks.CRACKED_BISMITE.get(), CCBlocks.POLISHED_BISMITE.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS.get(), CCBlocks.PURPLE_BISMUTH_BRICKS.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS.get(), CCBlocks.VIOLET_BISMUTH_BRICKS.get(), CCBlocks.YELLOW_BISMUTH_BRICKS.get())
                .add(CCBlocks.BLUE_BISMUTH.get(), CCBlocks.PURPLE_BISMUTH.get(), CCBlocks.VIOLET_BISMUTH.get(), CCBlocks.YELLOW_BISMUTH.get(), CCBlocks.RAINBOW_BISMUTH.get())
                .add(CCBlocks.BLUE_BISMUTH_CRYSTAL.get(), CCBlocks.PURPLE_BISMUTH_CRYSTAL.get(), CCBlocks.RAINBOW_BISMUTH_CRYSTAL.get(), CCBlocks.VIOLET_BISMUTH_CRYSTAL.get(), CCBlocks.YELLOW_BISMUTH_CRYSTAL.get())
                .add(CCBlocks.VOLCANITE_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CCBlocks.THUNDERSTONE.get(),
                        CCBlocks.CHARGED_THUNDERSTONE.get())
                .add(CCBlocks.GOLDSTONE.get())
                .add(CCBlocks.PYRITE.get());

        // --- CATEGORY TAGS ---
        this.tag(BlockTags.FENCES)
                .add(CCBlocks.BRONCHUS_FENCE.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(CCBlocks.BRONCHUS_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(CCBlocks.BRONCHUS_FENCE_GATE.get());

        this.tag(BlockTags.PLANKS)
                .add(CCBlocks.BRONCHUS_PLANKS.get());

        this.tag(BlockTags.BUTTONS)
                .add(CCBlocks.BRONCHUS_BUTTON.get());

        this.tag(BlockTags.DOORS)
                .add(CCBlocks.BRONCHUS_DOOR.get());

        this.tag(BlockTags.TRAPDOORS)
                .add(CCBlocks.BRONCHUS_TRAPDOOR.get());

        this.tag(BlockTags.PRESSURE_PLATES)
                .add(CCBlocks.BRONCHUS_PRESSURE_PLATE.get());

        this.tag(BlockTags.STONE_BRICKS)
                .add(CCBlocks.THUNDERSTONE_BRICKS.get())
                .add(CCBlocks.PUMICE_BRICKS.get())
                .add(CCBlocks.BISMITE_BRICKS.get())
                .add(CCBlocks.HOLY_MARBLE_BRICKS.get())
                .add(CCBlocks.CRUSTONE_BRICKS.get());

        this.tag(Tags.Blocks.STONES)
                .add(CCBlocks.THUNDERSTONE.get(), CCBlocks.CRUSTONE.get(), CCBlocks.BISMITE.get(), CCBlocks.HOLY_MARBLE.get(), CCBlocks.PUMICE.get(), CCBlocks.PYRITE.get(), CCBlocks.GOLDSTONE.get());

        this.tag(BlockTags.WALLS)
                .add(CCBlocks.THUNDERSTONE_WALL.get(), CCBlocks.CHISELED_THUNDERSTONE_WALL.get(), CCBlocks.THUNDERSTONE_BRICKS_WALL.get(), CCBlocks.POLISHED_THUNDERSTONE_WALL.get())
                .add(CCBlocks.BISMITE_WALL.get(), CCBlocks.CHISELED_BISMITE_WALL.get(), CCBlocks.CRACKED_BISMITE_WALL.get(), CCBlocks.POLISHED_BISMITE_WALL.get(), CCBlocks.BISMITE_BRICKS_WALL.get())
                .add(CCBlocks.BLUE_BISMUTH_WALL.get(), CCBlocks.PURPLE_BISMUTH_WALL.get(), CCBlocks.VIOLET_BISMUTH_WALL.get(), CCBlocks.YELLOW_BISMUTH_WALL.get(), CCBlocks.RAINBOW_BISMUTH_WALL.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS_WALL.get(), CCBlocks.PURPLE_BISMUTH_BRICKS_WALL.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS_WALL.get(), CCBlocks.VIOLET_BISMUTH_BRICKS_WALL.get(), CCBlocks.YELLOW_BISMUTH_BRICKS_WALL.get())
                .add(CCBlocks.CRUSTONE_WALL.get(), CCBlocks.CRUSTONE_BRICKS_WALL.get(), CCBlocks.POLISHED_CRUSTONE_WALL.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get(), CCBlocks.CHISELED_CRUSTONE_WALL.get())
                .add(CCBlocks.HOLY_MARBLE_WALL.get(), CCBlocks.HOLY_MARBLE_BRICKS_WALL.get(), CCBlocks.CHISELED_HOLY_MARBLE_WALL.get(), CCBlocks.CRACKED_HOLY_MARBLE_WALL.get(), CCBlocks.POLISHED_HOLY_MARBLE_WALL.get())
                .add(CCBlocks.GOLDSTONE_WALL.get())
                .add(CCBlocks.PUMICE_WALL.get(), CCBlocks.PUMICE_BRICKS_WALL.get(), CCBlocks.CHISELED_PUMICE_WALL.get(), CCBlocks.CRACKED_PUMICE_WALL.get(), CCBlocks.POLISHED_PUMICE_WALL.get())
                .add(CCBlocks.PYRITE_WALL.get());

        this.tag(BlockTags.SLABS)
                .add(CCBlocks.THUNDERSTONE_SLAB.get(), CCBlocks.CHISELED_THUNDERSTONE_SLAB.get(), CCBlocks.THUNDERSTONE_BRICKS_SLAB.get(), CCBlocks.POLISHED_THUNDERSTONE_SLAB.get())
                .add(CCBlocks.BISMITE_SLAB.get(), CCBlocks.CHISELED_BISMITE_SLAB.get(), CCBlocks.CRACKED_BISMITE_SLAB.get(), CCBlocks.POLISHED_BISMITE_SLAB.get(), CCBlocks.BISMITE_BRICKS_SLAB.get())
                .add(CCBlocks.BLUE_BISMUTH_SLAB.get(), CCBlocks.PURPLE_BISMUTH_SLAB.get(), CCBlocks.VIOLET_BISMUTH_SLAB.get(), CCBlocks.YELLOW_BISMUTH_SLAB.get(), CCBlocks.RAINBOW_BISMUTH_SLAB.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS_SLAB.get(), CCBlocks.PURPLE_BISMUTH_BRICKS_SLAB.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS_SLAB.get(), CCBlocks.VIOLET_BISMUTH_BRICKS_SLAB.get(), CCBlocks.YELLOW_BISMUTH_BRICKS_SLAB.get())
                .add(CCBlocks.BRONCHUS_SLAB.get())
                .add(CCBlocks.CRUSTONE_SLAB.get(), CCBlocks.CRUSTONE_BRICKS_SLAB.get(), CCBlocks.POLISHED_CRUSTONE_SLAB.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get(), CCBlocks.CHISELED_CRUSTONE_SLAB.get())
                .add(CCBlocks.HOLY_MARBLE_SLAB.get(), CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get(), CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get(), CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get(), CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get())
                .add(CCBlocks.GOLDSTONE_SLAB.get(), CCBlocks.PUMICE_SLAB.get(), CCBlocks.PUMICE_BRICKS_SLAB.get(), CCBlocks.CHISELED_PUMICE_SLAB.get(), CCBlocks.CRACKED_PUMICE_SLAB.get(), CCBlocks.POLISHED_PUMICE_SLAB.get(), CCBlocks.PYRITE_SLAB.get());

        this.tag(BlockTags.STAIRS)
                .add(CCBlocks.THUNDERSTONE_STAIRS.get(), CCBlocks.CHISELED_THUNDERSTONE_STAIRS.get(), CCBlocks.THUNDERSTONE_BRICKS_STAIRS.get(), CCBlocks.POLISHED_THUNDERSTONE_STAIRS.get())
                .add(CCBlocks.BISMITE_STAIRS.get(), CCBlocks.CHISELED_BISMITE_STAIRS.get(), CCBlocks.CRACKED_BISMITE_STAIRS.get(), CCBlocks.POLISHED_BISMITE_STAIRS.get(), CCBlocks.BISMITE_BRICKS_STAIRS.get())
                .add(CCBlocks.BLUE_BISMUTH_STAIRS.get(), CCBlocks.PURPLE_BISMUTH_STAIRS.get(), CCBlocks.VIOLET_BISMUTH_STAIRS.get(), CCBlocks.YELLOW_BISMUTH_STAIRS.get(), CCBlocks.RAINBOW_BISMUTH_STAIRS.get())
                .add(CCBlocks.BLUE_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.PURPLE_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.RAINBOW_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.VIOLET_BISMUTH_BRICKS_STAIRS.get(), CCBlocks.YELLOW_BISMUTH_BRICKS_STAIRS.get())
                .add(CCBlocks.BRONCHUS_STAIRS.get())
                .add(CCBlocks.CRUSTONE_STAIRS.get(), CCBlocks.CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.POLISHED_CRUSTONE_STAIRS.get(), CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get(), CCBlocks.CHISELED_CRUSTONE_STAIRS.get())
                .add(CCBlocks.HOLY_MARBLE_STAIRS.get(), CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get(), CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get(), CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get(), CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get())
                .add(CCBlocks.GOLDSTONE_STAIRS.get(), CCBlocks.PUMICE_STAIRS.get(), CCBlocks.PUMICE_BRICKS_STAIRS.get(), CCBlocks.CHISELED_PUMICE_STAIRS.get(), CCBlocks.CRACKED_PUMICE_STAIRS.get(), CCBlocks.POLISHED_PUMICE_STAIRS.get(), CCBlocks.PYRITE_STAIRS.get());

        // --- CUSTOM MOD TAGS ---
        this.tag(CCTags.Blocks.CC_BLOOD_BLOCK)
                .add(CCBlocks.FLESH_BLOCK.get())
                .add(CCBlocks.MUSCLE_BLOCK.get())
                .add(CCBlocks.FAT_TISSUE_BLOCK.get())
                .add(CCBlocks.TENDON_BLOCK.get())
                .add(CCBlocks.ROTTEN_FLESH_BLOCK.get());

        this.tag(CCTags.Blocks.CC_ARTREE_BLOCK)
                .add(CCBlocks.ARTREE_BASE.get())
                .add(CCBlocks.ARTREE_CAPILLARY.get())
                .add(CCBlocks.ARTREE_VEIN.get());

        // Logs Tag for Bronchus
        this.tag(BlockTags.LOGS)
                .add(CCBlocks.BRONCHUS.get());
    }
}