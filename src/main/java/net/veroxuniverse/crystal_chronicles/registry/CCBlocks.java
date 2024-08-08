package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.CrystalClusterBlock;

import java.util.function.Supplier;

public class CCBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CrystalChronicles.MODID);

    public static final DeferredBlock<Block> BLOODSTONE_CLUSTER = registerBlock("bloodstone_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> CELESTITE_CLUSTER = registerBlock("celestite_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> LUNARITE_CLUSTER = registerBlock("lunarite_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> VOIDSTONE_CLUSTER = registerBlock("voidstone_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> TOXITE_CLUSTER = registerBlock("toxite_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> PYRONITE_CLUSTER = registerBlock("pyronite_cluster",
            () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> SHALE = registerBlock("shale",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> INFECTED_SHALE = registerBlock("infected_shale",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MARBLE = registerBlock("marble",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> MAGNETITE = registerBlock("magnetite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> HEMATITE = registerBlock("hematite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
    public static final DeferredBlock<Block> VOIDSTONE_BLOCK = registerBlock("voidstone_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BLOODSTONE_BLOCK = registerBlock("bloodstone_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> LUNARITE_BLOCK = registerBlock("lunarite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CELESTITE_BLOCK = registerBlock("celestite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TOXITE_BLOCK = registerBlock("toxite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> PYRONITE_BLOCK = registerBlock("pyronite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> VOIDSTONE_BUDDING = registerBlock("voidstone_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> BLOODSTONE_BUDDING = registerBlock("bloodstone_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> LUNARITE_BUDDING = registerBlock("lunarite_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> CELESTITE_BUDDING = registerBlock("celestite_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> TOXITE_BUDDING = registerBlock("toxite_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
    public static final DeferredBlock<Block> PYRONITE_BUDDING = registerBlock("pyronite_budding",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    public static final DeferredBlock<Block> BLUE_MUSHROOM = registerBlock("blue_mushroom",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> PURPLE_MUSHROOM = registerBlock("purple_mushroom",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> BLUE_VINES = registerBlock("blue_vines",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> PURPLE_GRASS = registerBlock("purple_grass",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM).noOcclusion().noCollission()));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        CCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
