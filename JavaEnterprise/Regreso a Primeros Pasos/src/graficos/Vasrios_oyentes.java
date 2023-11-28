package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vasrios_oyentes {

	public static void main(String[] args) {

		Marco_Principal mimarco = new Marco_Principal();
		mimarco.setVisible(true);
	}

}

class Marco_Principal extends JFrame {

	public Marco_Principal() {

		setTitle("Prueba Varios");
		setBounds(1300, 100, 300, 200);
		setIconImage(new Logo().image());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lamina_Principal milamina = new Lamina_Principal();
		add(milamina);
	}
}

class Lamina_Principal extends JPanel {

	JButton boton_cerrar;

	public Lamina_Principal() {

		JButton boton_nuevo = new JButton("Nuevo");
		boton_cerrar = new JButton("Cerrar todo");

		add(boton_nuevo);
		add(boton_cerrar);
		OyenteNuevo miOyente = new OyenteNuevo();
		boton_nuevo.addActionListener(miOyente);
	}

	private class OyenteNuevo implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Marco_Emergente marco = new Marco_Emergente(boton_cerrar);
			marco.setVisible(true);

		}

	}
}

class Marco_Emergente extends JFrame {
	private static int contador = 0;

	public Marco_Emergente(JButton botonDePrincipal) {

		contador++;
		setTitle("Vetana " + contador);
		setBounds(40 * contador, 40 * contador, 300, 150);
		setIconImage(new Logo().image());

		CierraTodos oyenteCerrar = new CierraTodos();

		botonDePrincipal.addActionListener(oyenteCerrar);
	}

	private class CierraTodos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			dispose();
			contador=0;
		}

	}
}