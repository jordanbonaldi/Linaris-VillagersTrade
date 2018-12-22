package net.linaris.VillagersTrades.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagersListener implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void onEntityDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if(event.getEntityType() == EntityType.VILLAGER) {
			if(entity.hasMetadata("invincible")) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		if(!(event.getRightClicked() instanceof Villager)) return;
		if(event.getPlayer().getItemInHand() != null) {
			if(event.getPlayer().getItemInHand().getType() == Material.NAME_TAG) {
				Villager villager = (Villager) event.getRightClicked();
				if(villager.getCustomName() != null) {
					event.setCancelled(true);
				}
			}
		}
	}
}
