package net.linaris.VillagersTrades.Config;

import java.util.HashMap;

import org.bukkit.ChatColor;

public class Translation {
	private HashMap<String, String> lang = new HashMap<String, String>();
	
	private static Translation instance = null;
	public static String getString(String key) {
		if(instance == null) instance = new Translation();
		return instance.getStringLocale(key);
	}
	
	private Translation() {
		try {			
			// Valeurs par defaut
			lang.put("ONLY_OP", "&4Vous devez être op !");
			lang.put("NO_VILLAGER", "&4Le villageois n'existe pas !");
			
			lang.put("VILLAGER_INVINSIBLE", "&2Villageoi <name> invinsible !");
			lang.put("VILLAGER_PLUS_INVINSIBLE", "&2Le villageoi <name> n'est plus invinsible !");
			lang.put("VILLAGER_DELETE", "&2Villageoi <name> supprimé !");
			
			lang.put("VILLAGER_ALWAYS_INVINCIBLE", "&4Le villageoi <name> est déjà invinsible !");
			lang.put("VILLAGER_NOT_INVINCIBLE", "&4Le villageoi <name> n'est pas déjà invinsible !");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getStringLocale(String key) {
		return ChatColor.translateAlternateColorCodes('&', lang.get(key));
	}
}
