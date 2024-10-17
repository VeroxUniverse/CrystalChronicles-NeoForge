package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

import java.util.Set;

public class CCBlockLootTableProvider extends BlockLootSubProvider {

    protected CCBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        this.dropSelf(CCBlocks.BLOOD_BASES.get());
        this.dropSelf(CCBlocks.FLESH_BLOCK.get());
        this.dropSelf(CCBlocks.MUSCLE_BLOCK.get());
        this.dropSelf(CCBlocks.ALVEOLUS_BLOCK.get());
        this.dropSelf(CCBlocks.ARTREE_BASE.get());
        this.dropSelf(CCBlocks.ARTREE_CAPILLARY.get());
        this.dropSelf(CCBlocks.ARTREE_VEIN.get());
        this.dropSelf(CCBlocks.AXON.get());
        this.dropSelf(CCBlocks.NEURON_TORCH.get());
        this.dropOther(CCBlocks.NEURON_TORCH_WALL.get(), CCBlocks.NEURON_TORCH.get());
        this.dropSelf(CCBlocks.BRONCHUS.get());
        this.dropSelf(CCBlocks.BRONCHUS_PLANKS.get());
        this.dropSelf(CCBlocks.BRONCHUS_STAIRS.get());
        this.dropSelf(CCBlocks.BRONCHUS_SLAB.get());
        this.dropSelf(CCBlocks.BRONCHUS_FENCE.get());
        this.dropSelf(CCBlocks.BRONCHUS_FENCE_GATE.get());
        this.dropSelf(CCBlocks.BRONCHUS_BUTTON.get());
        this.dropSelf(CCBlocks.BRONCHUS_PRESSURE_PLATE.get());
        this.dropSelf(CCBlocks.BRONCHUS_TRAPDOOR.get());
        this.dropSelf(CCBlocks.CRUSTONE.get());
        this.dropSelf(CCBlocks.CRUSTONE_BRICKS.get());
        this.dropSelf(CCBlocks.CRACKED_CRUSTONE_BRICKS.get());
        this.dropSelf(CCBlocks.POLISHED_CRUSTONE.get());
        this.dropSelf(CCBlocks.CHISELED_CRUSTONE.get());
        this.dropSelf(CCBlocks.CELVER_LIGHT.get());
        this.dropSelf(CCBlocks.SKIN_LAYER.get());
        this.dropSelf(CCBlocks.BLOOD_BASES.get());
        this.dropSelf(CCBlocks.TALL_BLOOD_BASES.get());
        this.add(CCBlocks.FAT_TISSUE_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.FAT_TISSUE_BLOCK.get(), CCItems.FAT_TISSUE_BALL.get(), 2,4));
        this.add(CCBlocks.NEURON_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.NEURON_BLOCK.get(), CCItems.NEURON.get(), 2,4));
        this.add(CCBlocks.ROTTEN_FLESH_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.ROTTEN_FLESH_BLOCK.get(), Items.ROTTEN_FLESH, 2,4));
        this.add(CCBlocks.EYE_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.EYE_BLOCK.get(), CCItems.EYE.get(), 1,1));

        this.add(CCBlocks.BRONCHUS_DOOR.get(),
                block -> createDoorTable(CCBlocks.BRONCHUS_DOOR.get()));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CCBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
