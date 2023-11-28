package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;

public class Player extends MovingObject {
	private Vector2D heading;
	private Vector2D acceleration;
	private final double ACC = 0.08;

	public Player(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture) {
		super(position, velocity, maxVel, texture);
		heading = new Vector2D(0, 1);
		acceleration = new Vector2D();
	}

	public void update() {
		if (KeyBoard.RIGHT)
			angle += Math.PI / 30;
		if (KeyBoard.LEFT)
			angle -= Math.PI / 30;
		if (KeyBoard.UP)
			acceleration = heading.scale(ACC);

		velocity = velocity.add(acceleration);
		velocity = velocity.scale(maxVel);
		heading = heading.setDirection(angle - Math.PI / 2);
		position = position.add(velocity);
	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		at.rotate(angle, Assets.player.getWidth() / 2, Assets.player.getHeight() / 2);
		g2.drawImage(Assets.player, at, null);
	}

}
