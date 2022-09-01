package com.artyx.lobby.events.player;

import com.artyx.lobby.LobbyPlugin;
import com.artyx.lobby.view.LobbyView;
import com.artyx.lobby.view.ServerView;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent event) {
            Player player = event.getPlayer();

            ItemStack item = event.getItem();
            if(item == null) return;
            if(item.getType() == Material.AIR) return;
            if (!item.hasItemMeta()) return;

            if(item.getItemMeta().getDisplayName().equals("§fJogadores: §aOn")) {

                event.setCancelled(true);


                player.getInventory().setItem(
                        6,
                        new ItemBuilder(
                                Material.getMaterial(351)
                        ).name(
                                "§fJogadores: §cOff"
                        ).durability((short) 1).build()
                );
                LobbyPlugin.getInstance().getHideManager().hide(player);

            } else if(item.getItemMeta().getDisplayName().equals("§fJogadores: §cOff")) {

                event.setCancelled(true);

                player.getInventory().setItem(
                        6,
                        new ItemBuilder(
                                Material.getMaterial(351)
                        ).name(
                                "§fJogadores: §aOn"
                        ).durability((short) 10).build()
                );
                LobbyPlugin.getInstance().getHideManager().show(player);

            } else if(item.getType() == Material.COMPASS) {
                event.setCancelled(true);
                ServerView serverView = new ServerView();
                serverView.open(player);
            } else if(item.getType() == Material.NETHER_STAR) {
                event.setCancelled(true);
                LobbyView lobbyView = new LobbyView();
                lobbyView.open(player);
            }
    }
}
