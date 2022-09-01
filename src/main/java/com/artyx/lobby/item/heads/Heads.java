package com.artyx.lobby.item.heads;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import com.mojang.authlib.*;
import com.mojang.authlib.properties.*;
import org.bukkit.inventory.meta.*;
import java.lang.reflect.*;

public class Heads {
    public static ItemStack ZOMBIE_AQUATIC;
    public static ItemStack GOLD_BLOCK;
    public static ItemStack CHEST;
    public static ItemStack PICKAXE;
    public static ItemStack EGG;
    public static ItemStack FISH;
    public static ItemStack BOOKSHELF;
    public static ItemStack EMERALD;
    public static ItemStack STONE;
    public static ItemStack MINING;
    public static ItemStack STORE;
    public static ItemStack MACHINES;

    static {

        PICKAXE = getSkull("http://textures.minecraft.net/texture/b6ea2135838461534372f2da6c862d21cd5f3d2c7119f2bb674bbd42791");
        STORE =  getSkull("http://textures.minecraft.net/texture/7e3deb57eaa2f4d403ad57283ce8b41805ee5b6de912ee2b4ea736a9d1f465a7");
        BOOKSHELF = getSkull("http://textures.minecraft.net/texture/7f6bf958abd78295eed6ffc293b1aa59526e80f54976829ea068337c2f5e8");
        STONE = getSkull("http://textures.minecraft.net/texture/8e646d878591c58c39f2d7a1daf01e1144544d465977eba5c3fe743b9fcf140");
        EGG = getSkull("http://textures.minecraft.net/texture/9419f15ff54dae5d040f9b9d8eb2a8989e676710922a0ca164da613ca61e9");
        EMERALD = getSkull("http://textures.minecraft.net/texture/25ba9789087b012307dd47de38c6622d75d6bb21eb97016c49afe9d700419909");
        MINING = getSkull("http://textures.minecraft.net/texture/11ed9abf51fe4ea84cfcb27297f1bc54cd382edf85e7bd6e75ecca2b806611");
        FISH = getSkull("http://textures.minecraft.net/texture/4a786e4e35b59d91eb6454ef26b7b0683761d6b11f1d63c7740af17aa3f");
        MACHINES = getSkull("http://textures.minecraft.net/texture/f4bb171a16f9e5fc05e7d4136e4931571126756620bd795951906a31a2ecaa29");
        GOLD_BLOCK = getSkull("http://textures.minecraft.net/texture/54bf893fc6defad218f7836efefbe636f1c2cc1bb650c82fccd99f2c1ee6");
        CHEST = getSkull("http://textures.minecraft.net/texture/4cd3c45d7b8384e8a1963e4da0ae6b2daeb2a3e97ac7a28f9eb3d3959725799f");
        ZOMBIE_AQUATIC = getSkull("http://textures.minecraft.net/texture/c3f7ccf61dbc3f9fe9a6333cde0c0e14399eb2eea71d34cf223b3ace22051");
    }

    private static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }
}