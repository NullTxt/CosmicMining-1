package net.goldmc.cosmicmining.Listeners;

import net.goldmc.cosmicmining.Config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

public class onJoin implements Listener {
    @EventHandler
    public static void joinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID u = p.getUniqueId();


        Config.getCustomConfig2().set("Players." + e.getPlayer().getUniqueId() + ".Username", p.getName());
        Config.saveConfig2();
        boolean miningUUID = Config.getCustomConfig3().contains("Levels." + e.getPlayer().getUniqueId().toString());
        if(!(miningUUID)) {
            Config.getCustomConfig3().set("Levels." + e.getPlayer().getUniqueId().toString() + ".level", 1);
            Config.getCustomConfig3().set("Levels." + e.getPlayer().getUniqueId().toString() + ".xp", 0);
            Config.saveConfig3();
        }
        int Level = Integer.parseInt(Config.getCustomConfig3().getString("Levels." + e.getPlayer().getUniqueId().toString()+ ".level"));
        int xp = Integer.parseInt(Config.getCustomConfig3().getString("Levels." + e.getPlayer().getUniqueId().toString()+ ".xp"));
        p.setLevel(Level);
        //net.goldmc.cosmicmining.Database.Data.setPlayerData(u, Config.getCustomConfig3().getInt("Levels." + e.getPlayer().getUniqueId().toString() + ".level"), Config.getCustomConfig3().getInt("Levels." + e.getPlayer().getUniqueId().toString() + ".xp"));
        p.setExp(xp);
    }
}
