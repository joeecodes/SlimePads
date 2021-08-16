package me.buryings.slimepads.events;

import me.buryings.slimepads.SlimePads;
import me.buryings.slimepads.ui.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SlimePadEvent implements Listener {

    private SlimePads plugin;
    private FileConfiguration c = plugin.getConfig();
    // private ArrayList<Player> jumpers = new ArrayList<>();
    ItemStack material = new ItemStack(Material.getMaterial(c.getString("launchpad-block")));

    public SlimePadEvent() {
        this.plugin = SlimePads.getInstance();
    }

    @EventHandler
    public boolean onLaunch(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != Material.valueOf(String.valueOf(material)))
            return true;
        if (!p.hasPermission("slimepads.use")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.NO_PERMS));
            return true;
        }
        playerLaunch(e.getPlayer(), c.getString("launchpad-multiplier"));

        return true;
    }

    private void playerLaunch(Player p, String multiplier) {
        p.setVelocity(p.getLocation().getDirection().multiply(Integer.parseInt(multiplier)));
        p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
        p.playSound(p.getLocation(), Sound.valueOf(c.getString("settings.launchpad-sound")), 1.0F, 1.0F);
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.LAUNCHPAD_SUCCESS));
    }
}
