package com.artyx.lobby.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class TabListUtil {

    public static void sendTab(Player player, String header, String footer) {
        PacketPlayOutPlayerListHeaderFooter headerFooterPacket = new PacketPlayOutPlayerListHeaderFooter();
        IChatBaseComponent headerComp = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + header + "\"}");
        IChatBaseComponent footerComp = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + footer + "\"}");
        try {
            Field headerField = headerFooterPacket.getClass().getDeclaredField("a");
            Field footerField = headerFooterPacket.getClass().getDeclaredField("b");
            headerField.setAccessible(true);
            footerField.setAccessible(true);
            headerField.set(headerFooterPacket, headerComp);
            footerField.set(headerFooterPacket, footerComp);
            headerField.setAccessible(false);
            footerField.setAccessible(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        connection.sendPacket(headerFooterPacket);
    }

}
