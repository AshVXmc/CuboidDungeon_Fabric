package com.ashvxmc.cuboiddungeon.entities.entitymodelclasses;

import com.ashvxmc.cuboiddungeon.Cuboiddungeon;
import com.ashvxmc.cuboiddungeon.entities.DungeonSnakeEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DungeonSnakeModelClass extends AnimatedGeoModel<DungeonSnakeEntity> {

    @Override
    public Identifier getModelLocation(DungeonSnakeEntity object) {
        return new Identifier(Cuboiddungeon.MOD_ID,"geo/dungeonsnakemodel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DungeonSnakeEntity object) {
        return new Identifier(Cuboiddungeon.MOD_ID,"textures/entity/dungeon_snake.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DungeonSnakeEntity animatable) {
        return new Identifier(Cuboiddungeon.MOD_ID,"animations/dungeonsnakemodel.animation.json");
    }
}
