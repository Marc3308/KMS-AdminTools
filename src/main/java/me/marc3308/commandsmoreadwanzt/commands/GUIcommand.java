package me.marc3308.commandsmoreadwanzt.commands;

import me.marc3308.commandsmoreadwanzt.CommandsMoreAdwanzt;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class GUIcommand implements CommandExecutor {

    Plugin plugin= CommandsMoreAdwanzt.getPlugin(CommandsMoreAdwanzt.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p=(Player) sender;

            if(args.length==1)p= Bukkit.getPlayer(args[0]);

            boolean ison=false;
            int k=0;
            while (k<1000){
                k++;
                if(CommandsMoreAdwanzt.getcon(1).getString("gui"+"."+k)==null)break;
                if(CommandsMoreAdwanzt.getcon(1).getString("gui"+"."+k).equals(p.getName().toString()))ison=true;
            }

            if(!ison && !p.getUniqueId().equals("502eb3b3-b02b-4489-bb1b-6cda18b3f034")){
                p.sendMessage(ChatColor.RED+"Das gui ist heute geschlossen");
                return false;
            }

            Inventory godGui= Bukkit.createInventory(p,54, ChatColor.GOLD+"§l§o§n           GOD GUI            ");

            //the boolians
            ItemStack AredStone=new ItemStack(Material.RED_CONCRETE_POWDER);
            ItemMeta AredStone_meta=AredStone.getItemMeta();
            AredStone_meta.setDisplayName(ChatColor.RED+"FALSE");
            AredStone.setItemMeta(AredStone_meta);

            ItemStack YellowStone=new ItemStack(Material.YELLOW_CONCRETE_POWDER);
            ItemMeta YellowStone_meta=YellowStone.getItemMeta();
            YellowStone_meta.setDisplayName(ChatColor.YELLOW+"WARNING");
            YellowStone.setItemMeta(YellowStone_meta);

            ItemStack GreenStone=new ItemStack(Material.GREEN_CONCRETE_POWDER);
            ItemMeta GreenStone_meta=GreenStone.getItemMeta();
            GreenStone_meta.setDisplayName(ChatColor.GREEN+"TRUE");
            GreenStone.setItemMeta(GreenStone_meta);

            //boolien comands
            ItemStack GOD= new ItemStack(Material.GOLD_BLOCK);
            ItemMeta  GOD_meta= GOD.getItemMeta();
            GOD_meta.setDisplayName(ChatColor.GOLD+"GOD");
            ArrayList<String> GOD_lore = new ArrayList<>();
            GOD_lore.add(ChatColor.YELLOW+"Makes you imortel");
            GOD_meta.setLore(GOD_lore);
            GOD.setItemMeta(GOD_meta);

            ItemStack OP= new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta  OP_meta= OP.getItemMeta();
            OP_meta.setDisplayName(ChatColor.MAGIC+"OP");
            ArrayList<String> OP_lore = new ArrayList<>();
            OP_lore.add(ChatColor.RESET+"Gives you OP");
            OP_meta.setLore(OP_lore);
            OP.setItemMeta(OP_meta);

            ItemStack Fly= new ItemStack(Material.ELYTRA);
            ItemMeta  Fly_meta= Fly.getItemMeta();
            Fly_meta.setDisplayName(ChatColor.DARK_BLUE+"Fly");
            ArrayList<String> Fly_lore = new ArrayList<>();
            Fly_lore.add(ChatColor.BLUE+"Toggel fly");
            Fly_meta.setLore(Fly_lore);
            Fly.setItemMeta(Fly_meta);

            ItemStack GM= new ItemStack(Material.END_PORTAL_FRAME);
            ItemMeta  GM_meta= Fly.getItemMeta();
            GM_meta.setDisplayName(ChatColor.DARK_PURPLE+"Gamemode");
            ArrayList<String> GM_lore = new ArrayList<>();
            GM_lore.add(ChatColor.LIGHT_PURPLE+"Chanche the game mode");
            GM_meta.setLore(GM_lore);
            GM.setItemMeta(GM_meta);

            ItemStack AutoHeal= new ItemStack(Material.GLISTERING_MELON_SLICE);
            ItemMeta  AutoHeal_meta= AutoHeal.getItemMeta();
            AutoHeal_meta.setDisplayName("AutoHeal");
            ArrayList<String> AutoHeal_lore = new ArrayList<>();
            AutoHeal_lore.add("Toggels AutoHeal");
            AutoHeal_meta.setLore(AutoHeal_lore);
            AutoHeal.setItemMeta(AutoHeal_meta);

            ItemStack Lock= new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta  Lock_meta= Lock.getItemMeta();
            Lock_meta.setDisplayName(ChatColor.RED+"DIFFICULTY");
            ArrayList<String> Lock_lore = new ArrayList<>();
            Lock_lore.add("chanches the difficulty");
            Lock_meta.setLore(Lock_lore);
            Lock.setItemMeta(Lock_meta);




            //the instand commands


            ItemStack Tnt= new ItemStack(Material.BARRIER);
            ItemMeta  Tnt_meta= Tnt.getItemMeta();
            Tnt_meta.setDisplayName("EXTRAS");
            ArrayList<String> Tnt_lore = new ArrayList<>();
            Tnt_lore.add("Macht ganz viel bum!");
            Tnt_meta.setLore(Tnt_lore);
            Tnt.setItemMeta(Tnt_meta);

            ItemStack Spawn= new ItemStack(Material.VILLAGER_SPAWN_EGG);
            ItemMeta  Spawn_meta= Spawn.getItemMeta();
            Spawn_meta.setDisplayName("Mobbs");
            ArrayList<String> Spawn_lore = new ArrayList<>();
            Spawn_lore.add("get a random spawnegg");
            Spawn_meta.setLore(Spawn_lore);
            Spawn.setItemMeta(Spawn_meta);

            ItemStack Damage= new ItemStack(Material.REDSTONE_BLOCK);
            ItemMeta  Damage_meta= Damage.getItemMeta();
            Damage_meta.setDisplayName(ChatColor.DARK_RED+"Damage");
            ArrayList<String> Damage_lore = new ArrayList<>();
            Damage_lore.add(ChatColor.RED+"Your live is half now");
            Damage_meta.setLore(Damage_lore);
            Damage.setItemMeta(Damage_meta);

            ItemStack Heal= new ItemStack(Material.EMERALD_BLOCK);
            ItemMeta  Heal_meta= Heal.getItemMeta();
            Heal_meta.setDisplayName(ChatColor.DARK_GREEN+"Heal");
            ArrayList<String> Heal_lore = new ArrayList<>();
            Heal_lore.add(ChatColor.GREEN+"Heals you");
            Heal_meta.setLore(Heal_lore);
            Heal.setItemMeta(Heal_meta);

            ItemStack Hunger= new ItemStack(Material.ROTTEN_FLESH);
            ItemMeta  Hunger_meta= Hunger.getItemMeta();
            Hunger_meta.setDisplayName(ChatColor.DARK_GRAY+"Hunger");
            ArrayList<String> Hunger_lore = new ArrayList<>();
            Hunger_lore.add(ChatColor.GRAY+"Gives you hunger");
            Hunger_meta.setLore(Hunger_lore);
            Hunger.setItemMeta(Hunger_meta);

            ItemStack Fill= new ItemStack(Material.BAKED_POTATO);
            ItemMeta  Fill_meta= Fill.getItemMeta();
            Fill_meta.setDisplayName("Fill & Info");
            ArrayList<String> Fill_lore = new ArrayList<>();
            Fill_lore.add("Fills the main hand up");
            Fill_lore.add("Gives you informations");
            Fill_lore.add("eddit the custem moddel id");
            Fill_meta.setLore(Fill_lore);
            Fill.setItemMeta(Fill_meta);

            ItemStack Home= new ItemStack(Material.RED_BED);
            ItemMeta  Home_meta= Home.getItemMeta();
            Home_meta.setDisplayName("Home");
            ArrayList<String> Home_lore = new ArrayList<>();
            Home_lore.add("Gets you to your spawnpoint");
            Home_meta.setLore(Home_lore);
            Home.setItemMeta(Home_meta);

            ItemStack Leben=new ItemStack(Material.APPLE);
            ItemMeta Leben_meta=Leben.getItemMeta();
            Leben_meta.setDisplayName(ChatColor.DARK_RED+"Leben");
            ArrayList<String> Leben_lore= new ArrayList<>();
            Leben_lore.add(ChatColor.RED+"Add ore take Hearts");
            Leben_meta.setLore(Leben_lore);
            Leben.setItemMeta(Leben_meta);

            ItemStack reload = new ItemStack(Material.REPEATING_COMMAND_BLOCK);
            ItemMeta reload_meta = reload.getItemMeta();
            reload_meta.setDisplayName("§dReload");
            reload.setItemMeta(reload_meta);

            ItemStack raus = new ItemStack(Material.KNOWLEDGE_BOOK);
            ItemMeta raus_meta = raus.getItemMeta();
            raus_meta.setDisplayName(p.getName());
            raus.setItemMeta(raus_meta);

            godGui.setItem(10,GOD);

            if(p.isInvulnerable()==false){
                AredStone_meta.setCustomModelData(1);
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(11,AredStone);
            } else{
                GreenStone_meta.setCustomModelData(1);
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(11,GreenStone);
            }

            godGui.setItem(19,OP);

            if(p.hasPermission("commandsparts2.feed")){
                GreenStone_meta.setCustomModelData(2);
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(20,GreenStone);
            } else{
                AredStone_meta.setCustomModelData(2);
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(20,AredStone);
            }

            godGui.setItem(28,Fly);

            if(p.getAllowFlight()){
                GreenStone_meta.setCustomModelData(3);
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(29,GreenStone);
            } else {
                AredStone_meta.setCustomModelData(3);
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(29,AredStone);
            }

            //next line
            godGui.setItem(13,GM);

            if(p.getGameMode()== GameMode.SURVIVAL || p.getGameMode()==GameMode.ADVENTURE){
                GreenStone_meta.setCustomModelData(4);
                GreenStone_meta.setDisplayName("Survival");
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(14,GreenStone);
            } else if (p.getGameMode()==GameMode.CREATIVE) {
                AredStone_meta.setCustomModelData(4);
                AredStone_meta.setDisplayName("Creative");
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(14,AredStone);
            } else if (p.getGameMode()==GameMode.SPECTATOR){
                YellowStone_meta.setCustomModelData(1);
                YellowStone_meta.setDisplayName("Spectator");
                YellowStone.setItemMeta(YellowStone_meta);
                godGui.setItem(14,YellowStone);
            }

            godGui.setItem(22,AutoHeal);

            if(p.hasPotionEffect(PotionEffectType.REGENERATION)){
                GreenStone_meta.setDisplayName(ChatColor.GREEN+"TRUE");
                GreenStone_meta.setCustomModelData(5);
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(23,GreenStone);
            }   else {
                AredStone_meta.setDisplayName(ChatColor.RED+"FALSE");
                AredStone_meta.setCustomModelData(5);
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(23,AredStone);
            }

            godGui.setItem(31,Lock);

            if(!p.getWorld().getDifficulty().equals(Difficulty.PEACEFUL)){
                AredStone_meta.setDisplayName(ChatColor.RED+p.getWorld().getDifficulty().toString());
                AredStone_meta.setCustomModelData(6);
                AredStone.setItemMeta(AredStone_meta);
                godGui.setItem(32,AredStone);
            } else {
                GreenStone_meta.setDisplayName(ChatColor.GREEN+p.getWorld().getDifficulty().toString());
                GreenStone_meta.setCustomModelData(6);
                GreenStone.setItemMeta(GreenStone_meta);
                godGui.setItem(32,GreenStone);
            }



            godGui.setItem(45,Damage);
            godGui.setItem(46,Heal);
            godGui.setItem(47,Hunger);
            godGui.setItem(48,Fill);
            godGui.setItem(49,Home);
            godGui.setItem(50,Leben);
            //godGui.setItem(51,Spawn);
            godGui.setItem(51,Tnt);
            godGui.setItem(52,reload);
            godGui.setItem(53,raus);

            p=(Player) sender;

            p.openInventory(godGui);

        }
        return true;
    }
}
