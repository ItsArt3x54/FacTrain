package be.artex.factrain.listeners.gameLoop;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {
    public static final ItemStack play = ItemBuilder.create(Material.DIAMOND_AXE)
            .displayName(ChatColor.RESET + "Jouer")
            .build();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        World world = Bukkit.getWorlds().get(0);

        player.getInventory().clear();

        for (PotionEffect pe : player.getActivePotionEffects()) {
            player.getActivePotionEffects().remove(pe);
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));

        player.getInventory().setItem(4, play);

        player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 122, 0));
        player.setGameMode(GameMode.ADVENTURE);

        world.getWorldBorder().setCenter(0, 0);
        world.getWorldBorder().setSize(140);
    }
}
