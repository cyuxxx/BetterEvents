package com.cyux.betterevents.commands;

import com.cyux.betterevents.BetterEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventCommand implements CommandExecutor {

    private final BetterEvents plugin;

    public EventCommand(BetterEvents plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§cUsage: /event <join|start|stop>");
            return true;
        }

        if (args[0].equalsIgnoreCase("start")) {
            if (!player.hasPermission("betterevents.admin.create")) {
                player.sendMessage("§cNo permission.");
                return true;
            }
            plugin.getEventManager().startEvent();
            player.sendMessage("§aEvent started!");
        }

        return true;
    }
}
