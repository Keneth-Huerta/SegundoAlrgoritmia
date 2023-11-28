package pruebas;

import javax.swing.JOptionPane;

public class numeroMagico {

	public static void main(String[] args) {

		int random = (int) (100 * Math.random());

		int firstNum = Integer.parseInt(JOptionPane.showInputDialog("Pon un número entre 0 y 100"));

		int i = 0;
		while (firstNum != random) {
			i++;

			if (firstNum < random) {

				firstNum = Integer.parseInt(JOptionPane.showInputDialog("Más grande"));
			} else {

				firstNum = Integer.parseInt(JOptionPane.showInputDialog("Más pequeño"));
			}
		}
		JOptionPane.showMessageDialog(null, "El número " + random + " era correcto");
		System.out.println("número de intentos: " + i);
	}

}
