package examen;

import javax.swing.JFrame;

public class Examen {

	public static void main(String[] args) {

		JFrame f = new JFrame("Examen");
		Lienzo lin = new Lienzo();
		f.add(lin);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

}
