package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaCombo {

	public static void main(String[] args) {

		MarcoCombo mimarco = new MarcoCombo();
		mimarco.setVisible(true);
	}

}

class MarcoCombo extends JFrame {

	public MarcoCombo() {

		setBounds(550, 300, 550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaCombo milamina = new LaminaCombo();
		add(milamina);
	}
}

class LaminaCombo extends JPanel {
	private JLabel texto;
	private JComboBox micombo;

	public LaminaCombo() {

		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre no quiero acordarme...");
		texto.setFont(new Font("Sefir", Font.PLAIN, 18));
		add(texto, BorderLayout.CENTER);
		JPanel laminaNorte = new JPanel();
		micombo = new JComboBox();
		String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//		System.out.println(lista.length);
//		micombo.addItem("Serif");
//		micombo.addItem("Sans Serif");
//		micombo.addItem("Monospaced");
//		micombo.addItem("Dialog");
		for (int i = 0; i < lista.length; i++) {
			micombo.addItem(lista[i]);
		}
		micombo.setEditable(true);
		laminaNorte.add(micombo);
		add(laminaNorte, BorderLayout.NORTH);
		EventoCombo event = new EventoCombo();
		micombo.addActionListener(event);
	}

	private class EventoCombo implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			texto.setFont(new Font((String) micombo.getSelectedItem(), Font.PLAIN, 18));
		}
	}
}