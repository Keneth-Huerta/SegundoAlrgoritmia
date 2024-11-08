package com.mime.minefront;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class RunGame {
	public static JFrame frame;
	public static Point windowPos;

	public RunGame() {
		BufferedImage cursor = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blanck = Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(0, 0), "blank");
		Display game = new Display();


		frame = new JFrame();
		frame.add(game);
		frame.setSize(Display.getGameWidth(), Display.getGameHeight());
		frame.getContentPane().setCursor(blanck);
		frame.setTitle(Display.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);


		game.start();
		stopMenuThread();
	}
	private void stopMenuThread() {
		
		Display.getLauncherInstance().stopMenu();
	}
}
