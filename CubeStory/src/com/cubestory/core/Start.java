package com.cubestory.core;

import javax.swing.SwingUtilities;

import com.cubestory.entity.Player;
import com.cubestory.listener.KeyInputListener;
import com.cubestory.options.GraphicsOptions;
import com.cubestory.util.ComponentProperties;
import com.cubestory.world.World;
import com.cubestory.world.physics.Vector2D;

public class Start {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				CubeStory.cubeStoryInstance = new CubeStory();
				
//				VectorTesting.testing();
				startGame();
//				VectorTesting.testing();
			}
		});
	}
	
	public static synchronized void startGame() {
		
		initListeners();
		initComponents();
		initOptions();
		
		CubeStory.getCubeStory().setCurrentWorld(new World("Test World", 
				new Player(100f, new Vector2D("position", (ComponentProperties.getCanvas().getWidth() / 2) - 50, 
				(ComponentProperties.getCanvas().getHeight() / 2) - 50))));
		
		CubeStory.getCubeStory().start();
	}
	
	public static synchronized void initComponents() {
		ComponentProperties.initComponents();
	}
	
	public static synchronized void initOptions() {
		GraphicsOptions.initGraphicsOptions();
	}
	
	private static void initListeners() {
		CubeStory.getCubeStory().keyListener = new KeyInputListener();
	}
}
