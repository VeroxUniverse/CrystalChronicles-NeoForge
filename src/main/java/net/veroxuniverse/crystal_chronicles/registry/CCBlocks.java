package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.CrystalClusterBlock;

import static net.veroxuniverse.crystal_chronicles.registry.CCItems.ITEMS;

public class CCBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CrystalChronicles.MODID);


    public static final DeferredHolder<Block, CrystalClusterBlock> ROSE_CLUSTER = BLOCKS.register(
            "rose_cluster", // Our registry name.
        () -> new CrystalClusterBlock(10,3 ,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)
                .destroyTime(2.0f)
                .explosionResistance(10.0f)
                .lightLevel(state -> 10)
            ));
    public static final DeferredItem<BlockItem> ROSE_CLUSTER_ITEM = ITEMS.registerSimpleBlockItem("rose_cluster", ROSE_CLUSTER);

}
