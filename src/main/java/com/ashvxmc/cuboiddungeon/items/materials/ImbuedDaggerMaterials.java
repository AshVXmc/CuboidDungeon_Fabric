package com.ashvxmc.cuboiddungeon.items.materials;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ImbuedDaggerMaterials implements ToolMaterial {

    public ImbuedDaggerMaterials(FabricItemSettings group) {
    }

    @Override
    public int getDurability() {
        return 80;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 1;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
