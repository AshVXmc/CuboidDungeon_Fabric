package com.ashvxmc.cuboiddungeon.mixins;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SwordItem.class)
public class SwordItemMixin extends ToolItem implements Vanishable {
    public SwordItemMixin(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, (HostileEntity)attacker, (e) -> {
        });
        return true;
    }
}
