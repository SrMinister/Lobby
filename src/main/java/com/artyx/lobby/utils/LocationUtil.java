package com.artyx.lobby.utils;

import com.artyx.lobby.configuration.Config;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

public class LocationUtil {
    public static Config warps;
    private static Map<String, Location> warpList;

    public static void set(Location loc, String warp) {
        LocationUtil.warps.set(warp, loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getPitch() + ":" + loc.getYaw() + ":" + loc.getWorld().getName());
        getWarpList().put(warp, loc);
        LocationUtil.warps.saveConfig();
    }

    public static Location get(String warp) {
        Location location = getWarpList().get(warp);
        if (location == null) {
            double x = Double.parseDouble(LocationUtil.warps.getString(warp).split(":")[0]);
            double y = Double.parseDouble(LocationUtil.warps.getString(warp).split(":")[1]);
            double z = Double.parseDouble(LocationUtil.warps.getString(warp).split(":")[2]);
            float pitch = Float.parseFloat(LocationUtil.warps.getString(warp).split(":")[3]);
            float yaw = Float.parseFloat(LocationUtil.warps.getString(warp).split(":")[4]);
            World world = Bukkit.getServer().getWorld(LocationUtil.warps.getString(warp).split(":")[5]);
            Location loc = new Location(world, x, y, z, yaw, pitch);
            getWarpList().put(warp, loc);
            return loc;
        }
        return location;
    }

    public static void remove(String warp) {
        if (LocationUtil.warps.contains(warp)) {
            LocationUtil.warps.set(warp, null);
            getWarpList().remove(warp);
            LocationUtil.warps.saveConfig();
        }
    }

    public static boolean contains(String warp) {
        return getWarpList().containsKey(warp) || LocationUtil.warps.contains(warp);
    }

    public static Map<String, Location> getWarpList() {
        return LocationUtil.warpList;
    }

    static {
        LocationUtil.warps = new Config("config.yml");
        warpList = Maps.newConcurrentMap();
    }
}
