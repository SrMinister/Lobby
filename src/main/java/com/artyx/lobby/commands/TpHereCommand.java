package com.artyx.lobby.commands;

import com.artyx.lobby.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHereCommand {

    @Command(
            name = "tphere",
            aliases = {"puxar"},
            permission = "artyx.tphere",
            usage = "tphere [jogador]"
    )

    public void handleTpHere(
            Context<CommandSender> context,
            Player target
    ) {

        val player = (Player) context.getSender();

        if (player == target) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cVocê não pode puxar você mesmo."
            );
        } else if (target == null) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cEste jogador não existe ou não está online."
            );
        } else {
            target.teleport(player);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§aVocê puxou o jogador " + target.getName() +
                            "§a pra perto de você."
            );
        }

    }

}
