package conectaBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AplicacionConsulta {

	public static void main(String[] args) {

		VentaConsulta mimarco = new VentaConsulta();
		mimarco.setVisible(true);
	}
}

class VentaConsulta extends JFrame {

	public VentaConsulta() {

		setTitle("Consulta BBDD");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);

		MarcoConsulta milamina = new MarcoConsulta();
		add(milamina);
	}
}

class MarcoConsulta extends JPanel {
	private JComboBox<String> secciones;
	private JComboBox<String> paises;
	private JTextArea resultado;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	private final String consultaSeccion = "SELECT NombreArticulo, Seccion, Precio, PaisOrigen FROM articulos WHERE Seccion=?";
	private final String consultaPais = "SELECT NombreArticulo, Seccion, Precio, PaisOrigen FROM articulos WHERE PaisOrigen=?";
	private final String consultaTodos = "SELECT NombreArticulo, Seccion, Precio, PaisOrigen FROM articulos WHERE Seccion=? AND PaisOrigen=? ";
	private Connection miConexion;

	public MarcoConsulta() {

		setLayout(new BorderLayout());
		JPanel lamina1 = new JPanel();
		lamina1.setLayout(new FlowLayout());

		secciones = new JComboBox<String>(new String[] { "Todos" });
		secciones.setEditable(false);
		paises = new JComboBox<String>(new String[] { "Todos" });
		resultado = new JTextArea();

		JButton boton = new JButton("Consulta");

		lamina1.add(secciones);
		lamina1.add(paises);
		add(lamina1, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		boton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ejectutaConsulta();
			}
		});
		add(boton, BorderLayout.SOUTH);

		// -----------------Conexión con BBDD-----------------

		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

			Statement sentencia = miConexion.createStatement();

			// -------Carga JComboBox Secciones---------
			String consulta = "SELECT DISTINCTROW Seccion FROM articulos";

			ResultSet rs = sentencia.executeQuery(consulta);

			while (rs.next()) {
				secciones.addItem(rs.getString(1));
			}
			rs.close();
			// -------Carga JComboBox Paises---------
			consulta = "SELECT DISTINCTROW PaisOrigen FROM articulos";
			rs = sentencia.executeQuery(consulta);
			while (rs.next()) {
				paises.addItem(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();
		}
	}

	private void ejectutaConsulta() {
		ResultSet rs = null;
		try {
			String seccion = (String) secciones.getSelectedItem();
			String pais = (String) paises.getSelectedItem();

			if (!seccion.equals("Todos") && pais.equals("Todos")) {

				enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs = enviaConsultaSeccion.executeQuery();
			} else if (seccion.equals("Todos") && !pais.equals("Todos")) {

				enviaConsultaPais = miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
			} else if (!seccion.equals("Todos") && !pais.equals("Todos")) {

				enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
			}

			resultado.setText("");
			while (rs.next()) {

				resultado.append(rs.getString(1));
				resultado.append(",");
				resultado.append(rs.getString(2));
				resultado.append(",");
				resultado.append(rs.getString(3));
				resultado.append(",");
				resultado.append(rs.getString(4));
				resultado.append("\n");
			}

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
