package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by armaDio on 24/06/2015.
 */
public class ModelOrcishUkulele extends ModelBase
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape22;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public ModelOrcishUkulele()
    {
        textureWidth = 64;
        textureHeight = 64;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(-4F, 0F, 0F, 8, 9, 4);
        Shape1.setRotationPoint(0F, -2F, 0F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 24, 0);
        Shape2.addBox(0.5F, 0F, 0F, 1, 15, 1);
        Shape2.setRotationPoint(0F, -10F, -1F);
        Shape2.setTextureSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape22 = new ModelRenderer(this, 28, 0);
        Shape22.addBox(-1.5F, 0F, 0F, 1, 15, 1);
        Shape22.setRotationPoint(0F, -10F, -1F);
        Shape22.setTextureSize(64, 64);
        Shape22.mirror = true;
        setRotation(Shape22, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 13);
        Shape3.addBox(0F, 0F, 0F, 3, 6, 1);
        Shape3.setRotationPoint(-1.5F, -8F, 0F);
        Shape3.setTextureSize(64, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 8, 13);
        Shape4.addBox(0F, 0F, 0F, 4, 4, 2);
        Shape4.setRotationPoint(-2F, -12F, 0F);
        Shape4.setTextureSize(64, 64);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 22, 16);
        Shape5.addBox(0F, 0F, 0F, 4, 1, 1);
        Shape5.setRotationPoint(-2F, 5F, -1F);
        Shape5.setTextureSize(64, 64);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape22.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
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
