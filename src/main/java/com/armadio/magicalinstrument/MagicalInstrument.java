package com.armadio.magicalinstrument;

import com.armadio.magicalinstrument.entity.ModEntities;
import com.armadio.magicalinstrument.lib.BlockRecipes;
import com.armadio.magicalinstrument.lib.ItemRecipes;
import com.armadio.magicalinstrument.lib.MinstConfiguration;
import com.armadio.magicalinstrument.lib.Reference;
import com.armadio.magicalinstrument.proxy.ClientProxy;
import com.armadio.magicalinstrument.proxy.CommonProxy;
import com.armadio.magicalinstrument.proxy.ServerProxy;
import com.armadio.magicalinstrument.tabs.InstrumentTab;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

/**
 * Created by armaDio on 27/03/2015.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MagicalInstrument{

    //registra le classi che si occupano dei proxy
    @SidedProxy(clientSide = Reference.CLIENTSIDE_PROXY ,serverSide = Reference.SERVERSIDE_PROXY)
    public static CommonProxy proxy;
    public static ClientProxy cproxy;
    public static ServerProxy sproxy;


    //creo creative tabs
    public static CreativeTabs instTab = new InstrumentTab(CreativeTabs.getNextID(), "instTab");

    //configuration file
    public static Configuration config;

    @Mod.Instance(Reference.MOD_ID)
    public static MagicalInstrument instance;

    public static Logger log = FMLLog.getLogger();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        config = new Configuration(event.getSuggestedConfigurationFile());
        MinstConfiguration.syncConfig();


        AddedItemsBlocks.initBlocks();
        AddedItemsBlocks.initItems();
        ModEntities.initEntities();
        BlockRecipes.initShapedRecipes();
        ItemRecipes.initShapedRecipes();
        ItemRecipes.initShapelessRecipes();
        ItemRecipes.initSmeltingRecipes();
        log.info("Magical Instrument is pre initializating");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //registra blocchi, etc
        proxy.registerRenders();
        log.info("Magical Instrument is initializating");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        log.info("Magical Instrument has been loaded");
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID==Reference.MOD_ID) {
            MinstConfiguration.syncConfig();
        }
    }

}
