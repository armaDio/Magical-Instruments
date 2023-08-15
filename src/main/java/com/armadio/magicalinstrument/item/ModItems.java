package com.armadio.magicalinstrument.item;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.entity.ModEntityTypes;
import com.armadio.magicalinstrument.item.instruments.*;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MagicalInstrument.MODID);

    public static final RegistryObject<Item> GOLDEN_NOTE = ITEMS.register("goldennote",
            ()-> new Item(new Item.Properties()) );
    public static final RegistryObject<Item> NETHER_NOTE = ITEMS.register("nethernote",
            ()-> new Item(new Item.Properties()) );
    public static final RegistryObject<Item> ENDER_NOTE = ITEMS.register("endernote",
            ()-> new Item(new Item.Properties()) );
    public static final RegistryObject<Item> NOTE_LEGION = ITEMS.register("noteofthelegion",
            ()-> new Item(new Item.Properties()) );

    //DRUM
    public static final RegistryObject<Item> T1DRUM = ITEMS.register("t1drum",
                ()-> new DrumItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2DRUM = ITEMS.register("t2drum",
            ()-> new DrumItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3DRUM = ITEMS.register("t3drum",
            ()-> new DrumItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4DRUM = ITEMS.register("t4drum",
            ()-> new DrumItem(new InstrumentProperties().tier(4)));

    //BAGPIPE
    public static final RegistryObject<Item> T1BAGPIPE = ITEMS.register("t1bagpipe",
            ()-> new BagpipeItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2BAGPIPE = ITEMS.register("t2bagpipe",
            ()-> new BagpipeItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3BAGPIPE = ITEMS.register("t3bagpipe",
            ()-> new BagpipeItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4BAGPIPE = ITEMS.register("t4bagpipe",
            ()-> new BagpipeItem(new InstrumentProperties().tier(4)));


    //FLUTE
    public static final RegistryObject<Item> T1FLUTE = ITEMS.register("t1flute",
            ()-> new FluteItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2FLUTE = ITEMS.register("t2flute",
            ()-> new FluteItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3FLUTE = ITEMS.register("t3flute",
            ()-> new FluteItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4FLUTE = ITEMS.register("t4flute",
            ()-> new FluteItem(new InstrumentProperties().tier(4)));

    //HORN
    public static final RegistryObject<Item> T1HORN = ITEMS.register("t1horn",
            ()-> new HornItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2HORN = ITEMS.register("t2horn",
            ()-> new HornItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3HORN = ITEMS.register("t3horn",
            ()-> new HornItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4HORN = ITEMS.register("t4horn",
            ()-> new HornItem(new InstrumentProperties().tier(4)));

    //OBOE
    public static final RegistryObject<Item> T1OBOE = ITEMS.register("t1oboe",
            ()-> new OboeItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2OBOE = ITEMS.register("t2oboe",
            ()-> new OboeItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3OBOE = ITEMS.register("t3oboe",
            ()-> new OboeItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4OBOE = ITEMS.register("t4oboe",
            ()-> new OboeItem(new InstrumentProperties().tier(4)));

    //OCARINA
    public static final RegistryObject<Item> T1OCARINA = ITEMS.register("t1ocarina",
            ()-> new OcarinaItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2OCARINA = ITEMS.register("t2ocarina",
            ()-> new OcarinaItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3OCARINA = ITEMS.register("t3ocarina",
            ()-> new OcarinaItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4OCARINA = ITEMS.register("t4ocarina",
            ()-> new OcarinaItem(new InstrumentProperties().tier(4)));

    //UKULELE
    public static final RegistryObject<Item> T1UKULELE = ITEMS.register("t1ukulele",
            ()-> new UkuleleItem(new InstrumentProperties().tier(1)));
    public static final RegistryObject<Item> T2UKULELE = ITEMS.register("t2ukulele",
            ()-> new UkuleleItem(new InstrumentProperties().tier(2)));
    public static final RegistryObject<Item> T3UKULELE = ITEMS.register("t3ukulele",
            ()-> new UkuleleItem(new InstrumentProperties().tier(3)));
    public static final RegistryObject<Item> T4UKULELE = ITEMS.register("t4ukulele",
            ()-> new UkuleleItem(new InstrumentProperties().tier(4)));


    //LYRA
    public static final RegistryObject<Item> LYRA = ITEMS.register("lyra",
            ()-> new LyraItem(new InstrumentProperties().tier(1)));


    /*public static final RegistryObject<Item> ORC_SPAWN_EGG = ITEMS.register("orc_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntityTypes.ORC,
                    0x37702d,0x702d2d,
                    new Item.Properties()));
    public static final RegistryObject<Item> DRUMMER_SPAWN_EGG = ITEMS.register("drummer_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntityTypes.DRUMMER,
                    0x37002d,0x002d2d,
                    new Item.Properties()));*/
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
