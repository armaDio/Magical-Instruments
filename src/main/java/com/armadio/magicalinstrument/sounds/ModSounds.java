package com.armadio.magicalinstrument.sounds;

import com.armadio.magicalinstrument.MagicalInstrument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MagicalInstrument.MODID);

    public static final RegistryObject<SoundEvent> BAGPIPE = registerSoundEvent("bagpipe");
    public static final RegistryObject<SoundEvent> DRUM = registerSoundEvent("drum");
    public static final RegistryObject<SoundEvent> T4DRUM = registerSoundEvent("t4drum");
    public static final RegistryObject<SoundEvent> FLUTE = registerSoundEvent("flute");
    public static final RegistryObject<SoundEvent> HORN = registerSoundEvent("horn");
    public static final RegistryObject<SoundEvent> OBOE = registerSoundEvent("oboe");
    public static final RegistryObject<SoundEvent> OCARINA = registerSoundEvent("ocarina");
    public static final RegistryObject<SoundEvent> UKULELE = registerSoundEvent("ukulele");



    public static final RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MagicalInstrument.MODID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }
}
