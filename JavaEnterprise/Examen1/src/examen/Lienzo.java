package examen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lienzo extends JPanel {

	public Lienzo() {

		setPreferredSize(new Dimension(500, 500));

		setLayout(new BorderLayout());

		JPanel lam = new JPanel();

		JLabel lb1 = new JLabel("X:");
		JTextField x = new JTextField(5);
		JLabel lb2 = new JLabel("Y:");
		JTextField y = new JTextField(5);
		JLabel lb3 = new JLabel("Ancho:");
		JTextField ancho = new JTextField(5);
		JLabel lb4 = new JLabel("Filas:");
		JTextField filas = new JTextField(5);

		JButton btn = new JButton("Generar");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Rombo r = new Rombo(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()),
						Integer.parseInt(ancho.getText()), Integer.parseInt(filas.getText()));
				repaint();
			}
		});

		lam.add(lb1);
		lam.add(x);
		lam.add(lb2);
		lam.add(y);
		lam.add(lb3);
		lam.add(ancho);
		lam.add(lb4);
		lam.add(filas);
		lam.add(btn);
		add(lam, BorderLayout.SOUTH);

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rombo.dibujar(g2);
	}
}
