package com.ashvxmc.cuboiddungeon.items.materials;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SlowerSwordBase extends SwordItem {
    public SlowerSwordBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 0, -1.5f, new Settings().group(ItemGroup.COMBAT));
    }
}
