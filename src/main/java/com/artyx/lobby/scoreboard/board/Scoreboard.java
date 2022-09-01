package com.artyx.lobby.scoreboard.board;

import com.artyx.lobby.LobbyPlugin;
import com.artyx.lobby.scoreboard.controller.Controller;
import com.artyx.lobby.utils.LuckPermsUtil;
import com.google.common.collect.Lists;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.List;

@RequiredArgsConstructor
public class Scoreboard {

    private final LobbyPlugin plugin;

    public void scoreboard() {
        Assemble assemble = new Assemble(plugin, new AssembleAdapter() {
            @Override
            public String getTitle(Player player) {
                return "§9§LREDE WAND §7#1";
            }

            @Override
            public List<String> getLines(Player player) {
                return Lists.newArrayList(
                        "",
                        " §fCargo: " + LuckPermsUtil.getColoredSuffixFrom(player, false),
                        "",
                        "  §a→ §fR. Machines: §e" + Controller.playerCountRHeads(player),
                        "",
                        " §fOnline: §e" + Controller.playersCount(player),
                        "",
                        "§7www.redewand.com"
                );
            }
        });
    }
}
