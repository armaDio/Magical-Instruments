package com.armadio.magicalinstrument.item.instruments;


import com.armadio.magicalinstrument.config.InstrumentConstants;
import com.armadio.magicalinstrument.enchantments.InstrumentEnchants;
import com.armadio.magicalinstrument.enchantments.ModEnchantments;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public abstract class AbstractInstrument extends Item {
    protected final int tier;
    protected int bufflevel;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if(getEnchantmentLevel(itemStack, ModEnchantments.NO_DURABILITY.get()) == 0){
            itemStack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return super.use(level, player, interactionHand);
    }

    public AbstractInstrument(InstrumentProperties properties) {
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

    protected int getDuration(ItemStack itemStack, Boolean isBuffSingleTier){
        int duration = 0;
        switch (tier) {
            case 1 -> duration = isBuffSingleTier?InstrumentConstants.t1duration_single:InstrumentConstants.t1duration;
            case 2 -> duration = isBuffSingleTier?InstrumentConstants.t2duration_single:InstrumentConstants.t2duration;
            case 3 -> duration = isBuffSingleTier?InstrumentConstants.t3duration_single:InstrumentConstants.t3duration;
            case 4 -> duration = isBuffSingleTier?InstrumentConstants.t4duration_single:InstrumentConstants.t4duration;
        }
        if(this.getEnchantmentLevel(itemStack, ModEnchantments.BUFFDURATION.get()) > 0){
            duration = (int) (duration * 1.5);
        }
        return duration;
    }

    public int getBufflevel(ItemStack itemStack) {
        return bufflevel + getEnchantmentLevel(itemStack, ModEnchantments.TIERINCREASE.get()) > 0? 1:0;
    }

    public int getAuraRadius(ItemStack itemStack) {
        return 5 + 5 * getEnchantmentLevel(itemStack, ModEnchantments.AREAINCREASE.get());
    }
    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 22;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment instanceof InstrumentEnchants;
    }
}
