package com.blebdapleb.mrindia.commands;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("mrindia.gmc")){
            if (sender instanceof Player) {

                if (args.length != 0) {

                    String playerName = String.valueOf(args[0]);
                    Player target = Bukkit.getPlayer(playerName);

                    if (Bukkit.getPlayer(playerName) == null) {

                        sender.sendMessage(ChatColor.RED + "Player is not online.");

                    } else if (target.isOnline()) {

                        if(!target.getGameMode().equals(GameMode.CREATIVE)){
                            target.setGameMode(GameMode.CREATIVE);
                            sender.sendMessage(ChatColor.AQUA + "You have successfully set " + ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "to gamemode " + ChatColor.RED + "creative");
                            target.sendMessage(ChatColor.AQUA + "You were set to gamemode " + ChatColor.RED + "creative " + ChatColor.AQUA + "by " + ChatColor.YELLOW + sender.getName());
                        } else {
                            sender.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.AQUA + "is already in gamemode " + ChatColor.RED + "creative!");
                            return true;
                        }

                    } else {

                        sender.sendMessage(ChatColor.RED + "Player is not online.");

                    }
                } else {
                    Player player = (Player) sender;

                    if (!player.getGameMode().equals(GameMode.CREATIVE)) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(ChatColor.AQUA + "You have are now in gamemode " + ChatColor.RED + "creative");
                    } else {
                        sender.sendMessage(ChatColor.RED + "You are already in gamemode creative!");
                    }

                }

                Player player = (Player) sender;

                if (!player.getGameMode().equals(GameMode.CREATIVE)) {
                    player.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(ChatColor.AQUA + "You have are now in gamemode " + ChatColor.RED + "creative");
                } else {
                    sender.sendMessage(ChatColor.RED + "You are already in gamemode creative!");
                    return true;
                }
            } else {
                sender.sendMessage("This command only works in-game!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return true;
    }

}