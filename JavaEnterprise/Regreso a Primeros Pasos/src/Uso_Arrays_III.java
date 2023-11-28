import java.util.Scanner;

public class Uso_Arrays_III {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Cuantas filas necesitas");
		int filas = entrada.nextInt();

		System.out.println("Cuantas columnas necesitas");
		int columnas = entrada.nextInt();

		String[][] matriz = new String[filas][columnas];

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = Integer.toString((int) Math.round(Math.random() * 100));

			}
		}
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (matriz[i][j].length() == 2) {
					System.out.print(matriz[i][j] + "  ");
				} else if(matriz[i][j].length() == 1){
					System.out.print(matriz[i][j] + "   ");
				}
			}
			System.out.println();
		}
	}

}
