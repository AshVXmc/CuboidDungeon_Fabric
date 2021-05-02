package com.ashvxmc.cuboiddungeon.items.scrolls;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
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

public class ScrollOfRage extends Item {
    public ScrollOfRage(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.scroll_of_rage.tooltip").formatted(Formatting.DARK_GREEN));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            user.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN,1.2f,1);
            user.addStatusEffect(new StatusEffectInstance(Cuboiddungeon.RAGE,600,1));
            if (!user.abilities.creativeMode) {
                itemStack.decrement(1);
            }
        } else if (user.hasStatusEffect(StatusEffects.BLINDNESS)){
            user.sendMessage(Text.of("You can't read while blinded!"),false);
        }

        return TypedActionResult.success(itemStack,world.isClient);
    }
}
