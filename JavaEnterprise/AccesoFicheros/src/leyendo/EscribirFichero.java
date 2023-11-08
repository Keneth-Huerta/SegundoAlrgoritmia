package leyendo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFichero {

	public static void main(String[] args) {
		String dato;

		Scanner in = new Scanner(System.in);
		Escribiendo accedeEs = new Escribiendo();

		dato = in.nextLine();
		if (dato.equalsIgnoreCase("y")) {
			try {

				accedeEs.escribir(in.nextLine(), in.nextBoolean());
			} catch (Exception e) {

				System.out.println("Coloca un dato correcto");
				e.printStackTrace();
			}
		}
		try {

			FileReader document = new FileReader("C:/Users/kenet/OneDrive/Escritorio/textoNuevo.txt");
			int c = 0;
			while (c != -1) {
				c = document.read();
				char letra = (char) c;
				System.out.print(letra);
			}
			document.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

class Escribiendo {

	public void escribir(String datos, boolean New) {

		String frase = datos;
		try {
			FileWriter escritura = new FileWriter("C:/Users/kenet/OneDrive/Escritorio/textoNuevo.txt", New);
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
