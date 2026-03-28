package mute;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<List<? extends String>> MUTE_LIST = BUILDER
            .comment("List of PlaySound events to mute")
            .defineListAllowEmpty("muteList",
                    List.of("entity.wither.spawn", "entity.wither.death", "entity.ender_dragon.death"),
                    () -> "", o -> o instanceof String);

    static final ModConfigSpec SPEC = BUILDER.build();
}
