package me.b0bbydev.testplugin.events;

import me.b0bbydev.testplugin.TestPluginMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TPBowEvent implements Listener
{
    TestPluginMain plugin;

    public TPBowEvent(TestPluginMain plugin)
    {
        this.plugin = plugin;
    }// end of constructor.

    @EventHandler
    public void onBowShoot(ProjectileHitEvent e)
    {
        // saving the player who shot the bow.
        Player player = (Player) e.getEntity().getShooter();

        // setting the target location to the location off the arrow hit.
        Location location = e.getEntity().getLocation();

        // remove the entity from the HitEvent.
        e.getEntity().remove();

        // set the direction the player will face when getting to location.
        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());

        // teleport player to location.
        player.teleport(location);
        // play a sound when the player teleports.
        player.playSound(location, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0F, 1.0F);
        // send a message to the chat box when the player teleports. - Message can be configured from config.yml.
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-message")));
    }// end of onBowShoot method.
}// end of class.
