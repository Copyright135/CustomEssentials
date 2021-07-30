package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Heal extends PlayerCommand {

    public Heal(JavaPlugin plugin) {
        super(plugin);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if (super.onCommand(commandSender, command, s, strings)) {

            Player p = (Player) commandSender;

            p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
            p.sendMessage(Utils.chat(config.getString("healed_message")));
            return true;
        }

        return true;
    }

    @Override
    public String getPermission() {
        return "customessentials.heal";
    }
}
