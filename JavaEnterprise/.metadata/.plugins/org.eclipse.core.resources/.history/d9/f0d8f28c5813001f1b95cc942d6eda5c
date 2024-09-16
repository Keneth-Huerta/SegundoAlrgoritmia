package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Procesador {

	public static void main(String[] args) {

		menuProcesador mimarco = new menuProcesador();
		mimarco.setVisible(true);
	}

}

class menuProcesador extends JFrame {

	public menuProcesador() {

		setTitle("Procesador de textos");
		setBounds(500, 300, 550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaProcesador milamina = new LaminaProcesador();
		add(milamina);
	}
}

class LaminaProcesador extends JPanel {
	JMenuItem ejemplo;
	JTextPane miarea;
	JMenu fuente, estilo, tamano;

	public LaminaProcesador() {

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

		configuraMenu("Arial", "fuente", "Arial", 9, 1);
		configuraMenu("Courier", "fuente", "Courier", 9, 1);
		configuraMenu("Verdana", "fuente", "Verdana", 9, 1);
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
		configuraMenu("12", "tamano", "", 9, 12);
		configuraMenu("14", "tamano", "", 9, 14);
		configuraMenu("16", "tamano", "", 9, 16);
		configuraMenu("18", "tamano", "", 9, 18);
		configuraMenu("20", "tamano", "", 9, 20);
	}

	public void configuraMenu(String nombre, String menu, String TipoLetra, int estilo, int tamano) {

		ejemplo = new JMenuItem(nombre);

		if (menu.equals("fuente")) {

			fuente.add(ejemplo);
		} else if (menu.equals("estilo")) {

			this.estilo.add(ejemplo);
		} else {

			this.tamano.add(ejemplo);
		}
		ejemplo.addActionListener(new AccionProcesador(menu, TipoLetra, estilo, tamano));
	}

	private class AccionProcesador implements ActionListener {
		String tipoTexto, menu;
		int estiloLetra, tamanoLetra;

		public AccionProcesador(String elemento, String texto2, int estilo2, int tamano2) {

			tipoTexto = texto2;
			estiloLetra = estilo2;
			tamanoLetra = tamano2;
			menu = elemento;
		}

		public void actionPerformed(ActionEvent e) {

			Font letra = miarea.getFont();
			if (menu.equals("fuente")) {

				estiloLetra = letra.getStyle();
				tamanoLetra = letra.getSize();
			} else if (menu.equals("estilo")) {

				if (letra.getStyle() == 1 || letra.getStyle() == 2) {
					estiloLetra = 3;
				}
				tipoTexto = letra.getFontName();
				tamanoLetra = letra.getSize();
			} else if (menu.equals("tamano")) {

				tipoTexto = letra.getFontName();
				estiloLetra = letra.getStyle();
			}
			miarea.setFont(new Font(tipoTexto, estiloLetra, tamanoLetra));
			System.out.println(tipoTexto + " " + estiloLetra + " " + tamanoLetra);
		}
	}

}
