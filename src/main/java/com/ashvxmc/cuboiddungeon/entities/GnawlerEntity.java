package com.ashvxmc.cuboiddungeon.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;

public class GnawlerEntity extends PathAwareEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public GnawlerEntity(EntityType<? extends PathAwareEntity> entityType, World world, PlayerEntity playerEntity) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
        init(playerEntity);
    }

    private void init(PlayerEntity playerEntity){
        if (playerEntity.isHolding(Items.GOLDEN_SWORD)){
            Objects.requireNonNull(getAttributeInstance(EntityAttributes.GENERIC_ARMOR)).setBaseValue(5);
            setHealth(getMaxHealth());
        } // else if something something
    }

    // Animation controller
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if (this.isAttacking()){
            event.getController().setAnimation(
                    // to be added
                    new AnimationBuilder().addAnimation("",true)
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

    // Attributes

    @Override
    protected void initGoals() {
        this.goalSelector.add(3,new MeleeAttackGoal(this,0.8f,false));
        this.goalSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true, true));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }


    public static DefaultAttributeContainer.Builder createMobAttributes(){
        // this is a test for demon entities, remember to move this away
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.2F)
                .add(EntityAttributes.GENERIC_ARMOR)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,12);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        return entityData;
    }
}
