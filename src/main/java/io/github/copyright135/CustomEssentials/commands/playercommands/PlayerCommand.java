package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PlayerCommand implements CommandExecutor {

    JavaPlugin plugin;

    public PlayerCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat(config.getString("sender_not_player")));
            return false;
        }

        Player p = (Player) commandSender;

        if (!p.hasPermission(getPermission()) && !p.isOp()) {
            commandSender.sendMessage(Utils.chat(config.getString("insufficient_permission")));
            return false;
        }

        return true;
    }

    public abstract String getPermission();
}
