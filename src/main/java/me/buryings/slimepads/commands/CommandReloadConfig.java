package me.buryings.slimepads.commands;

import me.buryings.slimepads.SlimePads;
import me.buryings.slimepads.ui.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReloadConfig implements CommandExecutor {

    private final SlimePads plugin;

    public CommandReloadConfig() {
        this.plugin = SlimePads.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.hasPermission("slimepads.reloadconfig")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.NO_PERMS));
            return true;
        }

        plugin.reloadConfig();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CONFIG_RELOAD));
        return true;
    }

}
