package com.cubestory.options;

import java.awt.Dimension;

import com.cubestory.util.UserDisplayUtilities;

public class WindowOptions {
	
	public static final Dimension minimumScreenSize = new Dimension(
			(int) UserDisplayUtilities.getUserDisplay().getWidth() / 4,
			(int) UserDisplayUtilities.getUserDisplay().getHeight() / 4);
	
	public static final Dimension startScreenSize = new Dimension(
			(int) UserDisplayUtilities.getUserDisplay().getWidth() / 2,
			(int) UserDisplayUtilities.getUserDisplay().getHeight() / 2);
}
