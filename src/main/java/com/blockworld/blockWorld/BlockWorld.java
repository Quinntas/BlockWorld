package com.blockworld.blockWorld;

import com.blockworld.blockWorld.core.config.Config;
import com.blockworld.blockWorld.core.database.Database;
import com.blockworld.blockWorld.modules.Player.events.OnPlayerJoin;
import com.blockworld.blockWorld.modules.Stats.StatsGUI;
import com.blockworld.blockWorld.utils.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockWorld extends JavaPlugin {
    Config config;
    Database database;

    private void Init() {
        database.connect();
    }

    @Override
    public void onEnable() {
        Logger.prefix = "[BlockWorld]";

        Logger.info("Stating client");

        config = new Config(getDataFolder().getAbsolutePath() + "/config.json");
        database = new Database(config.getDatabaseConfig());

        Init();

        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new StatsGUI(), this);
    }

    @Override
    public void onDisable() {
        Logger.info("Stopping client");

        database.disconnect();
    }
}
