package me.b0bbydev.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // if person issuing command is a player.
        if(sender instanceof Player)
        {
            Player player = (Player) sender;

            // if user enters no args - which is incorrect usage - let them know.
            if(args.length == 0)
            {
                // printing a message to the chat box so the user can see how to use the commmand.
                player.sendMessage(ChatColor.RED + "You need to enter some arguments.");
                player.sendMessage(ChatColor.YELLOW + "To teleport yourself: /tp <otherplayer>");
                player.sendMessage(ChatColor.YELLOW + "To teleport others: /tp <player> <otherplayer>");
            }// end of if.

            // for teleporting yourself. (one args)
            else if(args.length == 1)
            {
                // target player.
                Player target = Bukkit.getPlayer(args[0]);

                // get the targets location and teleport them.
                try {
                    player.teleport(target.getLocation());
                } catch(NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "Player not found");
                }// end of try-catch.
            }// end of else-if.

            // for teleporting others.
            else if(args.length == 2)
            {
                // saving the player to send.
                Player playerToSend = Bukkit.getPlayer(args[0]);
                // target player.
                Player target = Bukkit.getPlayer(args[1]);

                // get the targets location and teleport them.
                try {
                    playerToSend.teleport(target.getLocation());
                } catch(NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "Player not found");
                }// end of try-catch.
            }// end of else-if.
        }// end of if.

        return true;
    }// end of onCommmand method.
}// end of class.
