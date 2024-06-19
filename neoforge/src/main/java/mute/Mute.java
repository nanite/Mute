package mute;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Mute.MODID)
public class Mute {
    public static final String MODID = "mute";

    public Mute() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);
        }

    }
}