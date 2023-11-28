package paquetepruebas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String originalText = "";
		String translatedText = textToBinary(originalText);


		String binaryText = "1110000 1100001 1110010 1111010 1101001 1100010 1111001 1110100 1100101 101110 1101101 1100101";
		String translatedBinary = binaryToText(binaryText);
		// También podemos convertir algo que el usuario proporcione
		String userText = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa algún texto y yo lo convertiré a binario: ");
		userText = sc.nextLine();
		translatedText = textToBinary(userText);
		System.out.println(translatedText);
		System.out.println("Ingresa un texto en binario y lo convertiré a texto en español: ");
		userText = sc.nextLine();
		translatedBinary = binaryToText(userText);
		System.out.println(translatedBinary);

	}

	public static String binaryToText(String binaryText) {
		// Necesitamos separar cada número binario por espacio. Usamos split
		String[] binaryNumbers = binaryText.split(" ");
		String text = "";

		// Los recorremos. En cada paso tenemos al número binario
		for (String currentBinary : binaryNumbers) {
			// Ahora convertimos ese binario a decimal
			int decimal = binaryToDecimal(currentBinary);
			// Obtenemos la letra que le corresponde a ese valor ASCII
			char letra = (char) decimal;
			text += letra;
		}
		return text;
	}

	public static String textToBinary(String originalText) {
		String binaryText = "";
		for (int i = 0; i < originalText.length(); i++) {
			// Primero obtenemos la letra o carácter actual
			char currentChar = originalText.charAt(i);
			// Necesitamos obtener su representación entera ASCII
			int ascii = (int) currentChar;
			// Una vez que ya tenemos el entero, lo convertimos a binario
			String binary = decimalToBinary(ascii);
			// Lo agregamos a la cadena resultante agregando además un espacio
			binaryText += binary + " ";
		}
		// Finalmente regresamos el texto
		return binaryText;
	}

	public static int binaryToDecimal(String binary) {
		// A este número le vamos a sumar cada valor binario
		int decimal = 0;
		int position = 0;
		// Recorrer la cadena...
		for (int x = binary.length() - 1; x >= 0; x--) {
			// Saber si es 1 o 0; primero asumimos que es 1 y abajo comprobamos
			short digit = 1;
			if (binary.charAt(x) == '0') {
				digit = 0;
			}

			/*
			 * Se multiplica el dígito por 2 elevado a la potencia según la posición;
			 * comenzando en 0, luego 1 y así sucesivamente
			 */
			double multiplier = Math.pow(2, position);
			decimal += digit * multiplier;
			position++;
		}
		return decimal;
	}

	public static String decimalToBinary(int decimal) {
		if (decimal <= 0) {
			return "0";
		}
		String binary = "";
		while (decimal > 0) {
			short remainder = (short) (decimal % 2);
			decimal = decimal / 2;
			// Insertar el dígito al inicio de la cadena
			binary = String.valueOf(remainder) + binary;
		}
		return binary;
	}
}