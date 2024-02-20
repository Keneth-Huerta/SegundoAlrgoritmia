package segundoalrgoritmia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Edad {

	public static void main(String[] args) {
		int edad;
		String yes;

		Scanner in = new Scanner(System.in);

		System.out.println("Cuál es tu edad?");

		do {
			try {
				edad = in.nextInt();
				if (edad < 3 && edad > 0) {
					
					System.out.println("Eres um bebe, tienes: " + edad + "años");
				} else if (edad > 3 && edad < 13) {
					System.out.println("Eres un niño, tienes: " + edad + "años");
				} else if (edad > 13 && edad < 18) {
					System.out.println("Eres un adolescente, tienes: " + edad + "años");
				} else if (edad >= 18 && edad < 60) {
					System.out.println("Eres un adulto, tienes: " + edad + "años");
				} else if (edad > 60) {
					System.out.println("Eres un adulto mayor, tienes: " + edad + "años");
				} else {
					System.out.println("No colocaste un dato correcto");
				}
			} catch (InputMismatchException e) {
				System.out.println("Coloca un dato númerico");
			}
			System.out.println("Repetir?");
			yes=in.nextLine();
		} while (yes.equals("y"));
		in.close();
	}
}
