package com.blebdapleb.mrindia.listeners;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (!player.hasPlayedBefore()) {

            // Keys
            String ironKeyPath = player.getUniqueId() + ".iron_keys";
            MrIndia.getInstance().getKeysConfig().set(ironKeyPath, 1);

            // Economy
            MrIndia.getInstance().getEconomyConfig().set(player.getUniqueId().toString(), 1000);

        }

    }

}
