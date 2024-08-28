package com.blockworld.blockWorld.events;

import com.blockworld.blockWorld.data.GlobalData;
import com.blockworld.blockWorld.entities.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = new Player(event.getPlayer());
        GlobalData.addPlayer(player);
    }
}
