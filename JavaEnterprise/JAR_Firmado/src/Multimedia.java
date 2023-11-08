
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Multimedia {

	public static void main(String[] args) {

		MarcoImagen mimarco = new MarcoImagen();
		mimarco.setVisible(true);
	}

}

class MarcoImagen extends JFrame {

	private Image imagen;

	public MarcoImagen() {

		setTitle("Marcon Con Imagen");
		setSize(300, 200);
		setLocationRelativeTo(null);

		LaminaConImagen milamina = new LaminaConImagen();
		add(milamina);
		try {
			imagen = ImageIO.read(new File("src/Cubo-EnfocadoL.png"));
		} catch (IOException e) {
			System.out.println("Imagen no encontrada");
		}
		setIconImage(imagen);

	}
}

class LaminaConImagen extends JPanel {

	private Image imagen;

	public LaminaConImagen() {
		try {
			imagen = ImageIO.read(new File("src/Cubo-EnfocadoL.png"));
		} catch (IOException e) {
			System.out.println("la imagen no se encuentra");
		}
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

//		File miImagen = new File("src/graficos/inoco.png");
		g.drawImage(imagen, 0, 0, null);
	}
}