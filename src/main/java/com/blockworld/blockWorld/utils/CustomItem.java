package com.blockworld.blockWorld.utils;


import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class CustomItem {
    private final NamespacedKey key;
    private final ItemStack item;

    public NamespacedKey getKey() {
        return key;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getDisplayName() {
        return Objects.requireNonNull(item.getItemMeta()).getDisplayName();
    }

    public CustomItem(Material material, String displayName, String key) {
        this.key = new NamespacedKey("blockworld", key);

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) throw new NullPointerException("ItemMeta is null");

        meta.setDisplayName(displayName);
        PersistentDataContainer container = meta.getPersistentDataContainer();

        container.set(
                this.key,
                PersistentDataType.STRING,
                "true"
        );

        item.setItemMeta(meta);

        this.item = item;
    }
}