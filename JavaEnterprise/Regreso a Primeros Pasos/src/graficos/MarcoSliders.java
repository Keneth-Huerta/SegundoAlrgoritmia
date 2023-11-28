package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSliders {

	public static void main(String[] args) {

		FrameSliders mimarco = new FrameSliders();
		mimarco.setVisible(true);
	}

}

class FrameSliders extends JFrame {

	public FrameSliders() {

		setBounds(550, 400, 550, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaSliders milamina = new LaminaSliders();
		add(milamina);
	}
}

class LaminaSliders extends JPanel {
	private JSlider control;
	private JLabel texto;
	private static int contador;

	public LaminaSliders() {

		setLayout(new BorderLayout());
		control = new JSlider(8, 50, 12);
		control.setMajorTickSpacing(10);
		control.setMinorTickSpacing(2);
		control.setPaintTicks(true);
		control.setFont(new Font("Serif", Font.ITALIC, 12));
		control.setPaintLabels(true);
//		control.setSnapToTicks(true);
		add(control, BorderLayout.NORTH);
		AccionSlider miaccion = new AccionSlider();
		control.addChangeListener((ChangeListener) miaccion);
		JPanel milamina2 = new JPanel();
		texto = new JLabel("Lorem ipsum dolor sit amet consectetur adipisicing elit.");
		Font mitexto = new Font("Arial", Font.PLAIN, 12);
		texto.setVerticalAlignment(SwingConstants.CENTER);
		texto.setFont(mitexto);
		JScrollPane mibarra = new JScrollPane(milamina2);
		add(mibarra);
		milamina2.add(texto, BorderLayout.CENTER);
	}

	private class AccionSlider implements ChangeListener {

		public void stateChanged(ChangeEvent e) {

			contador++;
//			System.out.println(contador);
//			System.out.println(control.getValue());
			texto.setFont(new Font("Arial", Font.PLAIN, control.getValue()));
		}
	}
}