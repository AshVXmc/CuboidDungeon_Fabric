package com.ashvxmc.cuboiddungeon.entitymodel;

import com.ashvxmc.cuboiddungeon.entities.RheumSlimeEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class RheumSlimeModel extends EntityModel<RheumSlimeEntity> {
private final ModelPart bone;
private final ModelPart bone2;
public RheumSlimeModel() {
    this.textureWidth = 64;
    this.textureHeight = 64;
    bone = new ModelPart(this);
    bone.setPivot(0.0F, 24.0F, 0.0F);
    bone.setTextureOffset(0, 16).addCuboid(-6.0F, -7.0F, -4.0F, 12.0F, 7.0F, 8.0F, 0.0F, false);
    bone.setTextureOffset(30, 0).addCuboid(-5.0F, -8.0F, -3.0F, 10.0F, 1.0F, 6.0F, 0.0F, false);
    bone.setTextureOffset(0, 31).addCuboid(-7.0F, -6.0F, -3.0F, 14.0F, 6.0F, 6.0F, 0.0F, false);
    bone.setTextureOffset(0, 0).addCuboid(-5.0F, -6.0F, -5.0F, 10.0F, 6.0F, 10.0F, 0.0F, false);

    bone2 = new ModelPart(this);
    bone2.setPivot(0.0F, 0.0F, 0.0F);
    bone.addChild(bone2);

}

    @Override
    public void setAngles(RheumSlimeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

    bone.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
    bone.pitch = x;
    bone.yaw = y;
    bone.roll = z;
}

}
