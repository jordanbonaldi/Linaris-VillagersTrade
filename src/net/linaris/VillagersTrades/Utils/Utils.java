package net.linaris.VillagersTrades.Utils;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

import net.linaris.VillagersTrades.VillagersTrades;

public class Utils {
	public static Villager getVillagerNear(Player player, String villagerName) {
		List<Entity> entities = player.getNearbyEntities(5, 5, 5);
		for(Entity entity : entities) {
			if(entity instanceof Villager) {
				Villager villager = (Villager) entity;
				if(villager.getCustomName().equals(villagerName)) return villager;
			}
		}
		return null;
	}
	
	public static boolean hasMetadata(Metadatable meta, String name) {
		if(!meta.hasMetadata(name)) return false;
		
		for(MetadataValue value : meta.getMetadata(name)) {
			if(value.getOwningPlugin().getName().equals(VillagersTrades.getPluginInstance().getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static MetadataValue getMetadata(Metadatable meta, String name) {
		if(!meta.hasMetadata(name)) return null;
		
		for(MetadataValue value : meta.getMetadata(name)) {
			if(value.getOwningPlugin().getName().equals(VillagersTrades.getPluginInstance().getName())) {
				return value;
			}
		}
		return null;
	}
}
