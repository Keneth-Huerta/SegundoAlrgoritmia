package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String[] args) {

		try {

			// 1. CREAR CONEXIÓN
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			// 2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			String instruccionSql = "DELETE FROM articulos WHER WHERE CodigoArticulo='77'";
									//"UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
			miStatement.executeUpdate(instruccionSql);

			System.out.println("Datos insertados correctamente");
			

		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();
		}
	}

}