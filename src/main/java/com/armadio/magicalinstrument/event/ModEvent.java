package com.armadio.magicalinstrument.event;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.ModEntityTypes;
import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvent {

    @Mod.EventBusSubscriber(modid = MagicalInstrument.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventsBusEvent {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.ORC.get(), OrcEntity.setAttributes());
            event.put(ModEntityTypes.DRUMMER.get(), DrummerEntity.setAttributes());
        }
    }
}
