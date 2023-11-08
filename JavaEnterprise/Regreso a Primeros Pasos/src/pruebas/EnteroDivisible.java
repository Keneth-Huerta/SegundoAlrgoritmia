// 03 de octubre del 2023
// Determina si un número entero es divisible entre otro
// Autor: Adam Michel y Keneth Huerta 
package pruebas;

import java.util.Scanner;

public class EnteroDivisible {

	public static void main(String[] args) {// inicio del programa
		// 12-25 desarrollo del programa
		Scanner in = new Scanner(System.in);
		System.out.println("Damel divisor");
		int divisor = in.nextInt();// datos de entrada
		System.out.println("Damel dividendo");
		int dividendo = in.nextInt();// datos de entrada

		int divisible = divisor % dividendo;// datos de proceso

		if (!(divisible < 0)) {
			System.out.println("Los números proporcionados son divisibles");// datos de salida
		} else {
			System.out.println("Los números proporcionados no son divisibles");// datos de salida
		}
		in.close();
	}// fin del programa

}
