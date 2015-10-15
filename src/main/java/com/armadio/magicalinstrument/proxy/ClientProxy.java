package com.armadio.magicalinstrument.proxy;

import com.armadio.magicalinstrument.ModItemsBlocks;
import com.armadio.magicalinstrument.client.models.ModelDrummerMob;
import com.armadio.magicalinstrument.client.models.ModelOrcMob;
import com.armadio.magicalinstrument.client.renders.*;
import com.armadio.magicalinstrument.entity.EntityOrc;
import com.armadio.magicalinstrument.entity.EntityDrummer;
import com.armadio.magicalinstrument.tileentities.TileEntityBossAltar;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Michele on 20/10/2014.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1flute,new ItemRendererFlute(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1drum,new ItemRendererDrum(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1ukulele,new ItemRendererUkulele(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1oboe,new ItemRendererOboe(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1ocarina,new ItemRendererOcarina(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1horn,new ItemRendererHorn(1));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t1bagpipe,new ItemRendererBagpipe(1));

        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2flute,new ItemRendererFlute(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2drum,new ItemRendererDrum(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2ukulele,new ItemRendererUkulele(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2oboe,new ItemRendererOboe(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2ocarina,new ItemRendererOcarina(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2horn,new ItemRendererHorn(2));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t2bagpipe,new ItemRendererBagpipe(2));

        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3flute,new ItemRendererFlute(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3drum,new ItemRendererDrum(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3ukulele,new ItemRendererUkulele(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3oboe,new ItemRendererOboe(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3ocarina,new ItemRendererOcarina(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3horn,new ItemRendererHorn(3));
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.t3bagpipe,new ItemRendererBagpipe(3));


        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishdrum,new ItemRendererOrcishDrum());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishoboe,new ItemRendererOrcishOboe());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishocarina,new ItemRendererOrcishOcarina());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishhorn,new ItemRendererOrcishHorn());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishbagpipe,new ItemRendererOrcishBagpipe());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishukulele, new ItemRendererOrcishUkulele());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.orcishflute, new ItemRendererOrcishFlute());


        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.trumpet, new ItemRendererTrumpet());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.harp, new ItemRendererHarp());
        MinecraftForgeClient.registerItemRenderer(ModItemsBlocks.banjo, new ItemRendererBanjo());


        RenderingRegistry.registerEntityRenderingHandler(EntityDrummer.class, new RenderDrummerBoss(new ModelDrummerMob(),0));

        RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RendererOrcBoss(new ModelOrcMob(),0));

        BlockRendererAltar render = new BlockRendererAltar();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBossAltar.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModItemsBlocks.spawner), new InventoryRenderBossAltar(render, new TileEntityBossAltar()));
    }
}
