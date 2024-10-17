package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluidTypes;
import net.veroxuniverse.crystal_chronicles.fluid.CCFluids;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

public class CCItemModelProvider extends ItemModelProvider {
    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalChronicles.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CCItems.TANK_HELMET.get());
        basicItem(CCItems.TANK_CHESTPLATE.get());
        basicItem(CCItems.TANK_LEGGINGS.get());
        basicItem(CCItems.TANK_BOOTS.get());
        basicItem(CCItems.ROGUE_HELMET.get());
        basicItem(CCItems.ROGUE_CHESTPLATE.get());
        basicItem(CCItems.ROGUE_LEGGINGS.get());
        basicItem(CCItems.ROGUE_BOOTS.get());
        basicItem(CCItems.MAGE_HELMET.get());
        basicItem(CCItems.MAGE_CHESTPLATE.get());
        basicItem(CCItems.MAGE_LEGGINGS.get());
        basicItem(CCItems.MAGE_BOOTS.get());
        basicItem(CCItems.PALADIN_HELMET.get());
        basicItem(CCItems.PALADIN_CHESTPLATE.get());
        basicItem(CCItems.PALADIN_LEGGINGS.get());
        basicItem(CCItems.PALADIN_BOOTS.get());
        basicItem(CCItems.BLOODSTONE_SHARD.get());
        basicItem(CCItems.VOIDSTONE_SHARD.get());
        basicItem(CCItems.LUNARITE_SHARD.get());
        basicItem(CCItems.CELESTITE_SHARD.get());
        basicItem(CCItems.TOXITE_SHARD.get());
        basicItem(CCItems.PYRONITE_SHARD.get());
        basicItem(CCItems.TOXIC_HELMET.get());
        basicItem(CCItems.TOXIC_CHESTPLATE.get());
        basicItem(CCItems.TOXIC_LEGGINGS.get());
        basicItem(CCItems.TOXIC_BOOTS.get());
        basicItem(CCItems.PYROMANCER_HELMET.get());
        basicItem(CCItems.PYROMANCER_CHESTPLATE.get());
        basicItem(CCItems.PYROMANCER_LEGGINGS.get());
        basicItem(CCItems.PYROMANCER_BOOTS.get());
        basicItem(CCItems.FAT_TISSUE_BALL.get());
        basicItem(CCItems.NEURON.get());
        basicItem(CCItems.EYE.get());
        basicItem(CCFluids.BLOOD_BUCKET.get());

        flowerItem(CCBlocks.BLOOD_BASES);
        flowerItem(CCBlocks.AXON);

        buttonItem(CCBlocks.BRONCHUS_BUTTON, CCBlocks.BRONCHUS_PLANKS);
        fenceItem(CCBlocks.BRONCHUS_FENCE, CCBlocks.BRONCHUS_PLANKS);

        basicItem(CCBlocks.BRONCHUS_DOOR.asItem());
        
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


}
