package com.blebdapleb.mrindia.commands.economy;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddmoneyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("mrindia.economy.addmoney")){

            if (args.length == 0) {
                sender.sendMessage("Usage: /addmoney <Player> <Amount>");
            } else {

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                if (Bukkit.getPlayerExact(playerName) == null) {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                } else if (target.isOnline()) {

                    Integer addAmount;

                    try {
                        addAmount = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("Usage: /addmoney <Player> <Amount>)");
                        return true;
                    }

                    int targetMoney = MrIndia.getInstance().getEconomyConfig().getInt(target.getUniqueId().toString());
                    targetMoney = targetMoney + addAmount;
                    MrIndia.getInstance().getEconomyConfig().set(target.getUniqueId().toString(), targetMoney);
                    sender.sendMessage(ChatColor.AQUA + "Successfully added " + ChatColor.YELLOW + "$" + addAmount + ChatColor.AQUA + " to " + ChatColor.YELLOW + target.getName() + "'s" + ChatColor.AQUA + "balance");
                    target.sendMessage(ChatColor.YELLOW + "$" + addAmount + ChatColor.AQUA + " has been added to your balance.");
                    return true;

                } else {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                }

            }

        }

        return true;
    }
}
