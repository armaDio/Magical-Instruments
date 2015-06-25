package com.armadio.magicalinstrument.lib;

import com.armadio.magicalinstrument.ModItemsBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by armaDio on 28/03/2015.
 */
public class ItemRecipes {
    public static void initShapedRecipes(){
        //t1 items

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                ModItemsBlocks.goldennote);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1horn), "CC ",
                "BB ",
                " BB",
                'C', ModItemsBlocks.goldennote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1drum), "SLS",
                "CWC",
                "CLC",
                'C', ModItemsBlocks.goldennote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', ModItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.goldennote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t1bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', ModItemsBlocks.goldennote,'S',Items.stick);


        //t2 items
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                ModItemsBlocks.nethernote);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2horn), "CC ",
                "BB ",
                " BB",
                'C', ModItemsBlocks.nethernote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2drum), "SLS",
                "CWC",
                "CLC",
                'C', ModItemsBlocks.nethernote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', ModItemsBlocks.nethernote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.nethernote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.nethernote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t2bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', ModItemsBlocks.nethernote,'S',Items.stick);


        //t3 items
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                ModItemsBlocks.endernote);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3horn), "CC ",
                "BB ",
                " BB",
                'C', ModItemsBlocks.endernote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3drum), "SLS",
                "CWC",
                "CLC",
                'C', ModItemsBlocks.endernote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', ModItemsBlocks.endernote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.endernote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.endernote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.t3bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', ModItemsBlocks.endernote,'S',Items.stick);

        //Legendary
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.orcishdrum), "SLS",
                "CWC",
                "CLC",
                'C', ModItemsBlocks.noteofthelegion, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.orcishocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', ModItemsBlocks.noteofthelegion);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.orcishhorn), "CC ",
                "BB ",
                " BB",
                'C', ModItemsBlocks.noteofthelegion, 'B',Items.bone);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.orcishoboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', ModItemsBlocks.noteofthelegion);


        //notes
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.nethernote), "BBB",
                "BNB",
                "BBB",
                'B', Items.blaze_rod, 'N', ModItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(ModItemsBlocks.endernote), " E ",
                "ENE",
                " E ",
                'E', Items.ender_eye, 'N', ModItemsBlocks.nethernote);
    }

    public static void initShapelessRecipes(){
        //aggiungi ricetta shapeless
        GameRegistry.addShapelessRecipe(new ItemStack(ModItemsBlocks.goldennote), new ItemStack(Blocks.noteblock),new ItemStack(Blocks.noteblock),new ItemStack(Blocks.obsidian), new ItemStack(Items.gold_ingot));
    }

    public static void initSmeltingRecipes(){
        //aggiungi ricetta fornace
        //GameRegistry.addSmelting(AddedItemsBlocks.goldennote,new ItemStack(Items.diamond,2),1);
    }
}
