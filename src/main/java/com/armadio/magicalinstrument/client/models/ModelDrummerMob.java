package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDrummerMob extends ModelBase
{
  //fields
    ModelRenderer bipedHead;
    ModelRenderer bipedBody;
    ModelRenderer bipedLeftArm;
    ModelRenderer bipedRightArm;
    ModelRenderer bipedLeftLeg;
    ModelRenderer bipedRightLeg;
    ModelRenderer bipedDrumTop;
    ModelRenderer bipedDrumBot;
    ModelRenderer bipedBackpack;
    ModelRenderer bipedPole;
    ModelRenderer bipedFlag;
    ModelRenderer bipedHeadwear;
  
  public ModelDrummerMob()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      bipedHead = new ModelRenderer(this, 0, 0);
      bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
      bipedHead.setRotationPoint(0F, 4F, 0F);
      bipedHead.setTextureSize(128, 64);
      bipedHead.mirror = true;
      setRotation(bipedHead, 0F, 0F, 0F);
      bipedBody = new ModelRenderer(this, 32, 0);
      bipedBody.addBox(-4F, 0F, -2.5F, 8, 10, 5);
      bipedBody.setRotationPoint(0F, 4F, 0F);
      bipedBody.setTextureSize(128, 64);
      bipedBody.mirror = true;
      setRotation(bipedBody, 0F, 0F, 0F);
      bipedLeftArm = new ModelRenderer(this, 0, 29);
      bipedLeftArm.addBox(0F, -2F, -2F, 4, 12, 4);
      bipedLeftArm.setRotationPoint(4F, 6F, 0F);
      bipedLeftArm.setTextureSize(128, 64);
      bipedLeftArm.mirror = true;
      setRotation(bipedLeftArm, 0F, 0F, 0F);
      bipedRightArm = new ModelRenderer(this, 0, 29);
      bipedRightArm.addBox(0F, -2F, -2F, 4, 12, 4);
      bipedRightArm.setRotationPoint(-4F, 6F, 0F);
      bipedRightArm.setTextureSize(128, 64);
      bipedRightArm.mirror = true;
      setRotation(bipedRightArm, 0F, 3.141593F, 0F);
      bipedLeftLeg = new ModelRenderer(this, 16, 29);
      bipedLeftLeg.addBox(-2F, 0F, -2F, 4, 10, 4);
      bipedLeftLeg.setRotationPoint(2F, 14F, 0F);
      bipedLeftLeg.setTextureSize(128, 64);
      bipedLeftLeg.mirror = true;
      setRotation(bipedLeftLeg, 0F, 3.141593F, 0F);
      bipedLeftLeg.mirror = false;
      bipedRightLeg = new ModelRenderer(this, 16, 29);
      bipedRightLeg.addBox(-2F, 0F, -2F, 4, 10, 4);
      bipedRightLeg.setRotationPoint(-2F, 14F, 0F);
      bipedRightLeg.setTextureSize(128, 64);
      bipedRightLeg.mirror = true;
      setRotation(bipedRightLeg, 0F, 3.141593F, 0F);
      bipedDrumTop = new ModelRenderer(this, 0, 16);
      bipedDrumTop.addBox(-5F, 0F, -10F, 10, 3, 10);
      bipedDrumTop.setRotationPoint(0F, 9F, -2.5F);
      bipedDrumTop.setTextureSize(128, 64);
      bipedDrumTop.mirror = true;
      setRotation(bipedDrumTop, 0F, 0F, 0F);
      bipedDrumBot = new ModelRenderer(this, 0, 45);
      bipedDrumBot.addBox(-4F, 3F, -9F, 8, 8, 8);
      bipedDrumBot.setRotationPoint(0F, 9F, -2.5F);
      bipedDrumBot.setTextureSize(128, 64);
      bipedDrumBot.mirror = true;
      setRotation(bipedDrumBot, 0F, 0F, 0F);
      bipedBackpack = new ModelRenderer(this, 40, 15);
      bipedBackpack.addBox(-3F, 0F, 0F, 6, 8, 3);
      bipedBackpack.setRotationPoint(0F, 5F, 2.5F);
      bipedBackpack.setTextureSize(128, 64);
      bipedBackpack.mirror = true;
      setRotation(bipedBackpack, 0F, 0F, 0F);
      bipedPole = new ModelRenderer(this, 32, 29);
      bipedPole.addBox(-0.5F, 0F, 0F, 1, 34, 1);
      bipedPole.setRotationPoint(0F, -22F, 5.5F);
      bipedPole.setTextureSize(128, 64);
      bipedPole.mirror = true;
      setRotation(bipedPole, 0F, 0F, 0F);
      bipedFlag = new ModelRenderer(this, 36, 29);
      bipedFlag.addBox(-0.5F, 0F, 0F, 1, 25, 10);
      bipedFlag.setRotationPoint(0F, -21F, 6.5F);
      bipedFlag.setTextureSize(128, 64);
      bipedFlag.mirror = true;
      setRotation(bipedFlag, 0F, 0F, 0F);
      bipedHeadwear = new ModelRenderer(this, 58, 0);
      bipedHeadwear.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
      bipedHeadwear.setRotationPoint(0F, 4F, 0F);
      bipedHeadwear.setTextureSize(128, 64);
      bipedHeadwear.mirror = true;
      setRotation(bipedHeadwear, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    bipedHead.render(f5);
    bipedBody.render(f5);
    bipedLeftArm.render(f5);
    bipedRightArm.render(f5);
    bipedLeftLeg.render(f5);
    bipedRightLeg.render(f5);
    bipedDrumTop.render(f5);
    bipedDrumBot.render(f5);
    bipedBackpack.render(f5);
    bipedPole.render(f5);
    bipedFlag.render(f5);
    bipedHeadwear.render(f5);
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
    this.bipedHead.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.bipedHead.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
    this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
    this.bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F ) * 2.0F * f1 * 0.5F;
    this.bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.bipedRightArm.rotateAngleZ = 0.0F;
    this.bipedLeftArm.rotateAngleZ = 0.0F;
    this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.bipedRightLeg.rotateAngleY = 0.0F;
    this.bipedLeftLeg.rotateAngleY = 0.0F;



    this.bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.bipedLeftArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    this.bipedLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
  }

}
