package leyendo_escribiendo_bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscritura {
	static String url, url1, url2, url3;

	public static void main(String[] args) {
		int contador = 0;
		int datosEntrada[] = new int[38394];
		try {
			url = "C:\\Users\\kenet\\OneDrive\\Documentos\\2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3\\Personal\\Renata Sofia Delgado Reyes\\Hermosa.jpg";
			url1 = "C:\\Users\\kenet\\OneDrive\\Documentos\\2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3\\Personal\\Yo\\keneth1.jpg";
			url2 = "C:\\Users\\kenet\\OneDrive\\Documentos\\2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3\\Personal\\Renata Sofia Delgado Reyes\\HermosaCopia.jpg";
			url3="C:\\Users\\kenet\\OneDrive\\Documentos\\Curso java 2023\\AccesoFicheros\\src\\serializacion\\sofi.jpg";
			FileInputStream archivoLectura = new FileInputStream(url);
			boolean finalAr = false;
			while (!finalAr) {
				int byteEntrada = archivoLectura.read();
//		char letra=(char)byteEntrada;
//		System.out.print(letra);
				if (byteEntrada != -1) {

					datosEntrada[contador] = byteEntrada;
//			System.out.println(byteEntrada);
				} else
					finalAr = true;

				System.out.println(datosEntrada[contador]);
				contador++;
			}
			archivoLectura.close();
		} catch (IOException e) {

			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
		System.out.println(contador);
		creaFichero(datosEntrada);
	}

	public static void creaFichero(int datosNuevoFichero[]) {

		try {

			FileOutputStream ficheroNuevo = new FileOutputStream(url);
			for (int i = 0; i < datosNuevoFichero.length; i++) {

				ficheroNuevo.write(datosNuevoFichero[i]);
			}
			ficheroNuevo.close();
		} catch (IOException e) {

			System.out.println("El archivo no se encuentra");
			e.printStackTrace();
		}
	}

}
