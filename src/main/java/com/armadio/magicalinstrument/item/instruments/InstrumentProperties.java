package com.armadio.magicalinstrument.item.instruments;

import com.armadio.magicalinstrument.config.InstrumentConstants;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class InstrumentProperties extends Item.Properties {
    int tier;
    public InstrumentProperties tier(int tier) {
        this.tier = tier;
        switch (tier) {
            case 1 -> {
                this.durability( 4);
                this.rarity(Rarity.COMMON);
            }
            case 2 -> {
                this.durability(8);
                this.rarity(Rarity.UNCOMMON);
            }
            case 3 -> {
                this.durability(12);
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
