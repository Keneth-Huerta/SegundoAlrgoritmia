package grafica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Grafica {
	static String[] numeros;
	static Color[] col = new Color[7];

	public Grafica(String[] numeros) {

		Grafica.numeros = numeros;
	}

	public static void dibujar(Graphics2D g) {

		Line2D lin = new Line2D.Double(30, 30, 30, 360);
		g.draw(lin);

		for (int i = 0; i <= 10; i++) {

			g.setColor(Color.black);
			g.drawString(Integer.toString(i * baseD() / 10), 8, 420 - (60 + 30 * i));
			Line2D lin2 = new Line2D.Double(30, 30 * i + 60, 280, 30 * i + 60);
			if (i != 10) {

				g.setColor(Color.gray);
			}
			g.draw(lin2);
		}

		for (int i = 5; i <= 10; i++) {

			Rectangle2D rec = new Rectangle2D.Double(10 * (i - 4) + 30 * (i - 4) ,
					360 - (calcular(i) / (baseD() / 10) * 30), 30, calcular(i) / (baseD() / 10) * 30);
			g.setColor(getcolor(i - 4));
			g.fill(rec);
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(i), 10 * (i - 4) + 30 * (i - 4) + 10, 380);

		}
		Lienzo.setColor(false);

	}

	public static Color getcolor(int i) {
		Random rm = new Random();

		if (Lienzo.isColor()) {
			col[i] = new Color(rm.nextInt(255), rm.nextInt(255), rm.nextInt(255));
		}
		return col[i];
	}

	public static double calcular(int numero) {
		int c = 0;

		for (String string : numeros) {

			int num = Integer.parseInt(string);
			if (numero == num) {
				c++;
			}
		}
		return c;
	}

	public static int baseD() {

		int c = maxR();
		while (c % 10 != 0) {
			c++;
		}

		return c;
	}

	public static int maxR() {

		int c = 0;
		for (int i = 5; i <= 10; i++) {
			if (c < calcular(i)) {

				c = (int) calcular(i);
			}
		}

		return c;
	}
}
