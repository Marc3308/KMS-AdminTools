package me.marc3308.commandsmoreadwanzt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class CustemModelDataCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p=(Player) sender;

        if(p.getInventory().getItemInMainHand()==null || args.length!=1){
            return true;
        }


        ItemMeta phand=p.getInventory().getItemInMainHand().getItemMeta();
        int a=Integer.parseInt(args[0]);
        phand.setCustomModelData(a);
        p.getInventory().getItemInMainHand().setItemMeta(phand);



        return true;
    }
}
