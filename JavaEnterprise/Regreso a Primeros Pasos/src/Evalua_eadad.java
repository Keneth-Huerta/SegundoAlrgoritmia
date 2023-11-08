import java.util.*;

public class Evalua_eadad {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Intrduce tu edad, por favor");

		int edad = entrada.nextInt();

		if (edad < 18) {
			System.out.println("Eres un adolescente");
		} else if (edad >= 18 && edad < 40) {
			System.out.println("Eres joven");
		} else if (edad >= 40 && edad < 65) {
			System.out.println("Eres maduro");
		} else if (edad > 65) {
			System.out.println("Cuidate!!");
		}else {
			System.out.println("No pusiste una edad");
		}
	}

}
