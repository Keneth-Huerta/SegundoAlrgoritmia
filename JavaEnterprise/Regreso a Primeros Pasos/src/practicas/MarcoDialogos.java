package practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoDialogos extends JFrame {
	private Laminabotones laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;

	public MarcoDialogos() {
		setIconImage(new ImageIcon(getClass().getResource("Cubo-EnfocadoL.png")).getImage());
		setTitle("Prueba de diálogos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 300, 600, 450);

		laminaTipo = new Laminabotones("Tipo", new String[] { "Mensaje", "Confirmar", "Opción", "Entrada" });
		laminaTipoMensaje = new Laminabotones("Tipo de Mensaje", new String[] { "ERROR_MESSAGE", "INFORMATION_MESSAGE",
				"WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE" });
		laminaMensaje = new Laminabotones("Mensaje",
				new String[] { "Cadena", "Icono", "Componente", "Otros", "Object [ ]" });
		laminaConfirmar = new Laminabotones("Confirmar",
				new String[] { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" });
		laminaOpcion = new Laminabotones("Opción", new String[] { "String [ ]", "Icon [ ]", "Object [ ]" });
		laminaEntrada = new Laminabotones("Entrada", new String[] { "Campo de texto", "Combo" });

		JPanel milamina = new JPanel(new GridLayout(2, 3));
		milamina.add(laminaTipo);
		milamina.add(laminaTipoMensaje);
		milamina.add(laminaMensaje);
		milamina.add(laminaConfirmar);
		milamina.add(laminaOpcion);
		milamina.add(laminaEntrada);
		add(milamina, BorderLayout.CENTER);

		JButton boton = new JButton("Mostrar");
		boton.addActionListener(new AccionMostrar());
		JPanel milamina2 = new JPanel();
		milamina2.add(boton);
		add(milamina2, BorderLayout.SOUTH);
	}

	private class AccionMostrar implements ActionListener {
		private String title = "Título";
		private Object message[] = { "Mensajeee", new ImageIcon("src/practicas/Azul.gif"), new LaminaEjemplo(),
				new Date() };

		public void actionPerformed(ActionEvent e) {
			int messageType = JOptionPane.PLAIN_MESSAGE;

			if (laminaTipoMensaje.dameSeleccion().equals("ERROR_MESSAGE")) {
				messageType = JOptionPane.ERROR_MESSAGE;
			} else if (laminaTipoMensaje.dameSeleccion().equals("INFORMATION_MESSAGE")) {
				messageType = JOptionPane.INFORMATION_MESSAGE;
			} else if (laminaTipoMensaje.dameSeleccion().equals("WARNING_MESSAGE")) {
				messageType = JOptionPane.WARNING_MESSAGE;
			} else if (laminaTipoMensaje.dameSeleccion().equals("QUESTION_MESSAGE")) {
				messageType = JOptionPane.QUESTION_MESSAGE;
			} else if (laminaTipoMensaje.dameSeleccion().equals("PLAIN_MESSAGE")) {
				messageType = JOptionPane.PLAIN_MESSAGE;
			}

			Object mensaje = null;
			if (laminaMensaje.dameSeleccion().equals("Cadena")) {
				mensaje = message[0];
			} else if (laminaMensaje.dameSeleccion().equals("Icono")) {
				mensaje = message[1];
			} else if (laminaMensaje.dameSeleccion().equals("Componente")) {
				mensaje = new LaminaEjemplo();
			} else if (laminaMensaje.dameSeleccion().equals("Otros")) {
				mensaje = message[3];
			} else if (laminaMensaje.dameSeleccion().equals("Object [ ]")) {
				mensaje = message;
			}

			if (laminaTipo.dameSeleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(MarcoDialogos.this, mensaje, title, messageType);
			} else if (laminaTipo.dameSeleccion().equals("Confirmar")) {
				int optionType = JOptionPane.DEFAULT_OPTION;
				if (laminaConfirmar.dameSeleccion().equals("YES_NO_OPTION")) {
					optionType = JOptionPane.YES_NO_OPTION;
				} else if (laminaConfirmar.dameSeleccion().equals("YES_NO_CANCEL_OPTION")) {
					optionType = JOptionPane.YES_NO_CANCEL_OPTION;
				} else if (laminaConfirmar.dameSeleccion().equals("OK_CANCEL_OPTION")) {
					optionType = JOptionPane.OK_CANCEL_OPTION;
				}
				JOptionPane.showConfirmDialog(MarcoDialogos.this, mensaje, title, optionType, messageType);
			} else if (laminaTipo.dameSeleccion().equals("Opción")) {
				Object[] options = null;
				if (laminaOpcion.dameSeleccion().equals("String [ ]")) {
					options = new String[] { "Amarillo", "Azul", "Rojo" };
				} else if (laminaOpcion.dameSeleccion().equals("Icon [ ]")) {
					options = new ImageIcon[] { new ImageIcon("src/practicas/Rojo.gif"),
							new ImageIcon("src/practicas/Amarillo.gif"), new ImageIcon("src/practicas/Azul.gif") };
				} else if (laminaOpcion.dameSeleccion().equals("Object [ ]")) {
					options = message;
				}
				JOptionPane.showOptionDialog(MarcoDialogos.this, mensaje, title, 1, 1, null, options, null);
			} else if (laminaTipo.dameSeleccion().equals("Entrada")) {
				if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {
					JOptionPane.showInputDialog(MarcoDialogos.this, mensaje, title, messageType);
				} else if (laminaEntrada.dameSeleccion().equals("Combo")) {
					JOptionPane.showInputDialog(MarcoDialogos.this, mensaje, title, messageType, null,
							new String[] { "Amarillo", "Azul", "Rojo" }, "Amarillo");
				}
			}
		}
	}
}

class LaminaEjemplo extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.yellow);
		g2.fill(rectangulo);
	}
}