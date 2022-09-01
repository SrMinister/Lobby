package com.artyx.lobby.view;

import com.artyx.lobby.enums.Messages;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;


public class LobbyView extends View {
    public LobbyView() {
        super(3, "Saguões");
        setCancelOnClick(true);
        setCancelOnPickup(true);
    }
    @Override
    protected void onRender(ViewContext context) {
        slot(10).onRender(slot -> {
            slot.setItem(
                    new ItemBuilder(
                            Material.NETHER_STAR
                    ).name(
                            "§aSaguão #1"
                    ).lore(
                            "§cVocê já está neste saguão!"
                    ).build()
            );
        }).onClick((handler -> {
            Messages.ERROR.sendMessage(
                    context.getPlayer(),
                    "§cVocê já está neste saguão!"
            );
            context.getPlayer().closeInventory();
        }));

        slot(11).onRender(slot -> {
            slot.setItem(
                    new ItemBuilder(
                            Material.NETHER_STAR
                    ).name(
                            "§aSaguão #2"
                    ).lore(
                            "§fOnline:§e 0",
                            "",
                            "§eClique para se conectar."
                    ).build()
            );
        }).onClick((handler -> {
            Messages.SUCCESS.sendMessage(
                    context.getPlayer(),
                    "§cSaguão #2 está em manutenção!"
            );
            context.getPlayer().closeInventory();
        }));
    }

}
