package be.artex.factrain.api.items.sword;

import be.artex.factrain.api.items.Item;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public abstract class SwordItem extends Item {
    public abstract void onHit(EntityDamageByEntityEvent e);
}
