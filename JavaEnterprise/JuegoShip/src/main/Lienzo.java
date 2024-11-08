package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Lienzo extends JPanel {

	private static final long serialVersionUID = 165559344073304835L;
	private Timer t;
	private Ellipse2D c;
	private Line2D lineaArriba1, lineaArriba2, lineaDerecha1, lineaDerecha2, lineaAbajo1, lineaAbajo2, lineaIzquierda1,
			lineaIzquierda2, lineaFinal;
	private boolean right, left, up, down;
	private int dx = 0, dy = 0;

	public Lienzo() {
		setPreferredSize(new Dimension(500, 500));
		lineaArriba1 = new Line2D.Double(0, 0, 0, 0);
		lineaArriba2 = new Line2D.Double(0, 0, 0, 0);
		lineaDerecha1 = new Line2D.Double(0, 0, 0, 0);
		lineaDerecha2 = new Line2D.Double(0, 0, 0, 0);
		lineaAbajo1 = new Line2D.Double(0, 0, 0, 0);
		lineaAbajo2 = new Line2D.Double(0, 0, 0, 0);
		lineaIzquierda1 = new Line2D.Double(0, 0, 0, 0);
		lineaIzquierda2 = new Line2D.Double(0, 0, 0, 0);
		lineaFinal = new Line2D.Double(0, 0, 0, 0);
		c = new Ellipse2D.Double(50, 50, 30, 30);
		t = new Timer(40, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (right) {
					dx = 5;
					dy = 0;
				} else if (left) {
					dx = -5;
					dy = 0;
				} else if (up) {
					dx = 0;
					dy = -5;
				} else if (down) {
					dx = 0;
					dy = 5;
				}

				double newX = c.getX() + dx;
				double newY = c.getY() + dy;

				Ellipse2D tempX = new Ellipse2D.Double(newX, c.getY(), c.getWidth(), c.getHeight());
				Ellipse2D tempY = new Ellipse2D.Double(c.getX(), newY, c.getWidth(), c.getHeight());

				boolean collisionX = checkCollisionPrecise(tempX);
				boolean collisionY = checkCollisionPrecise(tempY);

				if (!collisionX) {
					if (newX + c.getWidth() <= getWidth() && newX >= 0) {
						c.setFrame(newX, c.getY(), c.getWidth(), c.getHeight());
					}
				}
				if (!collisionY) {
					if (newY + c.getHeight() <= getHeight() && newY >= 0) {
						c.setFrame(c.getX(), newY, c.getWidth(), c.getHeight());
					}
				}

				repaint();
			}
		});
		t.start();
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = true;
					left = up = down = false;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = true;
					right = up = down = false;
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = true;
					right = left = down = false;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = true;
					right = left = up = false;
				}
			}
		});
		setFocusable(true);
	}

	private boolean checkCollisionPrecise(Ellipse2D ellipse) {
		Line2D[] lines = { lineaArriba1, lineaArriba2, lineaDerecha1, lineaDerecha2, lineaAbajo1, lineaAbajo2,
				lineaIzquierda1, lineaIzquierda2, lineaFinal };

		double radioX = ellipse.getWidth() / 2;
		double radioY = ellipse.getHeight() / 2;

		double centerX = ellipse.getCenterX();
		double centerY = ellipse.getCenterY();

		for (Line2D line : lines) {
			if (line != null) {

				double distancia = distanciaPuntoLinea(centerX, centerY, line.getX1(), line.getY1(), line.getX2(),
						line.getY2());

				if (distancia < radioX) {
					return true;
				}
			}
		}
		return false;
	}

	private double distanciaPuntoLinea(double px, double py, double x1, double y1, double x2, double y2) {
		double A = px - x1;
		double B = py - y1;
		double C = x2 - x1;
		double D = y2 - y1;

		double dot = A * C + B * D;
		double len_sq = C * C + D * D;
		double param = dot / len_sq;

		double xx, yy;

		if (param < 0) {
			xx = x1;
			yy = y1;
		} else if (param > 1) {
			xx = x2;
			yy = y2;
		} else {
			xx = x1 + param * C;
			yy = y1 + param * D;
		}

		double dx = px - xx;
		double dy = py - yy;
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		lineaArriba1 = new Line2D.Double(getWidth() / 2 - 25, 100, getWidth() / 2 - 25, getHeight() / 2 - 25);
		lineaArriba2 = new Line2D.Double(getWidth() / 2 + 25, 100, getWidth() / 2 + 25, getHeight() / 2 - 25);
		lineaDerecha1 = new Line2D.Double(100, getHeight() / 2 - 25, getWidth() / 2 - 25, getHeight() / 2 - 25);
		lineaDerecha2 = new Line2D.Double(100, getHeight() / 2 + 25, getWidth() / 2 - 25, getHeight() / 2 + 25);
		lineaAbajo2 = new Line2D.Double(getWidth() / 2 - 25, getHeight() / 2 + 25, getWidth() / 2 - 25,
				getHeight() - 100);
		lineaAbajo1 = new Line2D.Double(getWidth() / 2 + 25, getHeight() / 2 + 25, getWidth() / 2 + 25,
				getHeight() - 100);
		lineaIzquierda1 = new Line2D.Double(getWidth() / 2 + 25, getHeight() / 2 - 25, getWidth() - 100,
				getHeight() / 2 - 25);
		lineaIzquierda2 = new Line2D.Double(getWidth() / 2 + 25, getHeight() / 2 + 25, getWidth() - 100,
				getHeight() / 2 + 25);
		lineaFinal = new Line2D.Double(getWidth() - 100, getHeight() / 2 - 25, getWidth() - 100, getHeight() / 2 + 25);

		g2.draw(lineaArriba1);
		g2.draw(lineaArriba2);
		g2.draw(lineaDerecha1);
		g2.draw(lineaDerecha2);
		g2.draw(lineaAbajo1);
		g2.draw(lineaAbajo2);
		g2.draw(lineaIzquierda1);
		g2.draw(lineaIzquierda2);
		g2.fill(c);
		g2.setColor(getBackground());
		g2.draw(lineaFinal);
	}
}