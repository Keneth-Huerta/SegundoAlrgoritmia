package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraHerramientas {

	public static void main(String[] args) {

		Marco_Barra mimarco = new Marco_Barra();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame {

	public Marco_Barra() {

		setIconImage(new Logo().image());
		setTitle("Marco con Barra");

		setBounds(500, 300, 600, 450);

		lamina = new JPanel();

		add(lamina);

		// configuraciónn de acciones

		Action accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/azul.gif"), Color.BLUE);

		Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/amarillo.gif"),
				Color.YELLOW);

		Action accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/rojo.gif"), Color.RED);
		Action acionSalir =new AbstractAction("Salir", new ImageIcon("src/graficos/salir.png")) {
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		};
		
		JMenu menu = new JMenu("Color");

		menu.add(accionRojo);
		menu.add(accionAmarillo);
		menu.add(accionAzul);
		JMenuBar barraMenus = new JMenuBar();
		barraMenus.add(menu);
		setJMenuBar(barraMenus);
		//Construcción de la barra de herramientas
		JToolBar barra=new JToolBar();
		barra.add(accionAzul);
		barra.add(accionRojo);
		barra.add(accionAmarillo);
		barra.addSeparator();
		barra.add(acionSalir);
		add(barra,BorderLayout.NORTH);
	}

	private class AccionColor extends AbstractAction {

		public AccionColor(String nombre, Icon icono, Color c) {

			putValue(Action.NAME, nombre);

			putValue(Action.SMALL_ICON, icono);

			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);

			putValue("Color", c);
		}

		public void actionPerformed(ActionEvent arg0) {

			Color c = (Color) getValue("Color");

			lamina.setBackground(c);

		}

	}

	private JPanel lamina;
}
