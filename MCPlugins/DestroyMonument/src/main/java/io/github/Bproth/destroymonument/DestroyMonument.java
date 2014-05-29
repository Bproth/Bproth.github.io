package io.github.Bproth.destroymonument;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.World;

public class DestroyMonument extends JavaPlugin {

	private static int[][] monuments;
	private static int monCount;
	private static World world;
	
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked");
		world = getServer().getWorld(getConfig().getString("worldName"));
		monCount = getConfig().getInt("numberOfMonuments");
		monuments = new int[monCount][];
		for (int i = 0; i < monCount; i++) {
			int[] monCoord = new int[3];
			monCoord[0] = getConfig().getInt("monument" + (i+1) + ".x");
			monCoord[1] = getConfig().getInt("monument" + (i+1) + ".x");
			monCoord[2] = getConfig().getInt("monument" + (i+1) + ".x");
			monuments[i] = monCoord;
		}
		for (int i = 0; i < monCount; i++) {
			getServer().getPluginManager().registerEvents(new MonumentListener(monuments[i], world, i), this);
		}
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked");
	}
	

}
