package com.cubestory.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.cubestory.core.CubeStory;
import com.cubestory.entity.Player;
import com.cubestory.world.physics.Vector2D;

public class KeyInputListener extends KeyAdapter implements KeyListener {

	
	private final static List<Character> pressed = new ArrayList<Character>();
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		for (Character c : pressed) {
			if (c == e.getKeyChar()) {
				return;
			}
		}
		pressed.add(e.getKeyChar());
		System.out.println(pressed);
		
		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().addAppliedForce(new Vector2D("walking_north", 0, -Player.walkingForce));
		}
		else if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().addAppliedForce(new Vector2D("walking_west", -Player.walkingForce, 0));
		}
		else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().addAppliedForce(new Vector2D("walking_south", 0, Player.walkingForce));
		}
		else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().addAppliedForce(new Vector2D("walking_east", Player.walkingForce, 0));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		for (int i = 0; i < pressed.size(); i++) {
			if (e.getKeyChar() == pressed.get(i)) {
				pressed.remove(i);
				System.out.println(pressed);
			}
		}
		
		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().removeAppliedForce("walking_north");
		}
		else if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().removeAppliedForce("walking_west");;
		}
		else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().removeAppliedForce("walking_south");
		}
		else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			CubeStory.getCubeStory().getCurrentWorld().getPlayer().getForces().removeAppliedForce("walking_east");
		}
	}
	
	
}
