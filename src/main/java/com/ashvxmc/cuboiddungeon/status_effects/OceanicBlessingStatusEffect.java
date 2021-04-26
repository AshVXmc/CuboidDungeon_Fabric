package com.ashvxmc.cuboiddungeon.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

// LATER schlater
public class OceanicBlessingStatusEffect extends StatusEffect {
    public OceanicBlessingStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0xc42e1d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity){
            if(entity.isTouchingWaterOrRain()){

            }
        }
    }
}
