package graficos;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaImagenes {

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
			imagen = ImageIO.read(new File("src/graficos/Cubo-EnfocadoL.png"));
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
			imagen = ImageIO.read(new File("src/graficos/inoco.png"));
		} catch (IOException e) {
			System.out.println("la imagen no se encuentra");
		}
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

//		File miImagen = new File("src/graficos/inoco.png");
		g.drawImage(imagen, 0, 0, null);
		int altoLamina = getSize().height;
		int anchoLamina = getSize().width;
		for (int i = 0; i < (anchoLamina / imagen.getWidth(null)); i++) {
			for (int j = 0; j < (altoLamina / imagen.getHeight(null)); j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, imagen.getWidth(this), imagen.getHeight(this), imagen.getWidth(this) * i,
							imagen.getHeight(null) * j);
				}
			}
		}
//		for (int i = 0; i < 300; i++) {
//			for (int j = 0; j < 200; j++) {
//				g.copyArea(0, 0, 128, 128, 128*i, 128*j);
//			}
//		}
	}
}

class Logo {
	private Image image;

	public Logo() {

		try {
			image=ImageIO.read(new File("src/graficos/Cubo-EnfocadoL.png"));
		}
		catch(IOException e) {
			System.out.println("La image no se encuentra");
		}
	}
	public Image image() {
		
		return this.image;
	}
}