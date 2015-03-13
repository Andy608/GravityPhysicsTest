package com.cubestory.component;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import com.cubestory.core.CubeStory;
import com.cubestory.core.VectorTesting;
import com.cubestory.options.WindowOptions;
import com.cubestory.util.ComponentProperties;

public class MainCanvas extends Canvas {

	private static final int BUFFERS = 3;
	private static final long serialVersionUID = 1199460916906459121L;
	
	public MainCanvas() {
		super.setSize(WindowOptions.startScreenSize);
		super.setPreferredSize(super.getSize());
		this.addKeyListener(CubeStory.getCubeStory().keyListener);
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
	}
	
	public void updateGraphics(float alpha) {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			super.createBufferStrategy(BUFFERS);
			super.requestFocus();
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, ComponentProperties.getCanvas().getWidth(), ComponentProperties.getCanvas().getHeight());
		
		VectorTesting.updateVisualTest(g, alpha);
		
        g.dispose();
		
		if (!bs.contentsLost()) {
			bs.show();
		}
		Toolkit.getDefaultToolkit().sync();
	}
}
