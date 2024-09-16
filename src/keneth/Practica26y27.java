
package keneth;

public class Practica26y27 {

	public char[] minusculas(String cadenaPrincipal) {

		char[] palabras = cadenaPrincipal.toCharArray();
		char nuevaMin[] = new char[palabras.length];
		String original;
		for (int i = 0; i < cadenaPrincipal.length(); i++) {
			if ("a".equalsIgnoreCase(String.valueOf(palabras[i])) || "e".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "i".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "o".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "u".equalsIgnoreCase(String.valueOf(palabras[i]))) {

				original = String.valueOf(palabras[i]);
				String temp=original.toLowerCase();
				palabras[i] = temp.charAt(0);

				System.out.println("" + palabras);
			}
		}
		return palabras;
	}

	public char[] mayusculas(String cadenaPrincipal) {

		char[] palabras = cadenaPrincipal.toCharArray();
		for (int i = 0; i < cadenaPrincipal.length(); i++) {
			if ("a".equalsIgnoreCase(String.valueOf(palabras[i])) || "e".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "i".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "o".equalsIgnoreCase(String.valueOf(palabras[i]))
					|| "u".equalsIgnoreCase(String.valueOf(palabras[i]))) {

				String original = String.valueOf(palabras[i]);
				String nuevaMin = original.toUpperCase();
				palabras[i] = nuevaMin.charAt(0);

				System.out.println("" + palabras);
			}
		}
		return palabras;
	}

}
