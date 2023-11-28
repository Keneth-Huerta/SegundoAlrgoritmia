package pruebas;

import java.util.Scanner;

public class OrdenarTresNumeros {

	public static void main(String[] args) {
		// Declaramos las variables para almacenar los números enteros proporcionados
		// por el usuario.
		int numero1, numero2, numero3;

		// Usamos un Scanner para leer los tres números enteros.
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese el primer número entero:");
		numero1 = sc.nextInt();

		System.out.println("Ingrese el segundo número entero:");
		numero2 = sc.nextInt();

		System.out.println("Ingrese el tercer número entero:");
		numero3 = sc.nextInt();

		// Usamos un ciclo for para comparar los tres números.
		for (int i = 0; i < 2; i++) {
			if (numero1 > numero2) {
				int temp = numero1;
				numero1 = numero2;
				numero2 = temp;
			}

			if (numero2 > numero3) {
				int temp = numero2;
				numero2 = numero3;
				numero3 = temp;
			}
		}

		// Imprimimos los tres números ordenados.
		System.out.println("Los números ordenados de forma ascendente son:");
		System.out.println(numero1);
		System.out.println(numero2);
		System.out.println(numero3);
	}
}
