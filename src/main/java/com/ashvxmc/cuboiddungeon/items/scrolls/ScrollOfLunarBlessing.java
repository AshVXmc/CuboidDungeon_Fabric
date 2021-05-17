package com.ashvxmc.cuboiddungeon.items.scrolls;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScrollOfLunarBlessing extends Item {
    public ScrollOfLunarBlessing(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            if (world.isNight()){
                float moonPhase = world.getDimension().getMoonPhase(world.getLunarTime());

                if (moonPhase == 0.0f){
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 5 * 20,1));
                }

            } else if (user.hasStatusEffect(StatusEffects.BLINDNESS)){
                user.sendMessage(Text.of("You can't read while blinded!"),false);
            }
        }
        return TypedActionResult.success(itemStack,world.isClient);
    }
}
