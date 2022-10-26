package com.blebdapleb.mrindia.commands.economy;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            if(args.length == 0){

                Player player = (Player) sender;

                int money = MrIndia.getInstance().getEconomyConfig().getInt(player.getUniqueId().toString());
                sender.sendMessage(ChatColor.AQUA + "Your balance is " + ChatColor.YELLOW + "$" + money);
                return true;

            } else {

                String playerName = String.valueOf(args[0]);
                Player target = Bukkit.getPlayer(playerName);

                if(Bukkit.getPlayerExact(playerName) == null){
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                } else if(!target.isOnline()){
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                    return true;
                } else {
                    int money = MrIndia.getInstance().getEconomyConfig().getInt(target.getUniqueId().toString());
                    sender.sendMessage(ChatColor.YELLOW + target.getName() + "'s " + ChatColor.AQUA + "balance is " + ChatColor.YELLOW + "$" + money);
                    return true;
                }

            }

        } else {
            sender.sendMessage("Console does not have a balance!");
        }

        return true;
    }
}
