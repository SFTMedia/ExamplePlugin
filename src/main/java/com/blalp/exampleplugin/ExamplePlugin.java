package com.blalp.exampleplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("examplecommand").setExecutor(new ExampleCommand());
        getServer().getPluginManager().registerEvents(new ItemListener(), this);
    }
    @Override
    public void onDisable() {
        // When the plugin is disabled make sure no one still has the inventory open, as the listeners that stop them from grabbing items are removed on unload.
        for(Player player : getServer().getOnlinePlayers()) {
            if(player.getOpenInventory().getTopInventory().getHolder() instanceof CustomInvetoryHolder) {
                player.closeInventory();
            }
        }
    }
}
