package graficos;

import javax.swing.JFrame;

public class CreandoMarcos {

	public static void main(String[] args) {

		miMarco marco1 = new miMarco();

		marco1.setVisible(true);

		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		marco1
	}

}

class miMarco extends JFrame {

	public miMarco() {

//		setSize(500, 300);
//		setLocation(700,300);

		setBounds(650,300,500,300);
//		setResizable(false);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Mi ventana");
	}
}
