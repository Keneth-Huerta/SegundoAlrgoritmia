package pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TablaPeriodicaRandom {

	public static void main(String[] args) {
		marcoTabla mimarco = new marcoTabla();
		mimarco.setVisible(true);

	}
}

class marcoTabla extends JFrame {

	public marcoTabla() {

		setBounds(300, 300, 800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Pruebas de tabla periodica");
		laminaTabla milamina = new laminaTabla();
		add(milamina);
	}
}

class laminaTabla extends JPanel {

	public laminaTabla() {

		JLabel texto1 = new JLabel("Hola");
		add(texto1);
		JTextField mitexto = new JTextField(15);
		add(mitexto);
		JButton boton1 = new JButton("Enviar");
		boton1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        String mensaje = mitexto.getText();
                        texto1.setText(mensaje);
                    }
                });
		add(boton1);
	}
}
