package leyendo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPanel;

public class AccesoFichero {

	public static void main(String[] args) {

		LeerFichero accediendo = new LeerFichero();
		accediendo.lee();
		FrameFichero mimarco = new FrameFichero();
		mimarco.setVisible(true);
	}

}

class LeerFichero {
	private String linea;

	public String lee() {
		try {
			FileReader entrada = new FileReader("C:/Users/kenet/OneDrive/Escritorio/hola.txt");
			BufferedReader mibuffer = new BufferedReader(entrada);
			File file = new File("C:/Users/kenet/OneDrive/Escritorio/hola.txt");
//			letra = new char[(int) file.length() + 1];
//			System.out.println(file.length());
//			int c = 0;
//			int i = 0;
			linea = "";
			while (this.linea != null) {
//				c = entrada.read();
//				letra[i] = (char) c;
//				i++;
				this.linea = mibuffer.readLine();
				if (this.linea != null) {

					System.out.println(this.linea);
				}
			}
			System.out.println(linea);
			entrada.close();
		} catch (IOException e) {

			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
		return linea;
	}

}

class FrameFichero extends JFrame {

	public FrameFichero() {

		setBounds(300, 300, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LaminaFicheros milamina = new LaminaFicheros();
		add(milamina);
	}
}

class LaminaFicheros extends JPanel {

	public LaminaFicheros() {

		JLabel label = new JLabel(String.valueOf(new LeerFichero().lee()));
		System.out.println(new LeerFichero().lee());
		add(label);
	}
}