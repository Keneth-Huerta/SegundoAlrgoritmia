package practicas;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Laminabotones extends JPanel {
	private ButtonGroup grupo;

	public Laminabotones(String titulo, String[] opciones) {

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		grupo = new ButtonGroup();
		for (int i = 0; i < opciones.length; i++) {
			JRadioButton bot = new JRadioButton(opciones[i]);
			bot.setActionCommand(opciones[i]);
			grupo.add(bot);
			add(bot);
			bot.setSelected(i == 0);
		}
	}

	public String dameSeleccion() {

//		ButtonModel miboton = grupo.getSelection();
//		String s = miboton.getActionCommand();
//		return s;
		return grupo.getSelection().getActionCommand();
	}
}
