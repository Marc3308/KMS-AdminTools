package me.marc3308.commandsmoreadwanzt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hatcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))return false;
        Player p = (Player) sender;
        if(p.getInventory().getItemInMainHand().getType().isAir())return false;
        if (p.getInventory().getHelmet() == null) {
            p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
            p.getInventory().setItemInMainHand(null);
        } else {
            p.getInventory().setItemInMainHand(p.getInventory().getHelmet());
            p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
        }
        p.sendMessage(ChatColor.GREEN+"Was für ein Cooler "+p.getInventory().getHelmet().getType()+" Hut");
        return false;
    }
}
