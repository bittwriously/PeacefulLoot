package com.bittwr.peaceful_loot.fabric;

import net.fabricmc.api.ModInitializer;

import com.bittwr.peaceful_loot.fabriclike.PeacefulLootFabricLike;

public final class PeacefulLootFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run the Fabric-like setup.
        PeacefulLootFabricLike.init();
    }
}
