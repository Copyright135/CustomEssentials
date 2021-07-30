package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ToggleCreative extends PlayerCommand {

    public ToggleCreative(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if(super.onCommand(commandSender, command, s, strings)) {
            Player p = (Player) commandSender;

            if (p.getGameMode() == GameMode.CREATIVE) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Utils.chat(config.getString("creative.disabled")));
            } else {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Utils.chat(config.getString("creative.enabled")));
            }
            return true;
        }
        return true;
    }

    @Override
    public String getPermission() {
        return "customessentials.creative";
    }
}
