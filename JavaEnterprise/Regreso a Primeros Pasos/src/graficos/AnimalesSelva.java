package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AnimalesSelva {

	public static void main(String[] args) {

		MarcoAnimales mimarco = new MarcoAnimales();
		mimarco.setVisible(true);
	}

}

class MarcoAnimales extends JFrame {

	public MarcoAnimales() {

		setTitle("Animaes de la selva");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocationRelativeTo(null);

		Metodos met = new Metodos();

		JLabel text = new JLabel("Algo de los animales");
		JList<String> list = new JList<String>(met.getAnimales());
		JScrollPane scroll = new JScrollPane(list);
		list.setVisibleRowCount(5);

		JButton boton = new JButton("Verificar");
		boton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cont++;

				if (cont <= 3) {

					List<String> texto = list.getSelectedValuesList();
					for (String string : texto) {

						if (met.esAnimalSelva(string)) {
							JOptionPane.showMessageDialog(null, "Es un animal de la selva");
						} else {

							JOptionPane.showMessageDialog(null, "No es un animal de la selva");
						}
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "Solo son 3 veces");
					System.exit(0);
				}
				
			}
		});

		lamina = new JPanel();
		lamina.add(text);
		lamina.add(scroll);
		lamina.add(boton);
		add(lamina);
	}

	private JPanel lamina;
	private int cont = 0;
}

class Metodos {

	private String[] animales = new String[] { "Jaguar", "Mono araña", "Guacamaya", "Tapir", "Tucán",
			"Serpiente arborícola", "Rana venenosa", "Armadillo", "Perezoso", "Hormiguero gigante", "Caimán",
			"Nutria gigante", "Pez ángel", "Mariposa morfo azul", "Libélula", "Escarabajo hércules", "Ciempiés gigante",
			"Tarántula", "Escorpión", "Araña pollito" };

	public String[] getAnimales() {

		ArrayList<Integer> nums = new ArrayList<Integer>();

		Random rand = new Random();

		for (int i = 0; i < animales.length; i++) {
			int numAlea;
			do {
				numAlea = rand.nextInt(animales.length);
			} while (nums.contains(numAlea));
			nums.add(numAlea);
		}
		int[] alea = new int[animales.length];
		for (int i = 0; i < nums.size(); i++) {

			alea[i] = nums.get(i);
		}

		String[] temp = animales;
		for (int i = 0; i < animales.length; i++) {

			animales[i] = temp[alea[i]];
		}

		return animales;
	}

	public static boolean esAnimalSelva(String animal) {

		String[] animalesSelva = { "Jaguar", "Mono araña", "Guacamaya", "Tapir", "Tucán", "Serpiente arborícola",
				"Rana venenosa", "Armadillo", "Perezoso", "Hormiguero gigante", "Caimán", "Nutria gigante",
				"Pez ángel" };

		for (String animalSelva : animalesSelva) {
			if (animalSelva.equalsIgnoreCase(animal)) {
				return true;
			}
		}
		return false;
	}

}
