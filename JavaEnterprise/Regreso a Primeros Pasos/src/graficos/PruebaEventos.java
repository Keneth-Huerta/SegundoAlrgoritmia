package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {

		MarcoBotones mimarco = new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setIconImage(new Logo().image());
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setIconImage(new Logo().image());
	}

}

class MarcoBotones extends JFrame {

	public MarcoBotones() {

		setTitle("Botones y eventos");
		setSize(500, 300);
		setLocationRelativeTo(null);
		LaminaBotones milamina = new LaminaBotones();
		add(milamina);

	}
}

class LaminaBotones extends JPanel {

	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Verde");
	JButton botonRojo = new JButton("Rojo");

	public LaminaBotones() {

		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);

		ColorFondo Verde = new ColorFondo(new Color(0, 255, 0, 100));
		ColorFondo Rojo = new ColorFondo(new Color(255, 0, 0, 100));
		ColorFondo Azul = new ColorFondo(new Color(0, 0, 255, 100));
		botonAzul.addActionListener(Azul);
		botonAmarillo.addActionListener(Rojo);
		botonRojo.addActionListener(Verde);
		setBackground(Color.BLACK);
	}

	private class ColorFondo implements ActionListener {

		private Color colorDeFondo;

		public ColorFondo(Color c) {

			colorDeFondo = c;
		}

		public void actionPerformed(ActionEvent e) {

			setBackground(colorDeFondo);
		}

	}
}
