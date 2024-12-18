package conectaBD;

import java.sql.*;

public class ConsultaPreparada {

	public static void main(String[] args) {

		try {
			// 1. Crear conexión
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

			// 2. Preparar consulta

			PreparedStatement miSentencia = miConexion.prepareStatement(
					"SELECT NombreArticulo, Seccion, PaisOrigen FROM articulos WHERE Seccion=? AND PaisOrigen=?");

			// 3. Establecer parámetros de consulta

			miSentencia.setString(1, "Deportes");
			miSentencia.setString(2, "Estados Unidos");

			// 4. Ejecutar y recorrer consulta
			ResultSet rs = miSentencia.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();

			// Reutilización de consulta SQL
			System.out.println("Ejecucción de segunda consulta");
			System.out.println("");

			miSentencia.setString(1, "Moda");
			miSentencia.setString(2, "España");

			// 4. Ejecutar y recorrer consulta
			rs = miSentencia.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
