package com.blockworld.blockWorld.modules.Player.events;

import com.blockworld.blockWorld.data.GlobalData;
import com.blockworld.blockWorld.modules.Player.PlayerEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        PlayerEntity player = new PlayerEntity(event.getPlayer());
        GlobalData.addPlayer(player);
    }
}
