package me.xenodev.tmbbl.events.profil.trail.love;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (SettingsFilebuilder.getArmor(p, "Spur", "Love").equals(true)) {
            if (SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.CREATIVE)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (SettingsFilebuilder.getSetting(all, "Hide").equals(true)) {
                            Location loc = p.getLocation().add(0, 0.2, 0);
                            Object packet = Main.particles_1_13.HEART().packet(true, loc);
                            Main.particles_1_13.sendPacket(p, packet);
                        } else {
                            Location loc = p.getLocation().add(0, 0.2, 0);
                            Object packet = Main.particles_1_13.HEART().packet(true, loc);
                            Main.particles_1_13.sendPacket(all, packet);
                        }
                    }
                } else {
                    Location loc = p.getLocation().add(0, 0.2, 0);
                    Object packet = Main.particles_1_13.HEART().packet(true, loc);
                    Main.particles_1_13.sendPacket(p, packet);
                }
            } else {
                Location loc = p.getLocation().add(0, 0.2, 0);
                Object packet = Main.particles_1_13.HEART().packet(true, loc);
                Main.particles_1_13.sendPacket(p, packet);
            }
        }
    }

}
