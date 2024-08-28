package com.blockworld.blockWorld.data;

import com.blockworld.blockWorld.entities.Player;

import java.util.Map;

public class GlobalData {
    static Map<String, Player> players;

    public static Player getPlayer(String id) {
        return players.get(id);
    }

    public static void addPlayer(Player player) {
        players.put(player.getBukkitPlayer().getUniqueId().toString(), player);
    }
}
