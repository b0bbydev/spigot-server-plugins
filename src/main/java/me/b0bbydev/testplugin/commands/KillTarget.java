package me.b0bbydev.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillTarget implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // if person issuing command is a player.
        if(sender instanceof Player)
        {
            // casting the sender as Player
            Player player = (Player) sender;

            // throws ArrayIndexOutOfBounds without this when trying to use JUST '/kill'.
            try
            {
                if (args[0].equalsIgnoreCase("me"))
                {
                    // display a message to the chat box.
                    player.sendMessage("You have killed " + ChatColor.RED + "yourself");
                    // set their health to 0.
                    player.setHealth(0);
                }// end of if.
                else
                {
                    // if the argument isn't 'me', set it to the target.
                    Player target = Bukkit.getPlayerExact(args[0]);

                    // make sure the target is a player.
                    if (target instanceof Player)
                    {
                        // Send a message to the chat box.
                        target.sendMessage("You have been killed by " + ChatColor.RED + player.getDisplayName());
                        // set their health to 0.
                        target.setHealth(0);
                    }// end of if.
                }// end of else.
            }// end of try.
                catch(ArrayIndexOutOfBoundsException e) {
                player.sendMessage("Please provide a target. Usage: /kill " + ChatColor.YELLOW + "<target>");
                }// end of catch.
            }// end of if.

        return true;
    }// end of onCommand method.
}// end of class.
