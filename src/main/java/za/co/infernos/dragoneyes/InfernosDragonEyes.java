package za.co.infernos.dragoneyes;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import za.co.infernos.dragoneyes.registry.ModRegistries;

@Mod(InfernosDragonEyes.MOD_ID)
public final class InfernosDragonEyes {
    public static final String MOD_ID = "infernos_dragon_eyes";
    public static final Logger LOGGER = LogUtils.getLogger();

    public InfernosDragonEyes(IEventBus modEventBus, ModContainer modContainer) {
        ModRegistries.register(modEventBus);
        LOGGER.info("Infernos Dragon Eyes loaded");
    }
}
