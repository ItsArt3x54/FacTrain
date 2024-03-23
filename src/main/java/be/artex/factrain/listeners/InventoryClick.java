package be.artex.factrain.listeners;

import be.artex.factrain.commands.itemCommands.BowCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getCurrentItem().equals(BowCommand.border)) {
            e.setCancelled(true);
        }
    }
}
