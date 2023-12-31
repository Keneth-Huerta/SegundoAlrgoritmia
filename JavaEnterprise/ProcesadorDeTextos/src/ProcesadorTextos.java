import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class ProcesadorTextos {

	public static void main(String[] args) {

		menuProcesadorTextos mimarco = new menuProcesadorTextos();
		mimarco.setVisible(true);
	}

}

class menuProcesadorTextos extends JFrame {

	public menuProcesadorTextos() {

		setTitle("Procesador de textos");
		setBounds(500, 300, 550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("Cubo-EnfocadoL.png")).getImage());
		LaminaProcesadorTextos milamina = new LaminaProcesadorTextos();
		add(milamina);
	}
}

class LaminaProcesadorTextos extends JPanel {
	JTextPane miarea;
	JMenu fuente, estilo, tamano;

	public LaminaProcesadorTextos() {

		setLayout(new BorderLayout());
		miarea = new JTextPane();
		JMenuBar mibarra = new JMenuBar();
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tamaño");
		JPanel milamina2 = new JPanel();
		JScrollPane barra = new JScrollPane(miarea);
		add(milamina2, BorderLayout.NORTH);
		milamina2.add(mibarra);
		add(barra);
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamano);
		String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (int i = 0; i < 15; i++) {
			Random random = new Random();
			int ale = random.nextInt(lista.length) + 1;
			configuraMenu(lista[ale], "fuente", lista[ale], 9, 1, "");
		}
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "src/negrita.png");
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "src/cursiva.png");
		configuraMenu("12", "tamano", "", 9, 12, "");
		configuraMenu("14", "tamano", "", 9, 14, "");
		configuraMenu("16", "tamano", "", 9, 16, "");
		configuraMenu("18", "tamano", "", 9, 18, "");
		configuraMenu("20", "tamano", "", 9, 20, "");
	}

	public void configuraMenu(String nombre, String menu, String TipoLetra, int estilo, int tamano, String rutaIcono) {

		JMenuItem ejemplo = new JMenuItem(nombre, (Icon) new ImageIcon(getClass().getResource(rutaIcono)).getImage());

		if (menu.equals("fuente")) {

			fuente.add(ejemplo);
			ejemplo.addActionListener(new StyledEditorKit.FontFamilyAction("cambioLetra", TipoLetra));
		} else if (menu.equals("estilo")) {

			this.estilo.add(ejemplo);
			if (estilo == Font.BOLD) {

				ejemplo.addActionListener(new StyledEditorKit.BoldAction());
			} else if (estilo == Font.ITALIC) {

				ejemplo.addActionListener(new StyledEditorKit.ItalicAction());
			}
		} else if (menu.equals("tamano")) {

			this.tamano.add(ejemplo);
			ejemplo.addActionListener(new StyledEditorKit.FontSizeAction("cambioTamaño", tamano));
		}
	}

}
