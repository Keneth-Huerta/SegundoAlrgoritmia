package graficos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora {

	public static void main(String[] args) {

		MarcoCalc mimarco = new MarcoCalc();
		mimarco.setVisible(true);
	}
}

class MarcoCalc extends JFrame {

	public MarcoCalc() {

		setTitle("Calculadora");
		setBounds(500, 300, 450, 300);
	//	setIconImage(new ImageIcon(getClass().getResource("Cubo-EnfocadoL.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LaminaCalc());
//		pack();
	}
}

class LaminaCalc extends JPanel {

	private JButton pantalla;
	private JPanel milamina2;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;

	public LaminaCalc() {

		principio = true;

		setLayout(new BorderLayout());
		pantalla = new JButton("0");
		pantalla.setEnabled(false);

		add(pantalla, BorderLayout.NORTH);

		milamina2 = new JPanel();
		ActionListener insertar = new InsertaNumero();
		ActionListener orden = new AccionOrden();

		milamina2.setLayout(new GridLayout(4, 4));
		PonerBoton("7", insertar);
		PonerBoton("8", insertar);
		PonerBoton("9", insertar);
		PonerBoton("/", orden);
		PonerBoton("4", insertar);
		PonerBoton("5", insertar);
		PonerBoton("6", insertar);
		PonerBoton("*", orden);
		PonerBoton("1", insertar);
		PonerBoton("2", insertar);
		PonerBoton("3", insertar);
		PonerBoton("-", orden);
		PonerBoton(".", insertar);
		PonerBoton("0", insertar);
		PonerBoton("=", orden);
		PonerBoton("+", orden);

		add(milamina2, BorderLayout.CENTER);
		ultimaOperacion = "=";

	}

	private void PonerBoton(String rotulo, ActionListener oyente) {

		JButton boton = new JButton(rotulo);
		boton.addActionListener(oyente);
		milamina2.add(boton);
	}

	private class InsertaNumero implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String entrada = e.getActionCommand();
			if (principio) {

				pantalla.setText("");
				principio = false;
			}
			pantalla.setText(pantalla.getText() + entrada);
			System.out.println(entrada);
		}
	}

	private class AccionOrden implements ActionListener {

		String operacion;

		public void actionPerformed(ActionEvent e) {

			operacion = e.getActionCommand();

			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion = operacion;
			principio = true;
		}

		public void calcular(double x) {

			if (ultimaOperacion.equals("+")) {
				resultado += x;
				System.out.println(resultado);
			} else if (ultimaOperacion.equals("-")) {
				resultado -= x;
			} else if (ultimaOperacion.equals("*")) {
				resultado *= x;
			} else if (ultimaOperacion.equals("/")) {
				resultado /= x;
			} else if (ultimaOperacion.equals("=")) {
				resultado = x;
			}
			pantalla.setText(Double.toString(resultado));
		}

	}
}