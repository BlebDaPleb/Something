package com.blebdapleb.mrindia.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!sender.hasPermission("mrindia.feed")){
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        } else {
            if (args.length != 0) {
                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);
                if (Bukkit.getPlayer(playerName) == null) {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                } else if (target.isOnline()) {
                    target.setFoodLevel(20);
                    target.setSaturation(20);
                    sender.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.AQUA + " has successfully been fed!");
                    target.sendMessage(ChatColor.AQUA + "You were fed by " +  ChatColor.YELLOW + sender.getName());
                } else {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                }
            } else if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                player.setSaturation(20);

                sender.sendMessage(ChatColor.AQUA + "You have been fed!");
                return true;
            } else {
                sender.sendMessage("You can't heal the console!");
            }
        }
        return true;
    }
}