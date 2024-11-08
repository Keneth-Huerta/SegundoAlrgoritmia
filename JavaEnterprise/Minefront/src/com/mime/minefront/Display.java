package com.mime.minefront;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.mime.minefront.graphics.Screen;
import com.mime.minefront.gui.Launcher;
import com.mime.minefront.input.Controller;
import com.mime.minefront.input.InputHandler;

public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = -346504722713325956L;

	public static int width = 800, height = 600;
	public static final String TITLE = "MinefFont Pre-Alpha 0.02";

	private Thread thread;
	private Screen screen;
	private Game game;
	private BufferedImage img;
	private boolean running = false;
	private int[] pixels;
	private InputHandler input;
	public static int newX = 0;
	public static int oldX = 0;
	private int fps;
	public static int selection = 0;
	public static int mouseSpeed;

	static Launcher launcher;

	public Display() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		screen = new Screen(getGameWidth(), getGameHeight());
		game = new Game();
		img = new BufferedImage(getGameWidth(), getGameHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

		input = new InputHandler();
		addKeyListener(input);
		addFocusListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);

	}

	public static Launcher getLauncherInstance() {
		if (launcher == null) {
			launcher = new Launcher(0);
		}
		return launcher;
	}

	public static int getGameWidth() {

		return width;
	}

	public static int getGameHeight() {

		return height;
	}

	public synchronized void start() {

		if (running)
			return;
		running = true;
		thread = new Thread(this, "game");
		thread.start();
	}

	public void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void run() {
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;

		while (running) {

			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			requestFocus();

			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					// System.out.println(frames + "fps");
					fps = frames;
					previousTime += 1000;
					frames = 0;
				}
				if (ticked) {

					render();
					frames++;
				}
				// render();
			}

		}
	}

	private void tick() {
		game.tick(input.key);

		newX = InputHandler.MouseX;
		if (newX > oldX) {

			Controller.turnRight = true;

		}
		if (newX < oldX) {
			Controller.turnLeft = true;

		}
		if (newX == oldX) {
			Controller.turnRight = false;
			Controller.turnLeft = false;

		}
		mouseSpeed = Math.abs(newX - oldX);

		oldX = newX;
	}

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.render(game);

		for (int i = 0; i < getGameWidth() * getGameHeight(); i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getGameWidth(), getGameHeight(), null);
		g.setFont(new Font("Verdana", 0, 15));
		g.setColor(new Color(255, 255, 255));
		g.drawString(fps + "fps", 20, 30);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {

		getLauncherInstance();
	}
}
