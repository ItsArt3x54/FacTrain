package be.artex.factrain.api;

import be.artex.factrain.api.items.bow.BowItem;
import be.artex.factrain.api.items.sword.SwordItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Run {
    private UUID player;
    private SwordItem sword;
    private BowItem bow;

    public Run(UUID player, SwordItem sword, BowItem bow) {
        this.player = player;
        this.sword = sword;
        this.bow = bow;
    }

    public BowItem getBow() {
        return bow;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(player);
    }

    public SwordItem getSword() {
        return sword;
    }

    public void setBow(BowItem bow) {
        this.bow = bow;
    }

    public void setPlayer(UUID player) {
        this.player = player;
    }

    public void setSword(SwordItem sword) {
        this.sword = sword;
    }
}
