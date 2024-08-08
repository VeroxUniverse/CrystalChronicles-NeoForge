package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

import java.util.function.Function;

public class CCBlockStateProvider extends BlockStateProvider {

    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalChronicles.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CCBlocks.BLOODSTONE_BLOCK);
        blockWithItem(CCBlocks.VOIDSTONE_BLOCK);
        blockWithItem(CCBlocks.LUNARITE_BLOCK);
        blockWithItem(CCBlocks.PYRONITE_BLOCK);
        blockWithItem(CCBlocks.CELESTITE_BLOCK);
        blockWithItem(CCBlocks.TOXITE_BLOCK);
        blockWithItem(CCBlocks.BLOODSTONE_BUDDING);
        blockWithItem(CCBlocks.VOIDSTONE_BUDDING);
        blockWithItem(CCBlocks.LUNARITE_BUDDING);
        blockWithItem(CCBlocks.PYRONITE_BUDDING);
        blockWithItem(CCBlocks.CELESTITE_BUDDING);
        blockWithItem(CCBlocks.TOXITE_BUDDING);
        blockWithItem(CCBlocks.MARBLE);
        blockWithItem(CCBlocks.HEMATITE);
        blockWithItem(CCBlocks.SHALE);
        blockWithItem(CCBlocks.MAGNETITE);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("crystal_chronicles:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
