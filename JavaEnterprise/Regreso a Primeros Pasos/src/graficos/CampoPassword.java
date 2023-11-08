package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {

	public static void main(String[] args) {

		MarcoPassword mimarco = new MarcoPassword();
		mimarco.setVisible(true);
	}

}

class MarcoPassword extends JFrame {

	public MarcoPassword() {

		setBounds(400, 300, 550, 400);
		setIconImage(new Logo().image());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LaminaPassword milamina = new LaminaPassword();
		add(milamina);
	}
}

class LaminaPassword extends JPanel {
	private JPasswordField c_contra;

	public LaminaPassword() {

		setLayout(new BorderLayout());
		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new GridLayout(2, 2));
		add(laminaSuperior, BorderLayout.NORTH);
		JLabel etiqueta1 = new JLabel("Usuario:");
		JLabel etiqueta2 = new JLabel("Constraseña:");
		JTextField c_usuario = new JTextField(15);
		c_contra = new JPasswordField(15);
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(c_usuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(c_contra);
		JButton enviar = new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
		CompruebaPass mievento = new CompruebaPass();
		c_contra.getDocument().addDocumentListener(mievento);
	}

	private class CompruebaPass implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {

			char[] contrasena = c_contra.getPassword();
			if (contrasena.length < 8 || contrasena.length > 12) {
				c_contra.setBackground(Color.red);
			}else {
				c_contra.setBackground(Color.white);
			}
		}

		public void removeUpdate(DocumentEvent e) {

			char[] contrasena = c_contra.getPassword();
			if (contrasena.length < 8 || contrasena.length > 12) {
				c_contra.setBackground(Color.red);
			}else {
				c_contra.setBackground(Color.white);
			}
		}

		public void changedUpdate(DocumentEvent e) {

		}

	}
}
