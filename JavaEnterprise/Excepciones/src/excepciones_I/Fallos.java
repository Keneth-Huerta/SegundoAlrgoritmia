package excepciones_I;

import javax.swing.JOptionPane;

public class Fallos {

	public static void main(String[] args) {

		int[] miMatriz = { 5, 38, -15, 92, 71 };
		for (int i = 0; i < 5; i++) {
			System.out.println("Posición " + i + " = " + miMatriz[i]);
		}
//		Peticion de datos personales
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		System.out.println("Hola " + nombre + " Tienes " + edad + " años.  El programa termino su ejecucion");
	}

}
