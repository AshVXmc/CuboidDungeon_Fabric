package com.ashvxmc.cuboiddungeon.items.weapons;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.items.materials.StaffToolMaterials;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class HardwoodStaff extends SwordItem {
    public HardwoodStaff(StaffToolMaterials staffToolMaterials) {
        super(staffToolMaterials ,1,-2.8f, new Settings().group(Cuboiddungeon.DUNGEON_ITEMS));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("item.hardwood_staff.tooltip").formatted(Formatting.DARK_PURPLE));
    }
}
