package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.client.models.ModelOrcishOboe;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 16/05/2015.
 */
public class ItemRendererOrcishOboe implements IItemRenderer {

    protected ModelOrcishOboe oboe;

    public ItemRendererOrcishOboe(){
        oboe = new ModelOrcishOboe();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/OrcishOboeTexture.png"));

                GL11.glRotatef(90,0,1,0);
                GL11.glRotatef(180,0,0,1);
                GL11.glTranslatef(-0.2F,-0.8F,0.3F);
                GL11.glScalef(0.15f,0.15f,0.15f);
                //GL11.glTranslatef(x,y,z);

                oboe.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);

                GL11.glPopMatrix();
            default:
                break;
        }

    }
}
