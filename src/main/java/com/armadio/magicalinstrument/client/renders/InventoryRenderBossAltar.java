package com.armadio.magicalinstrument.client.renders;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 10/04/2015.
 */
public class InventoryRenderBossAltar implements IItemRenderer {

    private BlockRendererAltar render;
    private TileEntity entity;

    public InventoryRenderBossAltar(BlockRendererAltar render, TileEntity entity){
        this.render = render;
        this.entity = entity;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if(type==ItemRenderType.ENTITY){
            GL11.glTranslatef(-0.5F,0.0F,-0.5F);
        }
        this.render.renderTileEntityAt(this.entity,0.0D,0.0D,0.0D,0.0F);
    }
}
