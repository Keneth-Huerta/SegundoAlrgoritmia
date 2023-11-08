package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PruebaVentana {

	public static void main(String[] args) {

		MarcoVentana mimarco = new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentana mimarco2 = new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}

}

class MarcoVentana extends JFrame {

	public MarcoVentana() {

		setTitle("Respondiendo");
		setSize(500, 350);
		setLocationRelativeTo(null);
//		M_Ventana oyente = new M_Ventana();
//		addWindowListener(oyente);
		addWindowListener(new M_Ventana());
		setVisible(true);
		setIconImage(new Logo().image());
	}
}

class M_Ventana extends WindowAdapter /*implements WindowListener */{

//	public void windowOpened(WindowEvent e) {
//
//		System.out.println("Ventana abierta");
//	}
//
//	public void windowClosing(WindowEvent e) {
//		
//		System.out.println("Cerrando ventana");
//	}
//
//	public void windowClosed(WindowEvent e) {
//
//		System.out.println("La ventana ha sido cerrada");
//	}

	public void windowIconified(WindowEvent e) {

		System.out.println("Ventana minimizada");
	}

//	public void windowDeiconified(WindowEvent e) {
//
//		System.out.println("Ventana Restaurada");
//	}
//
//	public void windowActivated(WindowEvent e) {
//		
//		System.out.println("Ventana Activada");
//	}
//
//	public void windowDeactivated(WindowEvent e) {
//
//		System.out.println("Ventana desactivada");
//	}

}