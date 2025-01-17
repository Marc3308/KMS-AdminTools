package me.marc3308.commandsmoreadwanzt;

import me.marc3308.commandsmoreadwanzt.EventLiseners.DoDamage;
import me.marc3308.commandsmoreadwanzt.EventLiseners.GUI;
import me.marc3308.commandsmoreadwanzt.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CommandsMoreAdwanzt extends JavaPlugin implements Listener {

    private static CommandsMoreAdwanzt plugin;

    @Override
    public void onEnable() {

        plugin = this;


        getCommand("custlore").setExecutor(new custemlore());
        getCommand("custemid").setExecutor(new CustemModelDataCommand());
        getCommand("g").setExecutor(new GamemodeComands());
        getCommand("hat").setExecutor(new hatcommand());

        getCommand("gui").setExecutor(new GUIcommand());
        Bukkit.getPluginManager().registerEvents(new GUI(),this);
        Bukkit.getPluginManager().registerEvents(new DoDamage(),this);

        // Plugin startup logic
        File file = new File("plugins/KMS Plugins/MoreAdminTools","Einstellungen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        if(con.get("gui")==null){

            con.set("gui"+".1","Marc3308");

        }


        try {
            con.save(file);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }


    public static CommandsMoreAdwanzt getPlugin(){
        return plugin;
    }

    public static FileConfiguration getcon(Integer num){

        File file = new File("plugins/KMS Plugins/MoreAdminTools","Einstellungen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        return con;

    }
}
