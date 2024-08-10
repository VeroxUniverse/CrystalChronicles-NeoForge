package net.veroxuniverse.crystal_chronicles.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class CCEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, CrystalChronicles.MODID);

    public static final Holder<MobEffect> BLEEDING_EFFECT = MOB_EFFECTS.register("bleeding",
            () -> new BleedingMobEffect(MobEffectCategory.HARMFUL, 0xfc037b));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}