package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.*;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CCBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CrystalChronicles.MODID);

    public static final DeferredBlock<Block> BLOOD_BASES = registerBlock("blood_bases",
            () -> new BloodFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
    public static final DeferredBlock<Block> TALL_BLOOD_BASES = registerBlock("tall_blood_bases",
            () -> new TallBloodFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final DeferredBlock<Block> ALVEOLUS_BLOCK = registerBlock("alveolus_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FLESH_BLOCK = registerBlock("flesh_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> MUSCLE_BLOCK = registerBlock("muscle_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> FAT_TISSUE_BLOCK = registerBlock("fat_tissue_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> ARTREE_BASE = registerBlock("artree_base",
            () -> new ArteeBaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).noOcclusion()));
    public static final DeferredBlock<Block> ARTREE_VEIN = registerBlock("artree_vein",
            () -> new VeinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).noOcclusion()));
    public static final DeferredBlock<Block> ARTREE_CAPILLARY = registerBlock("artree_capillary",
            () -> new CapillaryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL).noOcclusion()));
    public static final DeferredBlock<Block> NEURON_BLOCK = registerBlock("neuron_block",
            () -> new NeuronBlock(BlockBehaviour.Properties.of().lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.FROGLIGHT).isValidSpawn(Blocks::always).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> AXON = registerBlock("axon",
            () -> new AxonBlock(BlockBehaviour.Properties.of().lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.FROGLIGHT).isValidSpawn(Blocks::always).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> ROTTEN_FLESH_BLOCK = registerBlock("rotten_flesh_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));

    public static final DeferredBlock<Block> BRONCHUS = registerBlock("bronchus",
            () -> new BronchusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<Block> BRONCHUS_PLANKS = registerBlock("bronchus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_STAIRS = registerBlock("bronchus_stairs",
            () -> new StairBlock(CCBlocks.BRONCHUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_SLAB = registerBlock("bronchus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_FENCE = registerBlock("bronchus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_FENCE_GATE = registerBlock("bronchus_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_BUTTON = registerBlock("bronchus_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<Block> BRONCHUS_PRESSURE_PLATE = registerBlock("bronchus_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_DOOR = registerBlock("bronchus_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BRONCHUS_TRAPDOOR = registerBlock("bronchus_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> NEURON_TORCH = registerBlockWithoutItem("neuron_torch",
            () -> new NeuronTorchBlock(ParticleTypes.CRIT , BlockBehaviour.Properties.of().lightLevel(state -> 14).strength(0.3F).sound(SoundType.FROGLIGHT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> NEURON_TORCH_WALL = registerBlockWithoutItem("neuron_torch_wall",
            () -> new WallNeuronTorchBlock(ParticleTypes.CRIT, BlockBehaviour.Properties.of().lightLevel(state -> 14).strength(0.3F).sound(SoundType.FROGLIGHT).noOcclusion().noCollission().lootFrom(NEURON_TORCH)));

    public static final DeferredBlock<Block> EYE_BLOCK = registerBlock("eye_block",
            () -> new EyeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CRUSTONE = registerBlock("crustone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CRUSTONE_BRICKS = registerBlock("crustone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CRACKED_CRUSTONE_BRICKS = registerBlock("cracked_crustone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> POLISHED_CRUSTONE = registerBlock("polished_crustone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> CHISELED_CRUSTONE = registerBlock("chiseled_crustone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> SKIN_LAYER = registerBlock("skin_layer",
            () -> new SkinLayerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD)));
    public static final DeferredBlock<Block> CELVER_LIGHT = registerBlock("clever_light",
            () -> new CleverLightBlock(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(CleverLightBlock.LIT) ? 15 : 0).strength(0.3F).sound(SoundType.FROGLIGHT).isValidSpawn(Blocks::always).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return state -> state.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        CCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
