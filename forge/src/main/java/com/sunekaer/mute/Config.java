package com.sunekaer.mute;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final String CATEGORY_GENERAL = "general";
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.ConfigValue<List<String>> muteList;

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
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
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
