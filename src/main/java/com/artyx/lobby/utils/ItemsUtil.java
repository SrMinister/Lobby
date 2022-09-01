package com.artyx.lobby.utils;

import com.artyx.lobby.LobbyPlugin;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemsUtil {
    public static void giveItems(
            Player player
    ) {
        if (LobbyPlugin.getInstance().getHideManager().getPlayers().contains(player)) {
            player.getInventory().setItem(
                    6,
                    new ItemBuilder(
                            Material.getMaterial(351)
                    ).name(
                            "§fJogadores: §cOff"
                    ).durability((short) 1).build()
            );
        } else {
            player.getInventory().setItem(
                    6,
                    new ItemBuilder(
                            Material.getMaterial(351)
                    ).name(
                            "§fJogadores: §aOn"
                    ).durability((short) 10).build()
            );

        }
        player.getInventory().setItem(
                2,
                new ItemBuilder(
                        Material.COMPASS
                ).name(
                        "§aServidores"
                ).build()
        );

        player.getInventory().setItem(
                4,
                new ItemBuilder(
                        Material.NETHER_STAR
                ).name(
                        "§aSaguões"
                ).build()
        );
    }
}
