package io.github.copyright135.CustomEssentials;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new CommandHandler(this);
    }
}
