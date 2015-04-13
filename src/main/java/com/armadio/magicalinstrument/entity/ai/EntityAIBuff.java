package com.armadio.magicalinstrument.entity.ai;

import com.armadio.magicalinstrument.entity.EntityOrc;
import com.armadio.magicalinstrument.entity.EntityDrummer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by armaDio on 08/04/2015.
 */
public class EntityAIBuff extends EntityAIBase {

    private EntityDrummer buffer;
    World theWorld;
    private EntityOrc mate;
    /** The speed the creature moves at during mating behavior. */
    double moveSpeed;


    public EntityAIBuff(EntityDrummer p_i1619_1_, double p_i1619_2_)
    {
        this.buffer = p_i1619_1_;
        this.theWorld = p_i1619_1_.worldObj;
        this.moveSpeed = p_i1619_2_;
        this.setMutexBits(3);
    }

    public void resetTask()
    {
        this.mate = null;
    }

    public void updateTask()
    {
        this.buffer.getLookHelper().setLookPositionWithEntity(this.mate, 10.0F, (float) this.buffer.getVerticalFaceSpeed());
        this.buffer.getNavigator().tryMoveToEntityLiving(this.mate, this.moveSpeed);

        if (this.buffer.getDistanceSqToEntity(this.mate) < 9.0D)
        {
            this.applyBuff();
        }
    }

    @Override
    public boolean shouldExecute() {
        this.mate = this.getNearbyAlly();
        return this.mate != null;
    }

    private EntityOrc getNearbyAlly()
    {
        List list = this.theWorld.getEntitiesWithinAABB(EntityOrc.class, this.buffer.boundingBox.expand(20, 5, 20));
        double d0 = Double.MAX_VALUE;
        EntityOrc entityanimal = null;
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            EntityOrc entityanimal1 = (EntityOrc)iterator.next();

            if (!entityanimal1.isPotionActive(Potion.damageBoost.id) && this.buffer.getDistanceSqToEntity(entityanimal1) < d0)
            {
                entityanimal = entityanimal1;
                d0 = this.buffer.getDistanceSqToEntity(entityanimal1);
            }
        }

        return entityanimal;
    }

    private void applyBuff(){
        this.buffer.isBuffing = true;
        Random random = this.buffer.getRNG();
        this.buffer.cooldown = (int)(random.nextGaussian()*EntityDrummer.MAX_COOLDOWN);

        double d0 = random.nextGaussian() * 0.02D;
        double d1 = random.nextGaussian() * 0.02D;
        double d2 = random.nextGaussian() * 0.02D;
        this.theWorld.spawnParticle("note", this.buffer.posX + (double)(random.nextFloat() * this.buffer.width * 2.0F) - (double)this.buffer.width, this.buffer.posY + 0.5D + (double)(random.nextFloat() * this.buffer.height), this.buffer.posZ + (double)(random.nextFloat() * this.buffer.width * 2.0F) - (double)this.buffer.width, d0, d1, d2);

        mate.addPotionEffect(new PotionEffect(Potion.damageBoost.id,600,9));
        mate.addPotionEffect(new PotionEffect(Potion.resistance.id,600,9));
        mate.addPotionEffect(new PotionEffect(Potion.fireResistance.id,600,9));
        mate.addPotionEffect(new PotionEffect(Potion.jump.id,600,1));
        mate.addPotionEffect(new PotionEffect(Potion.regeneration.id,600,1));

        resetTask();
    }
}
