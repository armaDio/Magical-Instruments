package com.armadio.magicalinstrument.entity;

import com.armadio.magicalinstrument.AddedItemsBlocks;
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
public class EntityOrc extends EntityMob implements IBossDisplayData {

    public EntityOrc(World par1World) {
        super(par1World);
        this.setSize(1.2F,2.4F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));


        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
        BossStatus.setBossStatus(this, false);
        return super.onSpawnWithEgg(p_110161_1_);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(270.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    }

    @Override
    public void onEntityUpdate() {
        BossStatus.setBossStatus(this,false);
        super.onEntityUpdate();
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    public float getAbsorptionAmount() {
        return 0.5F;
    }

    @Override
    public void onDeath(DamageSource p_70645_1_) {
        if(!worldObj.isRemote){
            dropItem(AddedItemsBlocks.noteofthelegion,1);
        }
        super.onDeath(p_70645_1_);
    }
}
