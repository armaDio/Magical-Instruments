package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by armaDio on 24/06/2015.
 */
public class ModelOrcishFlute extends ModelBase
{
    //fields
    ModelRenderer neverGonna;
    ModelRenderer give;
    ModelRenderer youUp;

    public ModelOrcishFlute()
    {
        textureWidth = 64;
        textureHeight = 64;

        neverGonna = new ModelRenderer(this, 0, 0);
        neverGonna.addBox(0F, 0F, 0F, 1, 14, 1);
        neverGonna.setRotationPoint(0F, 0F, 0F);
        neverGonna.setTextureSize(64, 64);
        neverGonna.mirror = true;
        setRotation(neverGonna, 0F, 0F, 0F);
        give = new ModelRenderer(this, 0, 0);
        give.addBox(0F, 0F, 0F, 2, 3, 2);
        give.setRotationPoint(-0.5F, 2F, -0.5F);
        give.setTextureSize(64, 64);
        give.mirror = true;
        setRotation(give, 0F, 0F, 0F);
        youUp = new ModelRenderer(this, 0, 0);
        youUp.addBox(0F, 0F, 0F, 2, 2, 2);
        youUp.setRotationPoint(-0.5F, 14F, -0.5F);
        youUp.setTextureSize(64, 64);
        youUp.mirror = true;
        setRotation(youUp, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        neverGonna.render(f5);
        give.render(f5);
        youUp.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
