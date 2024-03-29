package be.artex.factrain.listeners;

import be.artex.factrain.Main;
import be.artex.factrain.api.Run;
import be.artex.factrain.api.Runs;
import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import be.artex.factrain.api.items.sword.SwordItem;
import be.artex.factrain.commands.itemCommands.BowCommand;
import be.artex.factrain.commands.itemCommands.SwordCommand;
import be.artex.factrain.listeners.items.PlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

import static be.artex.factrain.listeners.items.PlayerInteract.prepareGear;

public class InventoryClick implements Listener {
    public static Inventory clickedInventory;
    public static ItemStack clickedItem;
    public static Player player;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }

        if (e.getCurrentItem() == null) {
            return;
        }

        player = (Player) e.getWhoClicked();

        clickedInventory = e.getClickedInventory();
        clickedItem = e.getCurrentItem();

        if (clickedItem.equals(BowCommand.border)) {
            e.setCancelled(true);
            return;
        }

        SwordItem sword = null;
        BowItem bow = null;

        if (clickedInventory.equals(SwordCommand.prepareSwordInv())) {
            for (SwordItem item : Items.registeredSwordItems) {
                if (clickedItem.equals(item.getStack())) {
                    sword = item;
                }
            }

            e.setCancelled(true);

            Runs.setPlayerRun(player, new Run(e.getWhoClicked().getUniqueId(), sword, null));

            Bukkit.getScheduler().runTask(Main.PLUGIN, () -> {
                player.closeInventory();
                player.openInventory(BowCommand.prepareBowInv());
            });
        }

        if (clickedInventory.equals(BowCommand.prepareBowInv())) {
            for (BowItem item : Items.registeredBowItems) {
                if (clickedItem.equals(item.getStack())) {
                    bow = item;
                }
            }

            e.setCancelled(true);
            Run run = Runs.getPlayerRun(player);
            run.setBow(bow);
            Runs.setPlayerRun(player, run);

            player.setItemInHand(null);
            player.setGameMode(GameMode.SURVIVAL);

            int x = new Random().nextInt(70);
            int z = new Random().nextInt(70);

            player.teleport(new Location(Bukkit.getWorlds().get(0), x, Bukkit.getWorlds().get(0).getHighestBlockYAt(x, z), z));

            PlayerInteract.prepareGear(Runs.getPlayerRun(player));
        }
    }
}
