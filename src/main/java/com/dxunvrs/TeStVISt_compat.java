package com.dxunvrs;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(TeStVISt_compat.MODID)
public class TeStVISt_compat {
    public static final String MODID = "testvist_compat";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TeStVISt_compat(IEventBus modEventBus, ModContainer modContainer) {
    }
}
