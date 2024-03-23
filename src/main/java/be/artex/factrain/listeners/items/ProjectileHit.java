package be.artex.factrain.listeners.items;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileHit implements Listener {

    ItemStack bow = null;
    Player shooter = null;

    @EventHandler
    public void onBow(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            shooter = (Player) e.getEntity();
            bow = e.getBow();
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player) {
            Arrow arrow = (Arrow) e.getEntity();
            if (arrow.getShooter().equals(shooter)) {
                for (BowItem item : Items.registeredBowItems) {
                    if (isSimilar(item.getStack(), bow)) {
                        item.onArrowLand(e);
                        break;
                    }
                }
            }
        }
    }

    private boolean isSimilar(ItemStack stack1, ItemStack stack2) {
        if (stack1 == null || stack2 == null) {
            return false;
        }
        if (stack1.getType() != stack2.getType()) {
            return false;
        }
        // You may want to compare additional properties like item metadata here
        return true;
    }
}
