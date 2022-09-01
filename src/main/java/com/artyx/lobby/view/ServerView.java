package com.artyx.lobby.view;

import com.artyx.lobby.controller.BungeeController;
import com.artyx.lobby.enums.Messages;
import com.artyx.lobby.item.heads.Heads;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;

public class ServerView extends View {
    public ServerView() {
        super(4, "Servidores");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }

    @Override
    protected void onRender(ViewContext context) {

        int playerCountRHeads = BungeeController.getServerCount("rankup-1");
        slot(13).onRender(slot -> {
            slot.setItem(
                    new com.artyx.lobby.item.ItemBuilder(
                            Heads.MACHINES
                    ).name(
                            "§bRankUP Machines"
                    ).lore(
                            "§7Algumas novidades sobre o",
                            "§7servidor.",
                            "",
                            "§8 ► §fMaquinas;",
                            "§8 ► §fCrates;",
                            "§8 ► §fPescaria;",
                            "§8 ► §fEvoluções;",
                            "§8 ► §fentre outros;",
                            "",
                            "§aClique para se conectar §7(" + playerCountRHeads + "§7)"
            ).build());
        }).onClick((handler -> {
            BungeeController.sendServer(context.getPlayer(), "rankup-1");

        }));

        slot(31).onRender(slot -> {
            slot.setItem(
                    new ItemBuilder(
                            Material.SIGN
                    ).name(
                            "§eWebSite"
                    ).lore(
                            "§7Adquira suas vantagens em nosso",
                            "§7web site acessando:",
                            "",
                            "§8 ➟ §fwww.redewand.com",
                            ""
                    ).build()
            );
        }).onClick((handler -> {
            Messages.SUCCESS.sendMessage(
                    context.getPlayer(),
                    "§eWebSite: §8➟ §fwww.redewand.com"
            );
            context.getPlayer().closeInventory();
        }));

    }
}
