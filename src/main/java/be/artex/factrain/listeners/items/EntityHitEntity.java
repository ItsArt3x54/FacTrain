package be.artex.factrain.listeners.items;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.sword.SwordItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityHitEntity implements Listener {
    @EventHandler
    public void onEntityHitEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            for (SwordItem item : Items.registeredSwordItems) {
                if (item.getStack().equals(((Player) e.getDamager()).getItemInHand())) {
                    item.onHit(e);
                    break;
                }
            }
        }
    }
}
