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

        getCommand("gui").setExecutor(new GUIcommand());
        Bukkit.getPluginManager().registerEvents(new GUI(),this);
        Bukkit.getPluginManager().registerEvents(new DoDamage(),this);

        // Plugin startup logic
        File file = new File("plugins/KMS Plugins/MoreAdminTools","Einstellungen.yml");
        FileConfiguration con= YamlConfiguration.loadConfiguration(file);

        if(con.get("gui")==null){

            con.set("gui"+".1","Marc3308");
            con.set("texpack","https://download.mc-packs.net/pack/3d80aef1ccebaa8b89a55273c2780f39a1809e2b.zip");

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
