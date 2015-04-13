package com.armadio.magicalinstrument.client.models;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBagpipe extends ModelBase
{
  //fields
  ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  public ModelBagpipe()
  {
      textureWidth = 64;
      textureHeight = 32;

      Shape1 = new ModelRenderer(this, 12, 9);
      Shape1.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape1.setRotationPoint(4.866667F, -7.3F, -0.9F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -0.2225295F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, -3.5F, 6, 5, 4);
      Shape2.setRotationPoint(-1.8F, -3.733333F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 32, 0);
      Shape3.addBox(-0.5F, 1F, -0.5F, 2, 1, 2);
      Shape3.setRotationPoint(4.9F, -7.3F, -0.9F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, -0.2225295F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 20, 0);
      Shape4.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape4.setRotationPoint(3.6F, -2.6F, -2.866667F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 9);
      Shape5.addBox(0F, 0F, 0F, 1, 11, 1);
      Shape5.setRotationPoint(2.7F, -13.93333F, -2.133333F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0.0523599F);
      Shape6 = new ModelRenderer(this, 4, 9);
      Shape6.addBox(0F, 0F, 0F, 1, 9, 1);
      Shape6.setRotationPoint(0.1333333F, -12.26667F, -1.466667F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, -0.0523599F, 0F, -0.044215F);
      Shape7 = new ModelRenderer(this, 8, 9);
      Shape7.addBox(0F, 0F, 0F, 1, 7, 1);
      Shape7.setRotationPoint(-1.733333F, -10.2F, -0.5333334F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, -0.1419534F, 0F, -0.1035562F);
  }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5,entity);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
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
