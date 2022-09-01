package com.artyx.lobby.commands;

import com.artyx.lobby.enums.Messages;
import lombok.val;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand {

    @Command(
            name = "gamemode",
            aliases = {"gm"},
            permission = "wand.gamemode",
            usage = "gamemode [modo] [jogador]"
    )

    public void handleGameMode(
            Context<CommandSender> context,
            Integer mode,
            @Optional Player target
    ) {
        val player = (Player) context.getSender();
        val gameMode = (GameMode) GameMode.getByValue(mode);

        if (gameMode == null) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cEste modo de jogo não existe."
            );
        }

        if (target == null) {
            player.setGameMode(gameMode);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§aModo de jogo alterado para §a§l" + gameMode.name()
            );
        } else if (target == player) {
            Messages.ERROR.sendMessage(
                    player,
                    "§cVocê não pode alterar o modo de jogo pra sí mesmo."
            );
        } else {
            target.setGameMode(gameMode);
            Messages.SUCCESS.sendMessage(
                    player,
                    "§aModo de jogo alterado de " + target.getName() + " §apara o modo §a§l" + gameMode.name()
            );
            Messages.SUCCESS.sendMessage(
                    target,
                    "§aSeu modo de jogo foi alterado para §a§l" + gameMode.name()
            );
        }

    }
}
