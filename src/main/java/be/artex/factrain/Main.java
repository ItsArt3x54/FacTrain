package be.artex.factrain;

import be.artex.factrain.api.items.Items;
import be.artex.factrain.commands.itemCommands.BowCommand;
import be.artex.factrain.commands.itemCommands.SwordCommand;
import be.artex.factrain.items.bows.EnderBow;
import be.artex.factrain.items.swords.AssasinSword;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("bow").setExecutor(new BowCommand());
        this.getCommand("sword").setExecutor(new SwordCommand());

        Items.registerItem(new EnderBow());
        Items.registerItem(new AssasinSword());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
