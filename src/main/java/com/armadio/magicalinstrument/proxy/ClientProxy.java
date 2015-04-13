package com.armadio.magicalinstrument.proxy;

import com.armadio.magicalinstrument.AddedItemsBlocks;
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
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1flute,new ItemRendererFlute(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1drum,new ItemRendererDrum(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1ukulele,new ItemRendererUkulele(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1oboe,new ItemRendererOboe(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1ocarina,new ItemRendererOcarina(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1horn,new ItemRendererHorn(1));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t1bagpipe,new ItemRendererBagpipe(1));

        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2flute,new ItemRendererFlute(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2drum,new ItemRendererDrum(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2ukulele,new ItemRendererUkulele(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2oboe,new ItemRendererOboe(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2ocarina,new ItemRendererOcarina(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2horn,new ItemRendererHorn(2));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t2bagpipe,new ItemRendererBagpipe(2));

        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3flute,new ItemRendererFlute(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3drum,new ItemRendererDrum(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3ukulele,new ItemRendererUkulele(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3oboe,new ItemRendererOboe(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3ocarina,new ItemRendererOcarina(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3horn,new ItemRendererHorn(3));
        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.t3bagpipe,new ItemRendererBagpipe(3));


        MinecraftForgeClient.registerItemRenderer(AddedItemsBlocks.orcishdrum,new ItemRendererOrcishDrum());


        RenderingRegistry.registerEntityRenderingHandler(EntityDrummer.class, new RenderDrummerBoss(new ModelDrummerMob(),0));

        RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RendererOrcBoss(new ModelOrcMob(),0));

        BlockRendererAltar render = new BlockRendererAltar();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBossAltar.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AddedItemsBlocks.spawner), new InventoryRenderBossAltar(render, new TileEntityBossAltar()));
    }
}
