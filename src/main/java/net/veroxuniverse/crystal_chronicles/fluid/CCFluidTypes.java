package net.veroxuniverse.crystal_chronicles.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
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



    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}