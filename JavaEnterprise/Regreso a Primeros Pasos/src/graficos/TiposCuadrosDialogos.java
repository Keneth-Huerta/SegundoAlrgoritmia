package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TiposCuadrosDialogos {

	public static void main(String[] args) {

		CuadroDialogos mimarco = new CuadroDialogos();
		mimarco.setVisible(true);
	}

}

class CuadroDialogos extends JFrame {

	public CuadroDialogos() {

		setBounds(500, 300, 400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		add(new LaminaCuadrosDialogos());
	}
}

class LaminaCuadrosDialogos extends JPanel {
	JButton boton1, boton2, boton3, boton4;

	public LaminaCuadrosDialogos() {

		boton1 = new JButton("Boton 1");
		boton2 = new JButton("Boton 2");
		boton3 = new JButton("Boton 3");
		boton4 = new JButton("Boton 4");
		boton1.addActionListener(new AccionBotones());
		boton2.addActionListener(new AccionBotones());
		boton3.addActionListener(new AccionBotones());
		boton4.addActionListener(new AccionBotones());
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	}

	private class AccionBotones implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == boton1) {
				
//				System.out.println("Has pulsado el botón 1");
//				JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de prueba");
				JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de prueba","Advertencia",JOptionPane.WARNING_MESSAGE);
			} else if (e.getSource() == boton2) {
				
//				System.out.println("Has pulsado el botón 2");
				JOptionPane.showInputDialog(LaminaCuadrosDialogos.this,"Introduce nombre","Introducción datos",2);
			} else if (e.getSource() == boton3) {
				
//				System.out.println("Has pulsado el botón 3");
				JOptionPane.showConfirmDialog(LaminaCuadrosDialogos.this, "Elige opción","V confirmar",JOptionPane.CANCEL_OPTION);
			} else if (e.getSource() == boton4) {
				
				JOptionPane.showOptionDialog(LaminaCuadrosDialogos.this, "Elige", "V de opciones", JOptionPane.ERROR_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, null, null);
//				System.out.println("Has pulsado el botón 4");
			}
		}
	}
}
