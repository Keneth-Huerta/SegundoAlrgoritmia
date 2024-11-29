import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseData {
	String user, pass, result = "";

	public BaseData(String user, String pass) {

		this.user = user;
		this.pass = pass;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/Basesita", "root", "1420");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM usuarios");
			while (miResultSet.next()) {

				CheckPass(miResultSet.getString("nombre_usuario"), miResultSet.getString("contrasena"),
						miResultSet.getBoolean("es_administrador"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getResult() {
		return result;
	}

	public void CheckPass(String user, String pass, boolean type) {

		if (this.user.equals(user)) {
			if (this.pass.equals(pass)) {

				if (type) {
					result = "admin";
				} else {

					result = "user";
				}
			} else {

				result = "incorrecta";
			}

		}
	}
}
