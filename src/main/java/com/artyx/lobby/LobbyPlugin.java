package com.artyx.lobby;

import com.artyx.lobby.controller.BungeeController;
import com.artyx.lobby.manager.HideManager;
import com.artyx.lobby.registry.DefaultRegistry;
import com.artyx.lobby.scoreboard.board.Scoreboard;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;

@Getter
public final class LobbyPlugin extends JavaPlugin{

    private final DefaultRegistry registry = new DefaultRegistry(this); ;
    private final HideManager hideManager = new HideManager(this);

    @Override
    public void onEnable() {
        saveDefaultConfig();
        commands();
        listeners();
        scoreboard();
        views();
        final Messenger messenger = getServer().getMessenger();
        messenger.registerIncomingPluginChannel(this, "BungeeCord", new BungeeController());
        messenger.registerOutgoingPluginChannel(this, "BungeeCord");
        final BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskTimer(this, new BungeeController(), 20L, 20L);
    }

    public void commands() {
        registry.commands();
    }

    public void listeners() {
        registry.listeners();
    }

    public void scoreboard() {
        Scoreboard scoreboard = new Scoreboard(this);
        scoreboard.scoreboard();
    }

    public void views() {
        registry.views();
    }

    public static LobbyPlugin getInstance() {
        return getPlugin(LobbyPlugin.class);
    }


}
