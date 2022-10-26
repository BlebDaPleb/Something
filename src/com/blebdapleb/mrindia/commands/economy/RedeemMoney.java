package com.blebdapleb.mrindia.commands.economy;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RedeemMoney implements Listener {

    @EventHandler
    public void onRedeem(PlayerInteractEvent e) {

        // Redeem 5000 Item
        ItemStack redeem5000 = new ItemStack(Material.PAPER, 1);
        ItemMeta redeem5000Meta = redeem5000.getItemMeta();
        redeem5000Meta.setDisplayName(ChatColor.GREEN + "$5000 Check");
        ArrayList<String> redeem5000Lore = new ArrayList<>();
        redeem5000Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$5000");
        redeem5000Meta.setLore(redeem5000Lore);
        redeem5000.setItemMeta(redeem5000Meta);

        // Redeem 2500 Item
        ItemStack redeem2500 = new ItemStack(Material.PAPER, 1);
        ItemMeta redeem2500Meta = redeem2500.getItemMeta();
        redeem2500Meta.setDisplayName(ChatColor.GREEN + "$2500 Check");
        ArrayList<String> redeem2500Lore = new ArrayList<>();
        redeem2500Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$2500");
        redeem2500Meta.setLore(redeem2500Lore);
        redeem2500.setItemMeta(redeem2500Meta);


        Player player = e.getPlayer();

        // Money redeem 5000
        if (player.getInventory().getItemInMainHand().equals(redeem5000)) {

            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

                    player.getInventory().remove(redeem5000);
                    int money = MrIndia.getInstance().getEconomyConfig().getInt(player.getUniqueId().toString());
                    money = money + 5000;
                    MrIndia.getInstance().getEconomyConfig().set(player.getUniqueId().toString(), money);
                    player.sendMessage(ChatColor.AQUA + "You have redeemed " + ChatColor.YELLOW + "$5000.");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);

                }

            } else return;

        } else if (player.getInventory().getItemInMainHand().equals(redeem2500)) {

            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

                player.getInventory().remove(redeem2500);
                int money = MrIndia.getInstance().getEconomyConfig().getInt(player.getUniqueId().toString());
                money = money + 2500;
                MrIndia.getInstance().getEconomyConfig().set(player.getUniqueId().toString(), money);
                player.sendMessage(ChatColor.AQUA + "You have redeemed " + ChatColor.YELLOW + "$2500.");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);

            }

        } else return;

    }

}
