package me.buryings.slimepads;

import lombok.Getter;
import lombok.Setter;
import me.buryings.slimepads.commands.CommandReloadConfig;
import me.buryings.slimepads.events.SlimePadEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimePads extends JavaPlugin {

    @Getter
    @Setter
    private static SlimePads instance;


    @Override
    public void onEnable() {
        setInstance(this);

        loadConfigFile();
        registerListeners();
        registerCommands();

        getLogger().info("[SLIMEPADS]: Slimepads is enabled");

    }


    @Override
    public void onDisable() {
        getLogger().info("[SLIMEPADS]: Slimepads is disabled");
    }

    public void loadConfigFile() {
        getLogger().info("[START-UP]: Loading configuration file...");
        this.getConfig().options().copyDefaults();
        saveConfig();
        saveDefaultConfig();

    }

    public void registerListeners() {
        getLogger().info("[START-UP]: Registering listeners...");
        Bukkit.getPluginManager().registerEvents(new SlimePadEvent(), this);
    }

    public void registerCommands() {
        getLogger().info("[START-UP]: Register commands...");
        getCommand("spreload").setExecutor(new CommandReloadConfig());
    }

}
