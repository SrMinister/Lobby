package com.artyx.lobby.controller;

import com.artyx.lobby.LobbyPlugin;
import com.artyx.lobby.enums.Messages;
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import javax.persistence.Lob;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BungeeController implements Runnable, PluginMessageListener {

    private static final Map<String, Integer> serverMap = new HashMap<>();

    private static final String[] SERVERS = {
            "lobby", "rankup-1"
    };

    @Override
    public void run() {
        for (String server : SERVERS) {
            final ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("PlayerCount");
            out.writeUTF(server);

            Bukkit.getServer().sendPluginMessage(
                    LobbyPlugin.getInstance(), "BungeeCord", out.toByteArray()
            );
        }
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;

        final ByteArrayDataInput input = ByteStreams.newDataInput(message);

        final String value = input.readUTF();
        if (!value.equals("PlayerCount")) return;

        final String server = input.readUTF();
        final int online = input.readInt();

        serverMap.put(server, online);
    }

    public static int getServerCount(String server) {
        return serverMap.getOrDefault(server, 0);
    }
    public static void sendServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArrayOutputStream);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException exception) {
            System.out.println(exception);
        }
        Bukkit.getPlayer(player.getName()).sendPluginMessage(LobbyPlugin.getInstance(), "BungeeCord", byteArrayOutputStream.toByteArray());
        Messages.SUCCESS.sendMessage(
                player,
                "§aConectando..."
        );
    }
}