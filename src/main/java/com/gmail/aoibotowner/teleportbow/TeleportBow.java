package com.gmail.aoibotowner.teleportbow;

import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    private static TeleportBow plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(new ShootBowEvent(), this);
        getPlugin().getCommand("getbow").setExecutor(new GetBowCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TeleportBow getPlugin() {
        return plugin;
    }
}
