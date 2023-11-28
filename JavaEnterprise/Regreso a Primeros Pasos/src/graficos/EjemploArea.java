package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploArea {

	public static void main(String[] args) {
		
		MarcoArea mimarco = new MarcoArea();
		mimarco.setVisible(true);
	}
}
class MarcoArea extends JFrame{
	
	public MarcoArea() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 350);
		setIconImage(new Logo().image());
		LaminaArea milamina = new LaminaArea();
		add(milamina);
	}
}
class LaminaArea extends JPanel{
	private JTextArea miarea;
	
	public LaminaArea() {
		miarea = new JTextArea(8,20);
		miarea.setLineWrap(true);
		JButton miboton = new JButton("Enviar");
		JScrollPane	laminaBarras = new JScrollPane(miarea);
		add(laminaBarras);
		add(miboton);
		miboton.addActionListener(new MiAccion());
		
	}
	private class MiAccion implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			System.out.println(miarea.getText());
		}
		
	}
}
