package com.armadio.magicalinstrument.entity.client;


import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OrcModel extends GeoModel<OrcEntity> {
    @Override
    public ResourceLocation getModelResource(OrcEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "geo/orc.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OrcEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "textures/entity/orc.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OrcEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "animations/orc.animation.json");
    }
}
