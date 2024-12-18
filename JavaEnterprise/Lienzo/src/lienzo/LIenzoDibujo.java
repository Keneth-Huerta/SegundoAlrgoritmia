package lienzo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LIenzoDibujo extends JPanel {
	private Shape s;
	private double scale = 1.01;

	public LIenzoDibujo() {
		setPreferredSize(new Dimension(500, 500));
		s = new Ellipse2D.Double(225, 225, 50, 50);
		
		Timer t = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				double centerX = s.getBounds2D().getCenterX();
				double centerY = s.getBounds2D().getCenterY();

				AffineTransform tr = new AffineTransform();
				tr.setToScale(scale, scale);
				s = tr.createTransformedShape(s);

				double newCenterX = s.getBounds2D().getCenterX();
				double newCenterY = s.getBounds2D().getCenterY();

				AffineTransform translate = new AffineTransform();
				translate.translate(centerX - newCenterX, centerY - newCenterY);

				s = translate.createTransformedShape(s);
				if (s.getBounds().getMaxX() >= getBounds().getWidth()) {
					scale = 0.99;
				
				}
				if (s.getBounds().width <= 10) {

					scale = 1.01;
				}

				repaint();
			}
		});
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(s);

	}

}
