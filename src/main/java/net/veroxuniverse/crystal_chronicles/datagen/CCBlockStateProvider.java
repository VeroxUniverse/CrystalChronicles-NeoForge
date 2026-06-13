package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class CCBlockStateProvider extends BlockStateProvider {

    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalChronicles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        ModelFile waterModel = models().getExistingFile(mcLoc("block/water"));

        getVariantBuilder(CCFluids.ACIDIC_BRINE_BLOCK.get())
                .partialState()
                .setModels(new ConfiguredModel(waterModel));

        // ==========================================================================================
        // 1. LIGHTNING
        // ==========================================================================================
        generateStoneFamily(CCBlocks.THUNDERSTONE, CCBlocks.THUNDERSTONE_STAIRS, CCBlocks.THUNDERSTONE_SLAB, CCBlocks.THUNDERSTONE_WALL);
        generateStoneFamily(CCBlocks.THUNDERSTONE_BRICKS, CCBlocks.THUNDERSTONE_BRICKS_STAIRS, CCBlocks.THUNDERSTONE_BRICKS_SLAB, CCBlocks.THUNDERSTONE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.CHISELED_THUNDERSTONE, CCBlocks.CHISELED_THUNDERSTONE_STAIRS, CCBlocks.CHISELED_THUNDERSTONE_SLAB, CCBlocks.CHISELED_THUNDERSTONE_WALL);
        generateStoneFamily(CCBlocks.POLISHED_THUNDERSTONE, CCBlocks.POLISHED_THUNDERSTONE_STAIRS, CCBlocks.POLISHED_THUNDERSTONE_SLAB, CCBlocks.POLISHED_THUNDERSTONE_WALL);

        // ==========================================================================================
        // 2. BISMUTH (END)
        // ==========================================================================================
        blockWithItem(CCBlocks.POLISHED_STONE_BRICKS);

        // Bismite

        stairsBlock(((StairBlock) CCBlocks.BISMITE_STAIRS.get()), blockTexture(CCBlocks.BISMITE.get()));
        slabBlock(((SlabBlock) CCBlocks.BISMITE_SLAB.get()), CCBlocks.BISMITE.getId(), blockTexture(CCBlocks.BISMITE.get()));
        wallBlock(((WallBlock) CCBlocks.BISMITE_WALL.get()), blockTexture(CCBlocks.BISMITE.get()));
        blockItem(CCBlocks.BISMITE_STAIRS);
        blockItem(CCBlocks.BISMITE_SLAB);

        generateStoneFamily(CCBlocks.BISMITE_BRICKS, CCBlocks.BISMITE_BRICKS_STAIRS, CCBlocks.BISMITE_BRICKS_SLAB, CCBlocks.BISMITE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.CHISELED_BISMITE, CCBlocks.CHISELED_BISMITE_STAIRS, CCBlocks.CHISELED_BISMITE_SLAB, CCBlocks.CHISELED_BISMITE_WALL);
        generateStoneFamily(CCBlocks.CRACKED_BISMITE, CCBlocks.CRACKED_BISMITE_STAIRS, CCBlocks.CRACKED_BISMITE_SLAB, CCBlocks.CRACKED_BISMITE_WALL);
        generateStoneFamily(CCBlocks.POLISHED_BISMITE, CCBlocks.POLISHED_BISMITE_STAIRS, CCBlocks.POLISHED_BISMITE_SLAB, CCBlocks.POLISHED_BISMITE_WALL);

        // Bismuth Bricks
        generateBismuthBrickFamily(CCBlocks.BLUE_BISMUTH_BRICKS, CCBlocks.BLUE_BISMUTH_BRICKS_STAIRS, CCBlocks.BLUE_BISMUTH_BRICKS_SLAB, CCBlocks.BLUE_BISMUTH_BRICKS_WALL);
        generateBismuthBrickFamily(CCBlocks.PURPLE_BISMUTH_BRICKS, CCBlocks.PURPLE_BISMUTH_BRICKS_STAIRS, CCBlocks.PURPLE_BISMUTH_BRICKS_SLAB, CCBlocks.PURPLE_BISMUTH_BRICKS_WALL);
        generateBismuthBrickFamily(CCBlocks.RAINBOW_BISMUTH_BRICKS, CCBlocks.RAINBOW_BISMUTH_BRICKS_STAIRS, CCBlocks.RAINBOW_BISMUTH_BRICKS_SLAB, CCBlocks.RAINBOW_BISMUTH_BRICKS_WALL);
        generateBismuthBrickFamily(CCBlocks.VIOLET_BISMUTH_BRICKS, CCBlocks.VIOLET_BISMUTH_BRICKS_STAIRS, CCBlocks.VIOLET_BISMUTH_BRICKS_SLAB, CCBlocks.VIOLET_BISMUTH_BRICKS_WALL);
        generateBismuthBrickFamily(CCBlocks.YELLOW_BISMUTH_BRICKS, CCBlocks.YELLOW_BISMUTH_BRICKS_STAIRS, CCBlocks.YELLOW_BISMUTH_BRICKS_SLAB, CCBlocks.YELLOW_BISMUTH_BRICKS_WALL);

        // Bismuth Walls
        wallBlock(((WallBlock) CCBlocks.BLUE_BISMUTH_WALL.get()), blockTexture(CCBlocks.BLUE_BISMUTH.get()));
        wallBlock(((WallBlock) CCBlocks.PURPLE_BISMUTH_WALL.get()), blockTexture(CCBlocks.PURPLE_BISMUTH.get()));
        wallBlock(((WallBlock) CCBlocks.VIOLET_BISMUTH_WALL.get()), blockTexture(CCBlocks.VIOLET_BISMUTH.get()));
        wallBlock(((WallBlock) CCBlocks.YELLOW_BISMUTH_WALL.get()), blockTexture(CCBlocks.YELLOW_BISMUTH.get()));
        wallBlock(((WallBlock) CCBlocks.RAINBOW_BISMUTH_WALL.get()), blockTexture(CCBlocks.RAINBOW_BISMUTH.get()));

        // ==========================================================================================
        // 3. BLOOD
        // ==========================================================================================
        blockWithItem(CCBlocks.ALVEOLUS_BLOCK);
        blockWithItem(CCBlocks.FAT_TISSUE_BLOCK);
        blockWithItem(CCBlocks.ROTTEN_FLESH_BLOCK);
        blockWithItem(CCBlocks.HEMALITE_BLOCK);
        saplingBlock(CCBlocks.ALVEOLUS);

        generateStoneFamily(CCBlocks.CRUSTONE, CCBlocks.CRUSTONE_STAIRS, CCBlocks.CRUSTONE_SLAB, CCBlocks.CRUSTONE_WALL);
        generateStoneFamily(CCBlocks.CRUSTONE_BRICKS, CCBlocks.CRUSTONE_BRICKS_STAIRS, CCBlocks.CRUSTONE_BRICKS_SLAB, CCBlocks.CRUSTONE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.CRACKED_CRUSTONE_BRICKS, CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS, CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB, CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.POLISHED_CRUSTONE, CCBlocks.POLISHED_CRUSTONE_STAIRS, CCBlocks.POLISHED_CRUSTONE_SLAB, CCBlocks.POLISHED_CRUSTONE_WALL);
        generateStoneFamily(CCBlocks.CHISELED_CRUSTONE, CCBlocks.CHISELED_CRUSTONE_STAIRS, CCBlocks.CHISELED_CRUSTONE_SLAB, CCBlocks.CHISELED_CRUSTONE_WALL);

        blockWithItem(CCBlocks.BRONCHUS_PLANKS);
        stairsBlock(((StairBlock) CCBlocks.BRONCHUS_STAIRS.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        slabBlock(((SlabBlock) CCBlocks.BRONCHUS_SLAB.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) CCBlocks.BRONCHUS_PRESSURE_PLATE.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        buttonBlock(((ButtonBlock) CCBlocks.BRONCHUS_BUTTON.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        fenceBlock(((FenceBlock) CCBlocks.BRONCHUS_FENCE.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) CCBlocks.BRONCHUS_FENCE_GATE.get()), blockTexture(CCBlocks.BRONCHUS_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) CCBlocks.BRONCHUS_DOOR.get()), modLoc("block/bronchus_door_bottom"), modLoc("block/bronchus_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) CCBlocks.BRONCHUS_TRAPDOOR.get()), modLoc("block/bronchus_trapdoor"), true, "cutout");

        blockItem(CCBlocks.BRONCHUS_STAIRS);
        blockItem(CCBlocks.BRONCHUS_SLAB);
        blockItem(CCBlocks.BRONCHUS_PRESSURE_PLATE);
        blockItem(CCBlocks.BRONCHUS_FENCE_GATE);
        blockItem(CCBlocks.BRONCHUS_TRAPDOOR, "_bottom");

        simpleCross(CCBlocks.VILLI);
        simpleCross(CCBlocks.HANGING_VEINS);

        // ==========================================================================================
        // 4. HOLY
        // ==========================================================================================
        blockWithItem(CCBlocks.CLOUD_BLOCK);
        blockWithItem(CCBlocks.DENSE_CLOUDS);
        //blockWithItem(CCBlocks.GOLDSTONE);

        generateStoneFamily(CCBlocks.HOLY_MARBLE, CCBlocks.HOLY_MARBLE_STAIRS, CCBlocks.HOLY_MARBLE_SLAB, CCBlocks.HOLY_MARBLE_WALL);
        generateStoneFamily(CCBlocks.HOLY_MARBLE_BRICKS, CCBlocks.HOLY_MARBLE_BRICKS_STAIRS, CCBlocks.HOLY_MARBLE_BRICKS_SLAB, CCBlocks.HOLY_MARBLE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.CHISELED_HOLY_MARBLE, CCBlocks.CHISELED_HOLY_MARBLE_STAIRS, CCBlocks.CHISELED_HOLY_MARBLE_SLAB, CCBlocks.CHISELED_HOLY_MARBLE_WALL);
        generateStoneFamily(CCBlocks.CRACKED_HOLY_MARBLE, CCBlocks.CRACKED_HOLY_MARBLE_STAIRS, CCBlocks.CRACKED_HOLY_MARBLE_SLAB, CCBlocks.CRACKED_HOLY_MARBLE_WALL);
        generateStoneFamily(CCBlocks.POLISHED_HOLY_MARBLE, CCBlocks.POLISHED_HOLY_MARBLE_STAIRS, CCBlocks.POLISHED_HOLY_MARBLE_SLAB, CCBlocks.POLISHED_HOLY_MARBLE_WALL);
        generateStoneFamily(CCBlocks.GOLDSTONE, CCBlocks.GOLDSTONE_STAIRS, CCBlocks.GOLDSTONE_SLAB, CCBlocks.GOLDSTONE_WALL);

        // ==========================================================================================
        // 5. FIRE
        // ==========================================================================================
        blockWithItem(CCBlocks.VOLCANITE_BLOCK);
        blockWithItem(CCBlocks.SULPHURIC_SOIL);
        blockWithItem(CCBlocks.SULPHUR_CRYSTAL);
        blockWithItem(CCBlocks.SULPHUR_POWDER);

        generateStoneFamily(CCBlocks.PUMICE, CCBlocks.PUMICE_STAIRS, CCBlocks.PUMICE_SLAB, CCBlocks.PUMICE_WALL);
        generateStoneFamily(CCBlocks.PUMICE_BRICKS, CCBlocks.PUMICE_BRICKS_STAIRS, CCBlocks.PUMICE_BRICKS_SLAB, CCBlocks.PUMICE_BRICKS_WALL);
        generateStoneFamily(CCBlocks.CHISELED_PUMICE, CCBlocks.CHISELED_PUMICE_STAIRS, CCBlocks.CHISELED_PUMICE_SLAB, CCBlocks.CHISELED_PUMICE_WALL);
        generateStoneFamily(CCBlocks.CRACKED_PUMICE, CCBlocks.CRACKED_PUMICE_STAIRS, CCBlocks.CRACKED_PUMICE_SLAB, CCBlocks.CRACKED_PUMICE_WALL);
        generateStoneFamily(CCBlocks.POLISHED_PUMICE, CCBlocks.POLISHED_PUMICE_STAIRS, CCBlocks.POLISHED_PUMICE_SLAB, CCBlocks.POLISHED_PUMICE_WALL);
        generateStoneFamily(CCBlocks.PYRITE, CCBlocks.PYRITE_STAIRS, CCBlocks.PYRITE_SLAB, CCBlocks.PYRITE_WALL);

        directionalCluster(CCBlocks.SMALL_SULPHUR_CLUSTER);
        directionalCluster(CCBlocks.MEDIUM_SULPHUR_CLUSTER);
        pillarBlock(CCBlocks.GREEN_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.ORANGE_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.RED_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.YELLOW_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.VERMILLION_SULPHUR_POOL, "_top");
    }

    // ==========================================================================================
    // HELPERS
    // ==========================================================================================

    private void generateStoneFamily(DeferredBlock<Block> base, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> wall) {
        simpleBlockWithItem(base.get(), cubeAll(base.get()));
        stairsBlock(((StairBlock) stairs.get()), blockTexture(base.get()));
        slabBlock(((SlabBlock) slab.get()), base.getId(), blockTexture(base.get()));
        wallBlock(((WallBlock) wall.get()), blockTexture(base.get()));
        blockItem(stairs);
        blockItem(slab);
    }

    private void generateBismuthBrickFamily(DeferredBlock<Block> base, DeferredBlock<Block> stairs, DeferredBlock<Block> slab, DeferredBlock<Block> wall) {
        simpleBlockWithItem(base.get(), cubeAll(base.get()));
        stairsBlock(((StairBlock) stairs.get()), blockTexture(base.get()));
        slabBlock(((SlabBlock) slab.get()), base.getId(), blockTexture(base.get()));
        wallBlock(((WallBlock) wall.get()), blockTexture(base.get()));
        blockItem(stairs);
        blockItem(slab);
    }

    private void simpleCross(DeferredBlock<Block> block) {
        simpleBlock(block.get(), models().cross(blockTexture(block.get()).getPath(), blockTexture(block.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void pillarBlock(DeferredBlock<Block> deferredBlock, String topSuffix) {
        String name = deferredBlock.getId().getPath();
        axisBlock((RotatedPillarBlock) deferredBlock.get(), blockTexture(deferredBlock.get()), modLoc("block/" + name + topSuffix));
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + name));
    }

    private void directionalCluster(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        ModelFile model = models().getBuilder(name)
                .parent(models().getExistingFile(mcLoc("block/amethyst_cluster")))
                .texture("cross", blockTexture(block.get()))
                .renderType("cutout");
        directionalBlock(block.get(), model);
        flatItemFromBlock(block);
    }

    private void flatItemFromBlock(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        itemModels().getBuilder(name).parent(itemModels().getExistingFile(mcLoc("item/generated"))).texture("layer0", modLoc("block/" + name));
    }
}