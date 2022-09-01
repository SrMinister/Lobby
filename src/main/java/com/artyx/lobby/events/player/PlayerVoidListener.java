package com.artyx.lobby.events.player;

import com.artyx.lobby.utils.LocationUtil;
import lombok.val;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerVoidListener implements Listener {

    @EventHandler
    public void on(
            EntityDamageEvent event
    ) {

        val cause = event.getCause();

        if(event.getEntity() instanceof Player) {

            val player = (Player) event.getEntity();

            if (cause == EntityDamageEvent.DamageCause.FALL) {
                event.setDamage(0);
                event.setCancelled(true);
            }

            if (cause == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                event.setDamage(0);
                event.setCancelled(true);
            }


            if (cause == EntityDamageEvent.DamageCause.VOID) {
                event.setDamage(0);
                Location lobby = LocationUtil.get("lobby");
                player.teleport(lobby);

                player.playSound(
                        player.getLocation(),
                        Sound.ENDERMAN_TELEPORT,
                        2.0f,
                        2.0f
                );
            }
        }
    }
}
