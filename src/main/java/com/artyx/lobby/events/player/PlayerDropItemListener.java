package com.artyx.lobby.events.player;

import lombok.val;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(
            PlayerDropItemEvent event
    ) {

        val player = event.getPlayer();
        event.setCancelled(true);

    }
}
