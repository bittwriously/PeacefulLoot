package com.bittwr.peaceful_loot.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.bittwr.peaceful_loot.fabriclike.PeacefulLootFabricLike;

public final class PeacefulLootQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        // Run the Fabric-like setup.
        PeacefulLootFabricLike.init();
    }
}
