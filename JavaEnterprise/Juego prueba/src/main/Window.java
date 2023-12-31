package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import graphics.Assets;
import input.KeyBoard;
import states.GameState;

public class Window extends JFrame implements Runnable {
	private static final long serialVersionUID = -5883563300696610184L;
	public static final int WIDTH = 800, HEIGHT = 600;
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	private final int FPS = 60;
	private double TARGETTIME = 1000000000 / FPS;
	private double delta = 0;
	private int AVERAGEPFS = FPS;

	private GameState gameState;
	private KeyBoard keyBoard;

	public Window() {

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Space Ship Game");
		setVisible(true);

		canvas = new Canvas();
		keyBoard = new KeyBoard();

		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);

		add(canvas);
		canvas.addKeyListener(keyBoard);
	}

	public static void main(String[] args) {

		new Window().star();
	}

	private void update() {

		keyBoard.update();
		gameState.update();
	}

	private void draw() {

		bs = canvas.getBufferStrategy();
		if (bs == null) {

			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// ----------------------------------------------------------

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		gameState.draw(g);
		g.setColor(Color.white);
		g.drawString("" + AVERAGEPFS, 10, 20);

		// ----------------------------------------------------------

		g.dispose();
		bs.show();
	}

	private void init() {

		Assets.init();
		gameState = new GameState();
	}

	public void run() {
		long now = 0;
		long lasTime = System.nanoTime();
		int frames = 0;
		long time = 0;

		init();

		while (running) {

			now = System.nanoTime();
			delta += (now - lasTime) / TARGETTIME;
			time += (now - lasTime);
			lasTime = now;

			if (delta >= 1) {

				update();
				draw();
				delta--;
				frames++;
			}
			if (time >= 1000000000) {

				AVERAGEPFS = frames;
				frames = 0;
				time = 0;
			}
		}
		stop();
	}

	private void star() {

		thread = new Thread(this);
		thread.start();
		running = true;
	}

	private void stop() {

		try {

			thread.join();
			running = false;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
