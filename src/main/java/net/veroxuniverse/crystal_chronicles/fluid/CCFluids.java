package net.veroxuniverse.crystal_chronicles.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.BloodFluidBlock;
import net.veroxuniverse.crystal_chronicles.block.ReactiveWaterBlock;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;

import java.util.function.Supplier;

public class CCFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CrystalChronicles.MODID);

    public static final Supplier<FlowingFluid> SOURCE_BLOOD = FLUIDS.register("source_blood",
            () -> new BaseFlowingFluid.Source(CCFluids.BLOOD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_BLOOD = FLUIDS.register("flowing_blood",
            () -> new BaseFlowingFluid.Flowing(CCFluids.BLOOD_PROPERTIES));

    public static final Supplier<FlowingFluid> SOURCE_SULPHURIC_WATER = FLUIDS.register("source_sulphuric_water",
            () -> new BaseFlowingFluid.Source(CCFluids.SULPHURIC_WATER_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_REACTIVE_WATER = FLUIDS.register("flowing_sulphuric_water",
            () -> new BaseFlowingFluid.Flowing(CCFluids.SULPHURIC_WATER_PROPERTIES));


    public static final DeferredBlock<LiquidBlock> BLOOD_BLOCK = CCBlocks.BLOCKS.register("blood_block",
            () -> new BloodFluidBlock(CCFluids.SOURCE_BLOOD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredItem<Item> BLOOD_BUCKET = CCItems.ITEMS.registerItem("blood_bucket",
            properties -> new BucketItem(CCFluids.SOURCE_BLOOD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredBlock<LiquidBlock> SULPHURIC_WATER_BLOCK = CCBlocks.BLOCKS.register("sulphuric_water_block",
            () -> new ReactiveWaterBlock(SOURCE_SULPHURIC_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredItem<Item> SULPHURIC_WATER_BUCKET = CCItems.ITEMS.registerItem("sulphuric_water_bucket",
            properties -> new BucketItem(SOURCE_SULPHURIC_WATER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));


    public static final BaseFlowingFluid.Properties BLOOD_PROPERTIES = new BaseFlowingFluid.Properties(
            CCFluidTypes.BLOOD_FLUID_TYPE, SOURCE_BLOOD, FLOWING_BLOOD)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(CCFluids.BLOOD_BLOCK)
            .bucket(CCFluids.BLOOD_BUCKET)
            .explosionResistance(10);


    public static final BaseFlowingFluid.Properties SULPHURIC_WATER_PROPERTIES = new BaseFlowingFluid.Properties(
            CCFluidTypes.SULPHURIC_WATER_FLUID_TYPE, SOURCE_SULPHURIC_WATER, FLOWING_REACTIVE_WATER)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(1)
            .block(SULPHURIC_WATER_BLOCK)
            .bucket(SULPHURIC_WATER_BUCKET)
            .explosionResistance(100);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}