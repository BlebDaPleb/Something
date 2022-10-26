package com.blebdapleb.mrindia.commands;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("mrindia.heal")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        } else {
            if (args.length != 0) {

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                if (Bukkit.getPlayer(playerName) == null) {

                    sender.sendMessage(ChatColor.RED + "Player is not online.");

                } else if (Bukkit.getOnlinePlayers().contains(target)) {

                    target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    sender.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.AQUA + " has successfully been healed!");
                    target.sendMessage(ChatColor.AQUA + "You were healed by " + ChatColor.YELLOW + sender.getName() + ".");

                } else {

                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                }
            } else if (sender instanceof Player) {

                Player player = (Player) sender;
                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                sender.sendMessage(ChatColor.AQUA + "You have been healed!");
                return true;

            } else {
                sender.sendMessage("You can't heal the console!");
                return true;
            }
        }

        return true;
    }


}