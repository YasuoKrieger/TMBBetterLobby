package me.xenodev.tmbbl.events.profil.main;

import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ProfilEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getType().equals(Material.PLAYER_HEAD)) {
                if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §aProfil §7«")) {
                    Inventory inv = Bukkit.createInventory(null, 9 * 6, "§7» §aProfil §7«");

                    for (int i = 0; i < 54; i++) {
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    inv.setItem(12, new ItemBuilder(Material.PLAYER_HEAD).setOwnerURL("http://textures.minecraft.net/texture/9d4c9997ad46fdf900720c189720977fdee3742ab9ae9ffb00e5af9417d0454e").setName("§7» §6Köpfe §7«").build());
                    inv.setItem(19, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Kleiderschrank §7«").build());
                    inv.setItem(38, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());

                    inv.setItem(14, new ItemBuilder(Material.CHEST).setName("§7» §6Gadgets §7«").build());
                    inv.setItem(25, new ItemBuilder(Material.ENDER_CHEST).setName("§7» §6Shop §7«").build());
                    inv.setItem(42, new ItemBuilder(Material.REDSTONE).setName("§7» §6Settings §7«").build());

                    p.openInventory(inv);
                }
            }
        } catch (NullPointerException e1) {}
    }
}
