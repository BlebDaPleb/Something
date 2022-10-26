package com.blebdapleb.mrindia.commands.keys;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeysCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            String emeraldKeyPath = player.getUniqueId() + ".emerald_keys";
            String diamondKeyPath = player.getUniqueId() + ".diamond_keys";
            String goldKeyPath = player.getUniqueId() + ".gold_keys";
            String ironKeyPath = player.getUniqueId() + ".iron_keys";

            int emeraldKeysAmount = MrIndia.getInstance().getKeysConfig().getInt(emeraldKeyPath);
            int diamondKeysAmount = MrIndia.getInstance().getKeysConfig().getInt(diamondKeyPath);
            int goldKeysAmount = MrIndia.getInstance().getKeysConfig().getInt(goldKeyPath);
            int ironKeysAmount = MrIndia.getInstance().getKeysConfig().getInt(ironKeyPath);

            player.sendMessage(ChatColor.GREEN + "Your keys:\n"
                    + ChatColor.AQUA + "Emerald keys: " + ChatColor.YELLOW + emeraldKeysAmount + "\n"
                    + ChatColor.AQUA + "Diamond keys: " + ChatColor.YELLOW + diamondKeysAmount + "\n"
                    + ChatColor.AQUA + "Gold keys: " + ChatColor.YELLOW + goldKeysAmount + "\n"
                    + ChatColor.AQUA + "Iron keys: " + ChatColor.YELLOW + ironKeysAmount);

        } else {

            sender.sendMessage("You must be a player to execute this command!");
            return true;
        }

        return true;
    }
}
