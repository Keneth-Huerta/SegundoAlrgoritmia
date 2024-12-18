package ajedrez;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Tablero {
	int x, y, longitud, largo;

	public Tablero(int x, int y, int largo, int longitud) {

		this.x = x;
		this.y = y;
		this.largo = largo;
		this.longitud = longitud;
	}

	public void dibujar(Graphics2D g) {

		Rectangle2D[][] array = new Rectangle2D[largo][largo];
		g.setColor(Color.RED);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {

				array[i][j] = new Rectangle2D.Double(x + j * longitud, y + i * longitud, longitud, longitud);
			}
		}

		int c = 0;
		for (int i = 0; i < array.length; i++) {

			if (i % 2 == 0) {

				c = 1;
			} else {
				c = 0;
			}
			for (int j = 0; j < array.length; j++) {

				c++;
				if (c % 2 == 0) {

					g.draw(array[i][j]);
				} else {

					g.fill(array[i][j]);
				}
			}
		}

	}

}
