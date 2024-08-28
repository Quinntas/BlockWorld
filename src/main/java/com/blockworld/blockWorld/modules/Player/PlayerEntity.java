package com.blockworld.blockWorld.modules.Player;


import com.blockworld.blockWorld.modules.Stats.Stats;

public class PlayerEntity {
    private final org.bukkit.entity.Player bukkitPlayer;
    private Stats stats;

    public PlayerEntity(org.bukkit.entity.Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.stats = Stats.createDefault();
    }

    public org.bukkit.entity.Player getBukkitPlayer() {
        return bukkitPlayer;
    }
}
