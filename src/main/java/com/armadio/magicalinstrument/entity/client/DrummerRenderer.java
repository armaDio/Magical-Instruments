package com.armadio.magicalinstrument.entity.client;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DrummerRenderer extends GeoEntityRenderer<DrummerEntity> {
    public DrummerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DrummerModel());
        this.shadowRadius = 1.2f;
    }

    @Override
    public ResourceLocation getTextureLocation(DrummerEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "textures/entity/drummer.png");
    }
}
