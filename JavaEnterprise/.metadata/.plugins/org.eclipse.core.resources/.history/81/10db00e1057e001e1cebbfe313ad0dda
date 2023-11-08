package Segundoalrgoritmia;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class NombresArregloFrame {

	public static void main(String[] args) {
		NombresFrame miventana = new NombresFrame();
		miventana.setVisible(true);
		miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class NombresFrame extends JFrame {

	NombresFrame() {
		setSize(500, 400);
		setLocationRelativeTo(null);
		setTitle("Alumnos y sus promedios");
		setIconImage(new ImageIcon(getClass().getResource("Cubo-EnfocadoL.png")).getImage());
		NombresLamina milamina = new NombresLamina();
		add(milamina);
	}
}

class NombresLamina extends JPanel {

	private ArrayList<String> listNombres = new ArrayList<>();
	private ArrayList<Integer> listPromedios = new ArrayList<>();

	NombresLamina() {
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu menuA = new JMenu("Agregar alumnos");
		JMenu menuB = new JMenu("Buscar");
		JMenu menuR = new JMenu("Reiniciar");
		JPanel milamina2 = new JPanel();
		JPanel milamina3 = new JPanel();
		JPanel lamina = new JPanel();
		JPanel lamina2 = new JPanel();
		JLabel textprom = new JLabel();
		JTextField textnom = new JTextField(15);

		menuBar.add(menuA);
		menuA.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				milamina2.setVisible(true);
				milamina3.setVisible(false);
				lamina.setVisible(true);
				lamina2.setVisible(false);
			}

			@Override
			public void menuCanceled(MenuEvent e) {
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}
		});
		menuBar.add(menuB);
		menuB.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				milamina2.setVisible(false);
				milamina3.setVisible(true);
				lamina.setVisible(false);
				lamina2.setVisible(true);
				add(lamina2, BorderLayout.SOUTH);
				add(milamina3, BorderLayout.CENTER);
			}

			@Override
			public void menuCanceled(MenuEvent e) {
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}
		});
		menuBar.add(menuR);
		menuR.addMenuListener(new MenuListener() {
			@Override
			public void menuCanceled(MenuEvent e) {
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuSelected(MenuEvent e) {
				listNombres.removeAll(listNombres);
				listPromedios.removeAll(listPromedios);
			}
		});

		add(menuBar, BorderLayout.NORTH);

		JLabel texto1 = new JLabel("Nombre: ");
		JLabel texto2 = new JLabel("Promedio: ");
		JTextField mitexto = new JTextField(15);
		JTextField mitexto2 = new JTextField(15);
		JButton miboton = new JButton("Agregar");
		JButton miboton1 = new JButton("Promedio");
		JButton miboton2 = new JButton("Buscar");

		miboton.addActionListener((ActionEvent e) -> {
			listNombres.add(mitexto.getText());
			listPromedios.add(Integer.valueOf(mitexto2.getText()));
			mitexto.setText("");
			mitexto2.setText("");
		});
		mitexto2.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					listNombres.add(mitexto.getText());
					listPromedios.add(Integer.valueOf(mitexto2.getText()));
					mitexto.setText("");
					mitexto2.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		mitexto.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					listNombres.add(mitexto.getText());
					listPromedios.add(Integer.valueOf(mitexto2.getText()));
					mitexto.setText("");
					mitexto2.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		milamina2.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					listNombres.add(mitexto.getText());
					listPromedios.add(Integer.valueOf(mitexto2.getText()));
					mitexto.setText("");
					mitexto2.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		JLabel texto3 = new JLabel();

		miboton1.addActionListener((ActionEvent e) -> {
			int promedios = 0;
			for (int promedio : listPromedios) {
				promedios += promedio;
			}
			texto3.setText("El promedio de los alumnos es: " + String.valueOf(promedios / listPromedios.size()));
		});
		miboton2.addActionListener((ActionEvent e) -> {
			for (String string : listNombres) {
				int index = string.indexOf(string);
				if (string.equalsIgnoreCase(textnom.getText())) {
					textprom.setText(String.valueOf(listPromedios.get(index)));
				}
			}
		});

		add(milamina3, BorderLayout.CENTER);
		milamina3.add(new JLabel("Buscar alumno: "));
		milamina3.add(textnom);
		milamina3.add(new JLabel("Promedio: "));
		milamina3.add(textprom);
		milamina3.setVisible(false);

		add(lamina2, BorderLayout.SOUTH);
		lamina2.add(miboton2);
		lamina2.setVisible(false);

		add(milamina2, BorderLayout.CENTER);
		milamina2.add(texto1);
		milamina2.add(mitexto);
		milamina2.add(texto2);
		milamina2.add(mitexto2);
		milamina2.add(texto3, BorderLayout.SOUTH);

		add(lamina, BorderLayout.SOUTH);
		lamina.add(miboton);
		lamina.add(miboton1);
	}
}
