package io.github.Bproth.destroymonument;

import org.bukkit.plugin.java.JavaPlugin;

public class DestroyMonument extends JavaPlugin {

	private static int[][] monuments;
	private static int monCount;
	private static String world;
	
	@Override
	public void onEnable() {
//		getLogger().info("onEnable has been invoked");
		world = getConfig().getString("worldName");
//		monCount = getConfig().getInt("numberOfMonuments");
//		monuments = new int[monCount][];
//		
//		for (int i = 0; i < monCount; i++) {
//			int[] monCoord = new int[3];
//			monCoord[0] = getConfig().getInt("monument" + (i+1) + ".x");
//			monCoord[1] = getConfig().getInt("monument" + (i+1) + ".y");
//			monCoord[2] = getConfig().getInt("monument" + (i+1) + ".z");
//			monuments[i] = monCoord;
//		}
//		
//		for (int i = 0; i < monCount; i++) {
//			getServer().getPluginManager().registerEvents(new MonumentListener(monuments[i], world, i), this);
//		}
		
		int[] spawn = {0,0,66};
		getServer().getPluginManager().registerEvents(new MonumentListener(spawn, world, 0), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked");
	}
	

}
