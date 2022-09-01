package com.artyx.lobby.events.server;

import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelListener {

    public void onFoodLevel(
            FoodLevelChangeEvent event
    ) {
        event.setCancelled(true);
    }
}
