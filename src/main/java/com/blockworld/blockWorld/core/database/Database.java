package com.blockworld.blockWorld.core.database;


import com.blockworld.blockWorld.utils.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connection;
    private final DatabaseConfig config;

    public Database(DatabaseConfig config) {
        this.config = config;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void connect() {
        Logger.info("Connecting to database...");

        try {
            this.connection = DriverManager.getConnection(
                    this.config.url(),
                    this.config.user(),
                    this.config.pass()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        Logger.info("Disconnecting from database...");

        if (this.connection == null)
            throw new RuntimeException("Connection is already closed");

        try {
            this.connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
