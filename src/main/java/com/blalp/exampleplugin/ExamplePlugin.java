package com.blalp.exampleplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("examplecommand").setExecutor(new ExampleCommand());
    }
}
