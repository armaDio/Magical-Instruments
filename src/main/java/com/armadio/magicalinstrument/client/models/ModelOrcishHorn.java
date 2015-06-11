package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by armaDio on 17/05/2015.
 */
public class ModelOrcishHorn  extends ModelBase
    {
        //fields
        ModelRenderer horn4;
        ModelRenderer horn7;
        ModelRenderer horn6;
        ModelRenderer horn5;
        ModelRenderer horn1;
        ModelRenderer horn3;
        ModelRenderer horn2;

        public ModelOrcishHorn()
        {
            textureWidth = 64;
            textureHeight = 32;

            horn4 = new ModelRenderer(this, 0, 23);
            horn4.addBox(-3.5F, 2F, 0.5F, 3, 4, 3);
            horn4.setRotationPoint(4F, 7.9F, 0.5F);
            horn4.setTextureSize(64, 32);
            horn4.mirror = true;
            setRotation(horn4, 0F, 0F, 0.5235988F);
            horn7 = new ModelRenderer(this, 0, 0);
            horn7.addBox(0F, 0F, 0F, 5, 3, 5);
            horn7.setRotationPoint(0F, 0F, 0F);
            horn7.setTextureSize(64, 32);
            horn7.mirror = true;
            setRotation(horn7, 0F, 0F, 0F);
            horn6 = new ModelRenderer(this, 0, 8);
            horn6.addBox(-4F, 0F, 0F, 4, 5, 4);
            horn6.setRotationPoint(4.5F, 3F, 0.5F);
            horn6.setTextureSize(64, 32);
            horn6.mirror = true;
            setRotation(horn6, 0F, 0F, 0.1745329F);
            horn5 = new ModelRenderer(this, 0, 17);
            horn5.addBox(-4F, 0F, 0F, 4, 2, 4);
            horn5.setRotationPoint(3.6F, 7.9F, 0.5F);
            horn5.setTextureSize(64, 32);
            horn5.mirror = true;
            setRotation(horn5, 0F, 0F, 0.3490659F);
            horn1 = new ModelRenderer(this, 20, 9);
            horn1.addBox(0F, 0.4F, 0F, 1, 1, 1);
            horn1.setRotationPoint(-3F, 13.5F, 2F);
            horn1.setTextureSize(64, 32);
            horn1.mirror = true;
            setRotation(horn1, 0F, 0F, 1.047198F);
            horn3 = new ModelRenderer(this, 20, 0);
            horn3.addBox(0F, 0F, 0F, 3, 2, 3);
            horn3.setRotationPoint(-1.7F, 10.8F, 1F);
            horn3.setTextureSize(64, 32);
            horn3.mirror = true;
            setRotation(horn3, 0F, 0F, 0.6981317F);
            horn2 = new ModelRenderer(this, 20, 5);
            horn2.addBox(0F, 0.4F, 0F, 2, 2, 2);
            horn2.setRotationPoint(-2F, 12.1F, 1.5F);
            horn2.setTextureSize(64, 32);
            horn2.mirror = true;
            setRotation(horn2, 0F, 0F, 0.8726646F);
        }

        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
        {
            super.render(entity, f, f1, f2, f3, f4, f5);
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            horn4.render(f5);
            horn7.render(f5);
            horn6.render(f5);
            horn5.render(f5);
            horn1.render(f5);
            horn3.render(f5);
            horn2.render(f5);
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
