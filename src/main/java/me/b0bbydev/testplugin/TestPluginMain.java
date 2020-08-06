/*
 * Name: Bobby Jonkman
 * Date: August 2nd, 2020 - 12:19pm
 * Purpose: Practice with Spigot plugins.
 */

package me.b0bbydev.testplugin;

import me.b0bbydev.testplugin.commands.*;
import me.b0bbydev.testplugin.events.*;
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

        // register the FullHealth command.
        this.getCommand("fullHealth").setExecutor(new FullHealth());

        // register the OneKOSword command.
        this.getCommand("oneKOSword").setExecutor(new OneKOSword(this));
    }// end of onEnable.


    // make a method to give the player a tpbow.
    public void giveBow(Player player)
    {
        // create a bow and arrow object.
        ItemStack teleport_bow = new ItemStack(Material.BOW);
        ItemStack arrow = new ItemStack(Material.ARROW);

        // set the meta of the bow.
        ItemMeta meta = teleport_bow.getItemMeta();

        // make the bow unbreakable.
        meta.setUnbreakable(true);

        // set the name of the bow. - Which can be changed from config.yml.
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-name")));

        ArrayList<String> lore = new ArrayList<>();
        // lore is sort of like the description of the weapon. - This can be changed from config.yml.
        lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-description")));
        // set the lore and ItemMeta.
        meta.setLore(lore);
        teleport_bow.setItemMeta(meta);

        // make sure the bow can be fired infinitely.
        teleport_bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 999);

        // add an arrow and the bow to players inventory.
        player.getInventory().addItem(arrow);
        player.getInventory().addItem(teleport_bow);
    }// end of giveBow method.


    //make a method to give the player a one-hit sword.
    public void giveSword(Player player)
    {
        // create a sword object.
        ItemStack oneKOSword = new ItemStack(Material.NETHERITE_SWORD);

        // set the meta of the sword.
        ItemMeta meta = oneKOSword.getItemMeta();
        // make it unbreakable.
        meta.setUnbreakable(true);

        // set the name of the bow.
        meta.setDisplayName(ChatColor.DARK_RED + "One hitter bastard.");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Yes this sword is a beast...");
        meta.setLore(lore);
        oneKOSword.setItemMeta(meta);

        // add a crazy enchantment.
        oneKOSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 9999);

        // add the sword to the players inventory.
        player.getInventory().addItem(oneKOSword);
    }// end of giveSword method.
}// end of class.
