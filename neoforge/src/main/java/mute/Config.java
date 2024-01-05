package mute;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final String CATEGORY_GENERAL = "general";
    public static ModConfigSpec CONFIG;
    public static ModConfigSpec.ConfigValue<List<String>> muteList;

    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading configEvent) {
        update();
    }

    @SubscribeEvent
    public static void onFileChange(ModConfigEvent.Reloading configEvent) {
        update();
    }

    public static final Set<String> mute = new HashSet<>();
    private static void update() {
        mute.addAll(muteList.get());
    }

    static {
        ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
        BUILDER.comment("General settings").push(CATEGORY_GENERAL);

        List<String> defaultMuteList = new ArrayList<>();
        defaultMuteList.add("entity.wither.spawn");
        defaultMuteList.add("entity.wither.death");
        defaultMuteList.add("entity.ender_dragon.death");

        muteList = BUILDER.comment("List of PlaySound events to mute").define("muteList", defaultMuteList);

        BUILDER.pop();

        CONFIG = BUILDER.build();
    }
}
