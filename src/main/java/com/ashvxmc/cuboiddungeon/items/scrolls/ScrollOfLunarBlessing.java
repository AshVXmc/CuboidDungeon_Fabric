package com.ashvxmc.cuboiddungeon.items.scrolls;

import net.minecraft.item.Item;

public class ScrollOfLunarBlessing extends Item {
    public ScrollOfLunarBlessing(Settings settings) {
        super(settings);
    }

    // Snippet to use later
    /*  if (world.isNight()){
            float MoonPhase = world.getDimension().getMoonPhase(world.getLunarTime());

           if (MoonPhase == 0.0f){
               user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 480 * 20,1));
           } else if (MoonPhase == 0.125f){
               user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 480 * 20,1));
           } else if (MoonPhase == 0.25f){
               user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 480 * 20,1));
           }

        }
     */
}
