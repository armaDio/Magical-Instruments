package com.armadio.magicalinstrument.enchantments.enchants;

import com.armadio.magicalinstrument.enchantments.InstrumentEnchants;
import com.armadio.magicalinstrument.enchantments.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class NoDurabilityEnchant extends Enchantment implements InstrumentEnchants{
    public NoDurabilityEnchant(Enchantment.Rarity p_44676_, EquipmentSlot... p_44678_) {
        super(p_44676_, ModEnchantments.INSTRUMENTS, p_44678_);
    }

    public int getMinCost(int p_45092_) {
        return 15 + (p_45092_ - 1) * 9;
    }

    public int getMaxCost(int p_45096_) {
        return super.getMinCost(p_45096_) + 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    protected boolean checkCompatibility(Enchantment p_44690_) {
        return p_44690_ instanceof InstrumentEnchants;
    }

    @Override
    public boolean canEnchant(ItemStack p_44689_) {
        return super.canEnchant(p_44689_);
    }

}
