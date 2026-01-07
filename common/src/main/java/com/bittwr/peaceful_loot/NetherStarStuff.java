package com.bittwr.peaceful_loot;


import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

// nether star items are initialized here
public final class NetherStarStuff {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(PeacefulLoot.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(PeacefulLoot.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<Item> NS_CLUMP = ITEMS.register("nether_star_clump", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistrySupplier<Item> NS_FRAGMENT = ITEMS.register("nether_star_fragment", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistrySupplier<Item> NS_SHARD = ITEMS.register("nether_star_shard", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final RegistrySupplier<Item> NS_DEAD = ITEMS.register("nether_star_dead", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistrySupplier<CreativeModeTab> MY_TAB = TABS.register(
            "peaceful_loot_tab",
            () -> CreativeTabRegistry.create(builder -> builder
                    .title(Component.translatable("itemGroup.peaceful_loot.peaceful_loot_tab"))
                    .icon(() -> new ItemStack(NS_DEAD.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(NS_CLUMP.get());
                        output.accept(NS_FRAGMENT.get());
                        output.accept(NS_SHARD.get());
                        output.accept(NS_DEAD.get());
                    })
            )
    );

    public static void init() {
        ITEMS.register();
        TABS.register();
    }
}
