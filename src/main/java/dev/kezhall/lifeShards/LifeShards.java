package dev.kezhall.lifeShards;

import org.bukkit.plugin.java.JavaPlugin;

public final class LifeShards extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[LifeShards] Plugin has been enabled!");

    }

    @Override
    public void onDisable() {
        getLogger().info("[LifeShards] Plugin has been disabled!");
    }
}
