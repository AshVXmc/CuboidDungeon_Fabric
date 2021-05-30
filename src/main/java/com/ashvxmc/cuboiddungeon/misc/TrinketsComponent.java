package com.ashvxmc.cuboiddungeon.misc;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


// Yoinked from https://github.com/florensie/artifacts-fabric/blob/1.16-fabric/src/main/java/artifacts/trinkets/TrinketsHelper.java

public final class TrinketsComponent {

    private TrinketsComponent() {
    }

    public static boolean isEquipped(Item item, LivingEntity livingentity) {
        return isEquipped(item, livingentity, false);
    }

    public static boolean isEquipped(Predicate<ItemStack> filter, LivingEntity livingentity) {
        return isEquipped(filter, livingentity, false);
    }

    public static List<ItemStack> getAllEquipped(LivingEntity livingentity) {
        return getAllEquipped(livingentity, false);
    }

    public static boolean isEquipped(Item item, LivingEntity entity, boolean ignoreEffectsDisabled) {
        return isEquipped(stack -> stack.getItem().equals(item), entity, ignoreEffectsDisabled);
    }

    public static boolean isEquipped(Predicate<ItemStack> filter, LivingEntity entity, boolean ignoreEffectsDisabled) {
        for (ItemStack stack : getAllEquipped(entity, ignoreEffectsDisabled)) {
            if (filter.test(stack)) {
                return true;
            }
        }
        return false;
    }

    public static List<ItemStack> getAllEquipped(LivingEntity entity, boolean ignoreEffectsDisabled) {
        List<ItemStack> stacks = new ArrayList<>();


        if (entity instanceof PlayerEntity) {
            Inventory inventory = TrinketsApi.getTrinketsInventory((PlayerEntity) entity);

            for (int i = 0; i < inventory.size(); i++) {
                ItemStack stack = inventory.getStack(i);
            }
        }

        return stacks;
    }
}
