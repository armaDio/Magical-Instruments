package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by armaDio on 16/05/2015.
 */

public class ModelOrcishOcarina extends ModelBase
{
    //fields
    ModelRenderer ocarina1;
    ModelRenderer ocarina2;
    ModelRenderer ocarina4;
    ModelRenderer ocarina3;

    public ModelOrcishOcarina()
    {
        textureWidth = 64;
        textureHeight = 32;

        ocarina1 = new ModelRenderer(this, 12, 2);
        ocarina1.addBox(0F, -1F, 0F, 1, 1, 1);
        ocarina1.setRotationPoint(0F, 1F, 0F);
        ocarina1.setTextureSize(64, 32);
        ocarina1.mirror = true;
        setRotation(ocarina1, -0.3490659F, 0F, 0F);
        ocarina2 = new ModelRenderer(this, 12, 0);
        ocarina2.addBox(0F, 0F, 0F, 2, 1, 1);
        ocarina2.setRotationPoint(-0.5F, 1F, 0F);
        ocarina2.setTextureSize(64, 32);
        ocarina2.mirror = true;
        setRotation(ocarina2, -0.1745329F, 0F, 0F);
        ocarina4 = new ModelRenderer(this, 0, 6);
        ocarina4.addBox(0F, 0F, 0F, 2, 2, 2);
        ocarina4.setRotationPoint(-3F, 2.5F, -0.8F);
        ocarina4.setTextureSize(64, 32);
        ocarina4.mirror = true;
        setRotation(ocarina4, 0F, 0F, 0F);
        ocarina3 = new ModelRenderer(this, 0, 0);
        ocarina3.addBox(0F, 0F, 0F, 3, 3, 3);
        ocarina3.setRotationPoint(-1F, 2F, -1F);
        ocarina3.setTextureSize(64, 32);
        ocarina3.mirror = true;
        setRotation(ocarina3, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        ocarina1.render(f5);
        ocarina2.render(f5);
        ocarina4.render(f5);
        ocarina3.render(f5);
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
