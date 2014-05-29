package io.github.Bproth.destroymonument;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.World;
import org.bukkit.event.block.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MonumentListener implements Listener {
	
	private Block monument;
	private World world;
	private int team;

	public MonumentListener(int[] coords, World cur, int teamNum) {
		world = cur;
		
		monument = world.getBlockAt(coords[0], coords[1], coords[2]);
		team = teamNum;
	}
	
	@EventHandler
	public void onDestroy(BlockBreakEvent event) {
		Block b = event.getBlock();
		Player breaker = event.getPlayer();
		String breakerName = breaker.getDisplayName();
		String monumentName = "Monument " + team;
		if (b == monument) {
			for (Player player: Bukkit.getServer().getOnlinePlayers()) {
				player.sendMessage(breakerName + " has broken " + monumentName);
			}
		}
	}
}
