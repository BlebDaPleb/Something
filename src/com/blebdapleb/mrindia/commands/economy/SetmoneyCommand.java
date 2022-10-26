package com.blebdapleb.mrindia.commands.economy;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetmoneyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("mrindia.economy.setmoney")){

            if (args.length == 0) {
                sender.sendMessage("Usage: /setmoney <Player> <Amount>");
            } else {

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                if (Bukkit.getPlayerExact(playerName) == null) {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                } else if (target.isOnline()) {

                    Integer setAmount;

                    try {
                        setAmount = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("Usage: /pay <Player> <Amount>)");
                        return true;
                    }

                    MrIndia.getInstance().getEconomyConfig().set(target.getUniqueId().toString(), setAmount);
                    sender.sendMessage(ChatColor.AQUA + "Successfully set " + ChatColor.YELLOW + target.getName() + "'s " + ChatColor.AQUA + "balance to " + ChatColor.YELLOW + "$" + setAmount);
                    target.sendMessage(ChatColor.AQUA + "Your balance has been set to " + ChatColor.YELLOW + "$" + setAmount);
                    return true;

                } else {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                }

            }

        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        return true;
    }
}
