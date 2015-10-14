package com.armadio.magicalinstrument.items.single;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.ModItemsBlocks;
import com.armadio.magicalinstrument.lib.MinstConfiguration;
import com.armadio.magicalinstrument.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Michele on 10/13/2015.
 */
public class Trumpet extends Item {
    private int tier;

    private static final int AREA = 7;
    private static final int DURABILITY = MinstConfiguration.t3durability;
    private static final int explosionRadius = 3;

    public Trumpet(){
        super();
        this.setCreativeTab(MagicalInstrument.instTab);
        this.maxStackSize = 1;
        this.setUnlocalizedName("trumpet");
        this.setTextureName(Reference.MOD_ID+":trumpet");
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
        for(Object el : (world.getEntitiesWithinAABB(EntityCreeper.class, AxisAlignedBB.getBoundingBox(pos.posX - AREA, pos.posY - AREA, pos.posZ - AREA, pos.posX + AREA, pos.posY + AREA, pos.posZ + AREA)))) {
            explode((EntityCreeper) el, world);
            ((EntityCreeper) el).setCreeperState(1);
        }

        p_77659_1_.damageItem(1,player);
        world.playSoundAtEntity(player, "minst:trumpet", 1, 1);
        return super.onItemRightClick(p_77659_1_, world, player);
    }

    private static void explode(EntityCreeper el, World world){
            if (!world.isRemote)
            {
                boolean flag = world.getGameRules().getGameRuleBooleanValue("mobGriefing");
                if (el.getPowered())
                {
                    world.createExplosion(el, el.posX, el.posY, el.posZ, explosionRadius*2 +1, flag);
                }
                else
                {
                    world.createExplosion(el, el.posX, el.posY, el.posZ, explosionRadius, flag);
                }
                el.setDead();
            }
    }
}
