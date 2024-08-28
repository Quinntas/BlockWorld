package com.blockworld.blockWorld.core.config;


import com.blockworld.blockWorld.core.database.DatabaseConfig;
import com.blockworld.blockWorld.utils.Logger;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;

public class Config {
    DatabaseConfig databaseConfig;

    public DatabaseConfig getDatabaseConfig() {
        return this.databaseConfig;
    }

    public Config(String filePath) {
        Logger.info("Loading config.json...");

        File f = new File(filePath);

        if (!f.exists())
            throw new RuntimeException("config.json does not exit at " + filePath);

        JsonObject config;

        try {
            JsonReader reader = new JsonReader(new java.io.FileReader(f));
            config = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Logger.info("Parsing database config...");

        JsonObject database = config.get("database").getAsJsonObject();
        String url = database.get("url").getAsString();
        String user = database.get("user").getAsString();
        String pass = database.get("password").getAsString();

        this.databaseConfig = new DatabaseConfig(url, user, pass);
    }
}
