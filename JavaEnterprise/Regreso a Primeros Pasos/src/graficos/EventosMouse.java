package graficos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EventosMouse {

	public static void main(String[] args) {

		MarcoCambioEstado mimarco = new MarcoCambioEstado(null, 700, 300, 600, 450, "eoc");
	}

}

class EventosDeRaton implements MouseMotionListener /* extends MouseAdapter implements MouseListener */ {

	public void mouseDragged(MouseEvent e) {

		System.out.println("Estás arrastrando");
	}

	public void mouseMoved(MouseEvent e) {

		System.out.println("Estás moviendo");
	}

//	public void mouseClicked(MouseEvent e) {
//
////		System.out.println("Coordenada X: " + e.getX() + " Cordenada Y: " + e.getY());
//		System.out.println(e.getClickCount());
//	}

//	public void mousePressed(MouseEvent e) {
//
//		System.out.println(e.getModifiersEx());
//		if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK) {
//			System.out.println("Diste click izquierdo");
//		}else if (e.getModifiersEx()==InputEvent.BUTTON2_DOWN_MASK) {
//			System.out.println("Has pulsado la rueda del raton");
//		}else if (e.getModifiersEx()==InputEvent.BUTTON3_DOWN_MASK) {
//			System.out.println("Has presionado el boton derecho");
//		}
//	}
//
//	public void mouseReleased(MouseEvent e) {
//
//		System.out.println("Acabas de levantar");
//	}
//
//	public void mouseEntered(MouseEvent e) {
//		
//		System.out.println("Acbas de entrar");
//	}
//
//	public void mouseExited(MouseEvent e) {
//		
//		System.out.println("Acabas de salir");
//	}

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
//		EventosDeRaton EventoRaton = new EventosDeRaton();
// //		addMouseListener(EventoRaton);
//			addMouseMotionListener(EventoRaton);
//	}
//}
