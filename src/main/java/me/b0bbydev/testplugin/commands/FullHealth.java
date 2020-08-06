package me.b0bbydev.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FullHealth implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // make sure the sender is a player.
        if(sender instanceof Player)
        {
            // cast the sender as a player.
            Player player = (Player) sender;

            // set their health to full.
            player.setHealth(20);

            // send a message to the chat box.
            player.sendMessage(ChatColor.GREEN + "Health refilled!");
        }// end of if.

        return true;
    }// end of onCommand method.
}// end of class.
