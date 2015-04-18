package com.armadio.magicalinstrument.entity;

import com.armadio.magicalinstrument.AddedItemsBlocks;
import com.armadio.magicalinstrument.entity.ai.EntityAIBuff;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by armaDio on 04/04/2015.
 */
public class EntityDrummer extends EntityMob implements IBossDisplayData {

    public static int MAX_COOLDOWN = 200;
    public boolean isBuffing = false;
    public int cooldown = 100;

    public EntityDrummer(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIBuff(this,1.5));
        this.tasks.addTask(3, new EntityAIPanic(this,1.5));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));


    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        if(worldObj.isRemote)
            BossStatus.setBossStatus(this, false);
        return super.onSpawnWithEgg(p_110161_1_);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }

    @Override
    public void onEntityUpdate() {
        if(worldObj.isRemote)
            BossStatus.setBossStatus(this,false);
        if(cooldown>0)
            cooldown--;
        super.onEntityUpdate();
    }

    @Override
    public void onDeath(DamageSource p_70645_1_) {
        if(!worldObj.isRemote){
            dropItem(AddedItemsBlocks.noteofthelegion,1);
        }
        super.onDeath(p_70645_1_);
    }

    public boolean isAIEnabled()
    {
        return true;
    }
}
