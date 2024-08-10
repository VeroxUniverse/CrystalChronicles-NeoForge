package net.veroxuniverse.crystal_chronicles.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class BleedingMobEffect extends MobEffect {

    protected BleedingMobEffect(MobEffectCategory effectCategory, int pColor) {
        super(effectCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int pAmplifier) {
        entity.hurt(entity.damageSources().magic(), 3.0F);
        entity.removeEffect(MobEffects.REGENERATION);
        return true;
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        int i = 25 >> pAmplifier;
        return i > 0 ? pDuration % i == 0 : true;
    }
}
