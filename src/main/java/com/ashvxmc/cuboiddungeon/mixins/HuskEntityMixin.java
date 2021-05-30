package com.ashvxmc.cuboiddungeon.mixins;

import com.ashvxmc.cuboiddungeon.misc.TrinketsComponent;
import com.ashvxmc.cuboiddungeon.registry.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HuskEntity.class)
public class HuskEntityMixin extends HostileEntity {
    protected HuskEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    // Replace with desert amulet later

}
