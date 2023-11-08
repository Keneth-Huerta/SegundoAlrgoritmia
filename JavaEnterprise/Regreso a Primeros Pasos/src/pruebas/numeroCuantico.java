package pruebas;

import java.util.Scanner;

public class numeroCuantico {

	public static void main(String[] args) {
		int confiElec[][] = { { 1, 0, 2 }, { 2, 0, 2 }, { 2, 1, 6 }, { 3, 0, 2 }, { 3, 2, 6 }, { 4, 0, 2 },
				{ 3, 2, 10 }, { 4, 1, 6 }, { 5, 0, 2 }, { 4, 2, 10 }, { 5, 1, 6 }, { 6, 0, 2 }, { 4, 3, 14 },
				{ 5, 2, 10 }, { 6, 1, 6 }, { 7, 0, 2 }, { 5, 3, 14 }, { 6, 2, 10 }, { 7, 1, 6 }, };
		int sumaConfi = 0;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Coloca el número atómico");
		int numAtomico = in.nextInt();
		in.close();
		if (numAtomico <= 2) {

			System.out.println("H");
		} else if (numAtomico < 10 && numAtomico >= 2) {

			for (int i = 0; i < 19; i++) {

				sumaConfi+=confiElec[i][2];
				for (int j = 0; j < 2; j++) {
					System.out.println("2");
				}
			}
			System.out.println("[He]");
		} else if (numAtomico < 18 && numAtomico >= 10) {

			System.out.println("[Ne]");
		} else if (numAtomico < 36 && numAtomico >= 18) {

			System.out.println("[Ar]");
		} else if (numAtomico < 54 && numAtomico >= 36) {

			System.out.println("[Kr]");
		} else if (numAtomico < 86 && numAtomico >= 54) {

			System.out.println("[Xe]");
		} else if (numAtomico >= 86) {

			System.out.println("[Rn]");
		}
	}

}
