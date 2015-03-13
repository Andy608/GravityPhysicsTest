package com.cubestory.core;

import com.cubestory.listener.KeyInputListener;
import com.cubestory.util.ComponentProperties;
import com.cubestory.world.World;

public class CubeStory implements Runnable {

	private World currentWorld;
	protected static CubeStory cubeStoryInstance;
	public KeyInputListener keyListener;
	
	private Thread cubeStoryThread;
	private static boolean isRunning;
	
	private static final double TIME_SLICE = 60.0;
	private static final double DELTA_TIME = 1 / TIME_SLICE;
	private int ticks;
	private int frames;
	private float accumulator;
	private float alpha;
	
	public synchronized void start() {
		if (isRunning) return;
		isRunning = true;
		cubeStoryThread = new Thread(this);
		cubeStoryThread.start();
	}
	
	public synchronized void stop() {
		if (!isRunning) return;
		isRunning = false;
		try {
			cubeStoryThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		float frameStart = System.nanoTime();
		float currentTime;
		final float LAG_CAP = 0.2f;
		
		while (isRunning) {
			currentTime = System.nanoTime();
			
			accumulator += (currentTime - frameStart) / 1_000_000_000;
			
			frameStart = currentTime;
			
			if (accumulator > LAG_CAP) {
				accumulator = LAG_CAP;
			}
			
			while (accumulator > DELTA_TIME) {
				updateGame();
				accumulator -= DELTA_TIME;
			}
			
			alpha = (float) (accumulator / DELTA_TIME);
			renderGame();
		}
	}
	
	private void updateGame() {
		ticks++;
		
		VectorTesting.updateTest(accumulator);
		
		if (ticks % (TIME_SLICE) == 0) {
			System.out.println("Ticks: " + ticks + " Frames: " + frames + " Accumulator: " + accumulator);
			ticks = 0;
			frames = 0;
		}
	}
	
	public int getTicks() {
		return ticks;
	}
	
	private void renderGame() {
		frames++;
		ComponentProperties.getCanvas().updateGraphics(alpha);
	}
	
	public static CubeStory getCubeStory() {
		return cubeStoryInstance;
	}
	
	public void setCurrentWorld(World w) {
		currentWorld = w;
	}
	
	public World getCurrentWorld() {
		return currentWorld;
	}
}
