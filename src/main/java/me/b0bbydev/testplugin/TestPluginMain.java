/*
 * Name: Bobby Jonkman
 * Date: August 2nd, 2020 - 12:19pm
 * Purpose: Practice with Spigot plugins.
 */

package me.b0bbydev.testplugin;

import me.b0bbydev.testplugin.commands.*;
import me.b0bbydev.testplugin.events.PlayerJoin;
import me.b0bbydev.testplugin.events.PlayerLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPluginMain extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // register the fly command.
        this.getCommand("fly").setExecutor(new ToggleFly());

        // register PlayerJoin and PlayerLeave events.
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeave(), this);

        // register the God Mode commands.
        this.getCommand("godModeOn").setExecutor(new GodModeOn());
        this.getCommand("godModeOff").setExecutor(new GodModeOff());

        // register the FullFood command
        this.getCommand("fullFood").setExecutor(new FullFood());

        // register the kill command.
        this.getCommand("kill").setExecutor(new KillTarget());

        // register the teleport command
        this.getCommand("tp").setExecutor(new Teleport());
    }// end of onEnable.
}// end of class.
