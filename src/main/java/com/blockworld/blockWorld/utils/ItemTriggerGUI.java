package com.blockworld.blockWorld.utils;

import com.blockworld.blockWorld.data.GlobalData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public abstract class ItemTriggerGUI extends GUI {
    private CustomItem itemTrigger;

    protected ItemTriggerGUI() {
        super();
    }

    public void setItemTrigger(CustomItem itemTrigger) {
        this.itemTrigger = itemTrigger;
    }

    protected abstract void handleItemClick(ItemStack item);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase(this.itemTrigger.getDisplayName()))
            return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null)
            return;

        if (event.getCurrentItem().getType() == Material.AIR)
            return;

        if (!event.getCurrentItem().hasItemMeta())
            return;

        this.handleItemClick(event.getCurrentItem());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().addItem(this.itemTrigger.getItem());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action a = event.getAction();
        ItemStack is = event.getItem();

        if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR)
            return;

        if (is.getItemMeta() == null)
            return;

        if (is.getItemMeta().getDisplayName().equals(itemTrigger.getDisplayName()))
            openGUI(GlobalData.getPlayer(event.getPlayer().getUniqueId().toString()));
    }
}
