import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Graficos extends JFrame {
	public static VentanaAdmin va;
	public static VentanaUser vu;
	public static VentanaPrincipal vp;

	public Graficos() {

		setTitle("Inicio de seción");
		setSize(250, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		vp = new VentanaPrincipal(this);
		vu = new VentanaUser(this);
		va = new VentanaAdmin(this);

		setContentPane(vp);
	}

	public void cambiarPanel(JPanel nuevoPanel) {
		setContentPane(nuevoPanel);
		revalidate();
		repaint();
	}

	public void start() {

		setVisible(true);
	}

}

class VentanaPrincipal extends JPanel {
	private Graficos frame;

	public VentanaPrincipal(Graficos frame) {
		this.frame = frame;
		JLabel lb1 = new JLabel("User");
		JLabel lb2 = new JLabel("Pass");
		JLabel lb3 = new JLabel("");
		JTextField tf1 = new JTextField(15);
		JPasswordField tf2 = new JPasswordField(15);
		JButton btn = new JButton("Ingresar");

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BaseData bd = new BaseData(tf1.getText(), new String(tf2.getPassword()));
				if (bd.getResult().equals("user")) {
					frame.cambiarPanel(Graficos.vu);
					lb3.setText("");
				} else if (bd.getResult().equals("admin")) {
					frame.cambiarPanel(Graficos.va);
					lb3.setText("");
				} else if (bd.getResult().equals("incorrecta")) {

					lb3.setText("    Contraseña incorrecta    ");
				} else {

					lb3.setText("Usuario inexistente o vacio");
				}

			}
		});
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(lb3);
		add(btn);
	}
}

class VentanaUser extends JPanel {
	public VentanaUser(Graficos frame) {
		JLabel lb = new JLabel("User");
		JButton btnVolver = new JButton("Volver");

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.cambiarPanel(Graficos.vp);
			}
		});

		add(lb);
		add(btnVolver);
	}
}

class VentanaAdmin extends JPanel {
	public VentanaAdmin(Graficos frame) {
		JLabel lb = new JLabel("Admin");
		JButton btnVolver = new JButton("Volver");

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.cambiarPanel(Graficos.vp);
			}
		});

		add(lb);
		add(btnVolver);
	}
}