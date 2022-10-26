package com.blebdapleb.mrindia.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmspCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("mrindia.gmsp")) {

            if (sender instanceof Player) {

                if (args.length != 0) {

                    String playerName = String.valueOf(args[0]);
                    Player target = Bukkit.getPlayer(playerName);

                    if (Bukkit.getPlayer(playerName) == null) {

                        sender.sendMessage(ChatColor.RED + "Player is not online.");
                    } else {
                        if (target.isOnline()) {

                            if (!target.getGameMode().equals(GameMode.SPECTATOR)) {

                                target.setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage(ChatColor.AQUA + "You have successfully set " + ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "to gamemode " + ChatColor.RED + "spectator");
                                target.sendMessage(ChatColor.AQUA + "You were set to gamemode " + ChatColor.RED + "spectator " + ChatColor.AQUA + "by " + ChatColor.YELLOW + sender.getName());
                            } else {
                                sender.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "is already in gamemode " + ChatColor.RED + "spectator!");
                                return true;
                            }
                        } else {
                            sender.sendMessage(ChatColor.RED + "Player is not online.");

                            return true;
                        }
                    }
                } else {
                    Player player = (Player) sender;
                    if (!player.getGameMode().equals(GameMode.SPECTATOR)) {

                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(ChatColor.AQUA + "You have are now in gamemode " + ChatColor.RED + "spectator");

                    } else {

                        sender.sendMessage(ChatColor.RED + "You are already in gamemode " + ChatColor.RED + "spectator!");
                        return true;
                    }
                }
            } else {
                sender.sendMessage("You can only use this command in-game!");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return true;
    }

}
