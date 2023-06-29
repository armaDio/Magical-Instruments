package com.armadio.magicalinstrument.entity.client;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OrcRenderer extends GeoEntityRenderer<OrcEntity> {
    public OrcRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OrcModel());
        this.shadowRadius = 1.2f;
    }

    @Override
    public ResourceLocation getTextureLocation(OrcEntity animatable) {
        return new ResourceLocation(MagicalInstrument.MODID, "textures/entity/orc.png");
    }
}
