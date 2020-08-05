package me.b0bbydev.testplugin.events;

import me.b0bbydev.testplugin.TestPluginMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class TPBowOnSpawn implements Listener
{
    TestPluginMain plugin;

    public TPBowOnSpawn(TestPluginMain plugin)
    {
        this.plugin = plugin;
    }// end of constructor.

    @EventHandler
    public void onSpawnEvent(PlayerJoinEvent e)
    {
        if(plugin.getConfig().getBoolean("give-bow-on-join"))
        {
            Player player = e.getPlayer();
            if(player.hasPermission("tpbow.join"))
            {
                plugin.giveBow(player);
            }// end of if.
        }// end of if.
    }// end of onSpawnEvent method.
}// end of class.
