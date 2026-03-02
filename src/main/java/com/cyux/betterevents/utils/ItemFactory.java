package com.cyux.betterevents.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemFactory {

    // Hidden lore to identify event items
    public static final String EVENT_UUID_TAG = "§0§a§b[EventItemUUID]";

    public static ItemStack createEventItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            List<String> lore = new ArrayList<>();
            lore.add(EVENT_UUID_TAG);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }
}
