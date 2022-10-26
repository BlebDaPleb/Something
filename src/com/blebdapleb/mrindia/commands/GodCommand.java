package com.blebdapleb.mrindia.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            if(args.length != 0){

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                if(Bukkit.getPlayerExact(playerName) == null){

                    sender.sendMessage(ChatColor.RED + "Player is not online.");

                } else if (!target.isOnline()){

                    sender.sendMessage(ChatColor.RED + "Player is not online.");

                } else {

                    if(!target.isInvulnerable()){

                        target.setInvulnerable(true);
                        sender.sendMessage(ChatColor.GREEN + "Enabled god mode for " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.GREEN + "You were set to godmode by " + ChatColor.YELLOW + sender.getName());

                    } else {

                        target.setInvulnerable(false);
                        sender.sendMessage(ChatColor.GREEN + "Enabled disabled mode for " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.GREEN + "God mode has been disabled by " + ChatColor.YELLOW + sender.getName());

                    }

                }

            } else {

                Player player = (Player) sender;
                if (!player.isInvulnerable()) {
                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.GREEN + "God mode enabled.");
                } else {
                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.RED + "God mode disabled.");
                }

            }

        } else {

            sender.sendMessage("You must be online to use this command!");

        }
        return true;
    }
}