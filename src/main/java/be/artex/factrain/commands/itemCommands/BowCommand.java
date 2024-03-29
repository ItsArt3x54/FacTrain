package be.artex.factrain.commands.itemCommands;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BowCommand implements CommandExecutor {
    public static Inventory inventory;
    public static ItemStack border;

    public BowCommand() {
        inventory = Bukkit.createInventory(null, 27, "bows");
        border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta itemMeta = border.getItemMeta();
        itemMeta.setDisplayName(" ");
        border.setItemMeta(itemMeta);
    }

    public static Inventory prepareBowInv() {
        inventory.setItem(0, border);
        inventory.setItem(1, border);
        inventory.setItem(2, border);
        inventory.setItem(3, border);
        inventory.setItem(4, border);
        inventory.setItem(5, border);
        inventory.setItem(6, border);
        inventory.setItem(7, border);
        inventory.setItem(8, border);
        inventory.setItem(9, border);
        inventory.setItem(17, border);
        inventory.setItem(18, border);
        inventory.setItem(19, border);
        inventory.setItem(20, border);
        inventory.setItem(21, border);
        inventory.setItem(22, border);
        inventory.setItem(23, border);
        inventory.setItem(24, border);
        inventory.setItem(25, border);
        inventory.setItem(26, border);

        int v = 9;

        for (BowItem item : Items.registeredBowItems) {
            v++;
            inventory.setItem(v, item.getStack());
        }

        return inventory;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        prepareBowInv();

        ((Player) sender).openInventory(inventory);

        return true;
    }
}
