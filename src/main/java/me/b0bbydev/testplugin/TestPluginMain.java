/*
 * Name: Bobby Jonkman
 * Date: August 2nd, 2020 - 12:19pm
 * Purpose: Practice with Spigot plugins.
 */

package me.b0bbydev.testplugin;

import me.b0bbydev.testplugin.commands.*;
import me.b0bbydev.testplugin.events.PlayerJoin;
import me.b0bbydev.testplugin.events.PlayerLeave;
import me.b0bbydev.testplugin.events.TPBowEvent;
import me.b0bbydev.testplugin.events.TPBowOnSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class TestPluginMain extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // Setup config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // register the TPBow command.
        this.getCommand("tpbow").setExecutor(new TPBowCommand(this));

        // register the TPBow event.
        this.getServer().getPluginManager().registerEvents(new TPBowEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new TPBowOnSpawn(this), this);

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

    public void giveBow(Player player)
    {
        // create a teleport bow and arrow object.
        ItemStack teleport_bow = new ItemStack(Material.BOW);
        ItemStack arrow = new ItemStack(Material.ARROW);

        // set the meta of the bow.
        ItemMeta meta = teleport_bow.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-name")));

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-description")));
        meta.setLore(lore);
        teleport_bow.setItemMeta(meta);
        teleport_bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 999);
        player.getInventory().addItem(arrow);
        player.getInventory().addItem(teleport_bow);
    }// end of giveBow method.
}// end of class.
