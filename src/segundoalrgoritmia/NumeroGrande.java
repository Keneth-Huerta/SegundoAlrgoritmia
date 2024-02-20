package segundoalrgoritmia;

import java.util.Scanner;

public class NumeroGrande {

	public static void main(String[] args) {
		int a, b, c;

		Scanner in = new Scanner(System.in);

		System.out.println("Dame el primer número");
		a = in.nextInt();
		System.out.println("Dame el segundo número");
		b = in.nextInt();
		System.out.println("Dame el tercer número");
		c = in.nextInt();

		if (a > b && a > c) {

			System.out.println(a + " es el mas grande");
		} else if (b > a && b > c) {

			System.out.println(b + " es el mas grande");
		} else if (c > a && c > b) {

			System.out.println(c + " es el mas grande");
		} else {
			System.out.println("Los números son iguales");
		}

	}

}
