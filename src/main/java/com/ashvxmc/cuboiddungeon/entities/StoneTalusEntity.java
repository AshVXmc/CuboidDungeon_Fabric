package com.ashvxmc.cuboiddungeon.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class StoneTalusEntity extends PathAwareEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public StoneTalusEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    // Attributes
    @Override
    protected void initGoals() {
        this.goalSelector.add(4,new MeleeAttackGoal(this,0.5f,false));
        this.goalSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true, true));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createMobAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,0.25F)
                .add(EntityAttributes.GENERIC_ARMOR,1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,12);
    }
    // Poison immunity
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        return effect.getEffectType() != StatusEffects.POISON && super.canHaveStatusEffect(effect);
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        return entityData;
    }
}
