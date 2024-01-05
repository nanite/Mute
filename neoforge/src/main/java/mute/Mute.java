package mute;

import com.machinezoo.noexception.throwing.ThrowingRunnable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Mute.MODID)
public class Mute {
    public static final String MODID = "mute";

    public Mute() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "", (c, b) -> true));

    }
}