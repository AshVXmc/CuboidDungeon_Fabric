package com.ashvxmc.cuboiddungeon.renderer;


import com.ashvxmc.cuboiddungeon.entities.MarsupialRatEntity;
import com.ashvxmc.cuboiddungeon.entities.entitymodelclasses.MarsupialRatModelClass;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class MarsupialRatEntityRenderer extends GeoEntityRenderer<MarsupialRatEntity> {
    public MarsupialRatEntityRenderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new MarsupialRatModelClass());
        this.shadowRadius = 0.45f;
    }

    @Override
    public Identifier getTexture(MarsupialRatEntity entity){
        return new Identifier("cuboiddungeon","textures/entity/marsupial_rat.png");
    }

}
