package be.artex.factrain.listeners.gameLoop;

import be.artex.factrain.api.Runs;
import be.artex.factrain.listeners.items.PlayerInteract;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerRespawn implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));

        player.getInventory().setItem(4, PlayerJoin.play);
    }

    @EventHandler
    public void onPlayerDie(PlayerDeathEvent e) {
        for (ItemStack itemStack : e.getDrops()) {
            itemStack.setType(Material.AIR);
        }

        e.getEntity().getKiller().getInventory().clear();
        PlayerInteract.prepareGear(Runs.getPlayerRun(e.getEntity().getKiller()));

        e.getEntity().getKiller().setHealth(e.getEntity().getKiller().getMaxHealth());
    }
}
