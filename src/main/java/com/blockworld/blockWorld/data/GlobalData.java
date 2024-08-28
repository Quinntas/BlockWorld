package com.blockworld.blockWorld.data;

import com.blockworld.blockWorld.modules.Player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;

public class GlobalData {
    static Map<String, PlayerEntity> players = new HashMap<>();

    public static PlayerEntity getPlayer(String id) {
        return players.get(id);
    }

    public static void addPlayer(PlayerEntity player) {
        players.put(player.getBukkitPlayer().getUniqueId().toString(), player);
    }
}