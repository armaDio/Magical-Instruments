package com.armadio.magicalinstrument;

import com.armadio.magicalinstrument.blocks.BossAltar;
import com.armadio.magicalinstrument.items.*;
import com.armadio.magicalinstrument.items.single.*;
import com.armadio.magicalinstrument.tileentities.TileEntityBossAltar;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by armaDio on 27/03/2015.
 */
public class ModItemsBlocks {

    //notes
    public static Item goldennote;
    public static Item nethernote;
    public static Item endernote;
    public static Item noteofthelegion;

    //t1 instruments
    public static Item t1flute;
    public static Item t1drum;
    public static Item t1bagpipe;
    public static Item t1horn;
    public static Item t1ukulele;
    public static Item t1oboe;
    public static Item t1ocarina;

    //t2 instruments
    public static Item t2flute;
    public static Item t2drum;
    public static Item t2bagpipe;
    public static Item t2horn;
    public static Item t2ukulele;
    public static Item t2oboe;
    public static Item t2ocarina;

    //t3 instruments
    public static Item t3flute;
    public static Item t3drum;
    public static Item t3bagpipe;
    public static Item t3horn;
    public static Item t3ukulele;
    public static Item t3oboe;
    public static Item t3ocarina;

    //legendary instruments
    public static Item orcishdrum;
    public static Item orcishoboe;
    public static Item orcishocarina;
    public static Item orcishhorn;
    public static Item orcishbagpipe;
    public static Item orcishflute;
    public static Item orcishukulele;

    //other instruments
    public static Item banjo;
    public static Item harp;
    public static Item trumpet;
    public static Item sdf;
    public static Item qwe;


    public static Block spawner;
    public static TileEntity spawner_ent;


    public static void initItems(){
        //t1 instruments
        t1flute = new Flute(1); GameRegistry.registerItem(t1flute,"t1flute");
        t1bagpipe= new Bagpipe(1); GameRegistry.registerItem(t1bagpipe,"t1bagpipe");
        t1drum= new Drum(1); GameRegistry.registerItem(t1drum,"t1drum");
        t1ocarina= new Ocarina(1); GameRegistry.registerItem(t1ocarina,"t1ocarina");
        t1ukulele= new Ukulele(1); GameRegistry.registerItem(t1ukulele,"t1ukulele");
        t1oboe= new Oboe(1); GameRegistry.registerItem(t1oboe,"t1oboe");
        t1horn= new Horn(1); GameRegistry.registerItem(t1horn,"t1horn");

        //t2 instruments
        t2flute = new Flute(2); GameRegistry.registerItem(t2flute,"t2flute");
        t2bagpipe= new Bagpipe(2); GameRegistry.registerItem(t2bagpipe,"t2bagpipe");
        t2drum= new Drum(2); GameRegistry.registerItem(t2drum,"t2drum");
        t2ocarina= new Ocarina(2); GameRegistry.registerItem(t2ocarina,"t2ocarina");
        t2ukulele= new Ukulele(2); GameRegistry.registerItem(t2ukulele,"t2ukulele");
        t2oboe= new Oboe(2); GameRegistry.registerItem(t2oboe,"t2oboe");
        t2horn= new Horn(2); GameRegistry.registerItem(t2horn,"t2horn");

        //t3 instruments
        t3flute = new Flute(3); GameRegistry.registerItem(t3flute,"t3flute");
        t3bagpipe= new Bagpipe(3); GameRegistry.registerItem(t3bagpipe,"t3bagpipe");
        t3drum= new Drum(3); GameRegistry.registerItem(t3drum,"t3drum");
        t3ocarina= new Ocarina(3); GameRegistry.registerItem(t3ocarina,"t3ocarina");
        t3ukulele= new Ukulele(3); GameRegistry.registerItem(t3ukulele,"t3ukulele");
        t3oboe= new Oboe(3); GameRegistry.registerItem(t3oboe,"t3oboe");
        t3horn= new Horn(3); GameRegistry.registerItem(t3horn,"t3horn");


        //notes
        goldennote = new Note(1); GameRegistry.registerItem(goldennote, "goldennote");
        nethernote = new Note(2); GameRegistry.registerItem(nethernote, "nethernote");
        endernote = new Note(3); GameRegistry.registerItem(endernote, "endernote");
        noteofthelegion = new Note(4); GameRegistry.registerItem(noteofthelegion, "noteofthelegion");

        //legendary instruments
        orcishdrum = new Drum(4); GameRegistry.registerItem(orcishdrum,"orcishdrum");
        orcishoboe = new Oboe(4); GameRegistry.registerItem(orcishoboe,"orcishoboe");
        orcishocarina = new Ocarina(4); GameRegistry.registerItem(orcishocarina, "zelda");
        orcishhorn = new Horn(4); GameRegistry.registerItem(orcishhorn, "orcishhorn");
        orcishbagpipe = new Bagpipe(4); GameRegistry.registerItem(orcishbagpipe, "orcishbagpipe");
        orcishukulele = new Ukulele(4); GameRegistry.registerItem(orcishukulele, "orcishukulele");
        orcishflute = new Flute(4); GameRegistry.registerItem(orcishflute, "orcishflute");

        //other instruments
        banjo = new Banjo(); GameRegistry.registerItem(banjo, "banjo");
        harp = new Harp(); GameRegistry.registerItem(harp, "harp");
        trumpet = new Trumpet(); GameRegistry.registerItem(trumpet,"trumpet");
        sdf = new SDF(); GameRegistry.registerItem(sdf,"sdf");
        qwe = new QWE(); GameRegistry.registerItem(qwe,"qwe");
    }
    public static void initBlocks() {
        spawner = new BossAltar();
        GameRegistry.registerBlock(spawner, "bossspawner");
        spawner_ent = new TileEntityBossAltar();
        GameRegistry.registerTileEntity(spawner_ent.getClass(), "bossspawner");

    }
    public static EnumRarity getRarityfromTier(int tier){
        EnumRarity rarity = EnumRarity.common;
        switch (tier){
            case 2:
                rarity = EnumRarity.uncommon;
                break;
            case 3:
                rarity = EnumRarity.rare;
                break;
            case 4:
                rarity = EnumRarity.epic;
                break;
        }
        return rarity;

    }

}
