package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class CCBlockStateProvider extends BlockStateProvider {

    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalChronicles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // BLOOD //

        blockWithItem(CCBlocks.ALVEOLUS_BLOCK);
        blockWithItem(CCBlocks.FAT_TISSUE_BLOCK);
        blockWithItem(CCBlocks.ROTTEN_FLESH_BLOCK);
        blockWithItem(CCBlocks.CRUSTONE);
        blockWithItem(CCBlocks.CRUSTONE_BRICKS);
        blockWithItem(CCBlocks.CRACKED_CRUSTONE_BRICKS);
        blockWithItem(CCBlocks.POLISHED_CRUSTONE);
        blockWithItem(CCBlocks.CHISELED_CRUSTONE);
        blockWithItem(CCBlocks.HEMALITE_BLOCK);

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

        wallBlock(((WallBlock) CCBlocks.CRUSTONE_WALL.get()), blockTexture(CCBlocks.CRUSTONE.get()));
        wallBlock(((WallBlock) CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get()), blockTexture(CCBlocks.CRACKED_CRUSTONE_BRICKS.get()));
        wallBlock(((WallBlock) CCBlocks.CRUSTONE_BRICKS_WALL.get()), blockTexture(CCBlocks.CRUSTONE_BRICKS.get()));
        wallBlock(((WallBlock) CCBlocks.POLISHED_CRUSTONE_WALL.get()), blockTexture(CCBlocks.POLISHED_CRUSTONE.get()));
        wallBlock(((WallBlock) CCBlocks.CHISELED_CRUSTONE_WALL.get()), blockTexture(CCBlocks.CHISELED_CRUSTONE.get()));

        stairsBlock(((StairBlock) CCBlocks.CRUSTONE_STAIRS.get()), blockTexture(CCBlocks.CRUSTONE.get()));
        stairsBlock(((StairBlock) CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get()), blockTexture(CCBlocks.CRACKED_CRUSTONE_BRICKS.get()));
        stairsBlock(((StairBlock) CCBlocks.CRUSTONE_BRICKS_STAIRS.get()), blockTexture(CCBlocks.CRUSTONE_BRICKS.get()));
        stairsBlock(((StairBlock) CCBlocks.POLISHED_CRUSTONE_STAIRS.get()), blockTexture(CCBlocks.POLISHED_CRUSTONE.get()));
        stairsBlock(((StairBlock) CCBlocks.CHISELED_CRUSTONE_STAIRS.get()), blockTexture(CCBlocks.CHISELED_CRUSTONE.get()));
        blockItem(CCBlocks.CRUSTONE_STAIRS);
        blockItem(CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS);
        blockItem(CCBlocks.CRUSTONE_BRICKS_STAIRS);
        blockItem(CCBlocks.POLISHED_CRUSTONE_STAIRS);
        blockItem(CCBlocks.CHISELED_CRUSTONE_STAIRS);

        slabBlock(((SlabBlock) CCBlocks.CRUSTONE_SLAB.get()), blockTexture(CCBlocks.CRUSTONE.get()), blockTexture(CCBlocks.CRUSTONE.get()));
        slabBlock(((SlabBlock) CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get()), blockTexture(CCBlocks.CRACKED_CRUSTONE_BRICKS.get()), blockTexture(CCBlocks.CRACKED_CRUSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) CCBlocks.CRUSTONE_BRICKS_SLAB.get()), blockTexture(CCBlocks.CRUSTONE_BRICKS.get()), blockTexture(CCBlocks.CRUSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) CCBlocks.POLISHED_CRUSTONE_SLAB.get()), blockTexture(CCBlocks.POLISHED_CRUSTONE.get()), blockTexture(CCBlocks.POLISHED_CRUSTONE.get()));
        slabBlock(((SlabBlock) CCBlocks.CHISELED_CRUSTONE_SLAB.get()), blockTexture(CCBlocks.CHISELED_CRUSTONE.get()), blockTexture(CCBlocks.CHISELED_CRUSTONE.get()));
        blockItem(CCBlocks.CRUSTONE_SLAB);
        blockItem(CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB);
        blockItem(CCBlocks.CRUSTONE_BRICKS_SLAB);
        blockItem(CCBlocks.POLISHED_CRUSTONE_SLAB);
        blockItem(CCBlocks.CHISELED_CRUSTONE_SLAB);

        saplingBlock(CCBlocks.ALVEOLUS);


        simpleBlock(CCBlocks.BLOOD_BASES.get(),
                models().cross(blockTexture(CCBlocks.BLOOD_BASES.get()).getPath(), blockTexture(CCBlocks.BLOOD_BASES.get())).renderType("cutout"));

        simpleBlock(CCBlocks.HANGING_VEINS.get(),
                models().cross(blockTexture(CCBlocks.HANGING_VEINS.get()).getPath(), blockTexture(CCBlocks.HANGING_VEINS.get())).renderType("cutout"));

        // HOLY //

        blockWithItem(CCBlocks.CLOUD_BLOCK);
        blockWithItem(CCBlocks.DENSE_CLOUDS);

        blockWithItem(CCBlocks.HOLY_MARBLE);
        stairsBlock(((StairBlock) CCBlocks.HOLY_MARBLE_STAIRS.get()), blockTexture(CCBlocks.HOLY_MARBLE.get()));
        slabBlock(((SlabBlock) CCBlocks.HOLY_MARBLE_SLAB.get()), blockTexture(CCBlocks.HOLY_MARBLE.get()), blockTexture(CCBlocks.HOLY_MARBLE.get()));
        wallBlock(((WallBlock) CCBlocks.HOLY_MARBLE_WALL.get()), blockTexture(CCBlocks.HOLY_MARBLE.get()));
        blockItem(CCBlocks.HOLY_MARBLE_STAIRS);
        blockItem(CCBlocks.HOLY_MARBLE_SLAB);

        blockWithItem(CCBlocks.HOLY_MARBLE_BRICKS);
        stairsBlock(((StairBlock) CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get()), blockTexture(CCBlocks.HOLY_MARBLE_BRICKS.get()));
        slabBlock(((SlabBlock) CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get()), blockTexture(CCBlocks.HOLY_MARBLE_BRICKS.get()), blockTexture(CCBlocks.HOLY_MARBLE_BRICKS.get()));
        wallBlock(((WallBlock) CCBlocks.HOLY_MARBLE_BRICKS_WALL.get()), blockTexture(CCBlocks.HOLY_MARBLE_BRICKS.get()));
        blockItem(CCBlocks.HOLY_MARBLE_BRICKS_STAIRS);
        blockItem(CCBlocks.HOLY_MARBLE_BRICKS_SLAB);

        blockWithItem(CCBlocks.CHISELED_HOLY_MARBLE);
        stairsBlock(((StairBlock) CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get()), blockTexture(CCBlocks.CHISELED_HOLY_MARBLE.get()));
        slabBlock(((SlabBlock) CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get()), blockTexture(CCBlocks.CHISELED_HOLY_MARBLE.get()), blockTexture(CCBlocks.CHISELED_HOLY_MARBLE.get()));
        wallBlock(((WallBlock) CCBlocks.CHISELED_HOLY_MARBLE_WALL.get()), blockTexture(CCBlocks.CHISELED_HOLY_MARBLE.get()));
        blockItem(CCBlocks.CHISELED_HOLY_MARBLE_STAIRS);
        blockItem(CCBlocks.CHISELED_HOLY_MARBLE_SLAB);

        blockWithItem(CCBlocks.CRACKED_HOLY_MARBLE);
        stairsBlock(((StairBlock) CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get()), blockTexture(CCBlocks.CRACKED_HOLY_MARBLE.get()));
        slabBlock(((SlabBlock) CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get()), blockTexture(CCBlocks.CRACKED_HOLY_MARBLE.get()), blockTexture(CCBlocks.CRACKED_HOLY_MARBLE.get()));
        wallBlock(((WallBlock) CCBlocks.CRACKED_HOLY_MARBLE_WALL.get()), blockTexture(CCBlocks.CRACKED_HOLY_MARBLE.get()));
        blockItem(CCBlocks.CRACKED_HOLY_MARBLE_STAIRS);
        blockItem(CCBlocks.CRACKED_HOLY_MARBLE_SLAB);

        blockWithItem(CCBlocks.POLISHED_HOLY_MARBLE);
        stairsBlock(((StairBlock) CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get()), blockTexture(CCBlocks.POLISHED_HOLY_MARBLE.get()));
        slabBlock(((SlabBlock) CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get()), blockTexture(CCBlocks.POLISHED_HOLY_MARBLE.get()), blockTexture(CCBlocks.POLISHED_HOLY_MARBLE.get()));
        wallBlock(((WallBlock) CCBlocks.POLISHED_HOLY_MARBLE_WALL.get()), blockTexture(CCBlocks.POLISHED_HOLY_MARBLE.get()));
        blockItem(CCBlocks.POLISHED_HOLY_MARBLE_STAIRS);
        blockItem(CCBlocks.POLISHED_HOLY_MARBLE_SLAB);

        blockWithItem(CCBlocks.GOLDSTONE);
        stairsBlock(((StairBlock) CCBlocks.GOLDSTONE_STAIRS.get()), blockTexture(CCBlocks.GOLDSTONE.get()));
        slabBlock(((SlabBlock) CCBlocks.GOLDSTONE_SLAB.get()), blockTexture(CCBlocks.GOLDSTONE.get()), blockTexture(CCBlocks.GOLDSTONE.get()));
        wallBlock(((WallBlock) CCBlocks.GOLDSTONE_WALL.get()), blockTexture(CCBlocks.GOLDSTONE.get()));
        blockItem(CCBlocks.GOLDSTONE_STAIRS);
        blockItem(CCBlocks.GOLDSTONE_SLAB);

        // FIRE //

        blockWithItem(CCBlocks.PUMICE);
        stairsBlock(((StairBlock) CCBlocks.PUMICE_STAIRS.get()), blockTexture(CCBlocks.PUMICE.get()));
        slabBlock(((SlabBlock) CCBlocks.PUMICE_SLAB.get()), blockTexture(CCBlocks.PUMICE.get()), blockTexture(CCBlocks.PUMICE.get()));
        wallBlock(((WallBlock) CCBlocks.PUMICE_WALL.get()), blockTexture(CCBlocks.PUMICE.get()));
        blockItem(CCBlocks.PUMICE_STAIRS);
        blockItem(CCBlocks.PUMICE_SLAB);

        blockWithItem(CCBlocks.PUMICE_BRICKS);
        stairsBlock(((StairBlock) CCBlocks.PUMICE_BRICKS_STAIRS.get()), blockTexture(CCBlocks.PUMICE_BRICKS.get()));
        slabBlock(((SlabBlock) CCBlocks.PUMICE_BRICKS_SLAB.get()), blockTexture(CCBlocks.PUMICE_BRICKS.get()), blockTexture(CCBlocks.PUMICE_BRICKS.get()));
        wallBlock(((WallBlock) CCBlocks.PUMICE_BRICKS_WALL.get()), blockTexture(CCBlocks.PUMICE_BRICKS.get()));
        blockItem(CCBlocks.PUMICE_BRICKS_STAIRS);
        blockItem(CCBlocks.PUMICE_BRICKS_SLAB);

        blockWithItem(CCBlocks.CHISELED_PUMICE);
        stairsBlock(((StairBlock) CCBlocks.CHISELED_PUMICE_STAIRS.get()), blockTexture(CCBlocks.CHISELED_PUMICE.get()));
        slabBlock(((SlabBlock) CCBlocks.CHISELED_PUMICE_SLAB.get()), blockTexture(CCBlocks.CHISELED_PUMICE.get()), blockTexture(CCBlocks.CHISELED_PUMICE.get()));
        wallBlock(((WallBlock) CCBlocks.CHISELED_PUMICE_WALL.get()), blockTexture(CCBlocks.CHISELED_PUMICE.get()));
        blockItem(CCBlocks.CHISELED_PUMICE_STAIRS);
        blockItem(CCBlocks.CHISELED_PUMICE_SLAB);

        blockWithItem(CCBlocks.CRACKED_PUMICE);
        stairsBlock(((StairBlock) CCBlocks.CRACKED_PUMICE_STAIRS.get()), blockTexture(CCBlocks.CRACKED_PUMICE.get()));
        slabBlock(((SlabBlock) CCBlocks.CRACKED_PUMICE_SLAB.get()), blockTexture(CCBlocks.CRACKED_PUMICE.get()), blockTexture(CCBlocks.CRACKED_PUMICE.get()));
        wallBlock(((WallBlock) CCBlocks.CRACKED_PUMICE_WALL.get()), blockTexture(CCBlocks.CRACKED_PUMICE.get()));
        blockItem(CCBlocks.CRACKED_PUMICE_STAIRS);
        blockItem(CCBlocks.CRACKED_PUMICE_SLAB);

        blockWithItem(CCBlocks.POLISHED_PUMICE);
        stairsBlock(((StairBlock) CCBlocks.POLISHED_PUMICE_STAIRS.get()), blockTexture(CCBlocks.POLISHED_PUMICE.get()));
        slabBlock(((SlabBlock) CCBlocks.POLISHED_PUMICE_SLAB.get()), blockTexture(CCBlocks.POLISHED_PUMICE.get()), blockTexture(CCBlocks.POLISHED_PUMICE.get()));
        wallBlock(((WallBlock) CCBlocks.POLISHED_PUMICE_WALL.get()), blockTexture(CCBlocks.POLISHED_PUMICE.get()));
        blockItem(CCBlocks.POLISHED_PUMICE_STAIRS);
        blockItem(CCBlocks.POLISHED_PUMICE_SLAB);

        blockWithItem(CCBlocks.PIRITE_BLOCK);
        stairsBlock(((StairBlock) CCBlocks.PIRITE_STAIRS.get()), blockTexture(CCBlocks.PIRITE_BLOCK.get()));
        slabBlock(((SlabBlock) CCBlocks.PIRITE_SLAB.get()), blockTexture(CCBlocks.PIRITE_BLOCK.get()), blockTexture(CCBlocks.PIRITE_BLOCK.get()));
        wallBlock(((WallBlock) CCBlocks.PIRITE_WALL.get()), blockTexture(CCBlocks.PIRITE_BLOCK.get()));
        blockItem(CCBlocks.PIRITE_STAIRS);
        blockItem(CCBlocks.PIRITE_SLAB);

        blockWithItem(CCBlocks.VOLCANITE_BLOCK);
        blockWithItem(CCBlocks.SULPHURIC_SOIL);
        blockWithItem(CCBlocks.SULPHUR_CRYSTAL);
        blockWithItem(CCBlocks.SULPHUR_DUST);
        directionalCluster(CCBlocks.SMALL_SULPHUR_CLUSTER);
        directionalCluster(CCBlocks.MEDIUM_SULPHUR_CLUSTER);
        pillarBlock(CCBlocks.GREEN_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.ORANGE_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.RED_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.YELLOW_SULPHUR_POOL, "_top");
        pillarBlock(CCBlocks.VERMILLION_SULPHUR_POOL, "_top");

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
        var side = blockTexture(deferredBlock.get());
        var end = modLoc("block/" + name + topSuffix);
        axisBlock((RotatedPillarBlock) deferredBlock.get(), side, end);
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + name));
    }

    private void directionalCluster(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        ModelFile model = models()
                .getBuilder(name)
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
