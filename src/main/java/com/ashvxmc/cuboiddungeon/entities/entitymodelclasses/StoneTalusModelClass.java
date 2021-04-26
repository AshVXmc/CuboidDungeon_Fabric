package com.ashvxmc.cuboiddungeon.entities.entitymodelclasses;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.entities.StoneTalusEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StoneTalusModelClass extends AnimatedGeoModel<StoneTalusEntity> {

    @Override
    public Identifier getModelLocation(StoneTalusEntity object) {
        return new Identifier(Cuboiddungeon.MOD_ID,"geo/stonetalusmodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(StoneTalusEntity object) {
        return new Identifier(Cuboiddungeon.MOD_ID,"textures/entity/stone_talus.png");
    }

    @Override
    public Identifier getAnimationFileLocation(StoneTalusEntity animatable) {
        return new Identifier(Cuboiddungeon.MOD_ID,"animations/stonetalusmodel.animation.json");
    }
}
