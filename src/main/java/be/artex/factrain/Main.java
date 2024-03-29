package be.artex.factrain;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.commands.itemCommands.BowCommand;
import be.artex.factrain.commands.itemCommands.SwordCommand;
import be.artex.factrain.items.bows.CupidonBow;
import be.artex.factrain.items.bows.EnderBow;
import be.artex.factrain.items.swords.AssasinSword;
import be.artex.factrain.listeners.InventoryClick;
import be.artex.factrain.listeners.gameLoop.PlayerJoin;
import be.artex.factrain.listeners.gameLoop.PlayerRespawn;
import be.artex.factrain.listeners.items.EntityHitEntity;
import be.artex.factrain.listeners.items.PlayerInteract;
import be.artex.factrain.listeners.items.ProjectileHit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin PLUGIN;

    @Override
    public void onEnable() {
        PLUGIN = this;

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        this.getServer().getPluginManager().registerEvents(new EntityHitEntity(), this);
        this.getServer().getPluginManager().registerEvents(new ProjectileHit(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        Items.registerItem(new EnderBow());
        Items.registerItem(new AssasinSword());
        Items.registerItem(new CupidonBow());

        int halfSize = 4;
        int centerX = 0;
        int centerY = 120;
        int centerZ = 0;
        World world = Bukkit.getWorlds().get(0);

        for (int x = centerX - halfSize; x <= centerX + halfSize; x++) {
            for (int z = centerZ - halfSize; z <= centerZ + halfSize; z++) {
                Block block = world.getBlockAt(x, centerY, z);
                block.setType(Material.GLASS);
            }
        }

        for (int x = centerX - halfSize - 1; x <= centerX + halfSize + 1; x++) {
            for (int z = centerZ - halfSize - 1; z <= centerZ + halfSize + 1; z++) {
                if (x == centerX - halfSize - 1 || x == centerX + halfSize + 1 || z == centerZ - halfSize - 1 || z == centerZ + halfSize + 1) {
                    for (int y = centerY; y <= centerY + 3; y++) {
                        Block block = world.getBlockAt(x, y, z);
                        block.setType(Material.GLASS);
                    }
                }
            }
        }

        world.setSpawnLocation(0, 122, 0);
    }
}
