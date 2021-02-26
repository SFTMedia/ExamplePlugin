package com.blalp.exampleplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExampleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // When accepting user input, make sure to check to make sure they formatted their message correctly.

        // Permission nodes should start with your plugins' name, then followed with a reasonably named subkey (like run)
        // If you have a lot of permission nodes, consider grouping them (like group in this example)
        if(sender.hasPermission("exampleplugin.group.run")) {
            // Some commands only make sense to run as a player
            if (sender instanceof Player) {
                Inventory inv = Bukkit.getServer().createInventory(new CustomInvetoryHolder(),1,"My Custom Invetory");
                ItemStack item = new ItemStack(Material.DIAMOND);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Congratulations!");
                item.setItemMeta(meta);
                ItemStack[] items = new ItemStack[]{item};
                inv.setContents(items);
                // This cast is safe, as we already checked to make sure sender was a player.
                ((Player)sender).openInventory(inv);
            } else {
                // This will trigger if a non-player (like console) tries to run the command.
                sender.sendMessage("You must be a player to open custom inventories");
            }
            // Return true if the command executed successfully
            return true;
        }
        // Return false to have bukkit show the usage of the command to the player.
        return false;
    }
    
}
