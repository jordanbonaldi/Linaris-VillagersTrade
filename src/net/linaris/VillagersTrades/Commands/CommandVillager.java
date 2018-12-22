package net.linaris.VillagersTrades.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.metadata.FixedMetadataValue;

import net.linaris.VillagersTrades.VillagersTrades;
import net.linaris.VillagersTrades.Config.Translation;
import net.linaris.VillagersTrades.Utils.Utils;

public class CommandVillager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.isOp()) {
			sender.sendMessage(Translation.getString("ONLY_OP"));
			return true;
		}
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		if(args.length == 2) {
			if(args[1].equalsIgnoreCase("setinvincible")) {
				Villager villager = Utils.getVillagerNear(player, args[0]);
				if(villager == null) {
					player.sendMessage(Translation.getString("NO_VILLAGER"));
				}
				else {
					if(Utils.hasMetadata(villager, "invincible")) {
						player.sendMessage(Translation.getString("VILLAGER_ALWAYS_INVINCIBLE"));
						return true;
					}
					villager.setMetadata("invincible", new FixedMetadataValue(VillagersTrades.getPluginInstance(), true));
					player.sendMessage(Translation.getString("VILLAGER_INVINSIBLE").replaceAll("<name>", args[0]));
				}
				return true;
			}
			else if(args[1].equalsIgnoreCase("supinvincible")) {
				Villager villager = Utils.getVillagerNear(player, args[0]);
				if(villager == null) {
					player.sendMessage(Translation.getString("NO_VILLAGER"));
				}
				else {
					if(!Utils.hasMetadata(villager, "invincible")) {
						player.sendMessage(Translation.getString("VILLAGER_NOT_INVINCIBLE"));
						return true;
					}
					villager.removeMetadata("invincible", VillagersTrades.getPluginInstance());
					player.sendMessage(Translation.getString("VILLAGER_PLUS_INVINSIBLE").replaceAll("<name>", args[0]));
				}
				return true;
			}
			else if(args[1].equalsIgnoreCase("delete")) {
				Villager villager = Utils.getVillagerNear(player, args[0]);
				if(villager == null) {
					player.sendMessage(Translation.getString("NO_VILLAGER"));
				}
				else {
					villager.remove();
					player.sendMessage(Translation.getString("VILLAGER_DELETE").replaceAll("<name>", args[0]));
				}
				return true;
			}
			else if(args[0].equalsIgnoreCase("spawn")) {
				Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
				villager.setMetadata("invincible", new FixedMetadataValue(VillagersTrades.getPluginInstance(), true));
				villager.setCustomName(args[1]);
				return true;
			}
		}
		
		return false;
	}

}
