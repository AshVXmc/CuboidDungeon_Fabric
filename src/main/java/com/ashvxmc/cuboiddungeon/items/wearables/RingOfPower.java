package com.ashvxmc.cuboiddungeon.items.wearables;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RingOfPower extends TrinketItem {
    public RingOfPower() {
        super(new Settings().group(Cuboiddungeon.DUNGEON_WEARABLES).maxCount(1));
    }
    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.HAND) && slot.equals(Slots.RING);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        int tickAmount = 20;
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,5 * tickAmount, 1));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.ring_of_power.tooltip").formatted(Formatting.AQUA));
        tooltip.add(new TranslatableText("item.ring_level1.tooltip").formatted(Formatting.BOLD));
    }
}
