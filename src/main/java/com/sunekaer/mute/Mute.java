package com.sunekaer.mute;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Mute.MODID)
public class Mute {
    public static final String MODID = "mute";

    public Mute() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "", (c, b) -> true));
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> PlaySoundEventHandler::setup);
    }
}