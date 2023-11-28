package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EjemploRadio {

	public static void main(String[] args) {

		MarcoRadio mimarco = new MarcoRadio();
		mimarco.setVisible(true);
	}

}

class MarcoRadio extends JFrame {

	public MarcoRadio() {

		setBounds(550, 300, 500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaRadio milamina = new LaminaRadio();
		add(milamina);
	}
}

class LaminaRadio extends JPanel {
	private JLabel mitexto;
	private JRadioButton boton1, boton2, boton3, boton4;
	private ButtonGroup migrupo;
	private JPanel laminaBotones;

	public LaminaRadio() {

		setLayout(new BorderLayout());
		mitexto = new JLabel("En un lugar de la Mancha cuyo nombre no quiero acordarme...");
		mitexto.setFont(new Font("Serif", Font.PLAIN, 12));
		add(mitexto);
		laminaBotones = new JPanel();
		migrupo = new ButtonGroup();
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Muy grande", false, 20);
		add(laminaBotones, BorderLayout.SOUTH);

	}

	public void colocarBotones(String nombre, boolean seleccionado, final int tamano) {
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		migrupo.add(boton);
		laminaBotones.add(boton);
		ActionListener mievento = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				mitexto.setFont(new Font("Serif", Font.PLAIN, tamano));
			}

		};
		boton.addActionListener(mievento);
	}
}