package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado {

	public static void main(String[] args) {

		MarcoCambioEstado mimarco = new MarcoCambioEstado(null, 700, 300, 600, 450, "eoc");

	}

}

class EventoDeTeclado implements KeyListener {

	public void keyTyped(KeyEvent e) {

		char letra = e.getKeyChar();
		System.out.println(letra);
	}

	public void keyPressed(KeyEvent e) {
//		int codigo = e.getKeyCode();
//		System.out.println(codigo);

	}

	public void keyReleased(KeyEvent e) {

	}

}
//class MarcoCambioEstado extends JFrame {
//
//	public MarcoCambioEstado(String title, int x, int y, int width, int height, String sdco) {
//
//		if (sdco.equalsIgnoreCase("eoc")) {
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		}
//
//		setVisible(true);
//		setBounds(x, y, width, height);
//		setTitle(title);
//		setIconImage(new Logo().image());
//		CambiaEstado nuevo_estado = new CambiaEstado();
//		addWindowStateListener(nuevo_estado);
//		
//		EventoDeTeclado tecla = new EventoDeTeclado();	
//		addKeyListener(tecla);
//	}
//}
