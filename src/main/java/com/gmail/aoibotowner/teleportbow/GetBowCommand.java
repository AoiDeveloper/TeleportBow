package com.gmail.aoibotowner.teleportbow;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class GetBowCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack bow = new ItemStack(Material.BOW, 1);
            ItemMeta meta = bow.getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(TeleportBow.getPlugin(), "teleport"), PersistentDataType.STRING, p.getUniqueId().toString());
            bow.setItemMeta(meta);
            p.getInventory().addItem(bow);
            return true;
        }
        return false;
    }
}
