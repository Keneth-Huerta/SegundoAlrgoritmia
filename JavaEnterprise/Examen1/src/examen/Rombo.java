package examen;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rombo {
	private static int x, y, ancho, filas;

	public Rombo(int x, int y, int ancho, int filas) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.filas = filas;
	}

	public static void dibujar(Graphics2D g) {

		int inicio = 0, fin = 1, incremento1 = 1, incremento2 = 2;
		for (int i = 0; i < filas; i++) {
			for (int j = inicio; j < fin; j += incremento1) {

				if (j == filas) {
					inicio = filas;
					fin = 0;
					incremento1 *= -1;
					incremento2 *= -1;
				}
				Rectangle2D rec = new Rectangle2D.Double(x + j * ancho+ancho*cal(i), y + i * ancho, ancho, ancho);
				g.draw(rec);
			}
			fin += incremento2;
		}

	}

	public static int cal(int j) {

		int c = filas - 2;
		for (int i = 1; j < i; i++) {

			c -= 1;
		}
		return c;
	}
}
