package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModificaConsulta;
import vista.MarcoAplicacion;

public class ControladorBotonCambia implements ActionListener {
	private MarcoAplicacion elmarco;
	private ModificaConsulta obj=new ModificaConsulta();

	public ControladorBotonCambia(MarcoAplicacion elmarco) {
		this.elmarco = elmarco;
	}

	public void actionPerformed(ActionEvent e) {
		int contenidoCodigo = Integer.valueOf(elmarco.getTexto().getText());
		Double contenidoPrecio = Double.valueOf(elmarco.getTexto().getText());
		
		obj.cambiaContenido(contenidoPrecio, contenidoCodigo);
		System.out.println("Datos insertados correctamente");

	}
}
