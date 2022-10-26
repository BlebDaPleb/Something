package com.blebdapleb.mrindia.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("mrindia.gms")){

            if(sender instanceof Player){

                if(args.length != 0){

                    String playerName = String.valueOf(args[0]);
                    Player target = Bukkit.getPlayer(playerName);

                    if(Bukkit.getPlayer(playerName) == null){
                        sender.sendMessage(ChatColor.RED + "Player is not online.");
                    } else if(target.isOnline()){

                        if(!target.getGameMode().equals(GameMode.SURVIVAL)){

                            target.setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage(ChatColor.AQUA + "You have successfully set " + ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "to gamemode " + ChatColor.RED + "survival");
                            target.sendMessage(ChatColor.AQUA + "You were set to gamemode " + ChatColor.RED + "survival " + ChatColor.AQUA + "by " + ChatColor.YELLOW + sender.getName());

                        } else {
                            sender.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "is already in gamemode " + ChatColor.RED + "survival!");
                        }

                    } else {
                        sender.sendMessage(ChatColor.RED + "Player is not online.");

                        return true;
                    }

                } else {
                    Player player = (Player) sender;
                    if (!player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(ChatColor.AQUA + "You have are now in gamemode " + ChatColor.RED + "survival");
                    } else {

                        sender.sendMessage(ChatColor.RED + "You are already in gamemode survival!");

                        return true;
                    }
                }
            } else {

                sender.sendMessage("This command only works in-game!");

                return true;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return true;
    }
}