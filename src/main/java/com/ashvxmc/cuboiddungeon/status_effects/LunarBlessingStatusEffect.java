package com.ashvxmc.cuboiddungeon.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class LunarBlessingStatusEffect extends StatusEffect {
    public LunarBlessingStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0xc42e1d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity){
            int tickAmount = 20;
            ((PlayerEntity) entity).addExhaustion(0.05f);
            entity.setMovementSpeed(3.5f);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 30 * tickAmount,2));
            entity.setAbsorptionAmount(8.0f);
            entity.heal(15f);
            if(entity.isInLava()){
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,5 * tickAmount,1));
            }
        }
    }
}
