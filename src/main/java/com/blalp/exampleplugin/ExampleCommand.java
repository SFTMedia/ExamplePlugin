package com.blalp.exampleplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ExampleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // When accepting user input, make sure to check to make sure they formatted their message correctly.

        // Permission nodes should start with your plugins' name, then followed with a reasonably named subkey (like run)
        // If you have a lot of permission nodes, consider grouping them (like group in this example)
        if(sender.hasPermission("exampleplugin.group.run")) {
            // Remember to inform the user if the command completed successfully
            sender.sendMessage("Completed successfully!");
            // Return true if the command executed successfully
            return true;
        }
        // Return false to have bukkit show the usage of the command to the player.
        return false;
    }
    
}
