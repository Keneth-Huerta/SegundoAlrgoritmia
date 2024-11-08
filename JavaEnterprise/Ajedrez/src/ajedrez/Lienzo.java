package ajedrez;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Lienzo extends JPanel {
	int x, y, longitud, largo;

	public Lienzo() {
		x = 0;
		y = 0;
		largo = 0;
		longitud = 0;
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.yellow);
	}

	public Lienzo(int x, int y, int largo, int longitud) {

		this.x = x;
		this.y = y;
		this.largo = largo;
		this.longitud = longitud;
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.yellow);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Tablero tbl = new Tablero(x, y, largo, longitud);
		tbl.dibujar(g2);
	}

}
