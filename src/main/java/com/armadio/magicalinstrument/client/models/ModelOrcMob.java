package com.armadio.magicalinstrument.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOrcMob extends ModelBase
{
  //fields
    ModelRenderer bipedHead;
    ModelRenderer bipedHeadwear;
    ModelRenderer bipedHeadwear1;
    ModelRenderer bipedHeadwear2;
    ModelRenderer bipedHeadwear3;

    ModelRenderer bipedBodytop;
    ModelRenderer bipedBodybot;

    ModelRenderer bipedLeftArm;
    ModelRenderer bipedShield;
    ModelRenderer bipedLeftShoulder;

    ModelRenderer bipedRightArm;
    ModelRenderer heldItemRight;
    ModelRenderer bipedRightShoulder;

    ModelRenderer bipedLeftLeg;
    ModelRenderer bipedRightLeg;

  
  public ModelOrcMob()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      bipedHead = new ModelRenderer(this, 0, 0);
      bipedHead.addBox(-5F, -10F, -5F, 10, 10, 10);
      bipedHead.setRotationPoint(0F, -4F, 0F);
      bipedHead.setTextureSize(128, 64);
      bipedHead.mirror = true;
      setRotation(bipedHead, 0F, 0F, 0F);
      bipedHeadwear = new ModelRenderer(this, 64, 0);
      bipedHeadwear.addBox(-5.5F, -10.5F, -5.5F, 11, 11, 11);
      bipedHeadwear.setRotationPoint(0F, -4F, 0F);
      bipedHeadwear.setTextureSize(128, 64);
      bipedHeadwear.mirror = true;
      setRotation(bipedHeadwear, 0F, 0F, 0F);
      bipedHeadwear1 = new ModelRenderer(this, 44, 21);
      bipedHeadwear1.addBox(-2.5F, -12.5F, -2.5F, 5, 2, 5);
      bipedHeadwear1.setRotationPoint(0F, -4F, 0F);
      bipedHeadwear1.setTextureSize(128, 64);
      bipedHeadwear1.mirror = true;
      setRotation(bipedHeadwear1, 0F, 0F, 0F);
      bipedHeadwear2 = new ModelRenderer(this, 44, 14);
      bipedHeadwear2.addBox(-1.5F, -16.5F, -1.5F, 3, 4, 3);
      bipedHeadwear2.setRotationPoint(0F, -4F, 0F);
      bipedHeadwear2.setTextureSize(128, 64);
      bipedHeadwear2.mirror = true;
      setRotation(bipedHeadwear2, 0F, 0F, 0F);
      bipedHeadwear3 = new ModelRenderer(this, 40, 0);
      bipedHeadwear3.addBox(-2F, -22.5F, -4F, 4, 6, 8);
      bipedHeadwear3.setRotationPoint(0F, -4F, 0F);
      bipedHeadwear3.setTextureSize(128, 64);
      bipedHeadwear3.mirror = true;
      setRotation(bipedHeadwear3, 0F, 0F, 0F);
      bipedBodytop = new ModelRenderer(this, 0, 20);
      bipedBodytop.addBox(-8F, 0F, -6F, 16, 10, 12);
      bipedBodytop.setRotationPoint(0F, -4F, 0F);
      bipedBodytop.setTextureSize(128, 64);
      bipedBodytop.mirror = true;
      setRotation(bipedBodytop, 0F, 0F, 0F);
      bipedBodybot = new ModelRenderer(this, 56, 22);
      bipedBodybot.addBox(-6F, 0F, -4F, 12, 6, 8);
      bipedBodybot.setRotationPoint(0F, 6F, 0F);
      bipedBodybot.setTextureSize(128, 64);
      bipedBodybot.mirror = true;
      setRotation(bipedBodybot, 0F, 0F, 0F);
      bipedLeftArm = new ModelRenderer(this, 0, 42);
      bipedLeftArm.addBox(0F, -3F, -3F, 6, 16, 6);
      bipedLeftArm.setRotationPoint(8F, 0F, 0F);
      bipedLeftArm.setTextureSize(128, 64);
      bipedLeftArm.mirror = true;
      setRotation(bipedLeftArm, 0F, 0F, 0F);
      bipedRightArm = new ModelRenderer(this, 0, 42);
      bipedRightArm.addBox(0F, -3F, -3F, 6, 16, 6);
      bipedRightArm.setRotationPoint(-8F, 0F, 0F);
      bipedRightArm.setTextureSize(128, 64);
      bipedRightArm.mirror = true;
      setRotation(bipedRightArm, 0F, 3.141593F, 0F);
      bipedLeftLeg = new ModelRenderer(this, 24, 42);
      bipedLeftLeg.addBox(-3F, 0F, -3F, 6, 12, 6);
      bipedLeftLeg.setRotationPoint(3F, 12F, 0F);
      bipedLeftLeg.setTextureSize(128, 64);
      bipedLeftLeg.mirror = true;
      setRotation(bipedLeftLeg, 0F, 3.141593F, 0F);
      bipedLeftLeg.mirror = false;
      bipedRightLeg = new ModelRenderer(this, 24, 42);
      bipedRightLeg.addBox(-3F, 0F, -3F, 6, 12, 6);
      bipedRightLeg.setRotationPoint(-3F, 12F, 0F);
      bipedRightLeg.setTextureSize(128, 64);
      bipedRightLeg.mirror = true;
      setRotation(bipedRightLeg, 0F, 3.141593F, 0F);
      bipedShield = new ModelRenderer(this, 88, 36);
      bipedShield.addBox(6F, 5F, -5F, 2, 10, 10);
      bipedShield.setRotationPoint(8F, 0F, 0F);
      bipedShield.setTextureSize(128, 64);
      bipedShield.mirror = true;
      setRotation(bipedShield, 0F, 0F, 0F);
      heldItemRight = new ModelRenderer(this, 0, 0);
      heldItemRight.addBox(-3F, 10F, 0F, 0, 0, 0);
      heldItemRight.setRotationPoint(-8F, 0F, 0F);
      heldItemRight.setTextureSize(128, 64);
      heldItemRight.mirror = true;
      setRotation(heldItemRight, 0F, 0F, 0F);
      bipedLeftShoulder = new ModelRenderer(this, 56, 36);
      bipedLeftShoulder.addBox(-1F, -5F, -4F, 8, 8, 8);
      bipedLeftShoulder.setRotationPoint(8F, 0F, 0F);
      bipedLeftShoulder.setTextureSize(128, 64);
      bipedLeftShoulder.mirror = true;
      setRotation(bipedLeftShoulder, 0F, 0F, 0F);
      bipedRightShoulder = new ModelRenderer(this, 56, 36);
      bipedRightShoulder.addBox(-1F, -5F, -4F, 8, 8, 8);
      bipedRightShoulder.setRotationPoint(-8F, 0F, 0F);
      bipedRightShoulder.setTextureSize(128, 64);
      bipedRightShoulder.mirror = true;
      setRotation(bipedRightShoulder, 0F, 3.141593F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bipedHead.render(f5);
    bipedHeadwear.render(f5);
    bipedHeadwear1.render(f5);
    bipedHeadwear2.render(f5);
    bipedHeadwear3.render(f5);
    bipedBodytop.render(f5);
    bipedBodybot.render(f5);
    bipedLeftArm.render(f5);
    bipedRightArm.render(f5);
    bipedLeftLeg.render(f5);
    bipedRightLeg.render(f5);
    bipedShield.render(f5);
    heldItemRight.render(f5);
    bipedLeftShoulder.render(f5);
    bipedRightShoulder.render(f5);
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
        this.bipedHeadwear1.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear1.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedHeadwear2.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear2.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedHeadwear3.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear3.rotateAngleX = this.bipedHead.rotateAngleX;

        this.bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        this.heldItemRight.rotateAngleX = this.bipedLeftArm.rotateAngleX;
        this.heldItemRight.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;
        this.bipedRightShoulder.rotateAngleX = this.bipedLeftArm.rotateAngleX;
        this.bipedRightShoulder.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;


        this.bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.bipedShield.rotateAngleX = this.bipedLeftArm.rotateAngleX;
        this.bipedShield.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;
        this.bipedLeftShoulder.rotateAngleX = this.bipedLeftArm.rotateAngleX;
        this.bipedLeftShoulder.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;

        this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.bipedRightLeg.rotateAngleY = (float)Math.PI;

        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.bipedLeftLeg.rotateAngleY = (float)Math.PI;

  }

}
