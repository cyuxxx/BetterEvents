package com.cyux.betterevents;

import org.bukkit.plugin.java.JavaPlugin;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.cyux.betterevents.managers.EventManager;

public class BetterEvents extends JavaPlugin {

    private static BetterEvents instance;
    private ProtocolManager protocolManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {
        instance = this;
        
        if (getServer().getPluginManager().getPlugin("ProtocolLib") == null) {
            getLogger().severe("ProtocolLib not found! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        
        protocolManager = ProtocolLibrary.getProtocolManager();
        this.eventManager = new EventManager(this);
        
        getLogger().info("BetterEvents enabled successfully!");
    }

    public static BetterEvents getInstance() {
        return instance;
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }
    
    public EventManager getEventManager() {
        return eventManager;
    }
}
