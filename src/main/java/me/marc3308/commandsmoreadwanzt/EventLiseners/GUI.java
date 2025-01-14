package me.marc3308.commandsmoreadwanzt.EventLiseners;

import me.marc3308.commandsmoreadwanzt.CommandsMoreAdwanzt;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GUI implements Listener {

    Plugin plugin = CommandsMoreAdwanzt.getPlugin(CommandsMoreAdwanzt.class);

    @EventHandler
    public void onGUI(InventoryClickEvent e) {


        //god gui
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "§l§o§n           GOD GUI            ")) {

            Player p=Bukkit.getPlayer(e.getView().getItem(53).getItemMeta().getDisplayName());

            //Player p = (Player) e.getWhoClicked();
            ItemStack off = p.getInventory().getItemInOffHand();

            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item == null) return;


            ItemStack AredStone = new ItemStack(Material.RED_CONCRETE_POWDER);
            ItemMeta AredStone_meta = AredStone.getItemMeta();
            AredStone_meta.setDisplayName(ChatColor.RED + "FALSE");
            AredStone.setItemMeta(AredStone_meta);

            ItemStack YellowStone = new ItemStack(Material.YELLOW_CONCRETE_POWDER);
            ItemMeta YellowStone_meta = YellowStone.getItemMeta();
            YellowStone_meta.setDisplayName(ChatColor.YELLOW + "WARNING");
            YellowStone.setItemMeta(YellowStone_meta);

            ItemStack GreenStone = new ItemStack(Material.GREEN_CONCRETE_POWDER);
            ItemMeta GreenStone_meta = GreenStone.getItemMeta();
            GreenStone_meta.setDisplayName(ChatColor.GREEN + "TRUE");
            GreenStone.setItemMeta(GreenStone_meta);

            ItemStack remove = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta remove_meta = remove.getItemMeta();
            remove_meta.setDisplayName(ChatColor.RED + "REMOVE");
            remove.setItemMeta(remove_meta);

            ItemStack add = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta add_meta = add.getItemMeta();
            add_meta.setDisplayName(ChatColor.GREEN + "ADD");
            add.setItemMeta(add_meta);

            ItemStack back = new ItemStack(Material.BOOK);
            ItemMeta back_meta = back.getItemMeta();
            back_meta.setDisplayName(p.getName());
            back.setItemMeta(back_meta);


            switch (e.getCurrentItem().getType()) {

                case RED_CONCRETE_POWDER:

                    if (item.getItemMeta().hasCustomModelData() == false) return;

                    if (item.getItemMeta().getCustomModelData() == 1) {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "Du bist jetzt unverwundbahr");
                        GreenStone_meta.setCustomModelData(1);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(11, GreenStone);
                    } else if (item.getItemMeta().getCustomModelData() == 2) {
                        if (p.getName().equals("Marc3308") || (p.getName().equals("Naomi_Keks")) || (p.getName().equals("AiwendilBraun")) ||p.getName().equals("Milkaa__")) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "op " + p.getName());
                            GreenStone_meta.setCustomModelData(2);
                            GreenStone.setItemMeta(GreenStone_meta);
                            e.getView().setItem(20, GreenStone);
                        } else {
                            p.sendMessage(ChatColor.RED + "You dont have the permision to do that <3");
                        }
                    } else if (item.getItemMeta().getCustomModelData() == 3) {
                        p.setAllowFlight(true);
                        p.setFlySpeed(10);
                        GreenStone_meta.setCustomModelData(3);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(29, GreenStone);

                    } else if (item.getItemMeta().getCustomModelData() == 4) {
                        p.setGameMode(GameMode.SURVIVAL);
                        GreenStone_meta.setCustomModelData(4);
                        GreenStone_meta.setDisplayName("Survival");
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(14, GreenStone);

                        AredStone_meta.setCustomModelData(3);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(29, AredStone);
                    } else if (item.getItemMeta().getCustomModelData() == 5) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2 * 60 * 60 * 20, 6, false, false));
                        GreenStone_meta.setCustomModelData(5);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(23, GreenStone);
                    } else if (item.getItemMeta().getCustomModelData() == 6) {

                        p.getWorld().setDifficulty(Difficulty.PEACEFUL);
                        GreenStone_meta.setDisplayName(ChatColor.GREEN+p.getWorld().getDifficulty().toString());
                        GreenStone_meta.setCustomModelData(6);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(32, GreenStone);
                    }

                    break;
                case GREEN_CONCRETE_POWDER:

                    if (item.getItemMeta().hasCustomModelData() == false) return;

                    if (item.getItemMeta().getCustomModelData() == 1) {
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "Du bist nicht mehr unverwundbahr");
                        AredStone_meta.setCustomModelData(1);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(11, AredStone);
                    } else if (item.getItemMeta().getCustomModelData() == 2) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "deop " + p.getName());
                        AredStone_meta.setCustomModelData(2);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(20, AredStone);
                    } else if (item.getItemMeta().getCustomModelData() == 3) {
                        p.setAllowFlight(false);
                        AredStone_meta.setCustomModelData(3);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(29, AredStone);
                    } else if (item.getItemMeta().getCustomModelData() == 4) {
                        p.setGameMode(GameMode.SPECTATOR);
                        YellowStone_meta.setCustomModelData(1);
                        YellowStone_meta.setDisplayName("Spectator");
                        YellowStone.setItemMeta(YellowStone_meta);
                        e.getView().setItem(14, YellowStone);

                        GreenStone_meta.setCustomModelData(3);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(29, GreenStone);
                    } else if (item.getItemMeta().getCustomModelData() == 5) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect clear " + p.getName() + " minecraft:regeneration");
                        AredStone_meta.setCustomModelData(5);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(23, AredStone);
                    } else if (item.getItemMeta().getCustomModelData() == 6) {

                        p.getWorld().setDifficulty(Difficulty.HARD);
                        AredStone_meta.setDisplayName(ChatColor.RED+p.getWorld().getDifficulty().toString());
                        AredStone_meta.setCustomModelData(6);
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(32, AredStone);
                    }
                    break;
                case YELLOW_CONCRETE_POWDER:

                    if (item.getItemMeta().hasCustomModelData() == false) return;

                    if (item.getItemMeta().getCustomModelData() == 1) {
                        p.setGameMode(GameMode.CREATIVE);
                        AredStone_meta.setCustomModelData(4);
                        AredStone_meta.setDisplayName("Creative");
                        AredStone.setItemMeta(AredStone_meta);
                        e.getView().setItem(14, AredStone);

                        GreenStone_meta.setCustomModelData(3);
                        GreenStone.setItemMeta(GreenStone_meta);
                        e.getView().setItem(29, GreenStone);
                    }
                    break;
                case REDSTONE_BLOCK:
                    p.setHealth(p.getHealth() / 2);
                    p.sendMessage(ChatColor.DARK_RED + "You have now: " + ChatColor.RED + p.getHealth() + ChatColor.DARK_RED + " Harts");
                    break;
                case EMERALD_BLOCK:
                    p.setHealth(p.getMaxHealth());
                    p.setFoodLevel(20);
                    p.setSaturation(40);
                    p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    p.sendMessage(ChatColor.DARK_GREEN + "Dein Leben beträgt nun: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    p.sendMessage(ChatColor.DARK_GREEN + "Deine Essens leiste beträgt nun: " + ChatColor.GREEN + p.getFoodLevel());
                    p.sendMessage(ChatColor.DARK_GREEN + "Deine Saturation ist nun: " + ChatColor.GREEN + p.getSaturation());
                    break;
                case ROTTEN_FLESH:
                    p.setFoodLevel(p.getFoodLevel() / 2);
                    p.setSaturation(0);
                    p.sendMessage(ChatColor.DARK_GRAY + "You have now: " + ChatColor.GRAY + p.getFoodLevel() + ChatColor.DARK_GRAY + " Hunger");
                    break;
                case BAKED_POTATO:

                    //p.closeInventory();
                    p.getInventory().setItemInOffHand(off);
                    p.updateInventory();

                    Inventory Stats = Bukkit.createInventory(p, 27, ChatColor.YELLOW + "§l§o§n          Information        ");

                    ItemStack fillup = new ItemStack(Material.GOLDEN_CARROT);
                    ItemMeta fillup_meta = fillup.getItemMeta();
                    ArrayList<String> fillup_lore = new ArrayList<>();
                    fillup_lore.add("Fills your hand up to 64");
                    fillup_meta.setLore(fillup_lore);
                    fillup_meta.setDisplayName(ChatColor.GOLD + "64");
                    fillup.setItemMeta(fillup_meta);
                    fillup.setAmount(64);

                    ItemStack data = new ItemStack(Material.PAPER);
                    ItemMeta data_meta = data.getItemMeta();
                    ArrayList<String> data_lore = new ArrayList<>();
                    data_lore.add("GIVES YOU THE DATA OF THE ITEM");
                    data_meta.setLore(data_lore);
                    data_meta.setDisplayName(ChatColor.GRAY + "DATA");
                    data.setItemMeta(data_meta);

                    ItemStack write = new ItemStack(Material.FEATHER);
                    ItemMeta write_meta = write.getItemMeta();
                    ArrayList<String> write_lore = new ArrayList<>();
                    write_lore.add("with that you can change the CustemID");
                    write_meta.setLore(write_lore);
                    write_meta.setDisplayName(ChatColor.GRAY + "CUSTEM_ID");
                    write.setItemMeta(write_meta);


                    Stats.setItem(16, write);

                    Stats.setItem(13, data);

                    Stats.setItem(10, fillup);

                    Stats.setItem(26, back);

                    p=(Player) e.getWhoClicked();
                    p.openInventory(Stats);
                    break;

                case RED_BED:
                    if (p.getBedSpawnLocation() == null) {
                        p.teleport(p.getWorld().getSpawnLocation());
                    } else {
                        p.teleport(p.getBedSpawnLocation());
                    }
                    p.closeInventory();
                    break;
                case KNOWLEDGE_BOOK:
                    p.closeInventory();
                    break;
                case REPEATING_COMMAND_BLOCK:

                    p.setTexturePack(CommandsMoreAdwanzt.getcon(1).getString("texpack"));
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "reload confirm");
                    p.updateInventory();
                    break;
                case APPLE:
                    //p.closeInventory();
                    p.getInventory().setItemInOffHand(off);
                    p.updateInventory();

                    Inventory Live = Bukkit.createInventory(p, 54, ChatColor.RED + "§l§o§n             Leben            ");

                    ItemStack leben = new ItemStack(Material.APPLE);
                    ItemMeta leben_meta = leben.getItemMeta();
                    ArrayList<String> leben_lore = new ArrayList<>();
                    leben_lore.add("Schows your Maxhealt");
                    double d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                    String str = (int) d + "";
                    leben_meta.setLore(leben_lore);
                    leben_meta.setDisplayName(str);
                    leben.setItemMeta(leben_meta);

                    ItemStack reset = new ItemStack(Material.GOLDEN_APPLE);
                    ItemMeta reset_meta = reset.getItemMeta();
                    ArrayList<String> reset_lore = new ArrayList<>();
                    reset_lore.add("Reset Max Healt");
                    reset_meta.setLore(reset_lore);
                    reset_meta.setDisplayName(ChatColor.GOLD + "RESET");
                    reset.setItemMeta(reset_meta);


                    if(!p.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER)){
                        p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER,1);
                    }

                    int extradamage=p.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER);

                    ItemStack dias = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta dias_meta = dias.getItemMeta();
                    ArrayList<String> dias_lore = new ArrayList<>();
                    dias_lore.add(ChatColor.BLUE + "Your Kurrent Damage extra");
                    str = extradamage + "";
                    dias_meta.setDisplayName(str);
                    dias_meta.setLore(dias_lore);
                    dias.setItemMeta(dias_meta);

                    ItemStack netsw = new ItemStack(Material.NETHERITE_SWORD);
                    ItemMeta netsw_meta = netsw.getItemMeta();
                    ArrayList<String> netsw_lore = new ArrayList<>();
                    netsw_lore.add("Resets your damage extra");
                    netsw_meta.setDisplayName("RESET");
                    netsw.setItemMeta(netsw_meta);

                    ItemStack woodsw = new ItemStack(Material.WOODEN_SWORD);
                    ItemMeta woodsw_meta = woodsw.getItemMeta();
                    woodsw_meta.setDisplayName("1");
                    woodsw.setItemMeta(woodsw_meta);

                    ItemStack irons = new ItemStack(Material.IRON_SWORD);
                    ItemMeta irons_meta = irons.getItemMeta();
                    irons_meta.setDisplayName(ChatColor.GRAY + "1");
                    irons.setItemMeta(irons_meta);


                    Live.setItem(10, remove);

                    AredStone.setAmount(1);
                    AredStone_meta.setDisplayName("1");
                    AredStone.setItemMeta(AredStone_meta);
                    Live.setItem(11, AredStone);

                    AredStone.setAmount(5);
                    AredStone_meta.setDisplayName("5");
                    AredStone.setItemMeta(AredStone_meta);
                    Live.setItem(12, AredStone);

                    AredStone.setAmount(10);
                    AredStone_meta.setDisplayName("10");
                    AredStone.setItemMeta(AredStone_meta);
                    Live.setItem(13, AredStone);

                    AredStone.setAmount(64);
                    AredStone_meta.setDisplayName("100");
                    AredStone.setItemMeta(AredStone_meta);
                    Live.setItem(14, AredStone);

                    Live.setItem(16, reset);


                    Live.setItem(19, add);

                    GreenStone.setAmount(1);
                    GreenStone_meta.setDisplayName("1");
                    GreenStone.setItemMeta(GreenStone_meta);
                    Live.setItem(20, GreenStone);

                    GreenStone.setAmount(5);
                    GreenStone_meta.setDisplayName("5");
                    GreenStone.setItemMeta(GreenStone_meta);
                    Live.setItem(21, GreenStone);

                    GreenStone.setAmount(10);
                    GreenStone_meta.setDisplayName("10");
                    GreenStone.setItemMeta(GreenStone_meta);
                    Live.setItem(22, GreenStone);

                    GreenStone.setAmount(64);
                    GreenStone_meta.setDisplayName("100");
                    GreenStone.setItemMeta(GreenStone_meta);
                    Live.setItem(23, GreenStone);

                    Live.setItem(25, leben);

                    Live.setItem(28, add);

                    woodsw.setAmount(1);
                    woodsw_meta.setDisplayName("1");
                    woodsw.setItemMeta(woodsw_meta);
                    Live.setItem(29, woodsw);

                    woodsw.setAmount(5);
                    woodsw_meta.setDisplayName("5");
                    woodsw.setItemMeta(woodsw_meta);
                    Live.setItem(30, woodsw);

                    woodsw.setAmount(10);
                    woodsw_meta.setDisplayName("10");
                    woodsw.setItemMeta(woodsw_meta);
                    Live.setItem(31, woodsw);

                    woodsw.setAmount(64);
                    woodsw_meta.setDisplayName("100");
                    woodsw.setItemMeta(woodsw_meta);
                    Live.setItem(32, woodsw);

                    Live.setItem(34, dias);


                    Live.setItem(37, remove);

                    irons.setAmount(1);
                    irons_meta.setDisplayName("1");
                    irons.setItemMeta(irons_meta);
                    Live.setItem(38, irons);

                    irons.setAmount(5);
                    irons_meta.setDisplayName("5");
                    irons.setItemMeta(irons_meta);
                    Live.setItem(39, irons);

                    irons.setAmount(10);
                    irons_meta.setDisplayName("10");
                    irons.setItemMeta(irons_meta);
                    Live.setItem(40, irons);

                    irons.setAmount(64);
                    irons_meta.setDisplayName("100");
                    irons.setItemMeta(irons_meta);
                    Live.setItem(41, irons);

                    Live.setItem(43, netsw);


                    Live.setItem(53, back);

                    p=(Player) e.getWhoClicked();
                    p.openInventory(Live);
                    break;
                case BARRIER:

                    Inventory Extras = Bukkit.createInventory(p, 27, ChatColor.RED + "             Extras            ");

                    ItemStack Tnt= new ItemStack(Material.TNT);
                    ItemMeta  Tnt_meta= Tnt.getItemMeta();
                    Tnt_meta.setDisplayName("TNT");
                    ArrayList<String> Tnt_lore = new ArrayList<>();
                    Tnt_lore.add("BOMB THE WORLD");
                    Tnt_meta.setLore(Tnt_lore);
                    Tnt.setItemMeta(Tnt_meta);

                    ItemStack Spawn= new ItemStack(Material.VILLAGER_SPAWN_EGG);
                    ItemMeta  Spawn_meta= Spawn.getItemMeta();
                    Spawn_meta.setDisplayName("Mobbs");
                    ArrayList<String> Spawn_lore = new ArrayList<>();
                    Spawn_lore.add("SPAWNS A LOT OF MOBBS");
                    Spawn_meta.setLore(Spawn_lore);
                    Spawn.setItemMeta(Spawn_meta);

                    ItemStack Tnts= new ItemStack(Material.BREAD);
                    ItemMeta  Tnt_metas= Tnts.getItemMeta();
                    Tnt_metas.setDisplayName("WORLDETER");
                    ArrayList<String> Tnt_lores = new ArrayList<>();
                    Tnt_lores.add("EATING THE WORLD!");
                    Tnt_metas.setLore(Tnt_lores);
                    Tnts.setItemMeta(Tnt_metas);

                    Extras.setItem(11,Tnt);
                    Extras.setItem(13,Spawn);
                    Extras.setItem(15,Tnts);

                    p.openInventory(Extras);
                    break;
                case VILLAGER_SPAWN_EGG:
                    //p.closeInventory();
                    p.updateInventory();
                    p.getInventory().setItemInOffHand(off);

                    Inventory Random = Bukkit.createInventory(p, 18, "            §cR§6A§eN§aD§2O§3M§b §1M§5O§dB§7S§f         ");

                    ItemStack Play = new ItemStack(Material.GREEN_STAINED_GLASS);
                    ItemMeta Play_meta = Play.getItemMeta();
                    Play_meta.setDisplayName(ChatColor.GREEN + "Play");
                    Play.setItemMeta(Play_meta);

                    ArrayList<ItemStack> test = new ArrayList<>();
                    test.add(new ItemStack(Material.ZOGLIN_SPAWN_EGG));
                    test.add(new ItemStack(Material.ZOMBIE_SPAWN_EGG));
                    test.add(new ItemStack(Material.SKELETON_SPAWN_EGG));
                    test.add(new ItemStack(Material.VILLAGER_SPAWN_EGG));
                    test.add(new ItemStack(Material.BAT_SPAWN_EGG));
                    test.add(new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
                    test.add(new ItemStack(Material.CREEPER_SPAWN_EGG));
                    test.add(new ItemStack(Material.HORSE_SPAWN_EGG));
                    test.add(new ItemStack(Material.CREEPER_SPAWN_EGG));
                    test.add(new ItemStack(Material.CREEPER_SPAWN_EGG));


                    add_meta.setDisplayName(ChatColor.GREEN + "");
                    add.setItemMeta(add_meta);

                    Random.setItem(0, test.get(0));
                    Random.setItem(1, test.get(1));
                    Random.setItem(2, test.get(2));
                    Random.setItem(3, add);
                    Random.setItem(4, test.get(3));
                    Random.setItem(5, add);
                    Random.setItem(6, test.get(5));
                    Random.setItem(7, test.get(6));
                    Random.setItem(8, test.get(7));


                    Random.setItem(13, Play);

                    Random.setItem(17, back);
                    p=(Player) e.getWhoClicked();
                    p.openInventory(Random);
                    break;
            }

            p.getInventory().setItemInOffHand(off);
            p.updateInventory();
        }

        //LiveGUI
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "§l§o§n             Leben            ")) {

            Player p=Bukkit.getPlayer(e.getView().getItem(53).getItemMeta().getDisplayName());
            ItemStack off = p.getInventory().getItemInOffHand();

            ItemStack leben = new ItemStack(Material.APPLE);
            ItemMeta leben_meta = leben.getItemMeta();
            ArrayList<String> leben_lore = new ArrayList<>();
            leben_lore.add("Your Maxhealt");
            double d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            String str = d + "";
            leben_meta.setLore(leben_lore);
            leben_meta.setDisplayName(str);
            leben.setItemMeta(leben_meta);

            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item == null) return;

            ItemStack dias = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta dias_meta = dias.getItemMeta();
            ArrayList<String> dias_lore = new ArrayList<>();
            dias_lore.add(ChatColor.BLUE + "Your Kurrent Damage extra");

            switch (e.getCurrentItem().getType()) {

                case GOLDEN_APPLE:
                    p.setMaxHealth(20);
                    d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                    str = (int) d + "";
                    leben_meta.setDisplayName(str);
                    leben.setItemMeta(leben_meta);
                    e.getView().setItem(25, leben);
                    p.sendMessage(ChatColor.DARK_GREEN + "Your Max Healt Resetet to: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    break;

                case WOODEN_SWORD:

                    int extradamage=p.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER);

                    if (item.getAmount() == 1) {
                        extradamage++;
                    } else if (item.getAmount() == 5) {
                        extradamage+=5;
                    } else if (item.getAmount() == 10) {
                        extradamage+=10;
                    } else if (item.getAmount() == 64) {
                        extradamage+=100;
                    }

                    p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER,extradamage);

                    str = extradamage + "";
                    dias_meta.setDisplayName(str);
                    dias_meta.setLore(dias_lore);
                    dias.setItemMeta(dias_meta);
                    e.getView().setItem(34, dias);
                    break;
                case NETHERITE_SWORD:

                    p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER,1);

                    dias_meta.setDisplayName("1");
                    dias_meta.setLore(dias_lore);
                    dias.setItemMeta(dias_meta);
                    e.getView().setItem(34, dias);
                    break;
                case IRON_SWORD:

                    int extradamagee=p.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER);

                    if (extradamagee - item.getAmount() <= 1) {
                        extradamagee=1;
                    } else if (item.getAmount() == 1) {
                        extradamagee--;
                    } else if (item.getAmount() == 5) {
                        extradamagee-=5;
                    } else if (item.getAmount() == 10) {
                        extradamagee-=10;
                    } else if (item.getAmount() == 64) {
                        if (extradamagee - 100 <= 1) {
                            extradamagee=1;
                        } else {
                            extradamagee-=100;
                        }
                    }

                    p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(),"damageduper"), PersistentDataType.INTEGER,extradamagee);

                    str = extradamagee + "";
                    dias_meta.setDisplayName(str);
                    dias_meta.setLore(dias_lore);
                    dias.setItemMeta(dias_meta);
                    e.getView().setItem(34, dias);
                    break;
                case BOOK:
                    //p.closeInventory();
                    CommandSender pa = (CommandSender) (Player) e.getWhoClicked();
                    Bukkit.dispatchCommand(pa, "gui "+p.getName());
                    break;
                case RED_CONCRETE_POWDER:

                    if (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - item.getAmount() < 1) {
                        p.sendMessage(ChatColor.DARK_RED + "You cant fall under 1HP !");
                        p.setMaxHealth(1);
                        d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                        str = (int) d + "";
                        leben_meta.setDisplayName(str);
                        leben.setItemMeta(leben_meta);
                        e.getView().setItem(25, leben);
                        break;
                    } else {

                        if (item.getAmount() == 1) {
                            p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 1);
                            p.sendMessage(ChatColor.DARK_RED + "Your Max Healt degreast to: " + ChatColor.RED + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                        } else if (item.getAmount() == 5) {
                            p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 5);
                            p.sendMessage(ChatColor.DARK_RED + "Your Max Healt degreast to: " + ChatColor.RED + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                        } else if (item.getAmount() == 10) {
                            p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 10);
                            p.sendMessage(ChatColor.DARK_RED + "Your Max Healt degreast to: " + ChatColor.RED + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                        } else if (item.getAmount() == 64) {

                            if (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 100 < 1) {
                                p.sendMessage(ChatColor.DARK_RED + "You cant fall under 1HP !");
                                p.setMaxHealth(1);
                                break;
                            } else {
                                p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 100);
                                p.sendMessage(ChatColor.DARK_RED + "Your Max Healt degreast to: " + ChatColor.RED + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                            }
                        }
                    }
                    d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                    str = (int) d + "";
                    leben_meta.setDisplayName(str);
                    leben.setItemMeta(leben_meta);
                    e.getView().setItem(25, leben);
                    break;
                case GREEN_CONCRETE_POWDER:

                    if (item.getAmount() == 1) {
                        p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 1);
                        p.sendMessage(ChatColor.DARK_GREEN + "Your Max Healt ingreast to: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    } else if (item.getAmount() == 5) {
                        p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 5);
                        p.sendMessage(ChatColor.DARK_GREEN + "Your Max Healt ingreast to: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    } else if (item.getAmount() == 10) {
                        p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 10);
                        p.sendMessage(ChatColor.DARK_GREEN + "Your Max Healt ingreast to: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    } else if (item.getAmount() == 64) {
                        p.setMaxHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 100);
                        p.sendMessage(ChatColor.DARK_GREEN + "Your Max Healt ingreast to: " + ChatColor.GREEN + p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                    }
                    d = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                    str = (int) d + "";
                    leben_meta.setDisplayName(str);
                    leben.setItemMeta(leben_meta);
                    e.getView().setItem(25, leben);
                    break;
            }

            p.setHealthScale(20);
            p.setHealthScaled(true);
            p.getInventory().setItemInOffHand(off);
            p.updateInventory();
        }

        //Mobs
        if (e.getView().getTitle().equalsIgnoreCase("            §cR§6A§eN§aD§2O§3M§b §1M§5O§dB§7S§f         ")) {

            Player p=Bukkit.getPlayer(e.getView().getItem(17).getItemMeta().getDisplayName());
            ItemStack off = p.getInventory().getItemInOffHand();
            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item == null) return;

            switch (e.getCurrentItem().getType()) {
                case GREEN_STAINED_GLASS:

                    ArrayList<ItemStack> test = new ArrayList<>();
                    test.add(new ItemStack(Material.ZOGLIN_SPAWN_EGG));
                    test.add(new ItemStack(Material.ZOMBIE_SPAWN_EGG));
                    test.add(new ItemStack(Material.SKELETON_SPAWN_EGG));
                    test.add(new ItemStack(Material.VILLAGER_SPAWN_EGG));
                    test.add(new ItemStack(Material.BAT_SPAWN_EGG));
                    test.add(new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
                    test.add(new ItemStack(Material.CREEPER_SPAWN_EGG));
                    test.add(new ItemStack(Material.HORSE_SPAWN_EGG));
                    test.add(new ItemStack(Material.ZOGLIN_SPAWN_EGG));
                    test.add(new ItemStack(Material.CREEPER_SPAWN_EGG));

                    ItemStack wait = new ItemStack(Material.YELLOW_STAINED_GLASS);
                    ItemMeta wait_meta = wait.getItemMeta();
                    wait_meta.setDisplayName(ChatColor.YELLOW + "WAIT");
                    wait.setItemMeta(wait_meta);

                    ItemStack air = new ItemStack(Material.AIR);

                    e.getView().setItem(13, wait);
                    e.getView().setItem(17, air);

                    for (int i = 0; i < 20; i++) {
                        new BukkitRunnable() {

                            @Override
                            public void run() {

                                int ran = ThreadLocalRandom.current().nextInt(1, 10);

                                ItemStack randa = test.get(ran);
                                test.set(7, test.get(6));
                                test.set(6, test.get(5));
                                test.set(5, test.get(4));
                                test.set(4, test.get(3));
                                test.set(3, test.get(2));
                                test.set(2, test.get(1));
                                test.set(1, randa);

                                e.getView().setItem(0, test.get(1));
                                e.getView().setItem(1, test.get(2));
                                e.getView().setItem(2, test.get(3));
                                e.getView().setItem(4, test.get(4));
                                e.getView().setItem(6, test.get(5));
                                e.getView().setItem(7, test.get(6));
                                e.getView().setItem(8, test.get(7));
                                cancel();

                                p.getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 1, 1);

                            }
                        }.runTaskTimer(CommandsMoreAdwanzt.getPlugin(), i * 5, 0);
                    }

                    new BukkitRunnable() {

                        @Override
                        public void run() {

                            ItemStack Play = new ItemStack(Material.GREEN_STAINED_GLASS);
                            ItemMeta Play_meta = Play.getItemMeta();
                            Play_meta.setDisplayName(ChatColor.GREEN + "Play");
                            Play.setItemMeta(Play_meta);

                            ItemStack back = new ItemStack(Material.BOOK);
                            ItemMeta back_meta = back.getItemMeta();
                            back_meta.setDisplayName("§oBack");
                            back.setItemMeta(back_meta);

                            p.getWorld().playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1, 1);
                            e.getView().setItem(13, Play);
                            e.getView().setItem(17, back);

                            ItemStack win = new ItemStack(test.get(4));
                            win.setAmount(64);
                            p.getWorld().dropItemNaturally(p.getLocation(), win);
                            cancel();

                        }
                    }.runTaskTimer(CommandsMoreAdwanzt.getPlugin(), 5 * 20, 0);


                    break;
                case BOOK:
                    //p.closeInventory();
                    CommandSender pa = (CommandSender) (Player) e.getWhoClicked();
                    Bukkit.dispatchCommand(pa, "gui "+p.getName());
                    break;
            }


            p.getInventory().setItemInOffHand(off);
            p.updateInventory();
        }

        //dataGUI
        if (e.getView().getTitle().equals(ChatColor.YELLOW + "§l§o§n          Information        ")) {

            Player p=Bukkit.getPlayer(e.getView().getItem(26).getItemMeta().getDisplayName());
            ItemStack off = p.getInventory().getItemInOffHand();
            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item == null) return;

            switch (e.getCurrentItem().getType()) {
                case GOLDEN_CARROT:

                    p.getInventory().getItemInMainHand().setAmount(64);

                    break;

                case PAPER:

                    if (p.getInventory().getItemInMainHand().getItemMeta() == null) {
                        p.sendMessage(ChatColor.DARK_GREEN + "Deine hand ist: " + ChatColor.GREEN + "lehr");
                        return;
                    }

                    String stc = p.getInventory().getItemInMainHand().getType() + "";
                    p.sendMessage(ChatColor.GREEN + stc);

                    if (p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) {
                        stc = p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() + "";
                        p.sendMessage(ChatColor.DARK_GREEN + "The CustemModelData is: " + ChatColor.GREEN + stc);
                    } else {
                        p.sendMessage(ChatColor.DARK_GREEN + "Das item hat keine CustemModelData");
                    }

                    p.sendMessage(ChatColor.GREEN+"Deine UID ist: "+ChatColor.DARK_GREEN+p.getUniqueId().toString());

                    break;

                case FEATHER:
                    if (p.getInventory().getItemInMainHand().getItemMeta() == null) {
                        p.sendMessage(ChatColor.DARK_GREEN + "Deine hand ist: " + ChatColor.GREEN + "lehr");
                        return;
                    }


                    ItemMeta a=p.getInventory().getItemInMainHand().getItemMeta();
                    a.setCustomModelData(1115);
                    p.getInventory().getItemInMainHand().setItemMeta(a);


                    break;

                case BOOK:
                    //p.closeInventory();
                    CommandSender pa = (CommandSender) (Player) e.getWhoClicked();
                    Bukkit.dispatchCommand(pa, "gui "+p.getName());
                    break;
            }

            p.getInventory().setItemInOffHand(off);
            p.updateInventory();
        }

        //extra spielerein gui
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "             Extras            ")){

            Player p= (Player) e.getWhoClicked();
            //Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            ItemStack item = e.getCurrentItem();
            if (item == null) return;
            Player finalP = p;

            switch (e.getCurrentItem().getType()){
                case VILLAGER_SPAWN_EGG:
                    if(p.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE)){
                        p.getPersistentDataContainer().remove(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"));
                        p.sendMessage(ChatColor.RED+"No mobs");
                        return;
                    }

                    ArrayList<EntityType> mobs=new ArrayList<>();
                    mobs.add(EntityType.ZOMBIE);
                    mobs.add(EntityType.ZOMBIE);
                    mobs.add(EntityType.ZOMBIE);
                    mobs.add(EntityType.SKELETON);
                    mobs.add(EntityType.ZOMBIE);
                    mobs.add(EntityType.ZOMBIE_VILLAGER);
                    mobs.add(EntityType.SPIDER);
                    mobs.add(EntityType.SPIDER);

                    Random ran =new Random();
                    p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE,0.0);
                    p.sendMessage(ChatColor.GREEN+"Mobs Startet");

                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            if(!finalP.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE)
                                    || finalP.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE)>250){
                                p.getPersistentDataContainer().remove(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"));
                                p.sendMessage(ChatColor.RED+"Mobs Stop");
                                cancel();
                                return;
                            }

                            for (Player pp : Bukkit.getOnlinePlayers()){
                                if(pp.getGameMode().equals(GameMode.SURVIVAL)){
                                    Location locit=pp.getLocation().add(ran.nextDouble(-6,-1),0,ran.nextDouble(-3,5));
                                    locit.setY(pp.getWorld().getHighestBlockYAt(locit)+1);
                                    for (int i=0;i<ran.nextInt(1,4);i++){
                                        p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE,
                                                p.getPersistentDataContainer().get(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "apokalypse"), PersistentDataType.DOUBLE)+1);
                                        pp.getWorld().spawnEntity(locit,mobs.get(ran.nextInt(0,7)));
                                    }
                                }
                            }
                        }
                    }.runTaskTimer(CommandsMoreAdwanzt.getPlugin(),0,20);
                    break;
                case TNT:
                    break;
                case BREAD:
                    if(!p.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "tnt"), PersistentDataType.DOUBLE)){
                        p.sendMessage(ChatColor.GREEN+"EATING HAS STARTET");
                        p.getPersistentDataContainer().set(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "tnt"), PersistentDataType.DOUBLE,0.0);
                        //Player finalP = p;
                        Chunk chunk=p.getLocation().getChunk();
                        // Only process newly generated chunks
                        new BukkitRunnable() {
                            int x = 0, y = chunk.getWorld().getMinHeight(), z = 0;

                            @Override
                            public void run() {
                                for (int i = 0; i < 50; i++) { // Process 50 blocks per tick
                                    if(!finalP.isOnline() || !finalP.getPersistentDataContainer().has(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "tnt"), PersistentDataType.DOUBLE))cancel();
                                    Block block = chunk.getBlock(x, y, z);
                                    Material type = block.getType();

                                    block.setBlockData(Material.AIR.createBlockData());

                                    z++;
                                    if (z == 16) {
                                        z = 0;
                                        x++;
                                    }
                                    if (x == 16) {
                                        x = 0;
                                        y++;
                                    }


                                    if (y >= block.getWorld().getMaxHeight()) {//chunk.getWorld().getMaxHeight()
                                        finalP.getPersistentDataContainer().remove(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "tnt"));
                                        finalP.sendMessage("Eating has stopt do to end fo world");
                                        cancel(); // Stop the task when done
                                        break;
                                    }
                                }
                            }
                        }.runTaskTimer(CommandsMoreAdwanzt.getPlugin(), 1L, 1L); // Run every tick
                    } else {
                        p.sendMessage(ChatColor.RED+"Sadly eating has stopt");
                        p.getPersistentDataContainer().remove(new NamespacedKey(CommandsMoreAdwanzt.getPlugin(), "tnt"));
                    }
                    break;
            }
        }
    }
}

