package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class EvaluarFuente {

	public static void main(String[] args) {
		String fuente = JOptionPane.showInputDialog("Introduce fuente");
		boolean estalafuente = false;

		String[] nombreDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (String string : nombreDeFuentes) {

			if (string.equalsIgnoreCase(fuente)) {
				estalafuente = true;
			}
		}
		if (estalafuente) {
			System.out.println("Fuente Instalada");
		} else {
			System.out.println("No está instala la fuente");
		}
	}

}
