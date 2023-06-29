package com.armadio.magicalinstrument.entity.client;


import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DrummerModel extends GeoModel<DrummerEntity> {
    @Override
    public ResourceLocation getModelResource(DrummerEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "geo/drummer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DrummerEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "textures/entity/drummer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DrummerEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "animations/drummer.animation.json");
    }
}
