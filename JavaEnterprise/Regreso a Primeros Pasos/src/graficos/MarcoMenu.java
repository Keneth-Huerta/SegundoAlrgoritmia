package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {

	public static void main(String[] args) {

		MenuFrame mimarco = new MenuFrame();
		mimarco.setVisible(true);
	}

}

class MenuFrame extends JFrame {

	public MenuFrame() {

		setBounds(500, 300, 550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		MenuLamina milamina = new MenuLamina();
		add(milamina);
	}
}

class MenuLamina extends JPanel {
	private JMenuItem rojo;

	public MenuLamina() {

		JMenuBar mibarra = new JMenuBar();
		add(mibarra);
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herraminetas");
		JMenu opciones = new JMenu("Opciones");
		mibarra.add(archivo);
		mibarra.add(edicion);
		mibarra.add(herramientas);
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar Como");
		JMenuItem copiar = new JMenuItem("Copiar",new ImageIcon("bin/graficos/copiar.gif"));
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem cortar = new JMenuItem("Cortar",new ImageIcon("bin/graficos/cortar.gif"));
		JMenuItem pegar = new JMenuItem("Pegar",new ImageIcon("bin/graficos/pegar.gif"));
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		JMenuItem generales = new JMenuItem("Generales");
		rojo = new JMenuItem("Rojo");
		herramientas.add(generales);
		herramientas.add(rojo);
		edicion.add(copiar);
		edicion.add(cortar);
		edicion.add(pegar);
		edicion.addSeparator();
		edicion.add(opciones);
		opciones.add(opcion1);
		opciones.add(opcion2);
		archivo.add(guardar);
		archivo.add(guardarComo);
		AccionMenu AccionM = new AccionMenu();
		rojo.addActionListener(AccionM);
	}

	private class AccionMenu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==rojo) {
				setBackground(Color.red);
			}
		}
	}
}