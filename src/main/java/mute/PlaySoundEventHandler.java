package mute;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.sound.PlaySoundEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class PlaySoundEventHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = false)
    public static void onPlaySoundEvent(PlaySoundEvent event) {
        if (Config.MUTE_LIST.get().contains(event.getName())) {
            event.setSound(null);
        }
    }
}
