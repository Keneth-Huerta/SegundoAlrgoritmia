package com.mime.minefront.input;

import java.awt.Robot;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.mime.minefront.Display;
import com.mime.minefront.RunGame;
import com.mime.minefront.gui.Launcher;

public class InputHandler implements MouseInputListener, KeyListener, FocusListener {
	public boolean[] key = new boolean[68836];
	public static int MouseX;
	public static int MouseY;
	public static int MouseDX;
	public static int MouseDY;
	public static int MousePX;
	public static int MousePY;
	public static int MouseButton;
	public static boolean dragged = false;

	private Robot robot;
	private int centerX = Display.getGameWidth() / 2, centerY = Display.getGameHeight() / 2;

	public void focusGained(FocusEvent e) {

	}

	private void recenterMouse(int game) {

		if (game != 0) {
			
			try {
				robot = new Robot();
			} catch (Exception e) {
				e.printStackTrace();
			}
			RunGame.windowPos = RunGame.frame.getLocationOnScreen();
			robot.mouseMove(RunGame.windowPos.x + centerX, RunGame.windowPos.y + centerY);
		}

	}

	public void focusLost(FocusEvent e) {

		for (int i = 0; i < key.length; i++) {

			key[i] = false;
		}
	}

	public void mouseDragged(MouseEvent e) {

		dragged = true;
		MouseDX = e.getX();
		MouseDY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {

	
		MouseX = e.getX();
		MouseY = e.getY();

	}

	public void mouseClicked(MouseEvent e) {

		
	}

	public void mousePressed(MouseEvent e) {

		MouseButton = e.getButton();
		MousePX = e.getX();
		MousePY = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		dragged = false;
		MouseButton = 0;

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

		recenterMouse(Launcher.games);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {

			key[keyCode] = false;
		}
	}

}
