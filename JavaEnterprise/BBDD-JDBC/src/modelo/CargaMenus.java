package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controlador.Conexion;

public class CargaMenus {
	public ResultSet rs;
	public ResultSet rs2;
	public ResultSet rs3;
	public Conexion miConexion;
	

	public CargaMenus() {

		miConexion = new Conexion();
	}

	public String ejecutaConsu1tas() {
		Productos miProducto = null;
		Connection accesoBBDD = miConexion.dameConexion();
		try {
			Statement secciones = accesoBBDD.createStatement();
			Statement paises = accesoBBDD.createStatement();
			Statement codigo = accesoBBDD.createStatement();
			rs = secciones.executeQuery("SELECT DISTINCTROW Seccion FROM articulos");
			rs2 = paises.executeQuery("SELECT DISTINCTROW PaisOrigen FROM articulos");
			rs3 = codigo.executeQuery("SELECT DISTINCTROW CodigoArticulo FROM articulos");
			miProducto = new Productos();
			
			miProducto.setSeccion(rs.getString(1));
			miProducto.setpOrigen(rs2.getString(2));
			miProducto.setCodigo(rs3.getInt(1));
			rs.close();
			rs2.close();
			rs3.close();
			accesoBBDD.close();
		} catch (Exception e) {
			
			
		}
		return miProducto.getSeccion();
		
	}
}
