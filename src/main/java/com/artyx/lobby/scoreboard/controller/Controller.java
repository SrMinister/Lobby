package com.artyx.lobby.scoreboard.controller;

import com.artyx.lobby.controller.BungeeController;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Controller {

    public static int playersCount(Player player) {
        return Bukkit.getOnlinePlayers().size();
    }

    public static int  playerCountRHeads (Player player) {
        int playerCountRHeads = BungeeController.getServerCount("rankup-1");
        return playerCountRHeads;
    }
}
