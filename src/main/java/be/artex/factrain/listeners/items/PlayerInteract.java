package be.artex.factrain.listeners.items;

import be.artex.factrain.api.Run;
import be.artex.factrain.api.items.Item;
import be.artex.factrain.api.items.Items;
import be.artex.factrain.commands.itemCommands.SwordCommand;
import be.artex.factrain.listeners.gameLoop.PlayerJoin;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class PlayerInteract implements Listener {
    public static void prepareGear(Run run) {
        PlayerInventory player = run.getPlayer().getInventory();


        ItemStack potionItem = new ItemStack(Material.POTION);
        Potion potion = new Potion(PotionType.INSTANT_HEAL, 2);
        ItemStack[] armorContents = {
                ItemBuilder.create(Material.DIAMOND_BOOTS)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_LEGGINGS)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_CHESTPLATE)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_HELMET)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build()
        };

        potion.setSplash(true); // Make it a splash potion
        potion.apply(potionItem);

        player.addItem(run.getSword().getStack());
        player.addItem(run.getBow().getStack());

        player.addItem(new ItemStack(Material.GOLDEN_APPLE, 16));
        player.setArmorContents(armorContents);

        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(new ItemStack(Material.ARROW));
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
        player.addItem(potionItem);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getItem() == null)
            return;

        if (e.getItem().equals(PlayerJoin.play)) {
            e.getPlayer().openInventory(SwordCommand.prepareSwordInv());
            return;
        }

        for (Item item : Items.registeredItems) {
            if (item.getStack().equals(e.getItem())) {
                item.onClick(e.getPlayer());
                break;
            }
        }
    }
}
