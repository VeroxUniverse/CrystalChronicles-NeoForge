package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

public class CCItemModelProvider extends ItemModelProvider {
    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CCItems.ICE_KNIGHT_HELMET.get());
        basicItem(CCItems.ICE_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.ICE_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.ICE_KNIGHT_BOOTS.get());
        basicItem(CCItems.BLOOD_KNIGHT_HELMET.get());
        basicItem(CCItems.BLOOD_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.BLOOD_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.BLOOD_KNIGHT_BOOTS.get());
        basicItem(CCItems.ENDER_MAGE_HELMET.get());
        basicItem(CCItems.ENDER_MAGE_CHESTPLATE.get());
        basicItem(CCItems.ENDER_MAGE_LEGGINGS.get());
        basicItem(CCItems.ENDER_MAGE_BOOTS.get());
        basicItem(CCItems.HOLY_KNIGHT_HELMET.get());
        basicItem(CCItems.HOLY_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.HOLY_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.HOLY_KNIGHT_BOOTS.get());
        basicItem(CCItems.HEMALITE_SHARD.get());
        basicItem(CCItems.VOIDSTONE_SHARD.get());
        basicItem(CCItems.DIVINITE_SHARD.get());
        basicItem(CCItems.VOLTITE_SHARD.get());
        basicItem(CCItems.FLORALITE_SHARD.get());
        basicItem(CCItems.VOLCANITE_SHARD.get());
        basicItem(CCItems.NATURE_KNIGHT_HELMET.get());
        basicItem(CCItems.NATURE_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.NATURE_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.NATURE_KNIGHT_BOOTS.get());
        basicItem(CCItems.FIRE_KNIGHT_HELMET.get());
        basicItem(CCItems.FIRE_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.FIRE_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.FIRE_KNIGHT_BOOTS.get());
        basicItem(CCItems.EVOCATION_KNIGHT_HELMET.get());
        basicItem(CCItems.EVOCATION_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.EVOCATION_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.EVOCATION_KNIGHT_BOOTS.get());
        basicItem(CCItems.LIGHTNING_KNIGHT_HELMET.get());
        basicItem(CCItems.LIGHTNING_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.LIGHTNING_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.LIGHTNING_KNIGHT_BOOTS.get());
        basicItem(CCItems.CLOUD_BUCKET.get());
        basicItem(CCItems.PRISMATIC_KNIGHT_HELMET.get());
        basicItem(CCItems.PRISMATIC_KNIGHT_CHESTPLATE.get());
        basicItem(CCItems.PRISMATIC_KNIGHT_LEGGINGS.get());
        basicItem(CCItems.PRISMATIC_KNIGHT_BOOTS.get());

        basicItem(CCItems.BISMUTH_CHISEL.get());
        basicItem(CCItems.AVARICITE_SHARD.get());
        basicItem(CCItems.BISMUTH_CANDY.get());
        basicItem(CCItems.FAT_TISSUE_BALL.get());
        basicItem(CCItems.ICE_SHARD.get());
        basicItem(CCItems.NEURON.get());
        basicItem(CCItems.EYE.get());
        basicItem(CCFluids.BLOOD_BUCKET.get());

        flowerItem(CCBlocks.VILLI);
        flowerItem(CCBlocks.AXON);
        flowerItem(CCBlocks.HANGING_VEINS);

        buttonItem(CCBlocks.BRONCHUS_BUTTON, CCBlocks.BRONCHUS_PLANKS);
        fenceItem(CCBlocks.BRONCHUS_FENCE, CCBlocks.BRONCHUS_PLANKS);

        basicItem(CCBlocks.BRONCHUS_DOOR.asItem());

        saplingItem(CCBlocks.ALVEOLUS);

        wallItem(CCBlocks.CRUSTONE_WALL, CCBlocks.CRUSTONE);
        wallItem(CCBlocks.CRUSTONE_BRICKS_WALL, CCBlocks.CRUSTONE_BRICKS);
        wallItem(CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL, CCBlocks.CRACKED_CRUSTONE_BRICKS);
        wallItem(CCBlocks.POLISHED_CRUSTONE_WALL, CCBlocks.POLISHED_CRUSTONE);
        wallItem(CCBlocks.CHISELED_CRUSTONE_WALL, CCBlocks.CHISELED_CRUSTONE);

        wallItem(CCBlocks.HOLY_MARBLE_WALL, CCBlocks.HOLY_MARBLE);
        wallItem(CCBlocks.HOLY_MARBLE_BRICKS_WALL, CCBlocks.HOLY_MARBLE_BRICKS);
        wallItem(CCBlocks.CHISELED_HOLY_MARBLE_WALL, CCBlocks.CHISELED_HOLY_MARBLE);
        wallItem(CCBlocks.CRACKED_HOLY_MARBLE_WALL, CCBlocks.CRACKED_HOLY_MARBLE);
        wallItem(CCBlocks.POLISHED_HOLY_MARBLE_WALL, CCBlocks.POLISHED_HOLY_MARBLE);
        wallItem(CCBlocks.GOLDSTONE_WALL, CCBlocks.GOLDSTONE);

        wallItem(CCBlocks.PUMICE_WALL, CCBlocks.PUMICE);
        wallItem(CCBlocks.PUMICE_BRICKS_WALL, CCBlocks.PUMICE_BRICKS);
        wallItem(CCBlocks.CHISELED_PUMICE_WALL, CCBlocks.CHISELED_PUMICE);
        wallItem(CCBlocks.CRACKED_PUMICE_WALL, CCBlocks.CRACKED_PUMICE);
        wallItem(CCBlocks.POLISHED_PUMICE_WALL, CCBlocks.POLISHED_PUMICE);
        wallItem(CCBlocks.PYRITE_WALL, CCBlocks.PYRITE);

        wallItem(CCBlocks.PUMICE_WALL, CCBlocks.PUMICE);
        wallItem(CCBlocks.PUMICE_BRICKS_WALL, CCBlocks.PUMICE_BRICKS);
        wallItem(CCBlocks.CHISELED_PUMICE_WALL, CCBlocks.CHISELED_PUMICE);
        wallItem(CCBlocks.CRACKED_PUMICE_WALL, CCBlocks.CRACKED_PUMICE);
        wallItem(CCBlocks.POLISHED_PUMICE_WALL, CCBlocks.POLISHED_PUMICE);
        wallItem(CCBlocks.PYRITE_WALL, CCBlocks.PYRITE);

        wallItem(CCBlocks.THUNDERSTONE_WALL, CCBlocks.THUNDERSTONE);
        wallItem(CCBlocks.CHISELED_THUNDERSTONE_WALL, CCBlocks.CHISELED_THUNDERSTONE);
        wallItem(CCBlocks.THUNDERSTONE_BRICKS_WALL, CCBlocks.THUNDERSTONE_BRICKS);
        wallItem(CCBlocks.POLISHED_THUNDERSTONE_WALL, CCBlocks.POLISHED_THUNDERSTONE);

        wallItem(CCBlocks.BISMITE_WALL, CCBlocks.BISMITE);
        wallItem(CCBlocks.BISMITE_BRICKS_WALL, CCBlocks.BISMITE_BRICKS);
        wallItem(CCBlocks.CHISELED_BISMITE_WALL, CCBlocks.CHISELED_BISMITE);
        wallItem(CCBlocks.CRACKED_BISMITE_WALL, CCBlocks.CRACKED_BISMITE);
        wallItem(CCBlocks.POLISHED_BISMITE_WALL, CCBlocks.POLISHED_BISMITE);

        wallItem(CCBlocks.BLUE_BISMUTH_WALL, CCBlocks.BLUE_BISMUTH);
        wallItem(CCBlocks.PURPLE_BISMUTH_WALL, CCBlocks.PURPLE_BISMUTH);
        wallItem(CCBlocks.VIOLET_BISMUTH_WALL, CCBlocks.VIOLET_BISMUTH);
        wallItem(CCBlocks.YELLOW_BISMUTH_WALL, CCBlocks.YELLOW_BISMUTH);
        wallItem(CCBlocks.RAINBOW_BISMUTH_WALL, CCBlocks.RAINBOW_BISMUTH);

        wallItem(CCBlocks.BLUE_BISMUTH_BRICKS_WALL, CCBlocks.BLUE_BISMUTH_BRICKS);
        wallItem(CCBlocks.PURPLE_BISMUTH_BRICKS_WALL, CCBlocks.PURPLE_BISMUTH_BRICKS);
        wallItem(CCBlocks.YELLOW_BISMUTH_BRICKS_WALL, CCBlocks.YELLOW_BISMUTH_BRICKS);
        wallItem(CCBlocks.RAINBOW_BISMUTH_BRICKS_WALL, CCBlocks.RAINBOW_BISMUTH_BRICKS);
        wallItem(CCBlocks.VIOLET_BISMUTH_BRICKS_WALL, CCBlocks.VIOLET_BISMUTH_BRICKS);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,"block/" + item.getId().getPath()));
    }

    public void flowerItem(DeferredBlock<Block> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",  ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,
                        "block/" + block.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }


}
