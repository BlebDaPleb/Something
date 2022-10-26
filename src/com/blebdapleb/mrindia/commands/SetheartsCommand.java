package com.blebdapleb.mrindia.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetheartsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length != 0){

            String playerName = String.valueOf(args[0]);
            int heartAmount = Integer.parseInt(args[1]);
            Player target = Bukkit.getPlayer(playerName);

            if(Bukkit.getPlayerExact(playerName) == null){

                sender.sendMessage("Usage : /sethearts <Player> <Amount>");
                return true;

            } else if (target.isOnline()){



            }

        }

        return true;
    }
}
