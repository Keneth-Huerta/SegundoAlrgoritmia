package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Prueba {

	public static void main(String[] args) {

		MarcoPrueba mimarco = new MarcoPrueba();
		mimarco.setVisible(true);
	}

}

class MarcoPrueba extends JFrame {

	public MarcoPrueba() {

		setBounds(500, 300, 500, 350);
		setIconImage(new Logo().image());
		LaminaPrueba milamina = new LaminaPrueba();
		add(milamina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class LaminaPrueba extends JPanel {

	private JTextField mitexto;
	public LaminaPrueba() {

		mitexto = new JTextField(20);
		EscuchaTexto el_evento=new EscuchaTexto();
		Document midoc = mitexto.getDocument();
		midoc.addDocumentListener(el_evento);
		add(mitexto);
	}

	private class EscuchaTexto implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {

			System.out.println(mitexto.getText());
		}

		public void removeUpdate(DocumentEvent e) {

			System.out.println("has borrado texto");
		}

		public void changedUpdate(DocumentEvent e) {

		}

	}
}