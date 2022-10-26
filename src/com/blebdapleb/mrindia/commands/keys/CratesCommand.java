package com.blebdapleb.mrindia.commands.keys;

import com.blebdapleb.mrindia.commands.keys.CrateSystem;
import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CratesCommand implements CommandExecutor {

    public CrateSystem crateSystem;

    public CratesCommand(CrateSystem crateSystem){

        this.crateSystem = crateSystem;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {;

        if(sender instanceof Player){

            Player player = (Player) sender;
            crateSystem.openCratesMenuGui(player);

        } else {

            sender.sendMessage("You must be a player to use this command!");

        }

        return true;
    }
}
