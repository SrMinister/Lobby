package com.artyx.lobby.events.player;

import com.artyx.lobby.utils.LocationUtil;
import lombok.val;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(
            PlayerRespawnEvent event
    ) {

        val player = event.getPlayer();

        Location spawn = LocationUtil.get("lobby");
        player.teleport(spawn);

    }
}
