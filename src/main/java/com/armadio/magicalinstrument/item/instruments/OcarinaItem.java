package com.armadio.magicalinstrument.item.instruments;

import com.armadio.magicalinstrument.config.MagicalInstrumentCommonConfig;
import com.armadio.magicalinstrument.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

public class OcarinaItem extends AbstractInstrument{
    public OcarinaItem(InstrumentProperties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        int duration = getDuration(itemstack, false);
        if(!MagicalInstrumentCommonConfig.areaEffect.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, bufflevel));
        } else {
            BlockPos pos = player.getOnPos();
            int radius = getAuraRadius(itemstack);
            for(Player el : (level.getEntitiesOfClass(Player.class, AABB.of(
                    new BoundingBox(
                            pos.getX()-radius,
                            pos.getY()-3,
                            pos.getZ()-radius,
                            pos.getX()+radius,
                            pos.getY()+3,
                            pos.getZ()+radius)
            )))) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, bufflevel));
            }
        }

        level.playSound(player, player.getOnPos(), ModSounds.OCARINA.get(), SoundSource.MASTER, 1, 1);


        player.getCooldowns().addCooldown(this,100);
        return super.use(level, player, interactionHand);
    }

}
