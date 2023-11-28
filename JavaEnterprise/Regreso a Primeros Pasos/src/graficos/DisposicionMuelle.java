package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {

		MarcoMuelle mimarco = new MarcoMuelle();
		mimarco.setVisible(true);
	}

}
class MarcoMuelle extends JFrame{
	
	public MarcoMuelle() {

		setBounds(300, 400, 1000, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		LaminaMuelle milamina = new LaminaMuelle();
		add(milamina);
	}
}
class LaminaMuelle extends JPanel{
	
	public LaminaMuelle() {

		JButton boton1 = new JButton("Boton 1");
		JButton boton2 = new JButton("Boton 2");
		JButton boton3 = new JButton("Boton 3");
		SpringLayout milayout = new SpringLayout();
		setLayout(milayout);
		add(boton1);
		add(boton2);
		add(boton3);
		Spring mimuelle=Spring.constant(100,10,100);
		Spring mimuelleRigido=Spring.constant(10);
		milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
		milayout.putConstraint(SpringLayout.WEST, boton2, mimuelleRigido, SpringLayout.EAST, boton1);
		milayout.putConstraint(SpringLayout.WEST, boton3, mimuelle, SpringLayout.EAST, boton2);
		milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.EAST, boton3);
	}
}