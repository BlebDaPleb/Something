package com.blebdapleb.mrindia.commands.keys;

import com.blebdapleb.mrindia.MrIndia;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class CrateSystem implements Listener {

    // Inventories
    Inventory mainGui = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD + "Crates");
    Inventory emeraldConfirmGui = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD +"Confirm");
    Inventory diamondConfirmGui = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD +"Confirm");
    Inventory goldConfirmGui = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD +"Confirm");
    Inventory ironConfirmGui = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.GREEN + "" + ChatColor.BOLD +"Confirm");

    Inventory insideEmeraldCrate = Bukkit.createInventory(null, 54, ChatColor.GREEN + "" + ChatColor.BOLD + "Emerald Crate");
    Inventory insideDiamondCrate = Bukkit.createInventory(null, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Diamond Crate");
    Inventory insideGoldCrate = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "" + ChatColor.BOLD + "Gold Crate");
    Inventory insideIronCrate = Bukkit.createInventory(null, 54, ChatColor.GRAY + "" + ChatColor.BOLD + "Iron Crate");

    public void openCratesMenuGui(Player player) {

        // Emerald Item
        ItemStack emeraldOreItem = new ItemStack(Material.EMERALD_ORE, 1);
        ItemMeta emeraldOreMeta = emeraldOreItem.getItemMeta();
        emeraldOreMeta.setDisplayName(ChatColor.GREEN + "Emerald Crates");
        emeraldOreItem.setItemMeta(emeraldOreMeta);
        System.out.println(emeraldOreItem);

        // Diamond Item
        ItemStack diamondOreItem = new ItemStack(Material.DIAMOND_ORE, 1);
        ItemMeta diamondOreMeta = diamondOreItem.getItemMeta();
        diamondOreMeta.setDisplayName(ChatColor.BLUE + "Diamond Crates");
        diamondOreItem.setItemMeta(diamondOreMeta);

        // Gold Item
        ItemStack goldOreItem = new ItemStack(Material.GOLD_ORE, 1);
        ItemMeta goldOreMeta = goldOreItem.getItemMeta();
        goldOreMeta.setDisplayName(ChatColor.YELLOW + "Gold Crates");
        goldOreItem.setItemMeta(goldOreMeta);

        // Iron Item
        ItemStack ironOreItem = new ItemStack(Material.IRON_ORE, 1);
        ItemMeta ironOreMeta = ironOreItem.getItemMeta();
        ironOreMeta.setDisplayName(ChatColor.GRAY + "Iron Crates");
        ironOreItem.setItemMeta(ironOreMeta);

        // Accept Item
        ItemStack greenConcreteItem = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta greenConcreteMeta = greenConcreteItem.getItemMeta();
        greenConcreteMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "ROLL");
        greenConcreteItem.setItemMeta(greenConcreteMeta);

        // Decline Item
        ItemStack redConcreteItem = new ItemStack(Material.RED_CONCRETE, 1);
        ItemMeta redConcreteMeta = redConcreteItem.getItemMeta();
        redConcreteMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CANCEL");
        redConcreteItem.setItemMeta(redConcreteMeta);

        // Inside Crate Item
        ItemStack chestItem = new ItemStack(Material.CHEST, 1);
        ItemMeta chestItemMeta = chestItem.getItemMeta();
        chestItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Inside Crate");
        ArrayList<String> chestItemLore = new ArrayList<>();
        chestItemLore.add(ChatColor.RED + "Click to see inside crate");
        chestItemMeta.setLore(chestItemLore);
        chestItem.setItemMeta(chestItemMeta);


        // Main gui
        mainGui.setItem(10, emeraldOreItem);
        mainGui.setItem(12, diamondOreItem);
        mainGui.setItem(14, goldOreItem);
        mainGui.setItem(16, ironOreItem);
        // Emerald gui
        emeraldConfirmGui.setItem(11, greenConcreteItem);
        emeraldConfirmGui.setItem(15, redConcreteItem);
        emeraldConfirmGui.setItem(13, chestItem);
        // Diamond gui
        diamondConfirmGui.setItem(11, greenConcreteItem);
        diamondConfirmGui.setItem(15, redConcreteItem);
        diamondConfirmGui.setItem(13, chestItem);
        // Gold gui
        goldConfirmGui.setItem(11, greenConcreteItem);
        goldConfirmGui.setItem(15, redConcreteItem);
        goldConfirmGui.setItem(13, chestItem);
        // Iron gui
        ironConfirmGui.setItem(11, greenConcreteItem);
        ironConfirmGui.setItem(15, redConcreteItem);
        ironConfirmGui.setItem(13, chestItem);

        // Inside emerald crate

        ItemStack greenGlassPane = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemStack grayGlassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        // Back item
        ItemStack backItem = new ItemStack(Material.EMERALD);
        ItemMeta backItemMeta = backItem.getItemMeta();
        backItemMeta.setDisplayName(ChatColor.YELLOW + "Back!");
        ArrayList<String> backItemLore = new ArrayList<>();
        backItemLore.add(ChatColor.RED + "Click to go back!");
        backItemMeta.setLore(backItemLore);
        backItem.setItemMeta(backItemMeta);

        // Green glass pane
        insideEmeraldCrate.setItem(0, greenGlassPane);
        insideEmeraldCrate.setItem(1, greenGlassPane);
        insideEmeraldCrate.setItem(9, greenGlassPane);
        insideEmeraldCrate.setItem(7, greenGlassPane);
        insideEmeraldCrate.setItem(8, greenGlassPane);
        insideEmeraldCrate.setItem(17, greenGlassPane);
        insideEmeraldCrate.setItem(36, greenGlassPane);
        insideEmeraldCrate.setItem(44, greenGlassPane);
        insideEmeraldCrate.setItem(53, greenGlassPane);
        insideEmeraldCrate.setItem(52, greenGlassPane);
        insideEmeraldCrate.setItem(45, greenGlassPane);
        insideEmeraldCrate.setItem(46, greenGlassPane);
        // Gray glass pane
        insideEmeraldCrate.setItem(2, grayGlassPane);
        insideEmeraldCrate.setItem(3, grayGlassPane);
        insideEmeraldCrate.setItem(4, grayGlassPane);
        insideEmeraldCrate.setItem(5, grayGlassPane);
        insideEmeraldCrate.setItem(6, grayGlassPane);
        insideEmeraldCrate.setItem(18, grayGlassPane);
        insideEmeraldCrate.setItem(27, grayGlassPane);
        insideEmeraldCrate.setItem(26, grayGlassPane);
        insideEmeraldCrate.setItem(35, grayGlassPane);
        insideEmeraldCrate.setItem(47, grayGlassPane);
        insideEmeraldCrate.setItem(48, grayGlassPane);
        insideEmeraldCrate.setItem(49, backItem);
        insideEmeraldCrate.setItem(50, grayGlassPane);
        insideEmeraldCrate.setItem(51, grayGlassPane);
        // Reward Items
        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytraMeta = elytra.getItemMeta();
        elytraMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        elytra.setItemMeta(elytraMeta);

        ItemStack trident = new ItemStack(Material.TRIDENT, 1);
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        trident.setItemMeta(tridentMeta);

        ItemStack enchGoldApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);

        ItemStack netheriteSraps = new ItemStack(Material.NETHERITE_SCRAP, 32);

        ItemStack crystals = new ItemStack(Material.END_CRYSTAL, 16);

        ItemStack obsidian = new ItemStack(Material.OBSIDIAN, 64);

        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta netheriteSwordMeta = netheriteSword.getItemMeta();
        netheriteSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        netheriteSwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        netheriteSword.setItemMeta(netheriteSwordMeta);

        ItemStack pigstepDisc = new ItemStack(Material.MUSIC_DISC_PIGSTEP, 1);

        ItemStack redeem5000 = new ItemStack(Material.PAPER, 1);
        ItemMeta redeem5000Meta = redeem5000.getItemMeta();
        redeem5000Meta.setDisplayName(ChatColor.GREEN + "$5000 Check");
        ArrayList<String> redeem5000Lore = new ArrayList<>();
        redeem5000Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$5000");
        redeem5000Meta.setLore(redeem5000Lore);
        redeem5000.setItemMeta(redeem5000Meta);

        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);

        insideEmeraldCrate.setItem(10, elytra);
        insideEmeraldCrate.setItem(11, trident);
        insideEmeraldCrate.setItem(12, enchGoldApple);
        insideEmeraldCrate.setItem(13, netheriteSraps);
        insideEmeraldCrate.setItem(14, crystals);
        insideEmeraldCrate.setItem(15, obsidian);
        insideEmeraldCrate.setItem(16, pigstepDisc);
        insideEmeraldCrate.setItem(19, totem);
        insideEmeraldCrate.setItem(20, redeem5000);
        insideEmeraldCrate.setItem(21, netheriteSword);


        // Inside Diamond Crate
        ItemStack blueGlassPane = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);

        // Green glass pane
        insideDiamondCrate.setItem(0, blueGlassPane);
        insideDiamondCrate.setItem(1, blueGlassPane);
        insideDiamondCrate.setItem(9, blueGlassPane);
        insideDiamondCrate.setItem(7, blueGlassPane);
        insideDiamondCrate.setItem(8, blueGlassPane);
        insideDiamondCrate.setItem(17, blueGlassPane);
        insideDiamondCrate.setItem(36, blueGlassPane);
        insideDiamondCrate.setItem(44, blueGlassPane);
        insideDiamondCrate.setItem(53, blueGlassPane);
        insideDiamondCrate.setItem(52, blueGlassPane);
        insideDiamondCrate.setItem(45, blueGlassPane);
        insideDiamondCrate.setItem(46, blueGlassPane);
        // Gray glass pane
        insideDiamondCrate.setItem(2, grayGlassPane);
        insideDiamondCrate.setItem(3, grayGlassPane);
        insideDiamondCrate.setItem(4, grayGlassPane);
        insideDiamondCrate.setItem(5, grayGlassPane);
        insideDiamondCrate.setItem(6, grayGlassPane);
        insideDiamondCrate.setItem(18, grayGlassPane);
        insideDiamondCrate.setItem(27, grayGlassPane);
        insideDiamondCrate.setItem(26, grayGlassPane);
        insideDiamondCrate.setItem(35, grayGlassPane);
        insideDiamondCrate.setItem(47, grayGlassPane);
        insideDiamondCrate.setItem(48, grayGlassPane);
        insideDiamondCrate.setItem(49, backItem);
        insideDiamondCrate.setItem(50, grayGlassPane);
        insideDiamondCrate.setItem(51, grayGlassPane);

        // Diamond rewards
        ItemStack diamondOres = new ItemStack(Material.DIAMOND_ORE, 16);

        ItemStack crystals2 = new ItemStack(Material.END_CRYSTAL, 8);

        ItemStack goldenApples = new ItemStack(Material.GOLDEN_APPLE, 5);

        ItemStack ancientDebris = new ItemStack(Material.ANCIENT_DEBRIS, 8);

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta diamondSwordMeta = diamondSword.getItemMeta();
        diamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        diamondSwordMeta.addEnchant(Enchantment.DURABILITY, 2, true);
        diamondSword.setItemMeta(diamondSwordMeta);

        ItemStack diamondBlocks = new ItemStack(Material.DIAMOND_BLOCK, 4);

        ItemStack diamonds = new ItemStack(Material.DIAMOND, 32);

        ItemStack diamondPick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta diamondPickMeta = diamondPick.getItemMeta();
        diamondPickMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        diamondPickMeta.addEnchant(Enchantment.DURABILITY, 2, true);
        diamondPick.setItemMeta(diamondPickMeta);

        ItemStack redeem2500 = new ItemStack(Material.PAPER, 1);
        ItemMeta redeem2500Meta = redeem2500.getItemMeta();
        redeem2500Meta.setDisplayName(ChatColor.GREEN + "$2500 Check");
        ArrayList<String> redeem2500Lore = new ArrayList<>();
        redeem2500Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$2500");
        redeem2500Meta.setLore(redeem2500Lore);
        redeem2500.setItemMeta(redeem2500Meta);

        insideDiamondCrate.setItem(10, diamondOres);
        insideDiamondCrate.setItem(11, crystals2);
        insideDiamondCrate.setItem(12, goldenApples);
        insideDiamondCrate.setItem(13, ancientDebris);
        insideDiamondCrate.setItem(14, diamondSword);
        insideDiamondCrate.setItem(15, diamondBlocks);
        insideDiamondCrate.setItem(16, diamonds);
        insideDiamondCrate.setItem(19, totem);
        insideDiamondCrate.setItem(20, redeem2500);
        insideDiamondCrate.setItem(21, diamondPick);


        // Inside gold crate
        ItemStack yellowGlassPane = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1);

        // Green glass pane
        insideGoldCrate.setItem(0, yellowGlassPane);
        insideGoldCrate.setItem(1, yellowGlassPane);
        insideGoldCrate.setItem(9, yellowGlassPane);
        insideGoldCrate.setItem(7, yellowGlassPane);
        insideGoldCrate.setItem(8, yellowGlassPane);
        insideGoldCrate.setItem(17, yellowGlassPane);
        insideGoldCrate.setItem(36, yellowGlassPane);
        insideGoldCrate.setItem(44, yellowGlassPane);
        insideGoldCrate.setItem(53, yellowGlassPane);
        insideGoldCrate.setItem(52, yellowGlassPane);
        insideGoldCrate.setItem(45, yellowGlassPane);
        insideGoldCrate.setItem(46, yellowGlassPane);
        // Gray glass pane
        insideGoldCrate.setItem(2, grayGlassPane);
        insideGoldCrate.setItem(3, grayGlassPane);
        insideGoldCrate.setItem(4, grayGlassPane);
        insideGoldCrate.setItem(5, grayGlassPane);
        insideGoldCrate.setItem(6, grayGlassPane);
        insideGoldCrate.setItem(18, grayGlassPane);
        insideGoldCrate.setItem(27, grayGlassPane);
        insideGoldCrate.setItem(26, grayGlassPane);
        insideGoldCrate.setItem(35, grayGlassPane);
        insideGoldCrate.setItem(47, grayGlassPane);
        insideGoldCrate.setItem(48, grayGlassPane);
        insideGoldCrate.setItem(49, backItem);
        insideGoldCrate.setItem(50, grayGlassPane);
        insideGoldCrate.setItem(51, grayGlassPane);

        // Gold rewards
        ItemStack goldenApples2 = new ItemStack(Material.GOLDEN_APPLE, 2);

        ItemStack goldIngots = new ItemStack(Material.GOLD_INGOT, 32);

        ItemStack netheriteScraps2 = new ItemStack(Material.NETHERITE_SCRAP, 4);

        ItemStack goldBlocks = new ItemStack(Material.GOLD_BLOCK, 16);

        ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL, 16);

        ItemStack blazeRods = new ItemStack(Material.BLAZE_ROD, 16);

        ItemStack rawGoldBlocks = new ItemStack(Material.RAW_GOLD_BLOCK, 32);

        ItemStack ancientDebris2 = new ItemStack(Material.ANCIENT_DEBRIS, 8);

        ItemStack nameTag = new ItemStack(Material.NAME_TAG, 2);

        ItemStack netherWarts = new ItemStack(Material.NETHER_WART, 16);

        insideGoldCrate.setItem(10, goldenApples2);
        insideGoldCrate.setItem(11, goldIngots);
        insideGoldCrate.setItem(12, netheriteScraps2);
        insideGoldCrate.setItem(13, goldBlocks);
        insideGoldCrate.setItem(14, enderPearls);
        insideGoldCrate.setItem(15, blazeRods);
        insideGoldCrate.setItem(16, rawGoldBlocks);
        insideGoldCrate.setItem(19, ancientDebris2);
        insideGoldCrate.setItem(20, nameTag);
        insideGoldCrate.setItem(21, netherWarts);

        // Inside iron crates
        ItemStack whiteGlassPane = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);

        // Green glass pane
        insideIronCrate.setItem(0, whiteGlassPane);
        insideIronCrate.setItem(1, whiteGlassPane);
        insideIronCrate.setItem(9, whiteGlassPane);
        insideIronCrate.setItem(7, whiteGlassPane);
        insideIronCrate.setItem(8, whiteGlassPane);
        insideIronCrate.setItem(17, whiteGlassPane);
        insideIronCrate.setItem(36, whiteGlassPane);
        insideIronCrate.setItem(44, whiteGlassPane);
        insideIronCrate.setItem(53, whiteGlassPane);
        insideIronCrate.setItem(52, whiteGlassPane);
        insideIronCrate.setItem(45, whiteGlassPane);
        insideIronCrate.setItem(46, whiteGlassPane);
        // Gray glass pane
        insideIronCrate.setItem(2, grayGlassPane);
        insideIronCrate.setItem(3, grayGlassPane);
        insideIronCrate.setItem(4, grayGlassPane);
        insideIronCrate.setItem(5, grayGlassPane);
        insideIronCrate.setItem(6, grayGlassPane);
        insideIronCrate.setItem(18, grayGlassPane);
        insideIronCrate.setItem(27, grayGlassPane);
        insideIronCrate.setItem(26, grayGlassPane);
        insideIronCrate.setItem(35, grayGlassPane);
        insideIronCrate.setItem(47, grayGlassPane);
        insideIronCrate.setItem(48, grayGlassPane);
        insideIronCrate.setItem(49, backItem);
        insideIronCrate.setItem(50, grayGlassPane);
        insideIronCrate.setItem(51, grayGlassPane);

        // Iron rewards
        // Reward 1
        ItemStack goldApple = new ItemStack(Material.GOLDEN_APPLE, 1);
        // Reward 2
        ItemStack rawIron = new ItemStack(Material.RAW_IRON, 32);
        // Reward 3
        ItemStack enderPearls2 = new ItemStack(Material.ENDER_PEARL, 4);
        // Reward 4
        ItemStack ironBlocks = new ItemStack(Material.IRON_BLOCK, 16);
        // Reward 5
        ItemStack ironPick = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta ironPickMeta = ironPick.getItemMeta();
        ironPickMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        ironPick.setItemMeta(ironPickMeta);
        // Reward 6
        ItemStack netherWarts2 = new ItemStack(Material.NETHER_WART, 4);
        // Reward 7
        ItemStack nameTag2 = new ItemStack(Material.NAME_TAG, 2);
        // Reward 8
        ItemStack ironOres = new ItemStack(Material.IRON_ORE, 16);
        // Reward 9
        ItemStack diamonds2 = new ItemStack(Material.DIAMOND, 10);
        // Reward 10
        ItemStack lead = new ItemStack(Material.LEAD, 1);

        insideIronCrate.setItem(10, goldApple);
        insideIronCrate.setItem(11, rawIron);
        insideIronCrate.setItem(12, enderPearls2);
        insideIronCrate.setItem(13, ironBlocks);
        insideIronCrate.setItem(14, ironPick);
        insideIronCrate.setItem(15, netherWarts2);
        insideIronCrate.setItem(16, nameTag2);
        insideIronCrate.setItem(19, ironOres);
        insideIronCrate.setItem(20, diamonds2);
        insideIronCrate.setItem(21, lead);

        // Opens crate menu gui for player
        player.openInventory(mainGui);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        // Accept Item
        ItemStack greenConcreteItem = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta greenConcreteMeta = greenConcreteItem.getItemMeta();
        greenConcreteMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "ROLL");
        greenConcreteItem.setItemMeta(greenConcreteMeta);

        // Decline Item
        ItemStack redConcreteItem = new ItemStack(Material.RED_CONCRETE, 1);
        ItemMeta redConcreteMeta = redConcreteItem.getItemMeta();
        redConcreteMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CANCEL");
        redConcreteItem.setItemMeta(redConcreteMeta);

        // Inside Crate Item
        ItemStack chestItem = new ItemStack(Material.CHEST, 1);
        ItemMeta chestItemMeta = chestItem.getItemMeta();
        chestItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Inside Crate");
        ArrayList<String> chestItemLore = new ArrayList<>();
        chestItemLore.add(ChatColor.RED + "Click to see inside crate");
        chestItemMeta.setLore(chestItemLore);
        chestItem.setItemMeta(chestItemMeta);

        if (e.getInventory().equals(mainGui)) {

            // Emerald Item
            ItemStack emeraldOreItem = new ItemStack(Material.EMERALD_ORE, 1);
            ItemMeta emeraldOreMeta = emeraldOreItem.getItemMeta();
            emeraldOreMeta.setDisplayName(ChatColor.GREEN + "Emerald Crates");
            emeraldOreItem.setItemMeta(emeraldOreMeta);

            // Diamond Item
            ItemStack diamondOreItem = new ItemStack(Material.DIAMOND_ORE, 1);
            ItemMeta diamondOreMeta = diamondOreItem.getItemMeta();
            diamondOreMeta.setDisplayName(ChatColor.BLUE + "Diamond Crates");
            diamondOreItem.setItemMeta(diamondOreMeta);

            // Gold Item
            ItemStack goldOreItem = new ItemStack(Material.GOLD_ORE, 1);
            ItemMeta goldOreMeta = goldOreItem.getItemMeta();
            goldOreMeta.setDisplayName(ChatColor.YELLOW + "Gold Crates");
            goldOreItem.setItemMeta(goldOreMeta);

            // Iron Item
            ItemStack ironOreItem = new ItemStack(Material.IRON_ORE, 1);
            ItemMeta ironOreMeta = ironOreItem.getItemMeta();
            ironOreMeta.setDisplayName(ChatColor.GRAY + "Iron Crates");
            ironOreItem.setItemMeta(ironOreMeta);

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            // If they click emerald item
            if (clickedItem.equals(emeraldOreItem)) {

                player.openInventory(emeraldConfirmGui);

            } else if (clickedItem.equals(diamondOreItem)) {

                player.openInventory(diamondConfirmGui);

            } else if (clickedItem.equals(goldOreItem)) {

                player.openInventory(goldConfirmGui);

            } else if (clickedItem.equals(ironOreItem)) {

                player.openInventory(ironConfirmGui);

            }

        } else if(e.getInventory().equals(emeraldConfirmGui)) {

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(greenConcreteItem)){

                // Elytra itemstack 1
                ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
                ItemMeta elytraMeta = elytra.getItemMeta();
                elytraMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                elytra.setItemMeta(elytraMeta);
                // Trident itemstack 2
                ItemStack trident = new ItemStack(Material.TRIDENT, 1);
                ItemMeta tridentMeta = trident.getItemMeta();
                tridentMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                trident.setItemMeta(tridentMeta);
                // Enchanted apple 3
                ItemStack enchGoldApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
                // Netherite Scraps 4
                ItemStack netheriteSraps = new ItemStack(Material.NETHERITE_SCRAP, 32);
                // Crystals 5
                ItemStack crystals = new ItemStack(Material.END_CRYSTAL, 16);
                // Obsidian 6
                ItemStack obsidian = new ItemStack(Material.OBSIDIAN, 64);
                // Netherite Sword 7
                ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD, 1);
                ItemMeta netheriteSwordMeta = netheriteSword.getItemMeta();
                netheriteSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                netheriteSwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                netheriteSword.setItemMeta(netheriteSwordMeta);
                // Pigstep disc
                ItemStack pigstepDisc = new ItemStack(Material.MUSIC_DISC_PIGSTEP, 1);
                // Redeem 5000
                ItemStack redeem5000 = new ItemStack(Material.PAPER, 1);
                ItemMeta redeem5000Meta = redeem5000.getItemMeta();
                redeem5000Meta.setDisplayName(ChatColor.GREEN + "$5000 Check");
                ArrayList<String> redeem5000Lore = new ArrayList<>();
                redeem5000Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$5000");
                redeem5000Meta.setLore(redeem5000Lore);
                redeem5000.setItemMeta(redeem5000Meta);
                // Totem
                ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);

                String emeraldKeyPath = player.getUniqueId() + ".emerald_keys";

                if(MrIndia.getInstance().getKeysConfig().getInt(emeraldKeyPath) > 0){

                    // Emerald keys amount
                    int emeraldKeys = MrIndia.getInstance().getKeysConfig().getInt(emeraldKeyPath);
                    emeraldKeys = emeraldKeys - 1;
                    MrIndia.getInstance().getKeysConfig().set(emeraldKeyPath, emeraldKeys);

                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Rolling!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 1);
                    // Runnable and timer
                    new BukkitRunnable(){

                        int countdownSecs = 4;

                        @Override
                        public void run() {

                            if(countdownSecs == 0){

                                // Gives the player a random prize
                                ItemStack[] emeraldCrateRewards = {elytra, trident, enchGoldApple, netheriteSraps, netheriteSraps, crystals, obsidian, obsidian, netheriteSword, pigstepDisc, pigstepDisc, redeem5000, totem};
                                Random random = new Random();
                                int randomItem = random.nextInt(emeraldCrateRewards.length);
                                player.getInventory().addItem(emeraldCrateRewards[randomItem]);
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
                                player.sendMessage(ChatColor.AQUA + "Your reward has be given!");
                                cancel();

                            } else {
                                countdownSecs--;
                            }

                        }
                    }.runTaskTimer(MrIndia.getPlugin(MrIndia.class), 0, 20);

                } else {

                    player.sendMessage(ChatColor.RED + "You don't have enough emerald keys!");

                }

            } else if(clickedItem.equals(redConcreteItem)){

                player.closeInventory();

            } else if (clickedItem.equals(chestItem)){

                player.openInventory(insideEmeraldCrate);

            }

        } else if(e.getInventory().equals(diamondConfirmGui)){

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(greenConcreteItem)){

                // Reward 1
                ItemStack diamondOres = new ItemStack(Material.DIAMOND_ORE, 16);
                // Reward 2
                ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
                // Reward 3
                ItemStack crystals = new ItemStack(Material.END_CRYSTAL, 8);
                // Reward 4
                ItemStack goldenApples = new ItemStack(Material.GOLDEN_APPLE, 5);
                // Reward 5
                ItemStack ancientDebris = new ItemStack(Material.ANCIENT_DEBRIS, 8);
                // Reward 6
                ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta diamondSwordMeta = diamondSword.getItemMeta();
                diamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                diamondSwordMeta.addEnchant(Enchantment.DURABILITY, 2, true);
                diamondSword.setItemMeta(diamondSwordMeta);
                // Reward 7
                ItemStack diamondBlocks = new ItemStack(Material.DIAMOND_BLOCK, 4);
                // Reward 8
                ItemStack diamonds = new ItemStack(Material.DIAMOND, 32);
                // Reward 9
                ItemStack diamondPick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                ItemMeta diamondPickMeta = diamondPick.getItemMeta();
                diamondPickMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                diamondPickMeta.addEnchant(Enchantment.DURABILITY, 2, true);
                diamondPick.setItemMeta(diamondPickMeta);
                // Reward 10
                ItemStack redeem2500 = new ItemStack(Material.PAPER, 1);
                ItemMeta redeem2500Meta = redeem2500.getItemMeta();
                redeem2500Meta.setDisplayName(ChatColor.GREEN + "$2500 Check");
                ArrayList<String> redeem2500Lore = new ArrayList<>();
                redeem2500Lore.add(ChatColor.RED + "Right click to redeem " + ChatColor.YELLOW + "$2500");
                redeem2500Meta.setLore(redeem2500Lore);
                redeem2500.setItemMeta(redeem2500Meta);

                String diamondKeyPath = player.getUniqueId() + ".diamond_keys";

                if(MrIndia.getInstance().getKeysConfig().getInt(diamondKeyPath) > 0){

                    // Diamond keys amount
                    int diamondKeys = MrIndia.getInstance().getKeysConfig().getInt(diamondKeyPath);
                    diamondKeys = diamondKeys - 1;
                    MrIndia.getInstance().getKeysConfig().set(diamondKeyPath, diamondKeys);

                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Rolling!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 1);
                    // Runnable and timers
                    new BukkitRunnable(){

                        int countdownSecs = 4;

                        @Override
                        public void run() {

                            if(countdownSecs == 0){

                                // Gives random item
                                ItemStack[] diamondCrateRewards = {diamondOres, diamondOres, totem, crystals, goldenApples, goldenApples, ancientDebris, diamondSword, diamondBlocks, diamondBlocks, diamonds, diamonds, diamondPick, redeem2500};
                                Random random = new Random();
                                int randomItem = random.nextInt(diamondCrateRewards.length);
                                ItemStack chosenItem = new ItemStack(diamondCrateRewards[randomItem]);
                                player.getInventory().addItem(chosenItem);

                                // Plays sound and sends msg
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
                                player.sendMessage(ChatColor.AQUA + "Your reward has be given!");
                                cancel();

                            } else {
                                countdownSecs--;
                            }

                        }
                    }.runTaskTimer(MrIndia.getPlugin(MrIndia.class), 0, 20);

                } else {

                    player.sendMessage(ChatColor.RED + "You don't have enough diamond keys!");

                }

            } else if(clickedItem.equals(redConcreteItem)){

                player.closeInventory();

            } else if (clickedItem.equals(chestItem)){

                player.openInventory(insideDiamondCrate);

            }

        } else if(e.getInventory().equals(goldConfirmGui)){

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(greenConcreteItem)){

                // Reward 1
                ItemStack goldenApples = new ItemStack(Material.GOLDEN_APPLE, 2);
                // Reward 2
                ItemStack goldIngots = new ItemStack(Material.GOLD_INGOT, 32);
                // Reward 3
                ItemStack netheriteScraps = new ItemStack(Material.NETHERITE_SCRAP, 4);
                // Reward 4
                ItemStack goldBlocks = new ItemStack(Material.GOLD_BLOCK, 16);
                // Reward 5
                ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL, 16);
                // Reward 6
                ItemStack blazeRods = new ItemStack(Material.BLAZE_ROD, 16);
                // Reward 7
                ItemStack rawGoldBlocks = new ItemStack(Material.RAW_GOLD_BLOCK, 32);
                // Reward 8
                ItemStack ancientDebris = new ItemStack(Material.ANCIENT_DEBRIS, 8);
                // Reward 9
                ItemStack nameTag = new ItemStack(Material.NAME_TAG, 2);
                // Reward 10
                ItemStack netherWarts = new ItemStack(Material.NETHER_WART, 16);

                String goldKeyPath = player.getUniqueId() + ".gold_keys";

                if(MrIndia.getInstance().getKeysConfig().getInt(goldKeyPath) > 0){

                    // Gold keys amount
                    int goldKeys = MrIndia.getInstance().getKeysConfig().getInt(goldKeyPath);
                    goldKeys = goldKeys - 1;
                    MrIndia.getInstance().getKeysConfig().set(goldKeyPath, goldKeys);

                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Rolling!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 1);

                    // Runnable and timers
                    new BukkitRunnable(){

                        int countdownSecs = 4;

                        @Override
                        public void run() {

                            if(countdownSecs == 0){

                                // Gives random item
                                ItemStack[] goldCrateRewards = {goldenApples, goldIngots, netheriteScraps, goldBlocks, enderPearls, blazeRods, rawGoldBlocks, ancientDebris, nameTag, netherWarts};
                                Random random = new Random();
                                int randomItem = random.nextInt(goldCrateRewards.length);
                                ItemStack chosenItem = goldCrateRewards[randomItem];
                                player.getInventory().addItem(chosenItem);

                                // Plays sound and sends msg
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
                                player.sendMessage(ChatColor.AQUA + "Your reward has be given!");
                                cancel();

                            } else {
                                countdownSecs--;
                            }

                        }
                    }.runTaskTimer(MrIndia.getPlugin(MrIndia.class), 0, 20);

                } else {

                    player.sendMessage(ChatColor.RED + "You don't have enough gold keys!");

                }
            } else if(clickedItem.equals(redConcreteItem)){

                player.closeInventory();

            } else if (clickedItem.equals(chestItem)){

                player.openInventory(insideGoldCrate);

            }

        } else if(e.getInventory().equals(ironConfirmGui)){

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(greenConcreteItem)){

                // Reward 1
                ItemStack goldApple = new ItemStack(Material.GOLDEN_APPLE, 1);
                // Reward 2
                ItemStack rawIron = new ItemStack(Material.RAW_IRON, 32);
                // Reward 3
                ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL, 4);
                // Reward 4
                ItemStack ironBlocks = new ItemStack(Material.IRON_BLOCK, 16);
                // Reward 5
                ItemStack ironPick = new ItemStack(Material.IRON_PICKAXE, 1);
                ItemMeta ironPickMeta = ironPick.getItemMeta();
                ironPickMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                ironPick.setItemMeta(ironPickMeta);
                // Reward 6
                ItemStack netherWarts = new ItemStack(Material.NETHER_WART, 4);
                // Reward 7
                ItemStack nameTag = new ItemStack(Material.NAME_TAG, 2);
                // Reward 8
                ItemStack ironOres = new ItemStack(Material.IRON_ORE, 16);
                // Reward 9
                ItemStack diamonds = new ItemStack(Material.DIAMOND, 10);
                // Reward 10
                ItemStack lead = new ItemStack(Material.LEAD, 1);

                String ironKeyPath = player.getUniqueId() + ".iron_keys";

                if(MrIndia.getInstance().getKeysConfig().getInt(ironKeyPath) > 0){

                    // Gold keys amount
                    int ironKeys = MrIndia.getInstance().getKeysConfig().getInt(ironKeyPath);
                    ironKeys = ironKeys - 1;
                    MrIndia.getInstance().getKeysConfig().set(ironKeyPath, ironKeys);

                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Rolling!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 1);

                    // Runnable and timers
                    new BukkitRunnable(){

                        int countdownSecs = 4;

                        @Override
                        public void run() {

                            if(countdownSecs == 0){

                                // Gives random item
                                ItemStack[] ironCrateRewards = {goldApple, rawIron, enderPearls, ironBlocks, ironPick, netherWarts, nameTag, ironOres, diamonds, lead};
                                Random random = new Random();
                                int randomItem = random.nextInt(ironCrateRewards.length);
                                ItemStack chosenItem = ironCrateRewards[randomItem];
                                player.getInventory().addItem(chosenItem);

                                // Plays sound and sends msg
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
                                player.sendMessage(ChatColor.AQUA + "Your reward has be given!");
                                cancel();

                            } else {
                                countdownSecs--;
                            }

                        }
                    }.runTaskTimer(MrIndia.getPlugin(MrIndia.class), 0, 20);

                } else {

                    player.sendMessage(ChatColor.RED + "You don't have enough iron keys!");

                }


            } else if(clickedItem.equals(redConcreteItem)){

                player.closeInventory();

            } else if (clickedItem.equals(chestItem)){

                player.openInventory(insideIronCrate);

            }

        } else if(e.getInventory().equals(insideEmeraldCrate)){

            ItemStack backItem = new ItemStack(Material.EMERALD);
            ItemMeta backItemMeta = backItem.getItemMeta();
            backItemMeta.setDisplayName(ChatColor.YELLOW + "Back!");
            ArrayList<String> backItemLore = new ArrayList<>();
            backItemLore.add(ChatColor.RED + "Click to go back!");
            backItemMeta.setLore(backItemLore);
            backItem.setItemMeta(backItemMeta);

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(backItem)){

                player.openInventory(emeraldConfirmGui);

            } else return;

        } else if(e.getInventory().equals(insideDiamondCrate)){

            ItemStack backItem = new ItemStack(Material.EMERALD);
            ItemMeta backItemMeta = backItem.getItemMeta();
            backItemMeta.setDisplayName(ChatColor.YELLOW + "Back!");
            ArrayList<String> backItemLore = new ArrayList<>();
            backItemLore.add(ChatColor.RED + "Click to go back!");
            backItemMeta.setLore(backItemLore);
            backItem.setItemMeta(backItemMeta);


            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(backItem)){

                player.openInventory(diamondConfirmGui);

            } else return;

        } else if (e.getInventory().equals(insideGoldCrate)){

            ItemStack backItem = new ItemStack(Material.EMERALD);
            ItemMeta backItemMeta = backItem.getItemMeta();
            backItemMeta.setDisplayName(ChatColor.YELLOW + "Back!");
            ArrayList<String> backItemLore = new ArrayList<>();
            backItemLore.add(ChatColor.RED + "Click to go back!");
            backItemMeta.setLore(backItemLore);
            backItem.setItemMeta(backItemMeta);

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(backItem)){

                player.openInventory(goldConfirmGui);

            } else return;


        } else if (e.getInventory().equals(insideIronCrate)){

            ItemStack backItem = new ItemStack(Material.EMERALD);
            ItemMeta backItemMeta = backItem.getItemMeta();
            backItemMeta.setDisplayName(ChatColor.YELLOW + "Back!");
            ArrayList<String> backItemLore = new ArrayList<>();
            backItemLore.add(ChatColor.RED + "Click to go back!");
            backItemMeta.setLore(backItemLore);
            backItem.setItemMeta(backItemMeta);

            ItemStack clickedItem = e.getCurrentItem();
            e.setCancelled(true);

            if(clickedItem.equals(backItem)){

                player.openInventory(ironConfirmGui);

            } else return;

        } else return;


    }


}
