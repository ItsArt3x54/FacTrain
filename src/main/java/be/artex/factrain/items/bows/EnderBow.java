package be.artex.factrain.items.bows;

import be.artex.factrain.Main;
import be.artex.factrain.api.items.bow.BowItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityShootBowEvent;
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
                .setLore(ChatColor.RESET + "" + ChatColor.DARK_GRAY + "aUIplMoKmLLghvBNaOmK", ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "Infinity")
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
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
    public void onClick(Player player) {

    }

    @Override
    public void onArrowShot(EntityShootBowEvent e) {
        e.setProjectile(null);
        e.getEntity().launchProjectile(EnderPearl.class);
    }
}
