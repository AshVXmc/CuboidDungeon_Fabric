package com.ashvxmc.cuboiddungeon.renderer;

import com.ashvxmc.cuboiddungeon.entities.RheumSlimeEntity;
import com.ashvxmc.cuboiddungeon.entitymodel.RheumSlimeModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RheumSlimeEntityRenderer extends MobEntityRenderer<RheumSlimeEntity, RheumSlimeModel> {
    public RheumSlimeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher){
        super(entityRenderDispatcher, new RheumSlimeModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(RheumSlimeEntity entity) {
        return new Identifier("cuboiddungeon","textures/entity/rheum_slime.png");
    }
}
