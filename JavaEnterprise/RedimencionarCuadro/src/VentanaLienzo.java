

import javax.swing.JFrame;

public class VentanaLienzo extends JFrame {

	public VentanaLienzo() {

		setTitle("Canvas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LIenzoDibujo mimarco = new LIenzoDibujo();
		add(mimarco);
		pack();
		setLocationRelativeTo(null);
		
	
	}
}
