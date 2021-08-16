package me.buryings.slimepads.ui;

import org.bukkit.configuration.file.FileConfiguration;

public class Messages {

    private static final FileConfiguration c = new ConfigUtils("config").getConfig();

    public static String NO_PERMS = c.getString("settings.no-permissions");
    public static String CONFIG_RELOAD = c.getString("settings.config-reload");
    public static String LAUNCHPAD_SUCCESS = c.getString("settings.launchpad-message");


}
