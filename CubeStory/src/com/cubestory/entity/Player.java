package com.cubestory.entity;

import java.awt.Color;
import java.util.Random;

import com.cubestory.world.physics.Vector2D;
import com.sun.javafx.geom.Rectangle;

public class Player extends Entity {

	protected Vector2D direction;
	
	public static float walkingForce = 2000f;
	protected Rectangle rect = new Rectangle(0, 0, 100, 100);
	public Color bodyColor;
	private static Random random = new Random();
	
	public Player(float mass) {
		super(mass);
		bodyColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	public Player(float mass, Vector2D pos) {
		this(mass);
		super.position = pos;
	}
	
	public Player(float mass, Vector2D pos, Vector2D dir) {
		this(mass, pos);
		this.direction = dir;
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
