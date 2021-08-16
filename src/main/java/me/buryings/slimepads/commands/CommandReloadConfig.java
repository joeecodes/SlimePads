package me.buryings.slimepads.commands;

import me.buryings.slimepads.SlimePads;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReloadConfig implements CommandExecutor {

    private SlimePads plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("spreload")) {
            if (p.hasPermission("slimepads.reloadconfig")) {
                plugin.reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "settings.prefix " + "settings.config-reload"));
            } else {
                if (!(p.hasPermission("slimepads.reloadconfig"))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "settings.prefix " + "settings.no-permission"));
                }
            }

            return false;
        }
        return false;
    }

}
