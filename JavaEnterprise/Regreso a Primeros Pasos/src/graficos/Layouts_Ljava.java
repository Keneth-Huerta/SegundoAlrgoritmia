package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts_Ljava {

	public static void main(String[] args) {
		MarcoLayout mimarco = new MarcoLayout();
		mimarco.setVisible(true);
		
	}
}

 class MarcoLayout extends JFrame{
	
	public MarcoLayout() {

		setTitle("Prueba Acciones");
		setIconImage(new Logo().image());
		setBounds(600, 350, 600, 300);

		PanelLayout milamina = new PanelLayout();
		add(milamina,BorderLayout.NORTH);
		PanelLayout2 milamina2 = new PanelLayout2();
		add(milamina2,BorderLayout.SOUTH);
	}
	
}
class PanelLayout extends JPanel{
	
	public PanelLayout() {

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
	}
}
class PanelLayout2 extends JPanel{
	
	public PanelLayout2() {

		setLayout(new BorderLayout(5,5));
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);		
	}
}