package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PruebaArea {

	public static void main(String[] args) {

		MarcoPruebaArea mimarco = new MarcoPruebaArea();
		mimarco.setVisible(true);
	}

}

class MarcoPruebaArea extends JFrame {
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;

	public MarcoPruebaArea() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 350);
		setTitle("Probando Área de texto");
		setIconImage(new Logo().image());
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		botonInsertar = new JButton("Insertar");
		add(laminaBotones, BorderLayout.SOUTH);
		laminaBotones.add(botonInsertar);
		botonInsertar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				areaTexto.append("En un lugar de la mancha de cuyo nombre no quiero acordarme... ");
			}
		});
		botonSaltoLinea = new JButton("Salto Línea");
		botonSaltoLinea.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				boolean saltar = !areaTexto.getLineWrap();
				areaTexto.setLineWrap(saltar);
//				if (saltar) {
//					botonSaltoLinea.setText("Quitar salto");
//				} else {
//					botonSaltoLinea.setText("Salto Línea");
//				}
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Línea");
			}
		});
		laminaBotones.add(botonSaltoLinea);
		areaTexto = new JTextArea(8, 20);
		laminaConBarras = new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);
	}
}
