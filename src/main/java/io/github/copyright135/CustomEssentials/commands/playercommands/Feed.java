package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Feed extends PlayerCommand {

    public Feed(JavaPlugin plugin) {
        super(plugin);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if (super.onCommand(commandSender, command, s, strings)) {
            Player p = (Player) commandSender;

            p.setFoodLevel(20);
            p.sendMessage(Utils.chat(Utils.chat(config.getString("fed_message"))));

            return true;
        }

        return true;
    }

    public String getPermission() {
        return "customessentials.feed";
    }
}
