package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {

	public static void main(String[] args) {

		MarcoConDibujo mimarco = new MarcoConDibujo();

		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujo extends JFrame {

	public MarcoConDibujo() {

		setTitle("prueba de Dibujo");
		setSize(400, 400);
		setLocationRelativeTo(null);
		LaminaConfiguras milamina = new LaminaConfiguras();
		add(milamina);
	}
}

class LaminaConfiguras extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
//		g.drawRect(50, 50, 200, 200);
//		g.drawLine(100, 100, 300, 200);
//		g.drawArc(50, 100, 100, 200, 120, 1280);
		Graphics2D g2 = (Graphics2D) g;

		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 1280);
		g2.draw(rectangulo);
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		double CentroenX = rectangulo.getCenterX();
		double CentroenY = rectangulo.getCenterY();
		double radio = 125;
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX + radio, CentroenY + radio);
		g2.draw(circulo);

		
	}
}