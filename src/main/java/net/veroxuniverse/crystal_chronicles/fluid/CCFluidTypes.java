package net.veroxuniverse.crystal_chronicles.fluid;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class CCFluidTypes {
    public static final ResourceLocation BLOOD_STILL_RL = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,"block/blood_still");
    public static final ResourceLocation BLOOD_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID,"block/blood_flow");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CrystalChronicles.MODID);

    public static final Supplier<FluidType> BLOOD_FLUID_TYPE = registerFluidType("blood_fluid",
            new BaseFluidType(BLOOD_STILL_RL, BLOOD_FLOWING_RL, new Vector3f(0.2118f, 0.0196f, 0.0431f) ,
                    FluidType.Properties.create()
                            .density(1000)
                            .viscosity(2000)));

    public static final Supplier<FluidType> REACTIVE_WATER_FLUID_TYPE =
            FLUID_TYPES.register("reactive_water", () -> new ReactiveWaterFluidType(
                    FluidType.Properties.create()
            ));


    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}