package io.github.lucianowayand.eyesoficeandfire.registry;

import com.iafenvoy.iceandfire.registry.IafDragonTypes;
import io.github.lucianowayand.eyesoficeandfire.EnderEyes;
import io.github.lucianowayand.eyesoficeandfire.EyesOfIceAndFire;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModRegistries {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(EyesOfIceAndFire.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EyesOfIceAndFire.MOD_ID);

    public static final DeferredItem<Item> EYE_OF_FIRE_DRAGON = ITEMS.register(
            "eye_of_fire_dragon",
            () -> new EnderEyes(new Item.Properties().stacksTo(16), IafDragonTypes.FIRE)
    );

    public static final DeferredItem<Item> EYE_OF_ICE_DRAGON = ITEMS.register(
            "eye_of_ice_dragon",
            () -> new EnderEyes(new Item.Properties().stacksTo(16), IafDragonTypes.ICE)
    );

    public static final DeferredItem<Item> EYE_OF_LIGHTNING_DRAGON = ITEMS.register(
            "eye_of_lightning_dragon",
            () -> new EnderEyes(new Item.Properties().stacksTo(16), IafDragonTypes.LIGHTNING)
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_TABS.register(
            "eyesoficeandfire_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.eyesoficeandfire_tab"))
                    .icon(() -> EYE_OF_FIRE_DRAGON.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(EYE_OF_FIRE_DRAGON.get());
                        output.accept(EYE_OF_ICE_DRAGON.get());
                        output.accept(EYE_OF_LIGHTNING_DRAGON.get());
                    })
                    .build()
    );

    private ModRegistries() {}

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
        CREATIVE_TABS.register(modBus);
    }
}
