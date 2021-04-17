package com.ashvxmc.cuboiddungeon.items;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
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

    public PoisonedDagger(ToolMaterials material) {
        super(material,1,-2.2f,new Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.poisoned_dagger.tooltip").formatted(Formatting.DARK_GREEN));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // HELP AAAAAAAAAAAAAAAAAAAAAAAAA
        target.applyStatusEffect(new StatusEffectInstance(StatusEffects.POISON,5,1));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack);
    }
}
