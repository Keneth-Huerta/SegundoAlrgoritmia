package poo;

import java.util.Scanner;

public class Uso_Tallas {

//	enum talla {
//		MINI, mediano, grande, muy_grande
//
//	};

	enum Talla {
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");

		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}

		public String dameAbreviatura() {
			return abreviatura;
		}

		private String abreviatura;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Escribe una talla: MINI, MEADIANO, GRANDE, MUY_GRANDE");

		String entrada_datos = in.next().toUpperCase();

		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("Talla="+la_talla);
		System.out.println("Abreviatura="+la_talla.dameAbreviatura());
	}
}