package com.armadio.magicalinstrument.item.instruments;

import com.armadio.magicalinstrument.config.InstrumentConstants;
import com.armadio.magicalinstrument.config.MagicalInstrumentCommonConfig;
import com.armadio.magicalinstrument.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

public class UkuleleItem extends Item{
    private final int tier;
    private int bufflevel;
    public UkuleleItem(InstrumentProperties properties) {
        super(properties);
        tier = properties.tier;
        switch (tier) {
            case 1 -> {
                this.bufflevel = InstrumentConstants.T1LEVEL;
            }
            case 2 -> {
                this.bufflevel = InstrumentConstants.T2LEVEL;
            }
            case 3 -> {
                this.bufflevel = InstrumentConstants.T3LEVEL;
            }
            case 4 -> {
                this.bufflevel = InstrumentConstants.T4LEVEL;
            }
        }
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        int duration = 0;
        switch (tier) {
            case 1 -> duration = MagicalInstrumentCommonConfig.t1duration.get();
            case 2 -> duration = MagicalInstrumentCommonConfig.t2duration.get();
            case 3 -> duration = MagicalInstrumentCommonConfig.t3duration.get();
            case 4 -> duration = 24000;
        }
        if(!MagicalInstrumentCommonConfig.areaEffect.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, duration, bufflevel));
        } else {
            BlockPos pos = player.getOnPos();
            for(Player el : (level.getEntitiesOfClass(Player.class, AABB.of(new BoundingBox(pos.getX()-10,pos.getY()-2,pos.getZ()-10,pos.getX()+10,pos.getY()+2,pos.getZ()+10))))) {
                el.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, duration, bufflevel));
            }
        }
        ItemStack itemstack = player.getItemInHand(interactionHand);

        player.getItemInHand(interactionHand).hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(player.getUsedItemHand()));
        level.playSound(player, player.getOnPos(), ModSounds.UKULELE.get(), SoundSource.MASTER, 1, 1);


        player.getCooldowns().addCooldown(this,100);
        return super.use(level, player, interactionHand);
    }
}
