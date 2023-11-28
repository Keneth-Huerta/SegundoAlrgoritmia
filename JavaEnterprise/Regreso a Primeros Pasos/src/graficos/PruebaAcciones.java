package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {

		MarcoAcciones mimarco = new MarcoAcciones("Prueba acciones", 600, 350, 600, 300, "eoc");
		mimarco.setVisible(true);
	} 

}

class MarcoAcciones extends JFrame {

	public MarcoAcciones(String title, int x, int y, int width, int height, String sdco) {

		if (sdco.equalsIgnoreCase("eoc")) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		setVisible(true);
		setBounds(x, y, width, height);
		setTitle(title);
		setIconImage(new Logo().image());

		add(new LaminaAcciones());
	}
}

class LaminaAcciones extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
	}

	public LaminaAcciones() {

		AccionesColor accionAmarillo = new AccionesColor("Amarillo", new ImageIcon("src/graficos/Amarillo.gif"),
				Color.yellow);
		AccionesColor accionRojo = new AccionesColor("Rojo", new ImageIcon("src/graficos/Rojo.gif"), Color.red);
		AccionesColor accionAzul = new AccionesColor("Azul", new ImageIcon("src/graficos/Azul.gif"), Color.blue);

		add(new JButton(accionAmarillo));
		add(new JButton(accionRojo));
		add(new JButton(accionAzul));

		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

//		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");

		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");

		ActionMap mapaAccion = getActionMap();

		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_rojo", accionRojo);
		mapaAccion.put("fondo_azul", accionAzul);
	}

	private class AccionesColor extends AbstractAction {

		public AccionesColor(String nombre, Icon icono, Color color_boton) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámia del color " + nombre);
			putValue("color_de_fondo", color_boton);

		}

		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("color_de_fondo");
			setBackground(c);
		}
	}
}
