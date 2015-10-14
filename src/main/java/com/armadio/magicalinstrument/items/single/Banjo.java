package com.armadio.magicalinstrument.items.single;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.ModItemsBlocks;
import com.armadio.magicalinstrument.lib.MinstConfiguration;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Michele on 10/11/2015.
 */
public class Banjo extends Item {
    private int tier;

    private static final int AREA = 7;
    private static final int DURABILITY = MinstConfiguration.t3durability;

    public Banjo(){
        super();
        this.setCreativeTab(MagicalInstrument.instTab);
        this.maxStackSize = 1;
        this.setUnlocalizedName("banjo");
        this.setTextureName(Reference.MOD_ID+":banjo");
        this.setMaxDamage(DURABILITY);

    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return ModItemsBlocks.getRarityfromTier(3);
    }

    @Override
    public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
    }

    @Override
    public IIcon getIconFromDamage(int p_77617_1_) {
        return super.getIconFromDamage(p_77617_1_);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer player) {
        ChunkCoordinates pos = player.getPlayerCoordinates();
        for(Object el : (world.getEntitiesWithinAABB(EntityAnimal.class, AxisAlignedBB.getBoundingBox(pos.posX - AREA, pos.posY - AREA, pos.posZ - AREA, pos.posX + AREA, pos.posY + AREA, pos.posZ + AREA)))) {
            ((EntityAnimal) el).addGrowth(100000);
        }

        p_77659_1_.damageItem(1,player);
        world.playSoundAtEntity(player, "minst:bagpipe", 1, 1);
        return super.onItemRightClick(p_77659_1_, world, player);
    }
}
