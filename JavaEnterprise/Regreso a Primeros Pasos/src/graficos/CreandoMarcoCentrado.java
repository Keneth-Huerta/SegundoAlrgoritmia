package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {

		MarcoCentrado mimarco = new MarcoCentrado();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);
		mimarco.setIconImage(null);
	}

}

class MarcoCentrado extends JFrame {

	public MarcoCentrado() {

		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setBounds(0, 0, anchoPantalla / 2, altoPantalla / 2);
		setLocationRelativeTo(null);
		setTitle("Mi ventana");
		Image miIcono = mipantalla.getImage("src/graficos/inoco.png");
		setIconImage(miIcono);

	}
}