package com.blebdapleb.mrindia.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("mrindia.fly")) {
            Player player = (Player) sender;

            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                sender.sendMessage(ChatColor.GREEN + "You are in fly mode");

                return true;
            } else {

                player.setAllowFlight(false);
                sender.sendMessage(ChatColor.GREEN + "You are no longer in fly mode");

            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        return true;
    }
}
