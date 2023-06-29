package com.armadio.magicalinstrument.entity.custom.AI;

import com.armadio.magicalinstrument.entity.custom.DrummerEntity;
import com.armadio.magicalinstrument.entity.custom.OrcEntity;
import com.armadio.magicalinstrument.sounds.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class BuffGoal extends Goal {
    private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forCombat().range(30D).ignoreLineOfSight();

    private OrcEntity mate;
    protected final Level level;
    private final DrummerEntity mob;
    private final double speedModifier;
    public BuffGoal(DrummerEntity drummer, double speedModifier) {
        this.mob = drummer;
        this.level = mob.level();
        this.speedModifier = speedModifier;
    }

    @Override
    public boolean canUse() {
        this.mate = this.getFreePartner();
        return this.mate != null && this.mob.cooldown == 0;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }



    private OrcEntity getFreePartner() {
        List<OrcEntity> list = this.level.getNearbyEntities(OrcEntity.class, PARTNER_TARGETING, this.mob, this.mob.getBoundingBox().inflate(30D));
        OrcEntity orc = null;
        double d0 = Double.MAX_VALUE;

        for(OrcEntity next : list) {


            if (!next.hasEffect(MobEffects.DAMAGE_BOOST) && this.mob.distanceToSqr(next) < d0 && this.mob.cooldown == 0){
                orc = next;
                d0 = this.mob.distanceToSqr(orc);
            }
        }

        return orc;
    }

    public void tick() {
        if(this.mate!=null) {
            this.mob.getLookControl().setLookAt(this.mate, 10.0F, (float) this.mob.getMaxHeadXRot());
            this.mob.getNavigation().moveTo(this.mate, this.speedModifier);

            if (this.mob.distanceToSqr(this.mate) < 9.0D) {
                this.applyBuff();
            }
        }
    }


    private void applyBuff(){
        this.mob.isBuffing = true;
        RandomSource random = this.mob.getRandom();

        double d0 = random.nextGaussian() * 0.02D;
        double d1 = random.nextGaussian() * 0.02D;
        double d2 = random.nextGaussian() * 0.02D;
        this.level.addParticle(ParticleTypes.NOTE, this.mob.position().x() + (double)(random.nextFloat() * this.mob.getBbWidth() * 2.0F) - (double)this.mob.getBbWidth(), this.mob.position().y() + 0.5D + (double)(random.nextFloat() * this.mob.getBbHeight()), this.mob.position().z() + (double)(random.nextFloat() * this.mob.getBbWidth() * 2.0F) - (double)this.mob.getBbWidth(), d0, d1, d2);

        mate.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,600,9));
        mate.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,600,9));
        mate.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,600,9));
        mate.addEffect(new MobEffectInstance(MobEffects.JUMP,600,1));
        mate.addEffect(new MobEffectInstance(MobEffects.REGENERATION,600,3));

        level.playSound(null, mob.getOnPos(), ModSounds.T4DRUM.get(), SoundSource.HOSTILE, 1f, 1f);

        resetTask();
    }

    public void resetTask()
    {
        this.mate = null;
    }
}
