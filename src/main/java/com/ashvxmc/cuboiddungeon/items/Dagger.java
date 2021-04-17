package com.ashvxmc.cuboiddungeon.items;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class Dagger extends SwordItem {

    public Dagger(ToolMaterials material) {
        super(material,1,-2.2f,new Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.dagger.tooltip").formatted(Formatting.DARK_PURPLE));
    }
}
