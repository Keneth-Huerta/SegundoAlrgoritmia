package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorBotonCambia;
import controlador.ControladorBotonEjecuta;
import controlador.ControladorCargaMenus;

public class MarcoAplicacion extends JFrame {
	private JComboBox<String> secciones;
	private JComboBox<String> paises;
	private JComboBox<Integer> codigo;
	private JTextField precio;

	public JTextField getTexto() {
		return precio;
	}

	public void setTexto(JTextField texto) {
		this.precio = texto;
	}

	public JComboBox<String> getPaises() {
		return paises;
	}

	public void setPaises(JComboBox<String> paises) {
		this.paises = paises;
	}

	public JTextArea getResultado() {
		return resultado;
	}

	public void setResultado(JTextArea resultado) {
		this.resultado = resultado;
	}

	private JTextArea resultado;

	public MarcoAplicacion() {

		setTitle("Consulta BBDD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());
		JPanel lamina1 = new JPanel();
		JPanel lamina2 = new JPanel();
		JPanel lamina3 = new JPanel();
		lamina1.setLayout(new FlowLayout());

		secciones = new JComboBox<String>(new String[] { "Todos" });
		paises = new JComboBox<String>(new String[] { "Todos" });

		resultado = new JTextArea(15, 30);
		resultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(resultado);
		JLabel text = new JLabel("Precio: ");
		JLabel text2 = new JLabel("Codigo: ");
		codigo= new JComboBox<Integer>();
		precio = new JTextField(15);
		lamina3.add(resultado, BorderLayout.CENTER);
		lamina3.add(text2, BorderLayout.SOUTH);
		lamina3.add(codigo);
		lamina3.add(text, BorderLayout.SOUTH);
		lamina3.add(precio, BorderLayout.SOUTH);

		JButton boton = new JButton("Consulta");
		boton.addActionListener(new ControladorBotonEjecuta(this));
		JButton boton2 = new JButton("Modifica");
		boton2.addActionListener(new ControladorBotonCambia(this));

		lamina1.add(secciones);
		lamina1.add(paises);
		add(lamina1, BorderLayout.NORTH);
		add(lamina3, BorderLayout.CENTER);
		lamina2.add(boton);
		lamina2.add(boton2);
		add(lamina2, BorderLayout.SOUTH);
		addWindowListener(new ControladorCargaMenus(this));
	}

	public JComboBox<Integer> getCodigo() {
		return codigo;
	}

	public void setCodigo(JComboBox<Integer> codigo) {
		this.codigo = codigo;
	}

	public JTextField getPrecio() {
		return precio;
	}

	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}

	public JComboBox<String> getSecciones() {
		return secciones;
	}

	public void setSecciones(JComboBox<String> secciones) {
		this.secciones = secciones;
	}

}
