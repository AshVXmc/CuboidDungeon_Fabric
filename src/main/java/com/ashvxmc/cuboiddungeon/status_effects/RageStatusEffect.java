package com.ashvxmc.cuboiddungeon.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class RageStatusEffect extends StatusEffect {
    public RageStatusEffect() {
        super(
                StatusEffectType.BENEFICIAL,
                0xc42e1d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity){
            // this drains hunger
            ((PlayerEntity) entity).addExhaustion(0.15f);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,30,2));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,30,2));
        }
    }
}
