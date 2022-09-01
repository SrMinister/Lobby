package com.artyx.lobby.events.player;

import com.artyx.lobby.utils.ItemsUtil;
import com.artyx.lobby.utils.LocationUtil;
import com.artyx.lobby.utils.TabListUtil;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(
            PlayerJoinEvent event
    ) {

        val player = (Player) event.getPlayer();
        event.setJoinMessage(null);
        player.teleport(LocationUtil.get("lobby"));

        TabListUtil.sendTab(
                player,
                "\n" +
                        "§eϟ §9§lREDE WAND §eϟ§f " +
                        "\n" +
                        "§fwww.redewand.com" +
                        "\n",
                "\n"+
                        "§bTwitter: §ftwitter.com/@ServidoresWand" +
                        "\n" +
                        " §b Discord: §fdiscord.redewand.com" +
                        "\n\n" +
                        "§7  Adquira suas vantagens acessando nosso site:  " +
                        "\n" +
                        "§f  www.redewand.com" +
                        "\n"
        );

        player.setGameMode(GameMode.ADVENTURE);
        ItemsUtil.giveItems(player);

        player.setHealthScale(2);
        player.setLevel(2022);


    }
}
