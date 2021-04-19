package com.ashvxmc.cuboiddungeon.items.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StaffToolMaterials implements ToolMaterial {
    @Override
    public int getDurability() {
        return 150;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0.5f;
    }

    @Override
    public float getAttackDamage() {
        return 3;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 9;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
