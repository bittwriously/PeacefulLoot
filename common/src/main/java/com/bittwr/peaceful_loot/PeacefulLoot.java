package com.bittwr.peaceful_loot;

import dev.architectury.event.events.common.LootEvent;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

// we inject loot into the table so
// if another mod adds something
// we don't override it by accident
public final class PeacefulLoot {
    public static final String MOD_ID = "peaceful_loot";

    private static final ResourceLocation FORTRESS_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/nether_bridge"); // rich

    private static final ResourceLocation BASTION_BRIDGE_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_bridge"); // noob
    private static final ResourceLocation BASTION_OTHER_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_other"); // pro
    private static final ResourceLocation BASTION_STABLE_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_hoglin_stable"); // hacker
    private static final ResourceLocation BASTION_TREASURE_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_treasure"); // god

    private static final ResourceLocation STRONGHOLD_CORRIDOR = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/stronghold_corridor");

    private static final ResourceLocation TREASURE_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/buried_treasure");

    private static final ResourceLocation END_CHEST = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/end_city_treasure");

    public static void init() {
        NetherStarStuff.init();
        LootEvent.MODIFY_LOOT_TABLE.register((lootTableId, tableBuilder, source) -> {
            // add a new loot pool to the existing table
            final ResourceLocation LootTableId = lootTableId.location();
            LootPool.Builder pool = LootPool.lootPool();
            if (FORTRESS_CHEST.equals(LootTableId)) {
                pool.setRolls(UniformGenerator.between(1.0f, 3.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD).setWeight(2))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(10))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(15))
                        .add(LootItem.lootTableItem(Items.WITHER_SKELETON_SKULL).setWeight(5));

            } else if (BASTION_BRIDGE_CHEST.equals(LootTableId)) {
                pool.setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(15))
                        .add(EmptyLootItem.emptyItem().setWeight(30));

            } else if (BASTION_OTHER_CHEST.equals(LootTableId)) {
                pool.setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(7))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(8));

            } else if (BASTION_STABLE_CHEST.equals(LootTableId)) {
                pool.setRolls(UniformGenerator.between(1.0f, 2.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD).setWeight(2))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(9))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(5));

            } else if (BASTION_TREASURE_CHEST.equals(LootTableId)) {
                pool.setRolls(UniformGenerator.between(1.0f, 3.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD).setWeight(3))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(18))
                        .add(LootItem.lootTableItem(Items.GHAST_TEAR).setWeight(2));

            } else if (STRONGHOLD_CORRIDOR.equals(LootTableId)) {
                pool.setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.BLAZE_ROD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BLAZE_POWDER).setWeight(7));

            } else if (TREASURE_CHEST.equals(LootTableId)) {
                pool.setRolls(UniformGenerator.between(1.0f, 4.0f))
                        .add(LootItem.lootTableItem(Items.NAUTILUS_SHELL).setWeight(10))
                        .add(LootItem.lootTableItem(Items.PRISMARINE).setWeight(8));

            } else if (END_CHEST.equals(LootTableId)) {
                pool.setRolls(UniformGenerator.between(2.0f, 4.0f))
                        .add(LootItem.lootTableItem(Items.SHULKER_SHELL).setWeight(10))
                        .add(EmptyLootItem.emptyItem().setWeight(5));

            } else { return; } // so we don't add an empty pool
            tableBuilder.addPool(pool);
        });
    }
}
