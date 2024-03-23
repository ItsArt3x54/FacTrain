package be.artex.factrain.items.swords;

import be.artex.factrain.api.items.sword.SwordItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class AssasinSword extends SwordItem {
    public final ItemStack stack;
    public final UUID itemId;

    public AssasinSword() {
        itemId = UUID.randomUUID();

        stack = ItemBuilder.create(Material.DIAMOND_SWORD)
                .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Lame de l'assasin")
                .setLore(ChatColor.RESET + "" + ChatColor.DARK_GRAY + "uIoPMlkhJNBfGhBNaEhJ", ChatColor.RESET + "" + ChatColor.RED + "Fire Aspect 2" + ChatColor.DARK_GRAY + ", " + ChatColor.LIGHT_PURPLE + "Sharpness 6")
                .addEnchant(Enchantment.FIRE_ASPECT, 2)
                .addEnchant(Enchantment.DAMAGE_ALL, 6, false)
                .addEnchant(Enchantment.DURABILITY, 5, false)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .build();
    }

    @Override
    public ItemStack getStack() {
        return stack;
    }

    @Override
    public UUID getID() {
        return itemId;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onHit(EntityDamageByEntityEvent e) {

    }
}
