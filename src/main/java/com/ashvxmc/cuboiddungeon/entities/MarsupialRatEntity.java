package com.ashvxmc.cuboiddungeon.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class MarsupialRatEntity extends PathAwareEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public MarsupialRatEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    // Animation controllers
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if (this.isImmobile()){
            event.getController().setAnimation(
                    new AnimationBuilder().addAnimation("animation.marsupial_rat.idle", true)
            );
            return PlayState.CONTINUE;
        }
        if (this.isAttacking()){
            event.getController().setAnimation(
                    new AnimationBuilder().addAnimation("animation.marsupial_rat.attack",true)
            );
            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


    // Mob attributes
    @Override
    protected void initGoals() {
        this.goalSelector.add(3,new MeleeAttackGoal(this,0.8f,false));
        this.goalSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class,true, true));
        this.goalSelector.add(2,new FollowTargetGoal<>(this, WolfEntity.class,true,true));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createMobAttributes(){
        int armorValue;
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.2F)
                .add(EntityAttributes.GENERIC_ARMOR,1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,12);
    }
}
