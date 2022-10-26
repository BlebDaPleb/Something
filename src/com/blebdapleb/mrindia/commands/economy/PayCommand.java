package com.blebdapleb.mrindia.commands.economy;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            if (args.length == 0) {
                sender.sendMessage("Usage: /pay <Player> <Amount>");
            } else {

                Player player = (Player) sender;

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                int yourMoney = MrIndia.getInstance().getEconomyConfig().getInt(player.getUniqueId().toString());

                if (Bukkit.getPlayerExact(playerName) == null) {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                } else if (target.isOnline()) {

                    Integer payAmount;

                    try {
                        payAmount = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("Usage: /setmoney <Player> <Amount>)");
                        return true;
                    }

                    int targetMoney = MrIndia.getInstance().getEconomyConfig().getInt(target.getUniqueId().toString());

                    if (payAmount <= yourMoney) {

                        yourMoney = yourMoney - payAmount;
                        MrIndia.getInstance().getEconomyConfig().set(player.getUniqueId().toString(), yourMoney);
                        sender.sendMessage(ChatColor.AQUA + "You have successfully paid " + ChatColor.YELLOW + target.getName() + " $" + payAmount);
                        targetMoney = targetMoney + payAmount;
                        MrIndia.getInstance().getEconomyConfig().set(target.getUniqueId().toString(), targetMoney);
                        target.sendMessage(ChatColor.AQUA + "You have been paid " + ChatColor.YELLOW + "$" + payAmount + ChatColor.AQUA + " by " + ChatColor.YELLOW + player.getName());

                    } else {
                        sender.sendMessage(ChatColor.RED + "Insufficient funds!");
                        return true;
                    }

                } else {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                }

            }

        }

        return true;
    }
}
