package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by armaDio on 24/06/2015.
 */

public class ModelOrcishBagpipe extends ModelBase {
    //fields
    ModelRenderer armadio;
    ModelRenderer sucks;
    ModelRenderer bags;
    ModelRenderer and;
    ModelRenderer his;
    ModelRenderer sister;
    ModelRenderer is_cute;

    public ModelOrcishBagpipe() {
        textureWidth = 64;
        textureHeight = 64;

        armadio = new ModelRenderer(this, 20, 0);
        armadio.addBox(0F, 0F, 0F, 3, 3, 7);
        armadio.setRotationPoint(-2F, 0F, -3F);
        armadio.setTextureSize(64, 64);
        armadio.mirror = true;
        setRotation(armadio, 0F, 0.1745329F, 0F);
        sucks = new ModelRenderer(this, 0, 10);
        sucks.addBox(0F, 0F, 0F, 1, 6, 1);
        sucks.setRotationPoint(-1F, 3F, -2.5F);
        sucks.setTextureSize(64, 64);
        sucks.mirror = true;
        setRotation(sucks, 0F, 0F, 0F);
        bags = new ModelRenderer(this, 0, 0);
        bags.addBox(0F, 0F, 0F, 5, 5, 5);
        bags.setRotationPoint(-2.5F, 3F, 0F);
        bags.setTextureSize(64, 64);
        bags.mirror = true;
        setRotation(bags, 0F, 0F, 0F);
        and = new ModelRenderer(this, 4, 10);
        and.addBox(0F, 0F, 0F, 1, 5, 1);
        and.setRotationPoint(0F, 0F, -2F);
        and.setTextureSize(64, 64);
        and.mirror = true;
        setRotation(and, 0F, 0F, 3.141593F);
        his = new ModelRenderer(this, 8, 10);
        his.addBox(0F, 0F, 0F, 1, 12, 1);
        his.setRotationPoint(1F, 0F, 1F);
        his.setTextureSize(64, 64);
        his.mirror = true;
        setRotation(his, 0F, 3.141593F, 2.86234F);
        sister = new ModelRenderer(this, 12, 10);
        sister.addBox(1F, 0F, 0F, 1, 8, 1);
        sister.setRotationPoint(0F, 0F, 3F);
        sister.setTextureSize(64, 64);
        sister.mirror = true;
        setRotation(sister, -0.1570796F, 3.141593F, 2.86234F);
        is_cute = new ModelRenderer(this, 16, 10);
        is_cute.addBox(0F, 0F, 0F, 1, 8, 1);
        is_cute.setRotationPoint(1F, 1F, 4F);
        is_cute.setTextureSize(64, 64);
        is_cute.mirror = true;
        setRotation(is_cute, -0.4537856F, 3.141593F, 2.86234F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        armadio.render(f5);
        sucks.render(f5);
        bags.render(f5);
        and.render(f5);
        his.render(f5);
        sister.render(f5);
        is_cute.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}