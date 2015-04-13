package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.client.models.ModelMusicAltar;
import com.armadio.magicalinstrument.lib.Reference;
import com.armadio.magicalinstrument.tileentities.TileEntityBossAltar;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 09/04/2015.
 */
public class BlockRendererAltar extends TileEntitySpecialRenderer{

    private static final ResourceLocation texturenormal = new ResourceLocation(Reference.MOD_ID,"textures/models/MusicAltarTexture.png");
    private static final ResourceLocation textureactive = new ResourceLocation(Reference.MOD_ID,"textures/models/MusicAltarTexture2.png");

    private ModelMusicAltar model;

    EntityItem entityItem = null;

    public BlockRendererAltar(){
        this.model = new ModelMusicAltar();
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float p_147500_8_) {
        GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F,(float)z+0.5F);
            GL11.glRotatef(180,0F,0F,1F);

            this.bindTexture(texturenormal);
            GL11.glPushMatrix();
                this.model.renderModel(0.0625F);
            GL11.glPopMatrix();
        GL11.glPopMatrix();

        //render hovering item
        int slot = 0;
        TileEntityBossAltar tileEntity = (TileEntityBossAltar)tile;
        if((entityItem == null) || entityItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
            entityItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, tileEntity.getStackInSlot(slot));
        if(entityItem != null){
        GL11.glPushMatrix();
            this.entityItem.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.5F);
            GL11.glRotatef(180, 0, 1, 1);
            GL11.glRotatef(90, 1, 0, 0);
            RenderManager.instance.renderEntityWithPosYaw(this.entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.renderInFrame = false;
        GL11.glPopMatrix();
        }
    }

}
