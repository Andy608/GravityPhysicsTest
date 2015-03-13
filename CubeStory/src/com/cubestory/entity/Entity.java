package com.cubestory.entity;

import com.cubestory.world.WorldObject;
import com.cubestory.world.physics.Vector2D;

public class Entity extends WorldObject {

	public Entity(float mass) {
		super(mass);
	}
	
	public Entity(float mass, Vector2D pos) {
		super(mass, pos);
	}
}
