package me.b0bbydev.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodModeOff implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // if person issuing command is a player.
        if(sender instanceof Player)
        {
            // casting the sender to a player.
            Player player = (Player) sender;
            // toggle God Mode.
            player.setInvulnerable(false);
            // print message to chat box.
            sender.sendMessage(ChatColor.RED + "God Mode disabled!");
        }// end of if.

        return true;
    }// end of onCommand method.
}// end of class.