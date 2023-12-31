package Segundoalrgoritmia;

import java.util.Scanner;

public class estresHidrico2 {
	private static String[] widgetsName = { "Baja California Sur", "Distrito Federal", "Sonora", "Coahuila", "Sinaloa",
			"Chihuahua", "Colima", "Aguascalientes", "Durango", "Baja California", "Guanajuato", "México", "Jalisco",
			"Zacatecas", "Querétaro", "Michoacán", "Morelos", "Tamaulipas", "Hidalgo", "Nayarit", "Nuevo León",
			"San Luis Potosí", "Tlaxcala", "Puebla", "Yucatán", "Guerrero", "Campeche", "Quintana Roo", "Oaxaca",
			"Veracruz", "Chiapas", "Tabasco" };
	private static double[] widgetChartText = { 5.00, 5.00, 5.00, 5.00, 5.00, 4.98, 4.93, 4.91, 4.92, 4.84, 4.86, 4.80,
			4.83, 4.51, 4.47, 4.84, 4.57, 4.69, 4.78, 4.76, 4.73, 4.72, 4.90, 4.85, 4.78, 4.55, 4.56, 4.63, 4.80, 4.75,
			4.62, 4.69, 4.62, 4.49, 4.67, 4.39, 4.57, 4.25, 4.50, 4.48, 4.45, 4.39, 4.49, 4.37, 4.30, 4.36, 3.94, 3.98,
			3.89, 4.26, 4.16, 3.94, 3.24, 3.40, 3.93, 3.06, 3.46, 3.93, 2.20, 3.08, 3.68, 2.95, 2.93, 3.11, 3.07, 3.02,
			2.57, 2.97, 2.99, 2.42, 2.19, 2.13, 1.12, 1.03, 1.06, 1.13, 0.96, 1.03, 1.07, 0.74, 0.82, 0.73, 0.97, 0.94,
			0.74, 0.42, 0.47, 0.63, 0.47, 0.41, 0.56, 0.35, 0.33, 0.29, 0.33, 0.30 };
	private static double[] widgetsTotal = { 5.00, 5.00, 4.93, 4.84, 4.80, 4.79, 4.78, 4.77, 4.74, 4.67, 4.63, 4.57,
			4.47, 4.47, 4.40, 4.25, 4.08, 3.83, 3.63, 3.63, 3.39, 3.08, 2.85, 2.26, 1.06, 1.05, 0.96, 0.86, 0.57, 0.49,
			0.40, 0.31 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int seleccion;

		System.out.println(
				"Este programa te dara el puntaje del sectorial del riesgo de Estrés hídrico inicial de los estados de la republica mexicana, de la forma siguiente");
		System.out.println("1. Riesgo bajo");
		System.out.println("2. Riesgo Medio bajo");
		System.out.println("3. Riesgo Medio alto");
		System.out.println("4. Riesgo Alto");
		System.out.println("5. Riesgo extremadamente alto");

		seleccion = in.nextInt();
		System.out.println();
		if (seleccion == 1) {

			country(0, 1);
		} else if (seleccion == 2) {

			country(1, 2);
		} else if (seleccion == 3) {

			country(2, 3);
		} else if (seleccion == 4) {

			country(3, 4);
		} else if (seleccion == 5) {

			country(4, 5);
		}
	}

	public static void country(int min, int max) {
		int cont = 0;

		for (int i = 0; i < widgetsTotal.length; i++) {

			if (widgetsTotal[i] >= min && widgetsTotal[i] <= max) {

				System.out.println(widgetsName[i - 1] + ": ");

				System.out.print("Agricola: " + widgetChartText[i * 3 - 3] + "\n");
				System.out.print("Doméstico: " + widgetChartText[i * 3 - 2] + "\n");
				System.out.print("Industrial: " + widgetChartText[i * 3 - 1] + "\n\n");
				cont++;

			}

		}
		System.out.println("La cantidad de estados en esta categoría son: " + cont);
	}
}
