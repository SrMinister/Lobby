package com.artyx.lobby.enums;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public enum Messages {
    ERROR(Sound.VILLAGER_NO),
    SUCCESS(Sound.LEVEL_UP);

    private Sound sound;

    Messages(
            Sound sound
    ) {
        this.sound = sound;
    }

    public void sendMessage(
            Player player,
            String message
    ) {
        player.sendMessage(message);
        player.playSound(player.getLocation(), this.sound, 1.0F, 1.0F);
    }
}