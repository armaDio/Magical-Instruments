package com.armadio.magicalinstrument.tabs;

import com.armadio.magicalinstrument.ModItemsBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by armaDio on 28/03/2015.
 */
public class InstrumentTab extends CreativeTabs {
    public InstrumentTab(int nextID, String instTab) {
        super(nextID,instTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem(){
        return ModItemsBlocks.goldennote;
    }
}
