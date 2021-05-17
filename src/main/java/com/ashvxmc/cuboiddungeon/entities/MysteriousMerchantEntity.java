package com.ashvxmc.cuboiddungeon.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class MysteriousMerchantEntity extends VillagerEntity implements IAnimatable {


    public MysteriousMerchantEntity(EntityType<? extends VillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }

    @Override
    public void sendOffers(PlayerEntity playerEntity, Text text, int i) {
        super.sendOffers(playerEntity, text, i);
    }


}
