package com.armadio.magicalinstrument.items.single;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.ModItemsBlocks;
import com.armadio.magicalinstrument.lib.MinstConfiguration;
import com.armadio.magicalinstrument.lib.Reference;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

import java.util.Random;

/**
 * Created by Michele on 10/11/2015.
 */
public class Harp extends Item {
        private int tier;

        private static final int AREA = 7;
        private static final int DURABILITY = MinstConfiguration.t3durability;

        private Random r;

        public Harp(){
            super();
            this.setCreativeTab(MagicalInstrument.instTab);
            this.maxStackSize = 1;
            this.setUnlocalizedName("harp");
            this.setTextureName(Reference.MOD_ID+":harp");
            this.setMaxDamage(DURABILITY);
            r=new Random();
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
            for(int x = -AREA; x<=AREA;x++){
                for(int y = -2;y<=2;y++){
                    for(int z = -AREA; z<=AREA; z++){
                        applyBonemeal(world, pos.posX+x,pos.posY+ y,pos.posZ+ z, player);
                        applyBonemeal(world, pos.posX+x,pos.posY+ y,pos.posZ+ z, player);
                        applyBonemeal(world, pos.posX+x,pos.posY+ y,pos.posZ+ z, player);
                        applyBonemeal(world, pos.posX+x,pos.posY+ y,pos.posZ+ z, player);
                    }
                }

            }

            p_77659_1_.damageItem(1,player);
            world.playSoundAtEntity(player, "minst:bagpipe", 1, 1);
            return super.onItemRightClick(p_77659_1_, world, player);
        }

    //Copied from ItemDye class
    public static boolean applyBonemeal(World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
    {
        Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

        BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Event.Result.ALLOW)
        {
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote))
            {
                if (!p_150919_1_.isRemote)
                {
                    if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_))
                    {
                        igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
                    }
                }

                return true;
            }
        }

        return false;
    }
}
