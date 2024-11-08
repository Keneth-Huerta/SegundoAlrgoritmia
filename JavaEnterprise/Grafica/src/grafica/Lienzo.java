package grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lienzo extends JPanel {
	private boolean click = false;
	private static boolean color = false;

	public Lienzo() {

		setPreferredSize(new Dimension(300, 430));
		setLayout(new BorderLayout());

		JButton btn = new JButton("Checar");
		JTextField tfld = new JTextField(10);
		JPanel lamina = new JPanel();

		lamina.add(tfld);
		lamina.add(btn);
		add(lamina, BorderLayout.SOUTH);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				click = true;
				color = true;
				Grafica grf = new Grafica(tfld.getText().split(","));
				repaint();
			}
		});
	}

	public static boolean isColor() {
		return color;
	}

	public static void setColor(boolean color) {
		Lienzo.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (click) {

			Grafica.dibujar(g2);
		}
	}
}
