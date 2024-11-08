
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class LIenzoDibujo extends JPanel implements MouseListener, MouseMotionListener {
	private int x = 150, y = 150, width = 300, height = 200;
	boolean pintar, r, l, t, b;
	Rectangle2D linea, linea1, linea2, linea3, linea4;

	public LIenzoDibujo() {
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.yellow);

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Redimencionar();

		linea = new Rectangle2D.Double(x, y, width, height);
		/*
		 * if (l || t) {
		 * 
		 * linea = new Rectangle2D.Double(150 + dx, 150 + dy, width, height); } else if
		 * (b || r) {
		 * 
		 * linea = new Rectangle2D.Double(150, 150, width, height); } if (c == 0) {
		 * 
		 * linea = new Rectangle2D.Double(150, 150, width, height); }
		 */

		linea1 = new Rectangle2D.Double(linea.getCenterX() - 15, linea.getY() - 10, 30, 20);
		linea2 = new Rectangle2D.Double(linea.getMaxX() - 10, linea.getCenterY() - 15, 20, 30);
		linea3 = new Rectangle2D.Double(linea.getCenterX() - 15, linea.getMaxY() - 10, 30, 20);
		linea4 = new Rectangle2D.Double(linea.getX() - 10, linea.getCenterY() - 15, 20, 30);
		if (pintar) {

			g2.draw(linea1);
			g2.draw(linea2);
			g2.draw(linea3);
			g2.draw(linea4);
			g2.setColor(Color.red);
		} else {
			g2.setColor(Color.black);
		}
		g2.draw(linea);

	}

	public void Redimencionar() {
		if (r) {
			width += dx;
		} else if (l) {
			x += dx;
			width -= dx;
		}
		if (b) {
			height += dy;
		} else if (t) {
			y += dy;
			height -= dy;
		}
		/*
		 * if (c > 0 && r || l) {
		 * 
		 * width += dx; } else if (c > 0 && b || t) {
		 * 
		 * height += dy; }
		 */
		if (width < 10) {
			width = 10;
			if (l)
				x = (int) (linea.getMaxX() - 10);
		}
		if (height < 10) {
			height = 10;
			if (t)
				y = (int) (linea.getMaxY() - 10);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		if (linea.contains(e.getX(), e.getY()) || ChecarTodos(e.getX(), e.getY())) {

			pintar = true;
		} else {
			pintar = false;
		}
		repaint();
	}

	public boolean ChecarTodos(int x, int y) {

		return linea1.contains(x, y) || linea2.contains(x, y) || linea3.contains(x, y) || linea4.contains(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		lastX = -1;
		lastY = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	int c = 0, dx, dy, lastX = -1, lastY = -1;

	@Override
	public void mouseDragged(MouseEvent e) {
		int currentX = e.getX();
		int currentY = e.getY();

		if (lastX != -1 && lastY != -1) {
			dx = currentX - lastX;
			dy = currentY - lastY;

	//		System.out.println(currentY + "-" + lastY + "=" + dy);
		}
		lastX = currentX;
		lastY = currentY;

		if (linea2.contains(e.getX(), e.getY())) {
			c++;

			r = true;
			l = false;
			b = false;
			t = false;
		} else if (linea3.contains(e.getX(), e.getY())) {
			c++;

			r = false;
			l = false;
			b = true;
			t = false;
		} else if (linea4.contains(e.getX(), e.getY())) {
			c++;

			r = false;
			l = true;
			b = false;
			t = false;
		} else if (linea1.contains(e.getX(), e.getY())) {
			c++;

			r = false;
			l = false;
			b = false;
			t = true;
		} else {
			r = false;
			l = false;
			b = false;
			t = false;

		}

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
