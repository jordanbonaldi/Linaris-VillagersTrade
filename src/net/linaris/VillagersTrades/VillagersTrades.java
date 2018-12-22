package net.linaris.VillagersTrades;

import org.bukkit.plugin.java.JavaPlugin;

import net.linaris.VillagersTrades.Commands.CommandVillager;
import net.linaris.VillagersTrades.Listeners.VillagersListener;

public class VillagersTrades extends JavaPlugin {
	private static VillagersTrades pluginInstance;
	public static VillagersTrades getPluginInstance() {
		return pluginInstance;
	}
	
	
	public void onEnable() {
		pluginInstance = this;
		
		this.getCommand("villager").setExecutor(new CommandVillager());
		getServer().getPluginManager().registerEvents(new VillagersListener(), this);
	}
}
