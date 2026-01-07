package com.bittwr.peaceful_loot.neoforge;

import net.neoforged.fml.common.Mod;

import com.bittwr.peaceful_loot.PeacefulLoot;

@Mod(PeacefulLoot.MOD_ID)
public final class PeacefulLootNeoForge {
    public PeacefulLootNeoForge() {
        // Run our common setup.
        PeacefulLoot.init();
    }
}
