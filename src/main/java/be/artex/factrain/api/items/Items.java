package be.artex.factrain.api.items;

import be.artex.factrain.api.items.bow.BowItem;
import be.artex.factrain.api.items.sword.SwordItem;

import java.util.ArrayList;

public final class Items {
    public static ArrayList<Item> registeredItems = new ArrayList<>();
    public static ArrayList<BowItem> registeredBowItems = new ArrayList<>();
    public static ArrayList<SwordItem> registeredSwordItems = new ArrayList<>();

    public static void registerItem(Item item) {
        registeredItems.add(item);

        if (item instanceof BowItem) {
            registeredBowItems.add((BowItem) item);
        } else if (item instanceof SwordItem) {
            registeredSwordItems.add((SwordItem) item);
        }
    }
}
