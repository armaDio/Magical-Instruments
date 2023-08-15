package com.armadio.magicalinstrument.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MagicalInstrumentCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> areaEffect;

    static {
        BUILDER.push("Magical Instruments Configuration");
        BUILDER.push("MISC");

        areaEffect = BUILDER
                .comment("Activates the potion effects in an area around the player or just to him")
                        .define("Area Effect", true);

        SPEC = BUILDER.build();
    }
}
