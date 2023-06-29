package com.armadio.magicalinstrument.entity.custom;

import com.armadio.magicalinstrument.entity.custom.AI.BuffGoal;
import com.armadio.magicalinstrument.item.ModItems;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class DrummerEntity extends Monster implements GeoEntity {

    double max_health = 500D;
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    RawAnimation walkAnimation = RawAnimation.begin().thenLoop("animation.drummer.walk");
    RawAnimation idleAnimation = RawAnimation.begin().thenLoop("animation.drummer.idle");
    RawAnimation buffAnimation = RawAnimation.begin().thenPlay("animation.drummer.buff");
    public static int MAX_COOLDOWN = 30;
    public boolean isBuffing = false;
    public int cooldown;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public DrummerEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        cooldown = MAX_COOLDOWN;
    }

    public static AttributeSupplier setAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 500D)
                .add(Attributes.FOLLOW_RANGE,32D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .add(Attributes.ARMOR, 15D)
                //.add(Attributes.ARMOR_TOUGHNESS, 15D)
                .add(Attributes.ATTACK_DAMAGE, 4D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .build();
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int i, boolean b) {
        super.dropCustomDeathLoot(damageSource, i, b);
        if(damageSource.is(DamageTypes.PLAYER_ATTACK) || damageSource.is(DamageTypes.ARROW)) {
            ItemStack itemstack = new ItemStack(ModItems.NOTE_LEGION.get(), 1);
            this.spawnAtLocation(itemstack);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
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
    protected void updateControlFlags() {
        super.updateControlFlags();
        if(cooldown>0)
            cooldown--;
    }

    @Override
    public int getExperienceReward() {
        return Enemy.XP_REWARD_BOSS;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BuffGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,8f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "buff-controller", 0, this::buffPredicate));
    }

    private  PlayState buffPredicate(AnimationState<GeoEntity> geoEntityAnimationState) {
        if(isBuffing && geoEntityAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            geoEntityAnimationState.getController().setAnimationSpeed(1.5).setAnimation(buffAnimation);
            this.isBuffing = false;
        }
        return PlayState.CONTINUE;
    }

    private PlayState predicate(AnimationState<GeoEntity> geoEntityAnimationState) {
        if(geoEntityAnimationState.isMoving() && !geoEntityAnimationState.isCurrentAnimation(walkAnimation)){
            geoEntityAnimationState.getController().setAnimationSpeed(2).setAnimation(walkAnimation);
            return PlayState.CONTINUE;
        }
        if(!geoEntityAnimationState.isMoving() && !geoEntityAnimationState.isCurrentAnimation(idleAnimation)) {
            geoEntityAnimationState.getController().setAnimationSpeed(2).setAnimation(idleAnimation);
        }
        return PlayState.CONTINUE;
    }

    public void spawn(){
        double healthMultiplier = 1;
        int players = this.getPlayersAround().size();
        if(players >1){
            healthMultiplier += players * 0.25D;
        }
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.max_health * healthMultiplier);
    }

    public List<Player> getPlayersAround() {
        return this.level().getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(50), (player) -> player.isAlive() && !player.isSpectator());
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


}
