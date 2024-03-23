package be.artex.factrain.items.bows;

import be.artex.factrain.api.items.bow.BowItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

public class EnderBow extends BowItem {
    public final ItemStack stack;
    public final UUID itemId;

    public EnderBow() {
        itemId = UUID.randomUUID();

        stack = ItemBuilder.create(Material.BOW)
                .displayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Arc de l'Ender")
                .setLore(ChatColor.RESET + "" + ChatColor.DARK_GRAY + "aUIplMoKmLLghvBNaOmK", ChatColor.RESET + "" + ChatColor.RED + "Flame" + ChatColor.DARK_GRAY + ", " + ChatColor.LIGHT_PURPLE + "Power 5" + ChatColor.DARK_GRAY + ", " + ChatColor.DARK_PURPLE + "Infinity")
                .addEnchant(Enchantment.ARROW_DAMAGE, 5)
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
                .addEnchant(Enchantment.DURABILITY, 5, false)
                .addEnchant(Enchantment.ARROW_FIRE, 1)
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
    public void onArrowLand(ProjectileHitEvent e) {
        Entity arrow = e.getEntity();
        ProjectileSource source = ((Projectile) arrow).getShooter();

        if (!(source instanceof Player)) {
            return;
        }

        Player player = (Player) source;

        player.teleport(e.getEntity().getLocation());
    }
}
