package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.entity.EntityOrc;
import com.armadio.magicalinstrument.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RendererOrcBoss extends RenderLiving
{
    private static final ResourceLocation bossTexture = new ResourceLocation(Reference.MOD_ID,"textures/models/MobOrc.png");
    private static final String __OBFID = "CL_00000984";

    public RendererOrcBoss(ModelBase p_i1253_1_, float p_i1253_2_)
    {
        super(p_i1253_1_, p_i1253_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityOrc p_110775_1_)
    {
        return bossTexture;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityOrc)p_110775_1_);
    }
}