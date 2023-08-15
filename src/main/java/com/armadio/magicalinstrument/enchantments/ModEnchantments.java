package com.armadio.magicalinstrument.enchantments;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.enchantments.enchants.AreaEnchantment;
import com.armadio.magicalinstrument.enchantments.enchants.BuffDurationEnchantment;
import com.armadio.magicalinstrument.enchantments.enchants.NoDurabilityEnchant;
import com.armadio.magicalinstrument.enchantments.enchants.TierEnchantment;
import com.armadio.magicalinstrument.item.instruments.AbstractInstrument;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MagicalInstrument.MODID);

    public static final EnchantmentCategory INSTRUMENTS = EnchantmentCategory.create("minst:instruments", (item) -> item instanceof AbstractInstrument || item instanceof EnchantedBookItem);

    public static RegistryObject<Enchantment> BUFFDURATION =
            ENCHANTMENTS.register("buff_duration",
                    () -> new BuffDurationEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static RegistryObject<Enchantment> TIERINCREASE =
            ENCHANTMENTS.register("tier_increase",
                    () -> new TierEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static RegistryObject<Enchantment> AREAINCREASE =
            ENCHANTMENTS.register("area_increase",
                    () -> new AreaEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static RegistryObject<Enchantment> NO_DURABILITY =
            ENCHANTMENTS.register("no_durability",
                    () -> new NoDurabilityEnchant(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
