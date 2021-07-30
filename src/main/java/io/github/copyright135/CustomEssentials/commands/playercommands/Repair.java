package io.github.copyright135.CustomEssentials.commands.playercommands;

import io.github.copyright135.CustomEssentials.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Repair extends PlayerCommand {

    public Repair(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = plugin.getConfig();

        if(super.onCommand(commandSender, command, s, strings)) {

            Player p = (Player) commandSender;

            for (ItemStack item : p.getInventory()) {

                if (item != null) {
                    Damageable meta = (Damageable) item.getItemMeta();
                    meta.setDamage(0);
                    item.setItemMeta((ItemMeta) meta);
                }

            }
            p.sendMessage(Utils.chat(config.getString("repaired_message")));
            return true;
        }
        return true;
    }

    @Override
    public String getPermission() {
        return "customessentials.repair";
    }
}
