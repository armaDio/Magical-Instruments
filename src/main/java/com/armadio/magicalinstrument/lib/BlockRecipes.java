package com.armadio.magicalinstrument.lib;

import com.armadio.magicalinstrument.ModItemsBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by armaDio on 28/03/2015.
 */
public class BlockRecipes {
    public static void initShapedRecipes(){
        GameRegistry.addShapedRecipe(new ItemStack(ModItemsBlocks.spawner),new Object[]{"OOO","INI","OOO",'O', Blocks.obsidian,'I',Blocks.iron_block,'N', ModItemsBlocks.endernote});
    }
}
