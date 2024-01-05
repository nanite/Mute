package mute;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.sound.PlaySoundEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PlaySoundEventHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = false)
    public static void onPlaySoundEvent(PlaySoundEvent event) {
        if (Config.mute.contains(event.getName())) {
            event.setSound(null);
        }
    }
}
