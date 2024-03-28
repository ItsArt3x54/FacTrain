package be.artex.factrain.listeners.items;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ProjectileHit implements Listener {
    @EventHandler
    public void onBow(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        for (BowItem item : Items.registeredBowItems) {
            if (e.getBow().equals(item.getStack())) {
                item.onArrowShot(e);
                break;
            }
        }
    }
}
