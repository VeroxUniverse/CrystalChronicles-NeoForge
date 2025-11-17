package net.veroxuniverse.crystal_chronicles.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
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

        // BLOOD //

        this.add(CCBlocks.BLOOD_BASES.get(),
                block -> createShearsOnlyDrop(CCBlocks.BLOOD_BASES.get()));
        this.dropSelf(CCBlocks.FLESH_BLOCK.get());
        this.dropSelf(CCBlocks.MUSCLE_BLOCK.get());
        this.dropSelf(CCBlocks.ARTREE_BASE.get());
        this.dropSelf(CCBlocks.ARTREE_CAPILLARY.get());
        this.dropSelf(CCBlocks.ARTREE_VEIN.get());
        this.dropSelf(CCBlocks.AXON.get());
        this.dropSelf(CCBlocks.NEURON_TORCH.get());
        this.dropOther(CCBlocks.NEURON_TORCH_WALL.get(), CCBlocks.NEURON_TORCH.get());
        this.dropSelf(CCBlocks.BRONCHUS.get());
        this.dropSelf(CCBlocks.BRONCHUS_PLANKS.get());
        this.dropSelf(CCBlocks.BRONCHUS_STAIRS.get());
        this.add(CCBlocks.BRONCHUS_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.BRONCHUS_SLAB.get()));
        this.dropSelf(CCBlocks.BRONCHUS_FENCE.get());
        this.dropSelf(CCBlocks.BRONCHUS_FENCE_GATE.get());
        this.dropSelf(CCBlocks.BRONCHUS_BUTTON.get());
        this.dropSelf(CCBlocks.BRONCHUS_PRESSURE_PLATE.get());
        this.dropSelf(CCBlocks.BRONCHUS_TRAPDOOR.get());

        this.add(CCBlocks.VEINS.get(),
                block -> createShearsOnlyDrop(CCBlocks.VEINS.get()));

        this.dropSelf(CCBlocks.CRUSTONE.get());
        this.dropSelf(CCBlocks.CRUSTONE_BRICKS.get());
        this.dropSelf(CCBlocks.CRACKED_CRUSTONE_BRICKS.get());
        this.dropSelf(CCBlocks.POLISHED_CRUSTONE.get());
        this.dropSelf(CCBlocks.CHISELED_CRUSTONE.get());
        this.dropSelf(CCBlocks.CRUSTONE_STAIRS.get());
        this.dropSelf(CCBlocks.CRUSTONE_BRICKS_STAIRS.get());
        this.dropSelf(CCBlocks.CRACKED_CRUSTONE_BRICKS_STAIRS.get());
        this.dropSelf(CCBlocks.POLISHED_CRUSTONE_STAIRS.get());
        this.dropSelf(CCBlocks.CHISELED_CRUSTONE_STAIRS.get());
        this.dropSelf(CCBlocks.CRUSTONE_WALL.get());
        this.dropSelf(CCBlocks.CRUSTONE_BRICKS_WALL.get());
        this.dropSelf(CCBlocks.CRACKED_CRUSTONE_BRICKS_WALL.get());
        this.dropSelf(CCBlocks.POLISHED_CRUSTONE_WALL.get());
        this.dropSelf(CCBlocks.CHISELED_CRUSTONE_WALL.get());
        this.dropSelf(CCBlocks.ALVEOLUS.get());

        this.add(CCBlocks.CRUSTONE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CRUSTONE_SLAB.get()));
        this.add(CCBlocks.CRUSTONE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CRUSTONE_BRICKS_SLAB.get()));
        this.add(CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CRACKED_CRUSTONE_BRICKS_SLAB.get()));
        this.add(CCBlocks.POLISHED_CRUSTONE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.POLISHED_CRUSTONE_SLAB.get()));
        this.add(CCBlocks.CHISELED_CRUSTONE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CHISELED_CRUSTONE_SLAB.get()));

        this.dropSelf(CCBlocks.TENDON_BLOCK.get());
        this.dropSelf(CCBlocks.CELVER_LIGHT.get());
        this.dropSelf(CCBlocks.SKIN_LAYER.get());
        this.dropSelf(CCBlocks.HANGING_VEINS.get());
        this.add(CCBlocks.FAT_TISSUE_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.FAT_TISSUE_BLOCK.get(), CCItems.FAT_TISSUE_BALL.get(), 2,4));
        this.add(CCBlocks.NEURON_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.NEURON_BLOCK.get(), CCItems.NEURON.get(), 2,4));
        this.add(CCBlocks.ROTTEN_FLESH_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.ROTTEN_FLESH_BLOCK.get(), Items.ROTTEN_FLESH, 2,4));
        this.add(CCBlocks.EYE_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.EYE_BLOCK.get(), CCItems.EYE.get(), 1,1));

        this.add(CCBlocks.HEMALITE_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.HEMALITE_BLOCK.get(), CCItems.HEMALITE_SHARD.get(), 1,4));

        //this.dropSelf(CCBlocks.ALVEOLUS_BLOCK.get());

        this.add(CCBlocks.ALVEOLUS_BLOCK.get(),
                block -> createMultipleOreDrops(CCBlocks.ALVEOLUS_BLOCK.get(), Item.byBlock(CCBlocks.ALVEOLUS.get()), 0,1));

        this.add(CCBlocks.BRONCHUS_DOOR.get(),
                block -> createDoorTable(CCBlocks.BRONCHUS_DOOR.get()));

        this.add(CCBlocks.TALL_BLOOD_BASES.get(),
                block -> createTallShearsOnlyDrop(CCBlocks.TALL_BLOOD_BASES.get()));
        //this.add(CCBlocks.TALL_BLOOD_BASES.get(),
        //        block -> createDoorTable(CCBlocks.TALL_BLOOD_BASES.get()));

        // HOLY //

        this.dropSelf(CCBlocks.CLOUD_BLOCK.get());
        this.dropSelf(CCBlocks.DENSE_CLOUDS.get());

        this.dropSelf(CCBlocks.HOLY_MARBLE.get());
        this.dropSelf(CCBlocks.HOLY_MARBLE_STAIRS.get());
        this.dropSelf(CCBlocks.HOLY_MARBLE_WALL.get());
        this.add(CCBlocks.HOLY_MARBLE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.HOLY_MARBLE_SLAB.get()));

        this.dropSelf(CCBlocks.HOLY_MARBLE_BRICKS.get());
        this.dropSelf(CCBlocks.HOLY_MARBLE_BRICKS_STAIRS.get());
        this.dropSelf(CCBlocks.HOLY_MARBLE_BRICKS_WALL.get());
        this.add(CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.HOLY_MARBLE_BRICKS_SLAB.get()));

        this.dropSelf(CCBlocks.CHISELED_HOLY_MARBLE.get());
        this.dropSelf(CCBlocks.CHISELED_HOLY_MARBLE_STAIRS.get());
        this.dropSelf(CCBlocks.CHISELED_HOLY_MARBLE_WALL.get());
        this.add(CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CHISELED_HOLY_MARBLE_SLAB.get()));

        this.dropSelf(CCBlocks.CRACKED_HOLY_MARBLE.get());
        this.dropSelf(CCBlocks.CRACKED_HOLY_MARBLE_STAIRS.get());
        this.dropSelf(CCBlocks.CRACKED_HOLY_MARBLE_WALL.get());
        this.add(CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CRACKED_HOLY_MARBLE_SLAB.get()));

        this.dropSelf(CCBlocks.POLISHED_HOLY_MARBLE.get());
        this.dropSelf(CCBlocks.POLISHED_HOLY_MARBLE_STAIRS.get());
        this.dropSelf(CCBlocks.POLISHED_HOLY_MARBLE_WALL.get());
        this.add(CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.POLISHED_HOLY_MARBLE_SLAB.get()));

        this.dropSelf(CCBlocks.HOLY_MARBLE_PILLAR.get());

        this.dropSelf(CCBlocks.GOLDSTONE.get());
        this.dropSelf(CCBlocks.GOLDSTONE_STAIRS.get());
        this.dropSelf(CCBlocks.GOLDSTONE_WALL.get());
        this.add(CCBlocks.GOLDSTONE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.GOLDSTONE_SLAB.get()));

        this.dropSelf(CCBlocks.HOLY_LIGHT_BLOCK.get());
        this.dropSelf(CCBlocks.HOLY_BEACON.get());


        // FIRE //

        this.dropSelf(CCBlocks.PUMICE.get());
        this.dropSelf(CCBlocks.PUMICE_STAIRS.get());
        this.dropSelf(CCBlocks.PUMICE_WALL.get());
        this.add(CCBlocks.PUMICE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.PUMICE_SLAB.get()));

        this.dropSelf(CCBlocks.PUMICE_BRICKS.get());
        this.dropSelf(CCBlocks.PUMICE_BRICKS_STAIRS.get());
        this.dropSelf(CCBlocks.PUMICE_BRICKS_WALL.get());
        this.add(CCBlocks.PUMICE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.PUMICE_BRICKS_SLAB.get()));

        this.dropSelf(CCBlocks.CHISELED_PUMICE.get());
        this.dropSelf(CCBlocks.CHISELED_PUMICE_STAIRS.get());
        this.dropSelf(CCBlocks.CHISELED_PUMICE_WALL.get());
        this.add(CCBlocks.CHISELED_PUMICE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CHISELED_PUMICE_SLAB.get()));

        this.dropSelf(CCBlocks.CRACKED_PUMICE.get());
        this.dropSelf(CCBlocks.CRACKED_PUMICE_STAIRS.get());
        this.dropSelf(CCBlocks.CRACKED_PUMICE_WALL.get());
        this.add(CCBlocks.CRACKED_PUMICE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.CRACKED_PUMICE_SLAB.get()));

        this.dropSelf(CCBlocks.POLISHED_PUMICE.get());
        this.dropSelf(CCBlocks.POLISHED_PUMICE_STAIRS.get());
        this.dropSelf(CCBlocks.POLISHED_PUMICE_WALL.get());
        this.add(CCBlocks.POLISHED_PUMICE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.POLISHED_PUMICE_SLAB.get()));

        this.dropSelf(CCBlocks.PYRITE_BLOCK.get());
        this.dropSelf(CCBlocks.PYRITE_STAIRS.get());
        this.dropSelf(CCBlocks.PYRITE_WALL.get());
        this.add(CCBlocks.PYRITE_SLAB.get(),
                block -> createSlabItemTable(CCBlocks.PYRITE_SLAB.get()));

        this.dropSelf(CCBlocks.VOLCANITE_BLOCK.get());
        this.dropSelf(CCBlocks.GREEN_SULPHUR_POOL.get());
        this.dropSelf(CCBlocks.ORANGE_SULPHUR_POOL.get());
        this.dropSelf(CCBlocks.RED_SULPHUR_POOL.get());
        this.dropSelf(CCBlocks.RED_SULPHUR_WATER_VENT_BASE.get());
        this.dropSelf(CCBlocks.RED_SULPHUR_WATER_VENT_TOP.get());
        this.dropSelf(CCBlocks.SMALL_PYRITE_BLOCK.get());
        this.dropSelf(CCBlocks.SULPHUR_CRYSTAL.get());
        this.dropSelf(CCBlocks.SMALL_SULPHUR_CLUSTER.get());
        this.dropSelf(CCBlocks.MEDIUM_SULPHUR_CLUSTER.get());
        this.dropSelf(CCBlocks.SULPHUR_DUST.get());
        this.dropSelf(CCBlocks.SULPHUR_DUST_LAYER.get());
        this.dropSelf(CCBlocks.SULPHUR_WATER_VENT_BASE.get());
        this.dropSelf(CCBlocks.SULPHUR_WATER_VENT_TOP.get());
        this.dropSelf(CCBlocks.SULPHURIC_SOIL.get());
        this.dropSelf(CCBlocks.VERMILLION_SULPHUR_POOL.get());
        this.dropSelf(CCBlocks.YELLOW_SULPHUR_POOL.get());
        this.add(CCBlocks.TALL_SULPHUR_CLUSTER.get(),
                block -> createDoorTable(CCBlocks.TALL_SULPHUR_CLUSTER.get()));


    }

    protected LootTable.Builder createTallShearsOnlyDrop(Block block) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(
                                                StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER)
                                        ))
                                .when(MatchTool.toolMatches(
                                        ItemPredicate.Builder.item().of(Items.SHEARS)
                                ))
                                .add(LootItem.lootTableItem(block))
                );
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
