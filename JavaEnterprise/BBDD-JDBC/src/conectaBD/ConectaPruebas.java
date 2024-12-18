package conectaBD;

import java.sql.*;

public class ConectaPruebas {

	public static void main(String[] args) {

		try {

			// 1. CREAR CONEXIÓN
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			// 2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();
			// 3. EJECUTAR SQL
			ResultSet miResultset = miStatement.executeQuery("SELECT * FROM articulos");
			// 4 RECORRER EL RESULSET
			while (miResultset.next()) {

				System.out.println(miResultset.getString("Seccion") + " " + miResultset.getString("NombreArticulo")
						+ " " + miResultset.getString("CodigoArticulo") + " " + miResultset.getString("Precio"));
			}
		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();
		}

	}

}
