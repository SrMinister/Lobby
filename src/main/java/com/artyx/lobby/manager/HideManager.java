package com.artyx.lobby.manager;

import com.artyx.lobby.LobbyPlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class HideManager {

    private final LobbyPlugin plugin;

    @Getter
    private final List<Player> players = new ArrayList<>();

    public void hide(Player player) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayers.hasPermission("artyx.staff")) {
                player.hidePlayer(onlinePlayers);
            }
        }
        players.add(player);
    }

    public void show(Player player) {
        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
            player.showPlayer(onlinePlayers);
        }
        players.remove(player);
    }
}
