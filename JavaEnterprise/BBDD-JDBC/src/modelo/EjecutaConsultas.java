package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controlador.Conexion;

public class EjecutaConsultas {
	private Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsultaSeccion;
	private final String consultaSeccion = "SELECT CodigoArticulo, NombreArticulo, Seccion, Precio,PaisOrigen FROM articulos WHERE Seccion=?";
	private PreparedStatement enviaConsultaPais;
	private final String consultaPais = "SELECT CodigoArticulo, NombreArticulo, Seccion, Precio,PaisOrigen FROM articulos WHERE PaisOrigen=?";
	private PreparedStatement enviaConsultaTodos;
	private final String consultaTodos = "SELECT CodigoArticulo, NombreArticulo, Seccion, Precio,PaisOrigen FROM articulos WHERE Seccion=? AND PaisOrigen=?";

	public EjecutaConsultas() {

		miConexion = new Conexion();
	}

	public ResultSet filtraBBDD(String seccion, String pais) {
		Connection conecta = miConexion.dameConexion();
		rs = null;

		try {

			if (!seccion.equals("Todos") && pais.equals("Todos")) {

				enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs = enviaConsultaSeccion.executeQuery();
			} else if (seccion.equals("Todos") && !pais.equals("Todos")) {

				enviaConsultaPais = conecta.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
			} else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaTodos = conecta.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
				
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return rs;
	}
}
