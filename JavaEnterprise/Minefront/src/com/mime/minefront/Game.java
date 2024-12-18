package com.mime.minefront;

import java.awt.event.KeyEvent;

import com.mime.minefront.input.Controller;
import com.mime.minefront.level.Level;

public class Game {
	public int time;
	public Controller controls;
	public Level level;

	public Game() {

		controls = new Controller();
		level = new Level(20, 20);
	}

	public void tick(boolean[] key) {

		time++;
		boolean forward = key[KeyEvent.VK_W];
		boolean back = key[KeyEvent.VK_S];
		boolean jump = key[KeyEvent.VK_SPACE];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean rleft = key[KeyEvent.VK_LEFT];
		boolean rright = key[KeyEvent.VK_RIGHT];
		boolean crouch = key[KeyEvent.VK_SHIFT];
		boolean run = key[KeyEvent.VK_CONTROL];
		boolean esc = key[KeyEvent.VK_ESCAPE];

		controls.tick(forward, back, left, right,rleft,rright, jump, crouch, run,esc);
	}

}
