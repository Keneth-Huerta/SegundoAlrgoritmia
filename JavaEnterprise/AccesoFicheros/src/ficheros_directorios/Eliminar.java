package ficheros_directorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {

		File ruta = new File("C:" + File.separator + "Users" + File.separator + "kenet" + File.separator + "OneDrive"
				+ File.separator + "Documentos" + File.separator + "2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3"
				+ File.separator + "Personal" + File.separator + "Yo" + File.separator + "hola.txt");

		ruta.delete();

	}

}
