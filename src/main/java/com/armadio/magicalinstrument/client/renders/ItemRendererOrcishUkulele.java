package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.client.models.ModelOrcishUkulele;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 01/04/2015.
 */
public class ItemRendererOrcishUkulele implements IItemRenderer {

    protected ModelOrcishUkulele ukulele;

    public ItemRendererOrcishUkulele(){
        ukulele = new ModelOrcishUkulele();
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
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID,"textures/models/OrcishUkuleleTexture.png"));

                GL11.glRotatef(180,1,0,0);
                GL11.glRotatef(30,0,0,1);
                GL11.glScalef(0.2f,0.2f,0.2f);

                ukulele.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);

                GL11.glPopMatrix();
                break;
            case EQUIPPED:
                GL11.glPushMatrix();

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID,"textures/models/OrcishUkuleleTexture.png"));

                GL11.glRotatef(90,1,0,0);
                GL11.glRotatef(90,0,0,1);
                GL11.glRotatef(20,1,0,0);
                GL11.glRotatef(-20,0,1,0);
                GL11.glTranslatef(0.1f,-0.3f,-0.3f);
                GL11.glScalef(0.2f,0.2f,0.2f);
                //GL11.glTranslatef(x,y,z);

                ukulele.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);

                GL11.glPopMatrix();
            default:
                break;
        }

    }
}
