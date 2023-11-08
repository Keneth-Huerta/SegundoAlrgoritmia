package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class MarcoEmergente {

	public static void main(String[] args) {

		MarcoEmergenteM mimarco = new MarcoEmergenteM();
		mimarco.setVisible(true);
	}

}
class MarcoEmergenteM extends JFrame{
	
	public MarcoEmergenteM() {

		setBounds(100, 100, 300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaEmergente milamina = new LaminaEmergente();
		add(milamina);
	}
}
class LaminaEmergente extends JPanel{
	
	public LaminaEmergente() {

		setLayout(new BorderLayout());
		JMenuBar mibar = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamano = new JMenu("Tamano");
		mibar.add(estilo);
		mibar.add(fuente);
		mibar.add(tamano);
		JPanel milamina2 = new JPanel();
		add(milamina2,BorderLayout.NORTH);
		milamina2.add(mibar,BorderLayout.CENTER);
		JTextArea miarea = new JTextArea("hola");
		add(miarea,BorderLayout.CENTER);
//		---------------------------------------
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		JMenuItem opcion3 = new JMenuItem("Opcion 3");
		JMenuItem opcion4 = new JMenuItem("Opcion 4");
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		emergente.add(opcion4);
		miarea.setComponentPopupMenu(emergente);
	}
}