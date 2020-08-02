package me.b0bbydev.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleFly implements CommandExecutor
{
    // String[] strings is the words after the "/fly". (in-game command arguments)
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        // if the sender is a Player and no in-game args are used. ex: /fly
        if(sender instanceof Player && args.length == 0)
        {
            // casts sender as player. Allows the command to be used without args and on-self.
            Player player = (Player) sender;

            // toggle flight.
            player.setAllowFlight(!player.getAllowFlight());

            // print a message to chat box telling player when /fly is enabled.
            if(player.getAllowFlight())
            {
                sender.sendMessage(ChatColor.GREEN + "Self flight enabled!");
            } else {
                sender.sendMessage(ChatColor.RED + "Self flight disabled!");
            }// end of if-else.
        }// end of if.

        // if command as args. ex: /fly <playername>.
        else if(args.length >= 1)
        {
            Player player = Bukkit.getPlayer(args[0]);

            // if player doesn't exist or isn't present in server.
            if(player == null)
            {
                sender.sendMessage(ChatColor.RED + "This player does not exist!");
            }// end of if.

            // toggle flight.
            player.setAllowFlight(!player.getAllowFlight());

            // print the flight status of the player to chat.
            if(player.getAllowFlight())
            {
                sender.sendMessage(ChatColor.GREEN + "Flight status for: " + player.getName() + " " + player.getAllowFlight());
            } else {
                sender.sendMessage(ChatColor.RED + "Flight status for: " + player.getName() + " " + player.getAllowFlight());
            }// end of if-else.
        }// end of else-if.
        else
        {
            sender.sendMessage(ChatColor.RED + "You have to be a player, or specified player to use this command!");
        }// end of else.

        return true;
    }// end of onCommand method.
}// end of class.
