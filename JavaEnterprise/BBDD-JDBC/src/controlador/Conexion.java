package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private Connection miConexion = null;

	public Connection dameConexion() {

		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

			} catch (Exception e) {

		}
		return miConexion;
	}

	public Conexion() {

	}
}
