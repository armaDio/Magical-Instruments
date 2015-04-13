package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHorn extends ModelBase
{
  //fields
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape6;
  
  public ModelHorn()
  {
      textureWidth = 64;
      textureHeight = 32;

      Shape2 = new ModelRenderer(this, 12, 0);
      Shape2.addBox(0F, -1F, 0F, 2, 3, 2);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0.2617994F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, -1F, 0F, 3, 4, 3);
      Shape4.setRotationPoint(0F, -3.5F, -0.5F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 20, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape6.setRotationPoint(-0.3F, 1.7F, 0.5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0.5235988F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Shape2.render(f5);
    Shape4.render(f5);
    Shape6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
