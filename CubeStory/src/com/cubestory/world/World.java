package com.cubestory.world;

import com.cubestory.entity.Player;


public class World {

	private String worldName;
	private Player player;
	
	public World(String name) {
		worldName = name;
		player = new Player(100);
	}
	
	public World(String name, Player p) {
		worldName = name;
		player = p;
	}
	
	public String getWorldName() {
		return worldName;
	}
	
	public Player getPlayer() {
		return player;
	}
}
