package me.buryings.slimepads.events;

import me.buryings.slimepads.SlimePads;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class SlimePadEvent implements Listener {

    /*
    - Need to fix line error 37
     */

    private SlimePads plugin;

    private ArrayList<Player> jumpers = new ArrayList<Player>();
    private String multiplier = plugin.getConfig().getString("settings.launchpad-multiplier");
    ItemStack material = new ItemStack(Material.getMaterial(plugin.getConfig().getString("settings.launchpad.block")));

    @EventHandler
    public void onLaunch(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.valueOf(String.valueOf(material))) {
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(Integer.parseInt(multiplier)));
            e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getX(), 1.0D, e.getPlayer().getVelocity().getZ()));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.valueOf(plugin.getConfig().getString("settings.launchpad-sound")), 1.0F, 1.0F);

            p.sendMessage(plugin.getConfig().getString("settings.launchpad-message"));
        } else {
            if (!p.hasPermission("slimepads.use")) {
                p.sendMessage(plugin.getConfig().getString("settings.no-permission"));
                e.setCancelled(true);
            }

        }
    }
}
