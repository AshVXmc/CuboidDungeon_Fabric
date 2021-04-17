package com.ashvxmc.cuboiddungeon.renderer;

import com.ashvxmc.cuboiddungeon.entities.DungeonSnakeEntity;
import com.ashvxmc.cuboiddungeon.entities.entitymodelclasses.DungeonSnakeModelClass;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class DungeonSnakeEntityRenderer extends GeoEntityRenderer<DungeonSnakeEntity> {
    public DungeonSnakeEntityRenderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new DungeonSnakeModelClass());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTexture(DungeonSnakeEntity entity){
        return new Identifier("cuboiddungeon","textures/entity/dungeon_snake.png");
    }
}
