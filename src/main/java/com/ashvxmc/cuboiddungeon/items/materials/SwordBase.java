package com.ashvxmc.cuboiddungeon.items.materials;

import com.ashvxmc.cuboiddungeon.items.weapons.Dagger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {
    public SwordBase(Dagger toolMaterial) {
        super((ToolMaterial) toolMaterial, 0, -0.8f, new Item.Settings().group(ItemGroup.COMBAT));
    }
}
