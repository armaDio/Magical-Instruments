package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.client.models.ModelOrcishHorn;
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
public class ItemRendererOrcishHorn implements IItemRenderer {

    protected ModelOrcishHorn horn;

    public ItemRendererOrcishHorn(){
        horn = new ModelOrcishHorn();
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

                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID,"textures/models/OrcishHornTexture.png"));

                GL11.glRotatef(+180,0,0,1);

                GL11.glTranslatef(-0.5F,-0.5F,00F);
                GL11.glScalef(0.2f,0.2f,0.2f);
                //GL11.glTranslatef(x,y,z);

                horn.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);

                GL11.glPopMatrix();
            default:
                break;
        }

    }
}