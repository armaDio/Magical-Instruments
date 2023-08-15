package com.armadio.magicalinstrument.item.instruments;

import com.armadio.magicalinstrument.config.MagicalInstrumentCommonConfig;
import com.armadio.magicalinstrument.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

public class LyraItem extends AbstractInstrument {
    public LyraItem(InstrumentProperties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        BlockPos pos = player.getOnPos();
        int radius = getAuraRadius(itemstack)*2;

        for (BlockPos targetPos :
                BlockPos.betweenClosed(
                        pos.getX()-radius,
                        pos.getY()-3,
                        pos.getZ()-radius,
                        pos.getX()+radius,
                        pos.getY()+3,
                        pos.getZ()+radius
                )
        ) {
            BlockState targetBlockState = level.getBlockState(targetPos);
            for(AgeableMob el : (level.getEntitiesOfClass(AgeableMob.class, AABB.of(
                    new BoundingBox(
                            pos.getX()-radius,
                            pos.getY()-3,
                            pos.getZ()-radius,
                            pos.getX()+radius,
                            pos.getY()+3,
                            pos.getZ()+radius)
            )))) {
                el.setAge(0);
            }
        }
        player.getCooldowns().addCooldown(this,100);
        return super.use(level, player, interactionHand);
    }

}
