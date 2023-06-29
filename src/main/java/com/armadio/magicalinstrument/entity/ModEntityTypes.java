package com.armadio.magicalinstrument.entity;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
            ForgeRegistries.ENTITY_TYPES, MagicalInstrument.MODID
    );


    public static final RegistryObject<EntityType<OrcEntity>> ORC = ENTITY_TYPES.register("orc",
            ()-> EntityType.Builder.of(OrcEntity::new, MobCategory.MONSTER).sized(1.2f,2.4f)
                    .build(new ResourceLocation(MagicalInstrument.MODID, "orc").toString()));

    public static final RegistryObject<EntityType<DrummerEntity>> DRUMMER = ENTITY_TYPES.register("drummer",
            ()-> EntityType.Builder.of(DrummerEntity::new, MobCategory.MONSTER).sized(1.2f,2.4f)
                    .build(new ResourceLocation(MagicalInstrument.MODID, "drummer").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
