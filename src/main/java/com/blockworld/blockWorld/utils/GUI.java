package com.blockworld.blockWorld.utils;


import com.blockworld.blockWorld.modules.Player.PlayerEntity;
import org.bukkit.event.Listener;

public class GUI implements Listener {
    private String title;
    private CustomInventory inv;

    public GUI() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInv(CustomInventory inv) {
        this.inv = inv;
    }

    public String getTitle() {
        return title;
    }

    public CustomInventory getInv() {
        return inv;
    }

    protected void openGUI(PlayerEntity player) {
        player.getBukkitPlayer().openInventory(inv.getInv());
    }
}