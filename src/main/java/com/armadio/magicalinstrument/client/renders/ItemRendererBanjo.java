package com.armadio.magicalinstrument.client.renders;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 01/04/2015.
 */
public class ItemRendererBanjo implements IItemRenderer {

    private int tier;
    protected IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("minst","models/banjoModel.obj"));
    private ResourceLocation modelTexture = new ResourceLocation("minst", "textures/obj/banjoTexture.png");

    public ItemRendererBanjo(){
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

                Minecraft.getMinecraft().renderEngine.bindTexture(modelTexture);
                GL11.glRotated(-60,1,0,0);
                GL11.glRotated(-60,0,0,1);
                GL11.glTranslated(0.4,-1,0.2);
                model.renderAll();

                GL11.glPopMatrix();
            default:
                break;
        }

    }
}
