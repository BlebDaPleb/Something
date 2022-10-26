package com.blebdapleb.mrindia.commands.keys;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GivekeyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("mrindia.keys.givekey")){

            if (args.length == 3) {


                String playerName = String.valueOf(args[0]);
                String keyType = String.valueOf(args[1]);
                Integer keyAmount = Integer.valueOf(args[2]);
                Player target = Bukkit.getPlayer(playerName);

                if (Bukkit.getPlayerExact(playerName) == null) {

                    sender.sendMessage(ChatColor.RED + "Player is not online.");

                } else if (!target.isOnline()) {
                    sender.sendMessage(ChatColor.RED + "Player is not online.");
                } else {

                    String emeraldKeyPath = target.getUniqueId() + ".emerald_keys";
                    String diamondKeyPath = target.getUniqueId() + ".diamond_keys";
                    String goldKeyPath = target.getUniqueId() + ".gold_keys";
                    String ironKeyPath = target.getUniqueId() + ".iron_keys";

                    try {
                        keyAmount = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("Usage: /givekey <Player> <Type: emerald, diamond, gold, iron> <Amount>");
                        return true;
                    }

                    if (keyType.contains("emerald")) {

                        int emeraldKeyAmount = MrIndia.getInstance().getKeysConfig().getInt(emeraldKeyPath);
                        emeraldKeyAmount = emeraldKeyAmount + keyAmount;
                        MrIndia.getInstance().getKeysConfig().set(emeraldKeyPath, emeraldKeyAmount);
                        sender.sendMessage(ChatColor.AQUA + "Successfully gave " + ChatColor.YELLOW + keyAmount + ChatColor.AQUA + " emerald keys to " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.AQUA + "You have been given " + ChatColor.YELLOW + keyAmount + " emerald" + ChatColor.AQUA + " keys by " + ChatColor.YELLOW + sender.getName());

                        return true;
                    } else if (keyType.contains("diamond")) {

                        int diamondKeyAmount = MrIndia.getInstance().getKeysConfig().getInt(diamondKeyPath);
                        diamondKeyAmount = diamondKeyAmount + keyAmount;
                        MrIndia.getInstance().getKeysConfig().set(diamondKeyPath, diamondKeyAmount);
                        sender.sendMessage(ChatColor.AQUA + "Successfully gave " + ChatColor.YELLOW + keyAmount + ChatColor.AQUA + " diamond keys to " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.AQUA + "You have been given " + ChatColor.YELLOW + keyAmount + " diamond" + ChatColor.AQUA + " keys by " + ChatColor.YELLOW + sender.getName());

                        return true;
                    } else if (keyType.contains("gold")){

                        int goldKeyAmount = MrIndia.getInstance().getKeysConfig().getInt(goldKeyPath);
                        goldKeyAmount = goldKeyAmount + keyAmount;
                        MrIndia.getInstance().getKeysConfig().set(goldKeyPath, goldKeyAmount);
                        sender.sendMessage(ChatColor.AQUA + "Successfully gave " + ChatColor.YELLOW + keyAmount + ChatColor.AQUA + " gold keys to " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.AQUA + "You have been given " + ChatColor.YELLOW + keyAmount + " gold" + ChatColor.AQUA + " keys by " + ChatColor.YELLOW + sender.getName());

                        return true;
                    } else if(keyType.contains("iron")){

                        int ironKeyAmount = MrIndia.getInstance().getKeysConfig().getInt(ironKeyPath);
                        ironKeyAmount = ironKeyAmount + keyAmount;
                        MrIndia.getInstance().getKeysConfig().set(ironKeyPath, ironKeyAmount);
                        sender.sendMessage(ChatColor.AQUA + "Successfully gave " + ChatColor.YELLOW + keyAmount + ChatColor.AQUA + " iron keys to " + ChatColor.YELLOW + target.getName());
                        target.sendMessage(ChatColor.AQUA + "You have been given " + ChatColor.YELLOW + keyAmount + " iron" + ChatColor.AQUA + " keys by " + ChatColor.YELLOW + sender.getName());

                        return true;
                    } else {

                        sender.sendMessage(ChatColor.RED + "That is not a valid key type!");
                        return true;

                    }

                }

            } else {

                sender.sendMessage("Usage: /givekey <Player> <Type: emerald, diamond, gold, iron> <Amount>");
                return true;

            }

        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return true;
    }
}
