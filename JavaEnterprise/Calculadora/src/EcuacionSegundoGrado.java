
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcuacionSegundoGrado {

	private double a, b, c;

	public EcuacionSegundoGrado(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void resolverPorFormulaGeneral() {
		double discriminante = b * b - 4.0 * a * c;

		try {
			if (discriminante < 0) {
				throw new DiscriminanteNegativoException();
			}

			double x1 = (-b + Math.sqrt(discriminante)) / (2.0 * a);
			double x2 = (-b - Math.sqrt(discriminante)) / (2.0 * a);

			mostrarResultados("Solución por fórmula general:", x1, x2);
		} catch (DiscriminanteNegativoException e) {
			mostrarMensajeError("La ecuación no tiene soluciones reales.", e);
		}
	}

	public void resolverPorFactorizacion() {
		double discriminante = b * b - 4 * a * c, x1 = 0, x2 = 0;

		// Verificar si la ecuación es realmente cuadrática
		try {
			if (a == 0) {
				mostrarMensajeError("No es una ecuación cuadrática.");
			}
			double ac = a * c;
			boolean encontrado = false;
			for (double i = -Math.abs(ac); i <= Math.abs(ac); i += 0.01) {
				if (Math.abs(i) > 1e-9 && Math.abs(ac / i - Math.round(ac / i)) < 1e-9) {
					double j = ac / i;
					if (Math.abs(i + j - b) < 1e-9) {
						encontrado = true;

						// Las soluciones de la ecuación factorizada
						x1 = -i / a;
						x2 = -j / a;

						break;
					}
				}
			}
			
			if (!encontrado) {

				throw new DiscriminanteNegativoException();

			}
			mostrarResultados("Solución por factorización:", x1, x2);
		} catch (Exception e) {
			if (discriminante<0) {
				
				mostrarMensajeError("La ecuación no tiene soluciones reales.", e);
			}else{
				mostrarMensajeError("No se encontraron factores que permitan factorizar la ecuación.");
			}

		}

	}

	private void mostrarResultados(String titulo, double x1, double x2) {
		String resultados = titulo + "\n";
		resultados += "x1 = " + x1 + "\n";
		resultados += "x2 = " + x2;

		JOptionPane.showMessageDialog(null, resultados);
	}

	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void mostrarMensajeError(String mensaje, Exception e) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		e.getMessage();
		e.printStackTrace();
	}
}

class DiscriminanteNegativoException extends Exception {
}

class VentanaPrincipal extends JFrame implements ActionListener {

	private JTextField txtA, txtB, txtC;
	private JButton btnFormulaGeneral, btnFactorizacion;
	private JTextArea txtResultados;

	public VentanaPrincipal() {
		super("Ecuación de Segundo Grado");
		setLayout(new GridLayout(3, 2, 5, 5));

		JLabel lblA = new JLabel("Coeficiente a:");
		add(lblA);
		txtA = new JTextField();
		add(txtA);

		JLabel lblB = new JLabel("Coeficiente b:");
		add(lblB);
		txtB = new JTextField();
		add(txtB);

		JLabel lblC = new JLabel("Coeficiente c:");
		add(lblC);
		txtC = new JTextField();
		add(txtC);

		btnFormulaGeneral = new JButton("Fórmula General");
		btnFormulaGeneral.addActionListener(this);
		add(btnFormulaGeneral);

		btnFactorizacion = new JButton("Factorización");
		btnFactorizacion.addActionListener(this);
		add(btnFactorizacion);

		txtResultados = new JTextArea();
		txtResultados.setEditable(false);
		add(txtResultados, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double a = Double.parseDouble(txtA.getText());
			double b = Double.parseDouble(txtB.getText());
			double c = Double.parseDouble(txtC.getText());

			EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado(a, b, c);

			if (e.getSource() == btnFormulaGeneral) {
				ecuacion.resolverPorFormulaGeneral();
			} else if (e.getSource() == btnFactorizacion) {
				ecuacion.resolverPorFactorizacion();
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Los valores ingresados no son números válidos.", "Error de formato",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

class Main {

	public static void main(String[] args) {
		new VentanaPrincipal();
	}
}
