package graficos;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscribiendoEnMarco {

	public static void main(String[] args) {

		MarcoContexto mimarco = new MarcoContexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoContexto extends JFrame {

	public MarcoContexto() {

		setVisible(true);
		setBounds(0, 0, 600, 450);
		setLocationRelativeTo(null);
		setTitle("primer texto");
		LaminaContexto milamina = new LaminaContexto();
		add(milamina);
	}
}

class LaminaContexto extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawString("Estamos Aprendindo Swing", 10, 20);
	}
}
