package com.ashvxmc.cuboiddungeon.renderer;

import com.ashvxmc.cuboiddungeon.entities.StoneTalusEntity;
import com.ashvxmc.cuboiddungeon.entities.entitymodelclasses.StoneTalusModelClass;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class StoneTalusEntityRenderer extends GeoEntityRenderer<StoneTalusEntity> {
    public StoneTalusEntityRenderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new StoneTalusModelClass());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTexture(StoneTalusEntity entity){
        return new Identifier("cuboiddungeon","textures/entity/stone_talus.png");
    }
}
