package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {

	public static void main(String[] args) {

		MarcoCambioEstado mimarco = new MarcoCambioEstado(null,300,300,500,350,"eoc");
		
	}

}
class CambiaEstado implements WindowStateListener{

	public void windowStateChanged(WindowEvent e) {

//		System.out.println("La ventana a camdiado de estado");
//		System.out.println(e.getNewState());
		if (e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana esta pantalla completa");
		}else if (e.getNewState()==Frame.NORMAL) {
			System.out.println("La ventana está nomrmal");
		}else if (e.getNewState()==Frame.ICONIFIED) {
			System.out.println("La ventana está minimizada");
		}
	}
	
}
class MarcoCambioEstado extends JFrame {

	public MarcoCambioEstado(String title, int x, int y, int width, int height, String sdco) {

		if (sdco.equalsIgnoreCase("eoc")) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		setVisible(true);
		setBounds(x, y, width, height);
		setTitle(title);
		setIconImage(new Logo().image());
		CambiaEstado nuevo_estado = new CambiaEstado();
		addWindowStateListener(nuevo_estado);
	}
}