package be.artex.factrain.api;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public final class Runs {
    public static HashMap<UUID, Run> playerRuns = new HashMap<>();

    public static void setPlayerRun(Player player, Run run) {
        if (playerRuns.get(player.getUniqueId()) != null) {
            playerRuns.remove(player.getUniqueId());
        }

        playerRuns.put(player.getUniqueId(), run);
    }

    public static void deletePlayerRun(Player player) {
        playerRuns.remove(player.getUniqueId());
    }

    public static Run getPlayerRun(Player player) {
        return playerRuns.get(player.getUniqueId());
    }

    public static HashMap<UUID, Run> getPlayerRuns() {
        return playerRuns;
    }
}
