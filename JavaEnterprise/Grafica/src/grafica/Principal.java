package grafica;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		Lienzo lien = new Lienzo();
		ventana.add(lien);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

}
