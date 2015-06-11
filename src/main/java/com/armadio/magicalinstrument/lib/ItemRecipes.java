package com.armadio.magicalinstrument.lib;

import com.armadio.magicalinstrument.AddedItemsBlocks;
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

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.goldennote);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1horn), "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.goldennote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1drum), "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.goldennote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.goldennote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.goldennote,'S',Items.stick);


        //t2 items
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.nethernote);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2horn), "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.nethernote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2drum), "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.nethernote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.nethernote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.nethernote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.nethernote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.nethernote,'S',Items.stick);


        //t3 items
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3flute), "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.endernote);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3horn), "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.endernote, 'B',Items.bone);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3drum), "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.endernote, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3oboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.endernote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3ocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.endernote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3ukulele), "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.endernote,'S',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3bagpipe), " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.endernote,'S',Items.stick);

        //Legendary
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.orcishdrum), "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.noteofthelegion, 'S',Items.stick,'W',Blocks.log,'L', Items.leather);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.orcishocarina), "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.noteofthelegion);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.orcishhorn), "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.noteofthelegion, 'B',Items.bone);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.orcishoboe), "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.noteofthelegion);


        //notes
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.nethernote), "BBB",
                "BNB",
                "BBB",
                'B', Items.blaze_rod, 'N', AddedItemsBlocks.goldennote);
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.endernote), " E ",
                "ENE",
                " E ",
                'E', Items.ender_eye, 'N', AddedItemsBlocks.nethernote);
    }

    public static void initShapelessRecipes(){
        //aggiungi ricetta shapeless
        GameRegistry.addShapelessRecipe(new ItemStack(AddedItemsBlocks.goldennote), new ItemStack(Blocks.noteblock),new ItemStack(Blocks.noteblock),new ItemStack(Blocks.obsidian), new ItemStack(Items.gold_ingot));
    }

    public static void initSmeltingRecipes(){
        //aggiungi ricetta fornace
        //GameRegistry.addSmelting(AddedItemsBlocks.goldennote,new ItemStack(Items.diamond,2),1);
    }
}
