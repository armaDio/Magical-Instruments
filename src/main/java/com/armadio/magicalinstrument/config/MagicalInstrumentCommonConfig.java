package com.armadio.magicalinstrument.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MagicalInstrumentCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> areaEffect;
    public static ForgeConfigSpec.ConfigValue<Integer> t1duration;
    public static ForgeConfigSpec.ConfigValue<Integer> t2duration;

    public static ForgeConfigSpec.ConfigValue<Integer> t3duration;
    /*public static ForgeConfigSpec.ConfigValue<Integer> t1durability;
    public static ForgeConfigSpec.ConfigValue<Integer> t2durability;
    public static ForgeConfigSpec.ConfigValue<Integer> t3durability;
*/

    static {
        BUILDER.push("Magical Instruments Configuration");
        BUILDER.push("MISC");

        areaEffect = BUILDER
                .comment("Activates the potion effects in an area around the player or just to him")
                        .define("Area Effect", true);
        BUILDER.push("INSTRUMENTS_SETTINGS");
        t1duration = BUILDER.comment("Duration of the effect for T1 Instruments in ticks (20 in one second)")
                        .define("Tier 1 duration", 1200);
        t2duration = BUILDER.comment("Duration of the effect for T2 Instruments in ticks (20 in one second)")
                .define("Tier 2 duration", 3000);
        t3duration = BUILDER.comment("Duration of the effect for T3 Instruments in ticks (20 in one second)")
                .define("Tier 3 duration", 6000);
        /*t1durability = BUILDER.comment("Duration of the effect for T3 Instruments in ticks (20 in one second)")
                .define("Tier 1 uses", 4);
        t2durability = BUILDER.comment("Duration of the effect for T3 Instruments in ticks (20 in one second)")
                .define("Tier 2 uses", 6);
        t3durability = BUILDER.comment("Duration of the effect for T3 Instruments in ticks (20 in one second)")
                .define("Tier 3 uses", 8);
*/
        BUILDER.push("INSTRUMENTS_SETTINGS");

        SPEC = BUILDER.build();
    }
}
