package com.blockworld.blockWorld.entities;

import com.blockworld.blockWorld.game.Stats;

public class Player {
    private final org.bukkit.entity.Player bukkitPlayer;
    private Stats stats;

    public Player(org.bukkit.entity.Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.stats = Stats.createDefault();
    }

    public org.bukkit.entity.Player getBukkitPlayer() {
        return bukkitPlayer;
    }
}
