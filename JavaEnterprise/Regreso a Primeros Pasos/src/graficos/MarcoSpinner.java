package graficos;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MarcoSpinner {

	public static void main(String[] args) {

		FrameSpinner mimarco = new FrameSpinner();
		mimarco.setVisible(true);
	}

}

class FrameSpinner extends JFrame {
	public FrameSpinner() {

		setBounds(550, 350, 550, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		add(new LaminaSpinner());
	}
}

class LaminaSpinner extends JPanel {
	private JSpinner control;
//	private JLabel mitexto;

	public LaminaSpinner() {

		setLayout(new BorderLayout());
//		String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		control = new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			public Object getNextValue() {

				return super.getPreviousValue();
			}

			public Object getPreviousValue() {

				return super.getNextValue();
			}
		});
		control.setPreferredSize(new Dimension(250, 25));
		JPanel milamina2 = new JPanel();
		add(milamina2, BorderLayout.NORTH);
		milamina2.add(control);
//		mitexto = new JLabel("Lorem ipsum dolor sit amet consectetur adipisicing elit.", SwingConstants.CENTER);
//		add(mitexto, BorderLayout.CENTER);
//		AccionSpinner AccionS = new AccionSpinner();
//		control.addChangeListener(AccionS);
	}

//	private class MiModeloJspinner extends SpinnerNumberModel {
//
//		public MiModeloJspinner(int value, int minimum, int maximum, int stepSize) {
//
//			super(value, minimum, maximum, stepSize);
//		}
//
//		public Object getNextValue() {
//
//			return super.getPreviousValue();
//		}
//
//		public Object getPreviousValue() {
//
//			return super.getNextValue();
//		}
//	}

	private class AccionSpinner implements ChangeListener {

		public void stateChanged(ChangeEvent e) {

//			mitexto.setFont(new Font((String) control.getValue(), Font.PLAIN, 12));
		}
	}
}