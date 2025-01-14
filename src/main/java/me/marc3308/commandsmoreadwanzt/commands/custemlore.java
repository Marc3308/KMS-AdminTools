package me.marc3308.commandsmoreadwanzt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class custemlore implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))return false;
        Player p=(Player) sender;

        if(p.getInventory().getItemInMainHand()==null || args.length!=1){
            return true;
        }

        ItemMeta phand=p.getInventory().getItemInMainHand().getItemMeta();
        ArrayList<String> a =new ArrayList();
        a.add(args[0]);
        phand.setLore(a);
        p.getInventory().getItemInMainHand().setItemMeta(phand);



        return true;
    }
}
