package com.cubestory.component;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import javax.swing.JFrame;

import com.cubestory.options.WindowOptions;
import com.cubestory.util.CubeStoryLogger;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 8387944726920115552L;
	public MainFrame(MainCanvas canvasInstance) {
		
		super.setTitle("Cube Story - Andy608");
		super.add(canvasInstance);
		
		super.setResizable(true);
		super.setMinimumSize(WindowOptions.minimumScreenSize);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
		super.setLocationRelativeTo(null);
		super.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				CubeStoryLogger.write(Level.INFO, "Saving!");
			}
		});
		
		super.addWindowFocusListener(new WindowAdapter() {
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				CubeStoryLogger.write(Level.INFO, "Focused!");
			}
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				CubeStoryLogger.write(Level.INFO, "Lost Focus!");
			}
		});
		super.setVisible(true);
	}
}
