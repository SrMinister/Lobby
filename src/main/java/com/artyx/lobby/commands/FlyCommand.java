package com.artyx.lobby.commands;

import com.artyx.lobby.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand {

    @Command(
            name = "fly",
            aliases = {"voar"},
            permission = "artyx.fly",
            usage = "fly [jogador]"
    )

    public void handleFly(
            Context<CommandSender> context,
            @Optional Player target
    ) {

        val player = (Player) context.getSender();

        if (target == null) {
            if (!player.isFlying()) {
                player.setAllowFlight(true);
                Messages.SUCCESS.sendMessage(
                        player,
                        "§aVoô ativado."
                );
                return;
            }
            player.setAllowFlight(false);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§cVoô desativado."
            );
        } else {
            if (!target.isFlying()) {
                target.setAllowFlight(true);
                Messages.SUCCESS.sendMessage(
                        player,
                        "§aVocê ativou o modo de voô para " + target.getName()
                );
                Messages.SUCCESS.sendMessage(
                        target,
                        "§aVoô ativado."
                );
                return;
            }

            target.setAllowFlight(false);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§cVocê desativou o modo de voô para " + target.getName()
            );
            Messages.SUCCESS.sendMessage(
                    player,
                    "§cVoô desativado."
            );
        }
    }
}
