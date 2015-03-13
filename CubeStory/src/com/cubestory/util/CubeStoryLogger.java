package com.cubestory.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.cubestory.core.CubeStory;

public class CubeStoryLogger {

	private static Logger logger = Logger.getLogger(CubeStory.class.getSimpleName());
	
	
	public static void write(Level level, String message) {
		logger.log(level, "[" + logger.getName() + "] " + message);
	}
}
