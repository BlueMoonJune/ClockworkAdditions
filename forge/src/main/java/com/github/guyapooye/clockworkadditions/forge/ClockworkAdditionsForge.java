package com.github.guyapooye.clockworkadditions.forge;

import com.github.guyapooye.clockworkadditions.ClockworkAdditions;
import com.github.guyapooye.clockworkadditions.forge.registries.BlockEntityRegistryImpl;
import com.github.guyapooye.clockworkadditions.forge.registries.BlockRegistryImpl;
import com.github.guyapooye.clockworkadditions.forge.registries.ConfigRegistryImpl;
import com.github.guyapooye.clockworkadditions.forge.registries.EntityRegistryImpl;
import com.github.guyapooye.clockworkadditions.registries.BlockRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.github.guyapooye.clockworkadditions.ClockworkAdditions.*;

@Mod(MOD_ID)
public class ClockworkAdditionsForge {
    private void initializeCreativeModeTab() {
        CWACreativeModeTab = new CreativeModeTab(MOD_ID) {
            @Override
            public ItemStack makeIcon() {
                return BlockRegistry.KINETIC_FLAP_BEARING.asStack();
            }
        };
    }
    public ClockworkAdditionsForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);

        ClockworkAdditions.init();

        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        ConfigRegistryImpl.register(modLoadingContext);

        initializeCreativeModeTab();
        EntityRegistryImpl.register();
        BlockRegistryImpl.register();
        BlockEntityRegistryImpl.register();
    }
}