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

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1flute), new Object[]{
                "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.goldennote
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1horn), new Object[]{
                "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.goldennote, 'B',Items.bone
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1drum), new Object[]{
                "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.goldennote, 'S',Items.stick,'W',Blocks.log ,'L', Items.leather
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1oboe), new Object[]{
                "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.goldennote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1ocarina), new Object[]{
                "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.goldennote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1ukulele), new Object[]{
                "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.goldennote,'S',Items.stick
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t1bagpipe), new Object[]{
                " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.goldennote,'S',Items.stick
        });


        //t2 items
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2flute), new Object[]{
                "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.nethernote
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2horn), new Object[]{
                "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.nethernote, 'B',Items.bone
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2drum), new Object[]{
                "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.nethernote, 'S',Items.stick,'W',Blocks.log ,'L', Items.leather
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2oboe), new Object[]{
                "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.nethernote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2ocarina), new Object[]{
                "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.nethernote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2ukulele), new Object[]{
                "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.nethernote,'S',Items.stick
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t2bagpipe), new Object[]{
                " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.nethernote,'S',Items.stick
        });


        //t3 items
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3flute), new Object[]{
                "  C",
                " S ",
                "C  ",
                'S', Items.stick, 'C',/* per usare metadata new ItemStack(Items.dye,1,0)*/
                AddedItemsBlocks.endernote
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3horn), new Object[]{
                "CC ",
                "BB ",
                " BB",
                'C', AddedItemsBlocks.endernote, 'B',Items.bone
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3drum), new Object[]{
                "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.endernote, 'S',Items.stick,'W',Blocks.log ,'L', Items.leather
        });

        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3oboe), new Object[]{
                "  C",
                " I ",
                "C  ",
                'I', Items.iron_ingot, 'C', AddedItemsBlocks.endernote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3ocarina), new Object[]{
                "WW ",
                "WCC",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.endernote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3ukulele), new Object[]{
                "WW ",
                "CCS",
                "WW ",
                'W', Blocks.planks, 'C', AddedItemsBlocks.endernote,'S',Items.stick
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.t3bagpipe), new Object[]{
                " S ",
                "SLC",
                "CL ",
                'L', Items.leather, 'C', AddedItemsBlocks.endernote,'S',Items.stick
        });

        //Legendary
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.orcishdrum), new Object[]{
                "SLS",
                "CWC",
                "CLC",
                'C', AddedItemsBlocks.noteofthelegion, 'S',Items.stick,'W',Blocks.log ,'L', Items.leather
        });


        //notes
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.nethernote), new Object[]{
                "BBB",
                "BNB",
                "BBB",
                'B', Items.blaze_rod, 'N', AddedItemsBlocks.goldennote
        });
        GameRegistry.addRecipe(new ItemStack(AddedItemsBlocks.endernote), new Object[]{
                " E ",
                "ENE",
                " E ",
                'E', Items.ender_eye, 'N', AddedItemsBlocks.nethernote
        });
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
