package com.cubestory.util;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class UserDisplayUtilities {

	private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private static DisplayMode userDisplay = ge.getDefaultScreenDevice().getDisplayMode();
	
	public static GraphicsDevice getGraphicsDevice() {
		return gd;
	}
	
	public static DisplayMode getUserDisplay() {
		return userDisplay;
	}
}