package com.armadio.magicalinstrument.client.renders;

import com.armadio.magicalinstrument.client.models.ModelUkulele;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by armaDio on 01/04/2015.
 */
public class ItemRendererTrumpet implements IItemRenderer {

    private int tier;
    protected IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("minst","models/test1Model.obj"));
    private ResourceLocation modelTexture = new ResourceLocation("minst", "textures/obj/test1Texture.png");

    public ItemRendererTrumpet(){
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
                GL11.glScaled(0.1d,0.1d,0.1);
                model.renderAll();

                GL11.glPopMatrix();
            default:
                break;
        }

    }
}
