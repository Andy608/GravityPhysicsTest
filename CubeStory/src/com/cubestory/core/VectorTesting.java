package com.cubestory.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import com.cubestory.entity.Player;
import com.cubestory.util.ComponentProperties;
import com.cubestory.world.World;
import com.cubestory.world.physics.Vector2D;

public class VectorTesting {

	public static Vector2D position = new Vector2D("position");
	
	private static World testWorld = CubeStory.getCubeStory().getCurrentWorld();
	private static Random random = new Random();
	
	public static void updateTest(float dt) {
		
		testWorld.getPlayer().updateObject(dt);
		
		checkBounds();
		System.out.println(testWorld.getPlayer().getPosition() + " " + testWorld.getPlayer().getVelocity() + testWorld.getPlayer().getForces().getAcceleration());
	}
	
	public static void updateVisualTest(Graphics2D g, float a) {
		
		if (CubeStory.getCubeStory().getTicks() % 60 == 0) {
			testWorld.getPlayer().bodyColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		}
		
		g.setColor(testWorld.getPlayer().bodyColor);
		g.fillRect((int)testWorld.getPlayer().getPosition().getX(), (int)testWorld.getPlayer().getPosition().getY(), testWorld.getPlayer().getRect().width, testWorld.getPlayer().getRect().height);
	}
	
	public static void checkBounds() {
		Player player = testWorld.getPlayer();
		
		if (player.getPosition().getY() > ComponentProperties.getCanvas().getHeight() - player.getRect().height) {
//			position.setVector(player.getPosition().getX(), 0);
			position.setVector(player.getPosition().getX(), ComponentProperties.getCanvas().getHeight() - player.getRect().height);
			testWorld.getPlayer().getVelocity().setVector(testWorld.getPlayer().getVelocity().getX(), 0);
			testWorld.getPlayer().setPosition(position);
		}
		else if (player.getPosition().getY() < 0) {
//			position.setVector(player.getPosition().getX(), ComponentProperties.getCanvas().getHeight() - player.getRect().height);
			position.setVector(player.getPosition().getX(), 0);
			testWorld.getPlayer().getVelocity().setVector(testWorld.getPlayer().getVelocity().getX(), 0);
			testWorld.getPlayer().setPosition(position);
		}
		
		if (player.getPosition().getX() > ComponentProperties.getCanvas().getWidth() - player.getRect().width) {
			position.setVector(ComponentProperties.getCanvas().getWidth() - player.getRect().width, player.getPosition().getY());
			testWorld.getPlayer().getVelocity().setVector(0, testWorld.getPlayer().getVelocity().getY());
			testWorld.getPlayer().setPosition(position);
		}
		else if (player.getPosition().getX() < 0) {
			position.setVector(0, player.getPosition().getY());
			testWorld.getPlayer().getVelocity().setVector(0, testWorld.getPlayer().getVelocity().getY());
			testWorld.getPlayer().setPosition(position);
		}
	}
}
