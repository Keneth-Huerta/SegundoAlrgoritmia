package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {

	public static void main(String[] args) {

		MarcoConColor mimarco = new MarcoConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoConColor extends JFrame {

	public MarcoConColor() {

		setTitle("Prueba con colores");
		setSize(400, 400);
		setLocationRelativeTo(null);
		LaminaConColor milamina = new LaminaConColor();
		add(milamina);
		milamina.setBackground(new Color(104, 29, 29));
	}
}

class LaminaConColor extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// dibujo de rectángulo
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 1280);
		g2.setPaint(Color.blue);
		g2.draw(rectangulo);
		g2.setPaint(Color.cyan);
		g2.fill(rectangulo);
		// dibujo de elipse
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.setPaint(new Color(117, 0, 62));
		g2.fill(elipse);

	}
}
