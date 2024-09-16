package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaMenus;
import vista.MarcoAplicacion;

public class ControladorCargaMenus extends WindowAdapter {
	CargaMenus obj = new CargaMenus();
	private MarcoAplicacion elmarco;

	public ControladorCargaMenus(MarcoAplicacion elmarco) {

		this.elmarco = elmarco;
	}

	public void windowOpened(WindowEvent e) {
	
		obj.ejecutaConsu1tas();
		try {
			
			while (obj.rs.next()) {
				elmarco.getSecciones().addItem(obj.rs.getString(1));
			}
			while (obj.rs2.next()) {
				
				elmarco.getPaises().addItem(obj.rs2.getString(1));
			}
			while (obj.rs3.next()) {

				elmarco.getCodigo().addItem(obj.rs3.getInt(1));
			}
		} catch (Exception e2) {
			
			e2.getMessage();
			e2.printStackTrace();
		}
	}
}
