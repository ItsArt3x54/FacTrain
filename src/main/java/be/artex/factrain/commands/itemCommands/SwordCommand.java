package be.artex.factrain.commands.itemCommands;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import be.artex.factrain.api.items.sword.SwordItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SwordCommand implements CommandExecutor {
    Inventory sword;

    public SwordCommand() {
        sword = Bukkit.createInventory(null, 27, "swords");
    }

    private Inventory prepareBowInv() {
        ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta itemMeta = border.getItemMeta();
        itemMeta.setDisplayName(" ");
        border.setItemMeta(itemMeta);

        sword.setItem(0, border);
        sword.setItem(1, border);
        sword.setItem(2, border);
        sword.setItem(3, border);
        sword.setItem(4, border);
        sword.setItem(5, border);
        sword.setItem(6, border);
        sword.setItem(7, border);
        sword.setItem(8, border);
        sword.setItem(9, border);
        sword.setItem(17, border);
        sword.setItem(18, border);
        sword.setItem(19, border);
        sword.setItem(20, border);
        sword.setItem(21, border);
        sword.setItem(22, border);
        sword.setItem(23, border);
        sword.setItem(24, border);
        sword.setItem(25, border);
        sword.setItem(26, border);

        int v = 9;

        for (SwordItem item : Items.registeredSwordItems) {
            v++;
            sword.setItem(v, item.getStack());
        }

        return sword;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        prepareBowInv();

        ((Player) sender).openInventory(sword);

        return true;
    }
}
