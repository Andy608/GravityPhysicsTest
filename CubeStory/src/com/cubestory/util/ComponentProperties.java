package com.cubestory.util;

import com.cubestory.component.MainCanvas;
import com.cubestory.component.MainFrame;

public class ComponentProperties {

	private static MainCanvas canvasInstance;
	private static MainFrame frameInstance;

	public static void initComponents() {
		canvasInstance = new MainCanvas();
		frameInstance = new MainFrame(canvasInstance);
	}
	
	public static MainFrame getFrame() {
		return frameInstance;
	}
	
	public static MainCanvas getCanvas() {
		return canvasInstance;
	}
}
