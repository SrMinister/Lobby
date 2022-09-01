package com.artyx.lobby.utils;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class CooldownUtil {

    private static CooldownUtil instance;

    public static CooldownUtil getInstance() {
        if (instance == null) instance = new CooldownUtil();

        return instance;
    }

    private final Map<String, Long> rawMap = new WeakHashMap<>();

    public void createCooldown(Player player, String name, long time, TimeUnit unit) {
        createCooldown(player.getUniqueId() + ";" + name, time, unit);
    }

    public void createCooldown(String name, long time, TimeUnit unit) {
        rawMap.put(name, System.currentTimeMillis() + unit.toMillis(time));
    }

    public boolean isInCooldown(Player player, String name) {
        return isInCooldown(player.getUniqueId() + ";" + name);
    }

    public boolean isInCooldown(String name) {
        return System.currentTimeMillis() < rawMap.getOrDefault(name, 0L);
    }

    public long getCooldownTime(Player player, String name) {
        return rawMap.get(player.getUniqueId() + ";" + name) - System.currentTimeMillis();
    }

    public long getCooldownTime(Player player, String name, TimeUnit unit) {
        return unit.convert(getCooldownTime(player, name), TimeUnit.MILLISECONDS);
    }
}