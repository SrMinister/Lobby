package com.artyx.lobby.events.player;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(
            PlayerQuitEvent event
    ) {

        val player = (Player) event.getPlayer();
        event.setQuitMessage(null);
    }
}
