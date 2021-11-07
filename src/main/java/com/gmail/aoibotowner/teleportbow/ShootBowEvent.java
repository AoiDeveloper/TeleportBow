package com.gmail.aoibotowner.teleportbow;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;

public class ShootBowEvent implements Listener {
    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        if(e.getEntity().getType() != EntityType.PLAYER) return;
        if(e.getBow() == null) return;
        Player p = (Player) e.getEntity();
        Entity entity = e.getProjectile();
        if(e.getBow().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(TeleportBow.getPlugin(), "teleport"), PersistentDataType.STRING)) {
            entity.getPersistentDataContainer().set(new NamespacedKey(TeleportBow.getPlugin(), "firedBy"), PersistentDataType.STRING, p.getName().toString());
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        if(e.getHitBlock() == null) return;
        if(e.getEntity().getPersistentDataContainer().has(new NamespacedKey(TeleportBow.getPlugin(), "firedBy"), PersistentDataType.STRING)) {
            Player p = TeleportBow.getPlugin().getServer().getPlayer(e.getEntity().getPersistentDataContainer().get(new NamespacedKey(TeleportBow.getPlugin(), "firedBy"), PersistentDataType.STRING));
            p.teleport(e.getHitBlock().getLocation());
            p.sendMessage(ChatColor.GOLD + "Teleported!");
        }
    }
}
