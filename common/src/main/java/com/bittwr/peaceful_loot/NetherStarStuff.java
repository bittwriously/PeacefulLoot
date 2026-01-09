package com.bittwr.peaceful_loot;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public final class NetherStarStuff {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(PeacefulLoot.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(PeacefulLoot.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<Item> NS_CLUMP = registerItem("nether_star_clump", Rarity.UNCOMMON);
    public static final RegistrySupplier<Item> NS_FRAGMENT = registerItem("nether_star_fragment", Rarity.UNCOMMON);
    public static final RegistrySupplier<Item> NS_SHARD = registerItem("nether_star_shard", Rarity.RARE);
    public static final RegistrySupplier<Item> NS_DEAD = registerItem("nether_star_dead", Rarity.EPIC);

    private static RegistrySupplier<Item> registerItem(String name, Rarity rarity) {
        return ITEMS.register(name, () -> {
            Identifier id = Identifier.fromNamespaceAndPath(PeacefulLoot.MOD_ID, name);
            ResourceKey<@NotNull Item> key = ResourceKey.create(Registries.ITEM, id);

            return new Item(new Item.Properties()
                    .setId(key)
                    .fireResistant()
                    .rarity(rarity));
        });
    }
    public static final RegistrySupplier<CreativeModeTab> MY_TAB = TABS.register(
            "peaceful_loot_tab",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0) // Basic vanilla builder
                    .title(Component.translatable("itemGroup.peaceful_loot.peaceful_loot_tab"))
                    .icon(() -> new ItemStack(NS_DEAD.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(NS_CLUMP.get());
                        output.accept(NS_FRAGMENT.get());
                        output.accept(NS_SHARD.get());
                        output.accept(NS_DEAD.get());
                    })
                    .build()
    );

    public static void init() {
        ITEMS.register();
        TABS.register();
    }
}