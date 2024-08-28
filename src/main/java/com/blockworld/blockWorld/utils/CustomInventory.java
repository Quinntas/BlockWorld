package com.blockworld.blockWorld.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomInventory {
    private final Inventory inv;

    public CustomInventory(String title, int size) {
        if (size > 54)
            throw new IllegalArgumentException("Inventory size cannot be greater than 54");
        this.inv = Bukkit.createInventory(null, size, title);
    }

    public void setItem(int slot, ItemStack item) {
        inv.setItem(slot, item);
    }

    public Inventory getInv() {
        return inv;
    }
}