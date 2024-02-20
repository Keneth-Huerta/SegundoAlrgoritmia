package segundoalrgoritmia;

import java.util.Scanner;

public class Triangulos4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner inR = new Scanner(System.in);
		int a, b, c, suma;
		String repetir;
		do {
			System.out.println("Dame los tres angulos de tu triangulo:");
			a = in.nextInt();
			c = in.nextInt();
			b = in.nextInt();
			suma = a + b + c;
			if (suma == 180) {
				if (a < 90 && b < 90 && c < 90) {
					System.out.println("Tu triangulo es un acutángulo");

				}
				if (a > 90 && b > 90 && c > 90) {
					System.out.println("Tu triangulo es un obtusángulo");

				} else if (a == 90 || b == 90 || c == 90) {
					System.out.println("Tu triangulo es un rectángulo");

				}

			} else {
				System.out.println("No es un triangulo");
			}
			System.out.println("Quieres repetir esta acción: si/no");
			repetir = inR.nextLine();

		} while (repetir.equalsIgnoreCase("si"));

	}
}
