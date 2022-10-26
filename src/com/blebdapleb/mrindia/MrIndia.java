package com.blebdapleb.mrindia;

import com.blebdapleb.mrindia.commands.*;
import com.blebdapleb.mrindia.commands.economy.*;
import com.blebdapleb.mrindia.commands.guis.InvseeCommand;
import com.blebdapleb.mrindia.commands.keys.CrateSystem;
import com.blebdapleb.mrindia.commands.keys.CratesCommand;
import com.blebdapleb.mrindia.commands.keys.GivekeyCommand;
import com.blebdapleb.mrindia.commands.keys.KeysCommand;
import com.blebdapleb.mrindia.listeners.PlayerDeathListener;
import com.blebdapleb.mrindia.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MrIndia extends JavaPlugin {

    FileConfiguration economyConfig;
    FileConfiguration keysConfig;

    private static MrIndia instance;

    public static MrIndia getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        loadEconomyConfig();
        loadKeysConfig();

        instance = this;


        // Commands
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        // Commands involving GUI
        getCommand("invsee").setExecutor(new InvseeCommand());
        // Gamemode commands
        getCommand("gms").setExecutor(new GmsCommand());
        getCommand("gmc").setExecutor(new GmcCommand());
        getCommand("gmsp").setExecutor(new GmspCommand());
        // Economy commands
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("setmoney").setExecutor(new SetmoneyCommand());
        getCommand("addmoney").setExecutor(new AddmoneyCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
        // Key commands
        getCommand("givekey").setExecutor(new GivekeyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("keys").setExecutor(new KeysCommand());
        CrateSystem crateSystem = new CrateSystem();

        getCommand("crates").setExecutor(new CratesCommand(crateSystem));
        // Events
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(crateSystem, this);
        // Economy events
        Bukkit.getPluginManager().registerEvents(new RedeemMoney(), this);

        getLogger().info("MrIndia Core is enabled!");

    }

    @Override
    public void onDisable() {

        getLogger().info("MrIndia Core is disabled!");

        // Economy config
        File economy = new File(getDataFolder(), "economy.yml");
        try {
            economyConfig.save(economy);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // Keys config
        File keys = new File(getDataFolder(), "keys.yml");
        try {
            keysConfig.save(keys);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    // Economy

    public void loadEconomyConfig(){

        if (!getDataFolder().exists()) {

            getDataFolder().mkdirs();

        }

        File economy = new File(getDataFolder(), "economy.yml");
        economyConfig = YamlConfiguration.loadConfiguration(economy);
        try {
            economyConfig.save(economy);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public FileConfiguration getEconomyConfig() {

        return economyConfig;

    }

    public void loadKeysConfig(){

        if(!getDataFolder().exists()){

            getDataFolder().mkdirs();

        }

        File keys = new File(getDataFolder(), "keys.yml");
        keysConfig = YamlConfiguration.loadConfiguration(keys);
        try {
            keysConfig.save(keys);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    public FileConfiguration getKeysConfig(){

        return keysConfig;

    }
}
