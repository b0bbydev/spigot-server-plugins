package me.b0bbydev.testplugin.commands;

import me.b0bbydev.testplugin.TestPluginMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPBowCommand implements CommandExecutor
{
    TestPluginMain plugin;

    public TPBowCommand(TestPluginMain plugin)
    {
        this.plugin = plugin;
    }// end of constructor.

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            plugin.giveBow(player);
        }// end of if.

        return true;
    }// end of onCommand method.
}// end of class.
