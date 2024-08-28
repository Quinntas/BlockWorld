package com.blockworld.blockWorld.modules.Stats;

import com.blockworld.blockWorld.utils.CustomInventory;
import com.blockworld.blockWorld.utils.CustomItem;
import com.blockworld.blockWorld.utils.ItemTriggerGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StatsGUI extends ItemTriggerGUI {
    public StatsGUI() {
        super();
        setTitle(ChatColor.DARK_GREEN + "Stats");
        setInv(this.statsInvFactory());
        setItemTrigger(this.statsItemFactory());
    }

    @Override
    protected void handleItemClick(ItemStack item) {
        switch (item.getType()) {
            case DIAMOND:
                System.out.println("Survival");
                break;
            case GRASS_BLOCK:
                System.out.println("Creative");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    private CustomInventory statsInvFactory() {
        CustomInventory statsInv = new CustomInventory("Stats", 9 * 6);

        ItemStack survival = new ItemStack(Material.DIAMOND);
        ItemMeta survivalMeta = survival.getItemMeta();

        ItemStack creative = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta creativeMeta = creative.getItemMeta();

        assert survivalMeta != null;
        survivalMeta.setDisplayName(ChatColor.GREEN + "Survival");
        survival.setItemMeta(survivalMeta);

        assert creativeMeta != null;
        creativeMeta.setDisplayName(ChatColor.GREEN + "Creative");
        creative.setItemMeta(creativeMeta);

        statsInv.setItem(1, survival);
        statsInv.setItem(4, creative);
        statsInv.setItem(6, creative);

        return statsInv;
    }

    private CustomItem statsItemFactory() {
        return new CustomItem(Material.DIAMOND, ChatColor.GREEN + "Stats", "stats");
    }
}

