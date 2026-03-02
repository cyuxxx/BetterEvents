package com.cyux.betterevents.managers;

import com.cyux.betterevents.BetterEvents;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final BetterEvents plugin;
    private Connection connection;

    public DatabaseManager(BetterEvents plugin) {
        this.plugin = plugin;
    }

    public void connect() throws SQLException {
        if (connection != null && !connection.isClosed()) return;
        
        // Setup SQLite connection
        String url = "jdbc:sqlite:" + plugin.getDataFolder().getAbsolutePath() + "/data.db";
        connection = DriverManager.getConnection(url);
        
        // Initialize tables
        connection.createStatement().execute(
            "CREATE TABLE IF NOT EXISTS kits (name TEXT PRIMARY KEY, contents TEXT)"
        );
    }
}
