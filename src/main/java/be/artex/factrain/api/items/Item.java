package be.artex.factrain.api.items;

import be.artex.factrain.api.items.bow.BowItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Item {
    public abstract ItemStack getStack();
    public abstract UUID getID();
    public abstract void onClick();
}
