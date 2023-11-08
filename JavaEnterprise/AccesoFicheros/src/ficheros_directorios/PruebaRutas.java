package ficheros_directorios;

import java.io.File;

public class PruebaRutas {

	public static void main(String[] args) {

		File archivo = new File("bin");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
	}

}
