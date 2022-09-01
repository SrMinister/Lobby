package com.artyx.lobby.commands;

import com.artyx.lobby.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand {

    @Command(
            name = "tp",
            aliases = {"teleport"},
            permission = "artyx.tp",
            usage = "tp [jogador]"
    )

    public void handleTp(
            Context<CommandSender> context,
            Player target
    ) {

        val player = (Player) context.getSender();

        if (player == target) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cVocê não pode se teleportar pra sí mesmo."
            );
        } else if (target == null) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cEste jogador não existe ou não está online."
            );
        } else {
            player.teleport(target);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§aVocê foi teleportado para o jogador " + target.getName()
            );
        }
    }
}
