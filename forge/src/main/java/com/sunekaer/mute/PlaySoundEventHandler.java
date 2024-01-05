package com.sunekaer.mute;

import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.sunekaer.mute.Config.mute;

public class PlaySoundEventHandler {
    public static void setup() {
        MinecraftForge.EVENT_BUS.register(new PlaySoundEventHandler());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = false)
    public void onEvent(PlaySoundEvent event) {
        if (mute.contains(event.getName())) {
            event.setSound(null);
        }
    }
}
