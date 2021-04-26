package com.ashvxmc.cuboiddungeon.items.weapons;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.items.materials.ImbuedDaggerMaterials;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoisonedDagger extends SwordItem {

    public PoisonedDagger(ImbuedDaggerMaterials material) {
        super(material,1,-2.2f,new Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.poisoned_dagger.tooltip").formatted(Formatting.DARK_PURPLE));
        tooltip.add(new TranslatableText("item.poisoned_dagger2.tooltip").formatted(Formatting.BOLD));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // effect duration is in ticks (20 ticks = 1 second)
        target.applyStatusEffect(new StatusEffectInstance(StatusEffects.POISON,100,1));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack);
    }
}
