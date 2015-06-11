package com.armadio.magicalinstrument.client.models;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOrcishOboe extends ModelBase
{
    //fields
    ModelRenderer oboeShaft;
    ModelRenderer oboeBot;
    ModelRenderer oboeTip;
    ModelRenderer oboeK1;
    ModelRenderer oboeK2;
    ModelRenderer oboeK6;
    ModelRenderer oboeK5;
    ModelRenderer oboeK4;
    ModelRenderer oboeK3;
    ModelRenderer oboeK7;

    public ModelOrcishOboe()
    {
        textureWidth = 64;
        textureHeight = 32;

        oboeShaft = new ModelRenderer(this, 0, 1);
        oboeShaft.addBox(0F, 0F, 0F, 3, 20, 3);
        oboeShaft.setRotationPoint(0F, 0F, 0F);
        oboeShaft.setTextureSize(64, 32);
        oboeShaft.mirror = true;
        setRotation(oboeShaft, 0F, 0F, 0F);
        oboeBot = new ModelRenderer(this, 16, 4);
        oboeBot.addBox(-0.5F, 0F, -0.5F, 4, 4, 4);
        oboeBot.setRotationPoint(0F, 20F, 0F);
        oboeBot.setTextureSize(64, 32);
        oboeBot.mirror = true;
        setRotation(oboeBot, 0F, 0F, 0F);
        oboeTip = new ModelRenderer(this, 9, 0);
        oboeTip.addBox(0F, 0F, 0F, 1, 2, 2);
        oboeTip.setRotationPoint(1.5F, -2F, 0.5F);
        oboeTip.setTextureSize(64, 32);
        oboeTip.mirror = true;
        setRotation(oboeTip, 0F, 0F, 0F);
        oboeK1 = new ModelRenderer(this, 15, 0);
        oboeK1.addBox(0F, 0F, 0F, 3, 1, 3);
        oboeK1.setRotationPoint(0.5F, 2F, 0.5F);
        oboeK1.setTextureSize(64, 32);
        oboeK1.mirror = true;
        setRotation(oboeK1, 0F, 0F, 0F);
        oboeK2 = new ModelRenderer(this, 15, 0);
        oboeK2.addBox(0F, 0F, 0F, 3, 1, 3);
        oboeK2.setRotationPoint(0.5F, 4F, -0.5F);
        oboeK2.setTextureSize(64, 32);
        oboeK2.mirror = true;
        setRotation(oboeK2, 0F, 0F, 0F);
        oboeK6 = new ModelRenderer(this, 15, 0);
        oboeK6.addBox(0F, 0F, 0F, 3, 1, 3);
        oboeK6.setRotationPoint(0.5F, 14F, -0.5F);
        oboeK6.setTextureSize(64, 32);
        oboeK6.mirror = true;
        setRotation(oboeK6, 0F, 0F, 0F);
        oboeK5 = new ModelRenderer(this, 15, 0);
        oboeK5.addBox(0F, 0F, 0F, 3, 1, 3);
        oboeK5.setRotationPoint(0.5F, 12F, 0.5F);
        oboeK5.setTextureSize(64, 32);
        oboeK5.mirror = true;
        setRotation(oboeK5, 0F, 0F, 0F);
        oboeK4 = new ModelRenderer(this, 12, 14);
        oboeK4.addBox(0F, 0F, 0F, 1, 3, 2);
        oboeK4.setRotationPoint(2.5F, 8F, 0.5F);
        oboeK4.setTextureSize(64, 32);
        oboeK4.mirror = true;
        setRotation(oboeK4, 0F, 0F, 0F);
        oboeK3 = new ModelRenderer(this, 15, 0);
        oboeK3.addBox(0F, 0F, 0F, 3, 1, 3);
        oboeK3.setRotationPoint(0.5F, 6F, -0.5F);
        oboeK3.setTextureSize(64, 32);
        oboeK3.mirror = true;
        setRotation(oboeK3, 0F, 0F, 0F);
        oboeK7 = new ModelRenderer(this, 12, 4);
        oboeK7.addBox(0F, 0F, 0F, 1, 9, 1);
        oboeK7.setRotationPoint(1.5F, 3F, 2.5F);
        oboeK7.setTextureSize(64, 32);
        oboeK7.mirror = true;
        setRotation(oboeK7, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        oboeShaft.render(f5);
        oboeBot.render(f5);
        oboeTip.render(f5);
        oboeK1.render(f5);
        oboeK2.render(f5);
        oboeK6.render(f5);
        oboeK5.render(f5);
        oboeK4.render(f5);
        oboeK3.render(f5);
        oboeK7.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }

}
