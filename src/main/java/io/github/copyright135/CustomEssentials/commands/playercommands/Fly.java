package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fly extends PlayerCommand {

    public Fly(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if (super.onCommand(commandSender, command, s, strings)) {
            Player p = (Player) commandSender;

            // Toggle flight
            if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) {
                p.sendMessage(Utils.chat(config.getString("fly.invalid_gamemode")));
            } else if (p.getAllowFlight() == true) {
                p.setFlying(false);
                p.setAllowFlight(false);
                p.sendMessage(Utils.chat(config.getString("fly.disabled")));
            } else {
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage(Utils.chat(config.getString("fly.enabled")));
            }
            return true;
        }

        return true;
    }

    public String getPermission() {
        return "customessentials.fly";
    }
}
