package com.armadio.magicalinstrument.entity.custom;

import com.armadio.magicalinstrument.item.ModItems;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.w3c.dom.Attr;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class OrcEntity extends Monster implements GeoEntity {
    double max_health = 300D;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    RawAnimation walkAnimation = RawAnimation.begin().thenLoop("animation.orc.walk");
    RawAnimation idleAnimation = RawAnimation.begin().thenLoop("animation.orc.idle");
    RawAnimation attackAnimation = RawAnimation.begin().thenPlay("animation.orc.attack");
    public OrcEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }



    public static AttributeSupplier setAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300D)
                .add(Attributes.FOLLOW_RANGE,64D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .add(Attributes.ATTACK_DAMAGE, 8D)
                .add(Attributes.ARMOR, 15D)
                //.add(Attributes.ARMOR_TOUGHNESS, 15D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .build();
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int i, boolean b) {
        super.dropCustomDeathLoot(damageSource, i, b);
        if(damageSource.is(DamageTypes.PLAYER_ATTACK) || damageSource.is(DamageTypes.ARROW)) {
            ItemStack itemstack = new ItemStack(ModItems.NOTE_LEGION.get(), 2);
            this.spawnAtLocation(itemstack);
        }
    }

    public void spawn(){
        double healthMultiplier = 1;
        int players = this.getPlayersAround().size();
        if(players >1){
            healthMultiplier += players * 0.25D;
        }
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.max_health * healthMultiplier);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public List<Player> getPlayersAround() {
        return this.level().getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(50), (player) -> player.isAlive() && !player.isSpectator());
    }

    @Override
    public void handleDamageEvent(DamageSource p_270229_) {
        if(!p_270229_.is(DamageTypes.FALLING_BLOCK)) {
            super.handleDamageEvent(p_270229_);
        }
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,8f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1,new HurtByTargetGoal(this,Player.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "attack-controller", 0, this::attackPredicate));
    }

    @Override
    public int getExperienceReward() {
        return Enemy.XP_REWARD_BOSS;
    }

    private PlayState predicate(AnimationState<GeoEntity> geoEntityAnimationState) {
        if(geoEntityAnimationState.isMoving() && !geoEntityAnimationState.isCurrentAnimation(walkAnimation)){
            geoEntityAnimationState.getController().setAnimationSpeed(2).setAnimation(walkAnimation);
            return PlayState.CONTINUE;
        }
        if(!geoEntityAnimationState.isCurrentAnimation(idleAnimation) && !geoEntityAnimationState.isMoving()) {
            geoEntityAnimationState.getController().setAnimationSpeed(2).setAnimation(idleAnimation);
        }
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState<GeoEntity> geoEntityAnimationState) {
        if(this.swinging && geoEntityAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            geoEntityAnimationState.getController().setAnimationSpeed(2).setAnimation(attackAnimation);
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}
