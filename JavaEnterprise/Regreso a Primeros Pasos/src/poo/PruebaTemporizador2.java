package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador2 {

	public static void main(String[] args) {

		Reloj mireloj = new Reloj();

		mireloj.enMarcha(3, true);

		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	}

}

class Reloj {

//	public Reloj(int intervalo, boolean sonido) {
//
//		this.intervalo = intervalo * 1000;
//		this.sonido = sonido;
//	}

	public void enMarcha(int intervalo, final boolean sonido) {

		class DameLaHora2 implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				Date ahora = new Date();
				System.out.println("Te pongo la hora cada " + intervalo + " sg " + ahora);
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}

		}

		ActionListener oyente = new DameLaHora2();

		Timer mitemporizador2 = new Timer(intervalo * 1000, oyente);
		mitemporizador2.start();

	}

}
