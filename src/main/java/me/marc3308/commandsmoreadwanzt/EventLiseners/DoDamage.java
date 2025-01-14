package me.marc3308.commandsmoreadwanzt.EventLiseners;

import me.marc3308.commandsmoreadwanzt.CommandsMoreAdwanzt;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class DoDamage implements Listener {

    Plugin plugin = CommandsMoreAdwanzt.getPlugin(CommandsMoreAdwanzt.class);

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {


        if (e.getDamager() instanceof Player) {
            dodamage((Player)e.getDamager(),e);
        }
    }

    public void dodamage(Player p, EntityDamageByEntityEvent e){

        if(!p.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER)){
            p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER,1);
        }

        int extradamage=p.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER);

        e.setDamage(e.getDamage()*extradamage);

    }
}
