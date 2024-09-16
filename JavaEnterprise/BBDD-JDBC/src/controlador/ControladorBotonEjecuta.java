package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import modelo.EjecutaConsultas;
import vista.MarcoAplicacion;

public class ControladorBotonEjecuta implements ActionListener {
	private MarcoAplicacion elmarco;
	private ResultSet resultadoConsulta;
	EjecutaConsultas obj = new EjecutaConsultas();

	public ControladorBotonEjecuta(MarcoAplicacion elmarco) {

		this.elmarco = elmarco;
	}

	public void actionPerformed(ActionEvent e) {

		String seleccionSeccion = elmarco.getSecciones().getSelectedItem().toString();
		String seleccionPais = elmarco.getPaises().getSelectedItem().toString();

		resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
		try {
			elmarco.getResultado().setText("");
			while (resultadoConsulta.next()) {
				

				elmarco.getResultado().append(resultadoConsulta.getString(1) + ", " + resultadoConsulta.getString(2)
						+ ", " + resultadoConsulta.getString(3) + ", " + resultadoConsulta.getString(4)+ ", " + resultadoConsulta.getString(5));
				elmarco.getResultado().append("\n");
				
			}
		} catch (Exception e2) {
			e2.getMessage();
			e2.printStackTrace();
		}
	}
}
