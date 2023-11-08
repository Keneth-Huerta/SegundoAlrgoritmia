package ficheros_directorios;

import java.io.File;

public class AcecesoFicheros {

	public static void main(String[] args) {

		File ruta = new File(
				"C:" + File.separator + "Users" + File.separator + "kenet" + File.separator + "Users" + "OneDrive"
						+ File.separator + "Documentos" + File.separator + "2IM2-HUERTA-GALINDO-KENETH-ISSAC-CECyT-3");
		System.out.println(ruta.getAbsolutePath());
		String[] directorio = ruta.list();
		for (String string : directorio) {

			System.out.println(string);
			File f = new File(ruta.getAbsoluteFile(), string);
			boolean directory = f.isDirectory();
			if (directory) {
				String[] archivosSubcarpeta = f.list();
				for (String string2 : archivosSubcarpeta) {

					System.out.println(string2);
				}
			}
		}
		System.out.println(File.separator);
	}

}
