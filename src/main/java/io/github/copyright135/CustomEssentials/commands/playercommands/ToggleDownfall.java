package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ToggleDownfall extends PlayerCommand {

    public ToggleDownfall(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if (super.onCommand(commandSender, command, s, strings)) {
            Player p = (Player) commandSender;
            World world = p.getWorld();

            if (world.hasStorm()) {
                world.setStorm(false);
                p.sendMessage(Utils.chat(config.getString("downfall.disabled")));
            } else {
                world.setStorm(true);
                p.sendMessage(Utils.chat(config.getString("downfall.enabled")));
            }
            return true;
        }

        return true;
    }

    @Override
    public String getPermission() {
        return "customessentials.toggledownfall";
    }
}
