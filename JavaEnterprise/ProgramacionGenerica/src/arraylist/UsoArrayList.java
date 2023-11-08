package arraylist;

import java.io.File;

public class UsoArrayList {

	public static void main(String[] args) {

		ArrayList2 archivos = new ArrayList2(5);
		archivos.add("Juan");
		archivos.add("María");
		archivos.add("Ana");
		archivos.add("Sandra");
		archivos.add(new File("Hola"));
//		for (int j = 0; j < archivos.length(); j++) {

//		}
		String nombrePersona = (String) archivos.get(2);
		System.out.println(nombrePersona);
	}

}
