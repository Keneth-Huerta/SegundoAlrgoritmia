
package Segundoalrgoritmia2;

import java.util.Scanner;

public class Triangulo {

	public static void main(String[] args) {
            int a,b,c;

		Scanner in = new Scanner(System.in);

		System.out.println("Ingresa el valor de a");
		a = in.nextInt();
		System.out.println("Ingresa el valor de b");
		b = in.nextInt();
		System.out.println("Ingresa el valor de c");
		c = in.nextInt();

		if (a + b > c && a + c > b && b + c > a) {
			System.out.println("Las longitudes forman un triángulo");
		}else{
                    System.out.println("No es un triángulo");
                }
	}
}
