package ajedrez;

import java.util.Scanner;

import javax.swing.JFrame;

public class Ajedrez {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("dame x:");
		int x = in.nextInt();
		System.out.println("dame y:");
		int y = in.nextInt();
		System.out.println("dame el largo del tablero:");
		int largo = in.nextInt();
		System.out.println("dame la longitud de cada cuadrito:");
		int longitud = in.nextInt();

		JFrame miventa = new JFrame();

		Lienzo mimarco = new Lienzo(x, y, largo, longitud);
		miventa.add(mimarco);

		miventa.setTitle("Tablero");
		miventa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miventa.pack();
		miventa.setLocationRelativeTo(null);
		miventa.setVisible(true);
	}

}
