package com.artyx.lobby.events.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(
            PlayerDeathEvent event
    ) {
        event.setDeathMessage(null);
        event.getDrops().clear();

    }
}
