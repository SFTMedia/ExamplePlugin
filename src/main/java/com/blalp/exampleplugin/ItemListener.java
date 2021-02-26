package com.blalp.exampleplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ItemListener implements Listener {
    @EventHandler
    public void onItemClcik(InventoryClickEvent e) {
        if(e.getClickedInventory()==null){
            // User clicked in free space, no need to cancel.
            return;
        }
        // Since we made all of our inventories with our own CustomInvetoryHolder, we can just check the holder's type to see if the inventory is ours.
        if (e.getClickedInventory().getHolder() instanceof CustomInvetoryHolder) {
            e.setCancelled(true);
        }
    }
}