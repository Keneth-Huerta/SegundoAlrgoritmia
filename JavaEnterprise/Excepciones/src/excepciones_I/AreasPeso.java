package excepciones_I;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AreasPeso {
	private static int figura;

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Circulo ");
		try {

			figura = entrada.nextInt();
//			entrada.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			entrada.close();
		}
		switch (figura) {
		case 1:
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println(Math.pow(lado, 2));
			break;
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println(Math.multiplyExact(base, altura));
			break;
		case 3:
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println(Math.multiplyExact(base, altura) / 2);
			break;
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			System.out.println(Math.PI * Math.pow(radio, 2));
			break;

		default:
			System.out.println("La opción no es correcta");
			break;
		}
		// -----------------------------------
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
		System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + " kg");
		System.out.println("Si eres mujer tu peso ideal es: " + (altura - 120) + " kg");
	}

}
