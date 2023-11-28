package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisposicionLibre {

	public static void main(String[] args) {

		marcoLibre mimarco = new marcoLibre();
		mimarco.setVisible(true);
	}

}

class marcoLibre extends JFrame {

	public marcoLibre() {

		setBounds(450, 350, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaLibre milamina = new LaminaLibre();
		add(milamina);
	}
}

class LaminaLibre extends JPanel {

	public LaminaLibre() {

		setLayout(new EnColumnas());
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JTextField cNombre = new JTextField();
		JTextField cApellido = new JTextField();
		JTextField cEdad = new JTextField();
//		nombre.setBounds(20, 20, 100, 20);
//		cNombre.setBounds(100, 17, 100, 20);
//		apellido.setBounds(20, 60, 80, 17);
//		cApellido.setBounds(100, 55, 100, 20);
		add(nombre);
		add(cNombre);
		add(apellido);
		add(cApellido);
		add(edad);
		add(cEdad);

	}
}

class EnColumnas implements LayoutManager {
	private int x;
	private int y;

	public void addLayoutComponent(String name, Component comp) {

	}

	public void removeLayoutComponent(Component comp) {

	}

	public Dimension preferredLayoutSize(Container parent) {

		return null;
	}

	public Dimension minimumLayoutSize(Container parent) {

		return null;
	}

	public void layoutContainer(Container parent) {

		int d = parent.getWidth();
		x = d / 2;
		int contador = 0;
		int n = parent.getComponentCount();

		for (int i = 0; i < n; i++) {
			contador++;
			Component c = parent.getComponent(i);
			c.setBounds(x - 100, y, 100, 20);
			x += 100;
			if (contador % 2 == 0) {
				x = d / 2;
				y += 40;
			} else {

			}
		}
	}

}