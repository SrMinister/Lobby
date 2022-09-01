package com.artyx.lobby.commands;

import com.artyx.lobby.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand {

    @Command(
            name = "invsee",
            aliases = {"inventory", "inventario"},
            permission = "wand.invsee",
            usage = "invsee [jogador]"
    )

    public void handleInventory(
            Context<CommandSender> context,
            Player target
    ) {

        val player = (Player) context.getSender();

        if (player == null) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cEste jogador não existe ou não está online."
            );
        } else {
            player.openInventory(target.getInventory());
        }

    }
}
