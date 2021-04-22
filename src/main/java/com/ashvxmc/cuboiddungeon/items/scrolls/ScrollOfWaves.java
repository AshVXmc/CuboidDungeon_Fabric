package com.ashvxmc.cuboiddungeon.items.scrolls;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ScrollOfWaves extends Item {
    public ScrollOfWaves(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            if(user.isTouchingWaterOrRain()){
                int tickAmount = 20;
                user.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN,5,1);
                user.applyStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING));
                // Add new custom effect later
            }
        }
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack,world.isClient);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.scroll_of_waves.tooltip").formatted(Formatting.DARK_GREEN));
        tooltip.add(2,new TranslatableText("item.scroll_of_waves2.tooltip").formatted(Formatting.BOLD));
    }
}
