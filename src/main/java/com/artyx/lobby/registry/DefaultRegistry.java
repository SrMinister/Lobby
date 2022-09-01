package com.artyx.lobby.registry;

import com.artyx.lobby.LobbyPlugin;
import com.artyx.lobby.commands.*;
import com.artyx.lobby.events.player.*;
import com.artyx.lobby.events.server.AsyncPlayerChatListener;
import com.artyx.lobby.view.LobbyView;
import com.artyx.lobby.view.ServerView;
import lombok.RequiredArgsConstructor;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.ViewFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import me.saiintbrisson.minecraft.command.message.MessageType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

@RequiredArgsConstructor
public class DefaultRegistry {
    private final LobbyPlugin plugin;
    public void commands() {
        BukkitFrame frame = new BukkitFrame(plugin);
        MessageHolder messageHolder = frame.getMessageHolder();
        frame.registerCommands(
                new GameModeCommand(),
                new FlyCommand(),
                new TpCommand(),
                new TpHereCommand(),
                new SetLobbyCommand(),
                new InvseeCommand()
        );
        messageHolder.setMessage(MessageType.NO_PERMISSION, "§cVocê não tem permissão para isso.");
        messageHolder.setMessage(MessageType.INCORRECT_USAGE, "§cUse: /{usage}.");
    }

    public void listeners() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(
                new PlayerJoinListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerQuitListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerDropItemListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerInteractListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerInteractListener(),
                plugin
        );

        manager.registerEvents(
                new AsyncPlayerChatListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerDeathListener(),
                plugin
        );

        manager.registerEvents(
                new PlayerRespawnListener(),
                plugin
         );

        manager.registerEvents(
                new PlayerVoidListener(),
                plugin
        );
    }

    public void views() {
        ViewFrame viewFrame = new ViewFrame(plugin);
        viewFrame.register(
                new LobbyView(),
                new ServerView()
        );
    }

}
