package com.ashvxmc.cuboiddungeon.entities.entitymodelclasses;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.entities.MarsupialRatEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MarsupialRatModelClass extends AnimatedGeoModel<MarsupialRatEntity> {

    @Override
    public Identifier getModelLocation(MarsupialRatEntity marsupialRatEntity) {
        return new Identifier(Cuboiddungeon.MOD_ID,"geo/marsupialratmodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MarsupialRatEntity marsupialRatEntity) {
        return new Identifier(Cuboiddungeon.MOD_ID,"textures/entity/marsupial_rat.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MarsupialRatEntity marsupialRatEntity) {
        return new Identifier(Cuboiddungeon.MOD_ID,"animations/marsupialratmodel.animation.json");
    }
}
