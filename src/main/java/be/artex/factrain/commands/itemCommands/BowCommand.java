package be.artex.factrain.commands.itemCommands;

import be.artex.factrain.api.items.Item;
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
    Inventory bows;
    public static ItemStack border;

    public BowCommand() {
        bows = Bukkit.createInventory(null, 27, "bows");
        border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta itemMeta = border.getItemMeta();
        itemMeta.setDisplayName(" ");
        border.setItemMeta(itemMeta);
    }

    private Inventory prepareBowInv() {
        bows.setItem(0, border);
        bows.setItem(1, border);
        bows.setItem(2, border);
        bows.setItem(3, border);
        bows.setItem(4, border);
        bows.setItem(5, border);
        bows.setItem(6, border);
        bows.setItem(7, border);
        bows.setItem(8, border);
        bows.setItem(9, border);
        bows.setItem(17, border);
        bows.setItem(18, border);
        bows.setItem(19, border);
        bows.setItem(20, border);
        bows.setItem(21, border);
        bows.setItem(22, border);
        bows.setItem(23, border);
        bows.setItem(24, border);
        bows.setItem(25, border);
        bows.setItem(26, border);

        int v = 9;

        for (BowItem item : Items.registeredBowItems) {
            v++;
            bows.setItem(v, item.getStack());
        }

        return bows;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        prepareBowInv();

        ((Player) sender).openInventory(bows);

        return true;
    }
}
