package com.ashvxmc.cuboiddungeon.items.flasks;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlaskOfLunarBlessingEmpty extends Item {
    public FlaskOfLunarBlessingEmpty(Settings settings) {
        super(new Settings().group(Cuboiddungeon.DUNGEON_ITEMS).maxCount(1));
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.flask_of_lunar_blessing_empty.tooltip").formatted(Formatting.DARK_PURPLE));
    }
}
