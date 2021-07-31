package io.github.copyright135.CustomEssentials;
import io.github.copyright135.CustomEssentials.commands.playercommands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler {

    private final JavaPlugin plugin;

    public CommandHandler(JavaPlugin plugin) {
        this.plugin = plugin;
        loadCommands();
    }

    private void loadCommands() {
        plugin.getCommand("heal").setExecutor(new Heal(plugin));
        plugin.getCommand("feed").setExecutor(new Feed(plugin));
        plugin.getCommand("fly").setExecutor(new Fly(plugin));
        plugin.getCommand("toggledownfall").setExecutor(new ToggleDownfall(plugin));
        plugin.getCommand("togglecreative").setExecutor(new ToggleCreative(plugin));
        plugin.getCommand("level").setExecutor(new Level(plugin));
        plugin.getCommand("repair").setExecutor(new Repair(plugin));
    }
}
