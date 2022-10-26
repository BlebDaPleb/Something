package com.blebdapleb.mrindia.commands.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class InvseeCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String playerName = String.valueOf(args[0]);
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(playerName);

        if(Bukkit.getPlayerExact(playerName) == null){

            sender.sendMessage(ChatColor.RED + "Player is not online.");
            return true;

        } else if (!target.isOnline()){

            sender.sendMessage(ChatColor.RED + "Player is not online.");
            return true;

        } else {
            sender.sendMessage(ChatColor.AQUA + "Opening inventory...");
            player.openInventory(target.getInventory());
            return true;
        }

    }

}
