package com.ashvxmc.cuboiddungeon.items.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BottleOfSouls extends Item {
    public BottleOfSouls(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
