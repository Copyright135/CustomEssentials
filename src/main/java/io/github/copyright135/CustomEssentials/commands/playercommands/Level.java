package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Level extends PlayerCommand {

    public Level(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if(super.onCommand(commandSender, command, s, strings)) {
            Player p = (Player) commandSender;

            if (strings.length == 0) {
                p.giveExpLevels(1);
            } else {
                int amount;
                try {
                    amount = parseExpLevels(strings[0]);
                    p.giveExpLevels(amount);
                } catch (NumberFormatException e) {
                    p.sendMessage(Utils.chat(config.getString("level.invalid_level_arg")));
                    return false;
                }
                p.sendMessage(Utils.chat(config.getString("level.leveled").replace("<amount>", String.valueOf(amount))));
            }
            return true;
        }
        return true;
    }

    private int parseExpLevels(String string) {
        return Integer.parseInt(string);
    }

    @Override
    public String getPermission() {
        return "customessentials.level";
    }
}
