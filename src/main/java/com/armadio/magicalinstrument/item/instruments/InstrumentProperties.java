package com.armadio.magicalinstrument.item.instruments;

import com.armadio.magicalinstrument.config.InstrumentConstants;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class InstrumentProperties extends Item.Properties {
    int tier;
    MobEffect effect;

    public InstrumentProperties() {
        super();
    }

    public InstrumentProperties food(FoodProperties p_41490_) {
        super.food(p_41490_);
        return this;
    }

    public InstrumentProperties stacksTo(int p_41488_) {
        super.stacksTo(p_41488_);
        return this;
    }

    public InstrumentProperties defaultDurability(int p_41500_) {
        super.defaultDurability(p_41500_);
        return this;
    }

    public InstrumentProperties durability(int p_41504_) {
        super.durability(p_41504_);
        return this;
    }

    public InstrumentProperties craftRemainder(Item p_41496_) {
        super.craftRemainder(p_41496_);
        return this;
    }

    public InstrumentProperties rarity(Rarity p_41498_) {
        super.rarity(p_41498_);
        return this;
    }

    public InstrumentProperties fireResistant() {
        super.fireResistant();
        return this;
    }

    public InstrumentProperties setNoRepair() {
        super.setNoRepair();
        return this;
    }

    public InstrumentProperties requiredFeatures(FeatureFlag... p_250948_) {
        super.requiredFeatures(p_250948_);
        return this;
    }

    public InstrumentProperties mobEffect(MobEffect effect) {
        this.effect = effect;
        return this;
    }

    public InstrumentProperties tier(int tier) {
        this.tier = tier;
        switch (tier) {
            case 1 -> {
                this.durability( 6);
                this.rarity(Rarity.COMMON);
            }
            case 2 -> {
                this.durability(12);
                this.rarity(Rarity.UNCOMMON);
            }
            case 3 -> {
                this.durability(18);
                this.rarity(Rarity.RARE);
            }
            case 4 -> {
                this.durability(32);
                this.rarity(Rarity.EPIC);
            }
        }
        return this;
    }

}
