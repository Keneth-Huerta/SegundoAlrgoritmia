package proyectointegrador;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
		setSize(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			setIconImage(ImageIO.read(new File("src/images/Cubo-EnfocadoL.png")));
		} catch (IOException e) {
			System.out.println("La image no se encuentra");
		}
		setLocationRelativeTo(null);
		LaminaProcesadorTextos milamina = new LaminaProcesadorTextos();
		add(milamina);
	}
}

class LaminaProcesadorTextos extends JPanel {
	JTextPane miarea;
	JMenu fuente, estilo, tamano;
	ButtonGroup tamanoLetra;
	JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, amarilloBarra, rojoBarra, centroBarra, izquiBarra,
			dereBarra, justiBarra;
	JToolBar barras;

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
			configuraMenu(lista[ale], "fuente", lista[ale], 9, 1, "", 0);
		}
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "src/images/negrita.png", KeyEvent.VK_N);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "src/images/cursiva.png", KeyEvent.VK_K);
		configuraMenu("Subrayado", "estilo", "", 9, 1, "src/images/subra.png", KeyEvent.VK_S);

		// JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new
		// ImageIcon("src/images/negrita.png"));
		// JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursica", new
		// ImageIcon("src/images/cursiva.png"));
		// negrita.addActionListener(new StyledEditorKit.BoldAction());
		// cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		// estilo.add(negrita);
		// estilo.add(cursiva);

		// configuraMenu("12", "tamano", "", 9, 12,"");
		// configuraMenu("14", "tamano", "", 9, 14,"");
		// configuraMenu("16", "tamano", "", 9, 16,"");
		// configuraMenu("18", "tamano", "", 9, 18,"");
		// configuraMenu("20", "tamano", "", 9, 20,"");

		tamanoLetra = new ButtonGroup();
		configuraMenu2("12", true, 0);
		configuraMenu2("16", false, 0);
		configuraMenu2("20", false, 0);
		configuraMenu2("24", false, 0);

		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita", new ImageIcon("src/images/negrita.png"));
		JMenuItem cursivaE = new JMenuItem("Cursiva", new ImageIcon("src/images/cursiva.png"));
		JMenuItem subraE = new JMenuItem("Subrayado", new ImageIcon("src/images/subra.png"));
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		subraE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		emergente.add(subraE);
		miarea.setComponentPopupMenu(emergente);
		// ----------------------
		barras = new JToolBar();
		// configuraBarra("Negrita").addActionListener(new
		// StyledEditorKit.BoldAction());
		// configuraBarras("Cursiva").addActionListener(new
		// StyledEditorKit.ItalicAction());
		// configuraBarras("Subrayado").addActionListener(new
		// StyledEditorKit.UnderlineAction());

		JList<String> list = new JList<String>(new String[] { FormatoTexto.NEGRITA.name(), FormatoTexto.CURSIVA.name(),
				FormatoTexto.SUBRAYADO.name() });
		barras.add(list);
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				if (list.getSelectedValue().equals(FormatoTexto.NEGRITA.name())) {

					new StyledEditorKit.BoldAction();

				} else if (list.getSelectedValue().equals(FormatoTexto.CURSIVA.name())) {

					new StyledEditorKit.ItalicAction();

				} else {
					new StyledEditorKit.UnderlineAction();

				}
			}
		});

		barras.addSeparator();
		configuraBarra("src/images/azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("", Color.blue));
		configuraBarra("src/images/rojo.gif").addActionListener(new StyledEditorKit.ForegroundAction("", Color.red));
		configuraBarra("src/images/Amarillo.png")
				.addActionListener(new StyledEditorKit.ForegroundAction("", Color.yellow));
		configuraBarra("src/images/negro.png").addActionListener(new StyledEditorKit.ForegroundAction("", Color.black));
		barras.addSeparator();
		configuraBarra("src/images/izqui.png").addActionListener(new StyledEditorKit.AlignmentAction("", 0));
		configuraBarra("src/images/centro.png").addActionListener(new StyledEditorKit.AlignmentAction("", 1));
		configuraBarra("src/images/dere.png").addActionListener(new StyledEditorKit.AlignmentAction("", 2));
		configuraBarra("src/images/justi.png").addActionListener(new StyledEditorKit.AlignmentAction("", 3));
		barras.setOrientation(1);
		add(barras, BorderLayout.WEST);
	}

	public enum FormatoTexto {
		NEGRITA, CURSIVA, SUBRAYADO;
	}

	public JButton configuraBarra(String ruta) {

		JButton boton = new JButton(new ImageIcon(ruta));
		barras.add(boton);
		return boton;
	}

	public void configuraMenu2(String number, boolean valor, int key) {

		JRadioButtonMenuItem numbers = new JRadioButtonMenuItem(number, valor);
		tamanoLetra.add(numbers);
		numbers.addActionListener(new StyledEditorKit.FontSizeAction("cambioLetra", Integer.parseInt(number)));
		tamano.add(numbers);
		numbers.setAccelerator(KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
	}

	public void configuraMenu(String nombre, String menu, String TipoLetra, int estilo, int tamano, String rutaIcono,
			int key) {

		JMenuItem ejemplo = new JMenuItem(nombre, new ImageIcon(rutaIcono));

		if (menu.equals("fuente")) {

			fuente.add(ejemplo);
			ejemplo.addActionListener(new StyledEditorKit.FontFamilyAction("cambioLetra", TipoLetra));
		} else if (menu.equals("estilo")) {

			this.estilo.add(ejemplo);
			if (estilo == Font.BOLD) {

				ejemplo.addActionListener(new StyledEditorKit.BoldAction());
			} else if (estilo == Font.ITALIC) {

				ejemplo.addActionListener(new StyledEditorKit.ItalicAction());
			} else if (estilo == 9) {
				ejemplo.addActionListener(new StyledEditorKit.UnderlineAction());
			}
			ejemplo.setAccelerator(KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
		}
	}

}
