package za.co.infernos.dragoneyes.registry;

import com.iafenvoy.iceandfire.registry.IafDragonTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import za.co.infernos.dragoneyes.DragonEyeItem;
import za.co.infernos.dragoneyes.InfernosDragonEyes;

public final class ModRegistries {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(InfernosDragonEyes.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InfernosDragonEyes.MOD_ID);

    public static final DeferredItem<Item> EYE_OF_FIRE_DRAGON = ITEMS.register(
            "eye_of_fire_dragon",
            () -> new DragonEyeItem(new Item.Properties().stacksTo(16), IafDragonTypes.FIRE)
    );

    public static final DeferredItem<Item> EYE_OF_ICE_DRAGON = ITEMS.register(
            "eye_of_ice_dragon",
            () -> new DragonEyeItem(new Item.Properties().stacksTo(16), IafDragonTypes.ICE)
    );

    public static final DeferredItem<Item> EYE_OF_LIGHTNING_DRAGON = ITEMS.register(
            "eye_of_lightning_dragon",
            () -> new DragonEyeItem(new Item.Properties().stacksTo(16), IafDragonTypes.LIGHTNING)
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_TABS.register(
            "main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.infernos_dragon_eyes"))
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
