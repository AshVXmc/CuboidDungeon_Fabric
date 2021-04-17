package com.ashvxmc.cuboiddungeon.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;


public class RheumSlimeEntity extends PathAwareEntity {

    public RheumSlimeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
       this.goalSelector.add(3, new MeleeAttackGoal(this,0.5,true));
       this.goalSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true, true));
       this.goalSelector.add(2, new LookAroundGoal(this));
    }


    public static DefaultAttributeContainer.Builder createMobAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }
}
