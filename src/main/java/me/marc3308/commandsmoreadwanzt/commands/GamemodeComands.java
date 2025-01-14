package me.marc3308.commandsmoreadwanzt.commands;

import me.marc3308.commandsmoreadwanzt.CommandsMoreAdwanzt;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeComands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p=(Player) sender;

            int Gm=Integer.parseInt(args[0]);

            int k=0;
            while (k<1000){
                k++;
                if(CommandsMoreAdwanzt.getcon(1).getString("gui"+"."+k)==null)break;
                if(CommandsMoreAdwanzt.getcon(1).getString("gui"+"."+k).equals(p.getName().toString()))p.setGameMode(Gm==1 ? GameMode.CREATIVE : Gm==2 ? GameMode.ADVENTURE : Gm==3 ? GameMode.SPECTATOR : Gm==0 ? GameMode.SURVIVAL : p.getGameMode());
                if(Gm>=1000){
                    p.setRemainingAir(Gm-1000);
                    return true;
                }
            }
        }
        return true;
    }
}
