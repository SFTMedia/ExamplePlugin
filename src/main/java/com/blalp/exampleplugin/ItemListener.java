package com.blalp.exampleplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class ItemListener implements Listener {
    @EventHandler
    public void onItemInteract(InventoryInteractEvent e) {
        // Since we made all of our inventories with our own CustomInvetoryHolder, we can just check the holder's type to see if the inventory is ours.
        if (e.getInventory().getHolder() instanceof CustomInvetoryHolder) {
            e.setCancelled(true);
            System.out.println("Canceled item movement");
        }
    }
    @EventHandler
    public void onItemMove(InventoryMoveItemEvent e) {
        // Since we made all of our inventories with our own CustomInvetoryHolder, we can just check the holder's type to see if the inventory is ours.
        if (e.getSource().getHolder() instanceof CustomInvetoryHolder) {
            e.setCancelled(true);
            System.out.println("Canceled item movement");
        }
    }
}