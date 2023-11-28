package graficos;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SintaxisRadio {

	public static void main(String[] args) {

		MarcoRadioSintaxis mimarco = new MarcoRadioSintaxis();
		mimarco.setVisible(true);
	}

}

class MarcoRadioSintaxis extends JFrame {

	public MarcoRadioSintaxis() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new Logo().image());
		setBounds(550, 300, 500, 300);
		LaminaRadioSintaxsis milamina = new LaminaRadioSintaxsis();
		add(milamina);
	}
}

class LaminaRadioSintaxsis extends JPanel {

	public LaminaRadioSintaxsis() {
		ButtonGroup migrupo1 = new ButtonGroup();
		ButtonGroup migrupo2 = new ButtonGroup();
		JRadioButton boton1 = new JRadioButton("Azul", false);
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		JRadioButton boton3 = new JRadioButton("Verde", false);
		JRadioButton boton4 = new JRadioButton("Masculino", false);
		JRadioButton boton5 = new JRadioButton("Femenino", false);
		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		migrupo2.add(boton4);
		migrupo2.add(boton5);
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton3);
		add(boton4);
		add(boton5);
	}

}