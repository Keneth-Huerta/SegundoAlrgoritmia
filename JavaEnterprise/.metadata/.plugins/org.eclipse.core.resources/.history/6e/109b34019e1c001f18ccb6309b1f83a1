package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controlador.Conexion;

public class ModificaConsulta {
	private Conexion miConexion;
	private PreparedStatement enviaCambio;
	private final String instruccionSQL = "UPDATE articulos SET PRECIO=? WHERE CodigoArticulo=?";

	public ModificaConsulta() {

		miConexion = new Conexion();
	}

	public void cambiaContenido(double precio, int codigo) {
		Connection conecta = miConexion.dameConexion();

		try {
			enviaCambio = conecta.prepareStatement(instruccionSQL);
			enviaCambio.setDouble(1, precio);
			enviaCambio.setInt(2, codigo);
			enviaCambio.executeUpdate();
			System.out.println("Datos insertados correctamente1");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
