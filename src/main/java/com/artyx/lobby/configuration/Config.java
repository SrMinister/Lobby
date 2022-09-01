package com.artyx.lobby.configuration;

import com.artyx.lobby.LobbyPlugin;
import org.bukkit.plugin.*;
import org.bukkit.configuration.file.*;

import java.io.*;
import java.util.*;


public class Config {
    private Plugin plugin;
    private String name;
    private File file;
    private YamlConfiguration config;

    public Config(String nome) {
        plugin = LobbyPlugin.getInstance();
        setName(nome);
        reloadConfig();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            getConfig().save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        getConfig().options().copyDefaults(true);
    }

    public void saveDefaultConfig() {
        if (!existeConfig()) {
            getPlugin().saveResource(getName(), false);
            reloadConfig();
        }
    }

    public void reloadConfig() {
        file = new File((LobbyPlugin.getInstance()).getDataFolder(), getName());
        config = YamlConfiguration.loadConfiguration(getFile());
    }

    public void deleteConfig() {
        getFile().delete();
    }

    public boolean existeConfig() {
        return getFile().exists();
    }

    public String getString(String path) {
        return getConfig().getString(path);
    }

    public int getInt(String path) {
        return getConfig().getInt(path);
    }

    public boolean getBoolean(String path) {
        return getConfig().getBoolean(path);
    }

    public double getDouble(String path) {
        return getConfig().getDouble(path);
    }

    public List<?> getList(String path) {
        return (List<?>) getConfig().getList(path);
    }

    public long getLong(String path) {
        return getConfig().getLong(path);
    }

    public float getFloat(String path) {
        return (float) getConfig().getInt(path);
    }

    public Object get(String path) {
        return getConfig().get(path);
    }

    public List<Map<?, ?>> getMapList(String path) {
        return (List<Map<?, ?>>) getConfig().getMapList(path);
    }

    public List<String> getStringList(String path) {
        return (List<String>) getConfig().getStringList(path);
    }

    public List<Integer> getIntegerList(String path) {
        return (List<Integer>) getConfig().getIntegerList(path);
    }

    public boolean contains(String path) {
        return getConfig().contains(path);
    }

    public void set(String path, Object value) {
        getConfig().set(path, value);
    }

    public void setString(String path, String value) {
        getConfig().set(path, value);
    }
}
