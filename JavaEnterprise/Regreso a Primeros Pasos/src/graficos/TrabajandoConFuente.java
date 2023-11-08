package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuente {

	public static void main(String[] args) {

		MarcoConFuentes mimarco = new MarcoConFuentes();
		mimarco.setVisible(true);

	}

}

class MarcoConFuentes extends JFrame {

	public MarcoConFuentes() {

		setTitle("Prueba con fuentes");
		setSize(400, 400);
		setLocationRelativeTo(null);
		LaminaConFuentes milamina = new LaminaConFuentes();
		add(milamina);
		milamina.setForeground(Color.black);

	}
}

class LaminaConFuentes extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintChildren(g);
		Graphics g2 = (Graphics2D) g;
		Font mifuente = new Font("Algerian", Font.BOLD, 26);
		g2.setFont(mifuente);
		g2.setColor(Color.blue);
		g2.drawString("Juan", 100, 100);
		g2.setFont(new Font("times new roman", Font.ITALIC, 14));
		g2.setColor(Color.red);
		g2.drawString("Curso de Java", 100, 200);

	}
}
