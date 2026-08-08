package io.github.lucianowayand.eyesoficeandfire;

import com.mojang.logging.LogUtils;
import io.github.lucianowayand.eyesoficeandfire.registry.ModRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(EyesOfIceAndFire.MOD_ID)
public final class EyesOfIceAndFire {
    public static final String MOD_ID = "eyesoficeandfire";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EyesOfIceAndFire(IEventBus modEventBus, ModContainer modContainer) {
        ModRegistries.register(modEventBus);
        LOGGER.info("Eyes of Ice and Fire CE (1.21.1 NeoForge) loaded");
    }
}
