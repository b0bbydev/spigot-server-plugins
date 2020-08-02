package me.b0bbydev.testplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener
{
    @EventHandler
    void onPlayerLeave(PlayerQuitEvent e)
    {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.LIGHT_PURPLE + player.getDisplayName() + ChatColor.AQUA + " has left the server...");
    }// end of onPlayerLeave method.
}// end of class.
