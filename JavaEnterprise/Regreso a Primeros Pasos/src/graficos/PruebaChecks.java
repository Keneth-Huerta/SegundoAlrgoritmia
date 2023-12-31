package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaChecks {

	public static void main(String[] args) {

		MarcoCheck mimarco = new MarcoCheck();
		mimarco.setVisible(true);
	}
}

class MarcoCheck extends JFrame {

	public MarcoCheck() {

		setBounds(550, 300, 550, 350);
		setIconImage(new Logo().image());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LaminaCheck milamina = new LaminaCheck();
		add(milamina);
	}
}

class LaminaCheck extends JPanel {
	private JLabel texto;
	private JCheckBox check1, check2;

	public LaminaCheck() {

		setLayout(new BorderLayout());
		Font miletra = new Font("Serif", Font.PLAIN, 24);
		texto = new JLabel("En un lugar de la Mancha de cuyo nombe...");
		texto.setFont(miletra);
		JPanel laminatexto = new JPanel();
		laminatexto.add(texto);
		add(laminatexto, BorderLayout.CENTER);
		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		JPanel laminaChecks = new JPanel();
		laminaChecks.add(check1);
		laminaChecks.add(check2);
		add(laminaChecks, BorderLayout.SOUTH);

	}

	private class ManejaChecks implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int tipo = 0;
			if (check1.isSelected())
				tipo += Font.BOLD;
			if (check2.isSelected())
				tipo += Font.ITALIC;
			texto.setFont(new Font("Serif",tipo,24));
		}

	}
}