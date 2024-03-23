package be.artex.factrain.api.items.bow;

import be.artex.factrain.api.items.Item;
import org.bukkit.event.entity.ProjectileHitEvent;

public abstract class BowItem extends Item {
    public abstract void onArrowLand(ProjectileHitEvent e);


}
