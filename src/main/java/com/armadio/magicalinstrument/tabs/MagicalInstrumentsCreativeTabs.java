package com.armadio.magicalinstrument.tabs;

import com.armadio.magicalinstrument.MagicalInstrument;
import com.armadio.magicalinstrument.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MagicalInstrumentsCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MagicalInstrument.MODID);

    public static RegistryObject<CreativeModeTab> MINST_TAB = CREATIVE_MODE_TABS.register("inst_tab",
            ()-> CreativeModeTab.builder()
                    .icon(()->new ItemStack(ModItems.GOLDEN_NOTE.get()))
                    .title(Component.translatable("creative_tab.minst.inst_tab"))
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
