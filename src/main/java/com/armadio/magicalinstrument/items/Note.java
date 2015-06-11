package com.armadio.magicalinstrument.items;

import com.armadio.magicalinstrument.AddedItemsBlocks;
import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by armaDio on 27/03/2015.
 */
public class Note extends Item {

    int tier;

    public Note(int tier){
        super();
        this.setCreativeTab(MagicalInstrument.instTab);
        this.tier = tier;
        switch(tier){
            case 1:
                this.setUnlocalizedName("goldennote");
                break;
            case 2:
                this.setUnlocalizedName("nethernote");
                break;
            case 3:
                this.setUnlocalizedName("endernote");
                break;
            case 4:
                this.setUnlocalizedName("noteofthelegion");
                break;
        }
        this.setTextureName(Reference.MOD_ID+":"+getUnlocalizedName().substring(5));
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return AddedItemsBlocks.getRarityfromTier(tier);
    }

}
