import java.util.Scanner;

import javax.swing.JOptionPane;

public class Areas {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(
				"De qué figura quieres calcular el área: \n1: Cuadrado \n2: Recntágulo \n3: Triángulo\n4: Círculo");
		int figura = entrada.nextInt();
		switch (figura) {
		case 1:// Square
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Cuál es el lado"));
			System.out.println("El área del cuadrado es: " + (int) (Math.pow(lado, 2)));
			break;

		case 2:// Rectangle
			int MarcoCambioEstado = Integer.parseInt(JOptionPane.showInputDialog("Cual es la MarcoCambioEstado"));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Cual es la altura"));
			System.out.println("El área del rectángulo es: " + MarcoCambioEstado * altura);
			break;
		case 3:// Triangle
			int MarcoCambioEstadoT = Integer.parseInt(JOptionPane.showInputDialog("Cual es la MarcoCambioEstado"));
			int alturaT = Integer.parseInt(JOptionPane.showInputDialog("Cual es la altura"));
			System.out.println("El área del triángulo es: " + (MarcoCambioEstadoT * alturaT) / 2);
			break;
		case 4:// Circle
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Cual es el radio"));
			System.out.println("El área del circulo es: " + Math.pow(radio, 2) * Math.PI);
			System.out.printf("%1.2f", Math.pow(radio, 2) * Math.PI);
			break;
		default:
			System.out.println("La opción no es correcta");
			break;
		}
	}

}
