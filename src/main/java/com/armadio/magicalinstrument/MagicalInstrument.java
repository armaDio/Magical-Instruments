package com.armadio.magicalinstrument;

import com.armadio.magicalinstrument.block.ModBlocks;
import com.armadio.magicalinstrument.block.entity.ModBlockEntities;
import com.armadio.magicalinstrument.config.MagicalInstrumentCommonConfig;
import com.armadio.magicalinstrument.entity.ModEntityTypes;
import com.armadio.magicalinstrument.entity.client.DrummerRenderer;
import com.armadio.magicalinstrument.entity.client.OrcRenderer;
import com.armadio.magicalinstrument.item.ModItems;
import com.armadio.magicalinstrument.sounds.ModSounds;
import com.armadio.magicalinstrument.tabs.MagicalInstrumentsCreativeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MagicalInstrument.MODID)
public class MagicalInstrument {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "minst";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MagicalInstrument() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MagicalInstrumentsCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntityTypes.register(modEventBus);
        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreatve);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MagicalInstrumentCommonConfig.SPEC, "magicalinstruments.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public void addCreatve(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == MagicalInstrumentsCreativeTabs.MINST_TAB.get()) {
            event.accept(ModItems.GOLDEN_NOTE);
            event.accept(ModItems.NETHER_NOTE);
            event.accept(ModItems.ENDER_NOTE);
            event.accept(ModItems.NOTE_LEGION);
            event.accept(ModItems.T1DRUM);
            event.accept(ModItems.T2DRUM);
            event.accept(ModItems.T3DRUM);
            event.accept(ModItems.T4DRUM);
            event.accept(ModItems.T1BAGPIPE);
            event.accept(ModItems.T2BAGPIPE);
            event.accept(ModItems.T3BAGPIPE);
            event.accept(ModItems.T4BAGPIPE);
            event.accept(ModItems.T1FLUTE);
            event.accept(ModItems.T2FLUTE);
            event.accept(ModItems.T3FLUTE);
            event.accept(ModItems.T4FLUTE);
            event.accept(ModItems.T1HORN);
            event.accept(ModItems.T2HORN);
            event.accept(ModItems.T3HORN);
            event.accept(ModItems.T4HORN);
            event.accept(ModItems.T1OBOE);
            event.accept(ModItems.T2OBOE);
            event.accept(ModItems.T3OBOE);
            event.accept(ModItems.T4OBOE);
            event.accept(ModItems.T1OCARINA);
            event.accept(ModItems.T2OCARINA);
            event.accept(ModItems.T3OCARINA);
            event.accept(ModItems.T4OCARINA);
            event.accept(ModItems.T1UKULELE);
            event.accept(ModItems.T2UKULELE);
            event.accept(ModItems.T3UKULELE);
            event.accept(ModItems.T4UKULELE);
            /*event.accept(ModItems.ORC_SPAWN_EGG);
            event.accept(ModItems.DRUMMER_SPAWN_EGG);*/
            event.accept(ModBlocks.ALTAR);
        }
    }

    @Mod.EventBusSubscriber(modid = MagicalInstrument.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.ORC.get(), OrcRenderer::new);
            EntityRenderers.register(ModEntityTypes.DRUMMER.get(), DrummerRenderer::new);
        }
    }

}
