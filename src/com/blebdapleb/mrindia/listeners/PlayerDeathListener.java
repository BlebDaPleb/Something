package com.blebdapleb.mrindia.listeners;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        EntityDamageEvent lastDamage = e.getEntity().getLastDamageCause();
        if (lastDamage instanceof EntityDamageByEntityEvent) {

            EntityDamageByEntityEvent entityDamage = (EntityDamageByEntityEvent) lastDamage;
            Entity killer = entityDamage.getDamager();

            if (killer instanceof Player) {

                Player player = ((Player) killer);

                // Adds a heart to the killer
                double killerHeartAmount = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
                System.out.println("Getting the killers current base heart value " + killerHeartAmount);
                killerHeartAmount = killerHeartAmount + 2.0;
                System.out.println("Adding 1 heart to the killers base heart value " + killerHeartAmount);
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(killerHeartAmount);
                System.out.println("Setting the killers base heart value to the new base heart value " + killerHeartAmount);

                // Removes a heart from the player
                Player victim = e.getEntity();
                System.out.println("Getting the entity that died");
                double playerHeartAmount = victim.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
                System.out.println("Getting the victims current base heart value " + playerHeartAmount);
                playerHeartAmount = playerHeartAmount - 2.0;
                System.out.println("Removing 1 heart from the victims base heart value" + playerHeartAmount);
                victim.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(playerHeartAmount);
                System.out.println("Setting the victims base heart value to the new base heart value" + playerHeartAmount);

                // Gives money to players for each kill
                int money = MrIndia.getInstance().getEconomyConfig().getInt(killer.getUniqueId().toString());
                money = money + 50;
                MrIndia.getInstance().getEconomyConfig().set(killer.getUniqueId().toString(), money);

            }

        }

    }

}
