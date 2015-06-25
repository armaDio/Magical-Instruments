package com.armadio.magicalinstrument.items;

import com.armadio.magicalinstrument.ModItemsBlocks;
import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.lib.MinstConfiguration;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

/**
 * Created by armaDio on 27/03/2015.
 */
public class Drum extends Item {
    private int tier;

    private static final int T1DURATION = MinstConfiguration.t1duration * 20;
    private static final int T2DURATION = MinstConfiguration.t2duration * 20;
    private static final int T3DURATION = MinstConfiguration.t3duration * 20;
    private static final int T4DURATION = 24000;
    private static final int T1DURABILITY = MinstConfiguration.t1durability;
    private static final int T2DURABILITY = MinstConfiguration.t2durability;
    private static final int T3DURABILITY = MinstConfiguration.t3durability;
    private static final int T1LEVEL = 0;
    private static final int T2LEVEL = 1;
    private static final int T3LEVEL = 2;
    private static final int T4LEVEL = 4;

    public Drum(int tier){
        super();
        this.tier = tier;
        this.setCreativeTab(MagicalInstrument.instTab);
        this.maxStackSize = 1;

        switch (tier){
            case 1:
                this.setUnlocalizedName("t1drum");
                this.setTextureName(Reference.MOD_ID+":/drum/drum1");
                this.setMaxDamage(T1DURABILITY);
                break;
            case 2:
                this.setUnlocalizedName("t2drum");
                this.setTextureName(Reference.MOD_ID+":/drum/drum2");
                this.setMaxDamage(T2DURABILITY);
                break;
            case 3:
                this.setUnlocalizedName("t3drum");
                this.setTextureName(Reference.MOD_ID+":/drum/drum3");
                this.setMaxDamage(T3DURABILITY);
                break;
            case 4:
                this.setUnlocalizedName("orcishdrum");
                this.setTextureName(Reference.MOD_ID + ":/drum/drum4");
                this.setMaxDamage(32);
                break;
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return ModItemsBlocks.getRarityfromTier(tier);
    }

    @Override
    public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        super.onUpdate(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
    }


    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer player) {
        if(!MinstConfiguration.areaEffect) {
            switch(tier){
                case 1:
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,T1DURATION,T1LEVEL));
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,T1DURATION,T1LEVEL));
                    break;
                case 2:
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,T2DURATION,T2LEVEL));
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,T2DURATION,T2LEVEL));
                    break;
                case 3:
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,T3DURATION,T3LEVEL));
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,T3DURATION,T3LEVEL));
                    break;
                case 4:
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,T4DURATION,T4LEVEL));
                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,T4DURATION,T4LEVEL));
                    break;
            }
        }else{ChunkCoordinates pos = player.getPlayerCoordinates();
            for(Object el : (world.getEntitiesWithinAABB(EntityPlayer.class,AxisAlignedBB.getBoundingBox(pos.posX-10,pos.posY-2,pos.posZ-10,pos.posX+10,pos.posY+2,pos.posZ+10)))) {
                switch(tier){
                    case 1:
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.digSpeed.id, T1DURATION,T1LEVEL));
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, T1DURATION,T1LEVEL));
                        break;
                    case 2:
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.digSpeed.id, T2DURATION,T2LEVEL));
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, T2DURATION,T2LEVEL));
                        break;
                    case 3:
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.digSpeed.id, T3DURATION,T3LEVEL));
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, T3DURATION,T3LEVEL));
                        break;
                    case 4:
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.digSpeed.id, T4DURATION,T4LEVEL));
                        ((EntityPlayer) el).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, T4DURATION,T4LEVEL));
                        break;
                }
            }
        }
        p_77659_1_.damageItem(1, player);
        if(tier<4) {
            world.playSoundAtEntity(player, "minst:drum", 1, 1);
        }
        else{
            world.playSoundAtEntity(player, "minst:drummer", 1, 1);
        }
        return super.onItemRightClick(p_77659_1_, world, player);
    }
}
