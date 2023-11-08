package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {

		File ruta = new File("C:" + File.separator + "Users" + File.separator + "kenet" + File.separator + "OneDrive"
				+ File.separator + "Documentos" + File.separator + "2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3"
				+ File.separator + "Personal" + File.separator + "Yo" + File.separator + "hola.txt");

		System.out.println(ruta.getAbsoluteFile());
//		ruta.mkdir();
		String archivoDestino = ruta.getAbsolutePath();
		try {

			ruta.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Escribiendo accedeEs = new Escribiendo();
		accedeEs.escribir(archivoDestino);
		
	}

}

class Escribiendo {

	public void escribir(String archivoDestino) {
		String frase = "Esto es un ejemplo. Espero que salga";
		try {

			FileWriter escritura = new FileWriter(archivoDestino);
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
