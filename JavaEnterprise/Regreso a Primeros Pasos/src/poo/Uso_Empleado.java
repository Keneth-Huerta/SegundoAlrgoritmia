package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {

	public static void main(String[] args) {

		/*
		 * Empleado empleado1 = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		 * Empleado empleado2 = new Empleado("Ana López", 95000, 1995, 06, 02); Empleado
		 * empleado3 = new Empleado("María Martín", 105000, 2002, 03, 128);
		 * 
		 * empleado1.subeSueldoo(5); empleado2.subeSueldoo(5); empleado3.subeSueldoo(5);
		 * 
		 * System.out.println("Nombre: " + empleado1.dameNombre() + "\nSueldo: " +
		 * empleado1.dameSueldo() + "\nFecha de Alta: " +
		 * empleado1.dameFechaContrato()); System.out.println("Nombre: " +
		 * empleado2.dameNombre() + "\nSueldo: " + empleado2.dameSueldo() +
		 * "\nFecha de Alta: " + empleado2.dameFechaContrato());
		 * System.out.println("Nombre: " + empleado3.dameNombre() + "\nSueldo: " +
		 * empleado3.dameSueldo() + "\nFecha de Alta: " +
		 * empleado3.dameFechaContrato());
		 */
		Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);

		jefe_RRHH.estableceIncentivo(25770);

		Empleado[] misEmpleados = new Empleado[6];

		misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana López", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("María Martín", 105000, 2002, 03, 128);
		misEmpleados[3] = new Empleado("Antonio Fernández");
		misEmpleados[4] = jefe_RRHH; // Polimorfirsmo en acción. Principio de sustitución
		misEmpleados[5] = new Jefatura("María", 95000, 1999, 5, 26);
		Jefatura Jefa_finanzas = (Jefatura) misEmpleados[5];

		Jefa_finanzas.estableceIncentivo(55000);

		System.out.println(Jefa_finanzas.tomar_decisiones("Dar más vacaciones a los empleados"));

		System.out.println(
				"El Jefe " + Jefa_finanzas.dameNombre() + " tiene un bonus de: " + Jefa_finanzas.estable_bonus(500));

		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de: " + misEmpleados[3].estable_bonus(200));

		for (Empleado empleado : misEmpleados) {

			empleado.subeSueldo(5);
		}

		Arrays.sort(misEmpleados);

		for (Empleado empleado : misEmpleados) {

			System.out.println("Nombre: " + empleado.dameNombre() + " Sueldo: " + empleado.dameSueldo()
					+ " Fecha de Alta: " + empleado.dameFechaContrato());
		}
	}
}

class Empleado implements Comparable, Trabajadores {

	public Empleado(String nom, double sue, int agno, int mes, int dia) {

		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		altaContrato = calendario.getTime();
		idSiguiente++;
		id = idSiguiente;
	}

	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado = (Empleado) miObjeto;
		if (this.id < otroEmpleado.id) {
			return -1;
		}
		if (this.id > otroEmpleado.id) {
			return 1;
		}
		return 0;
	}

	public Empleado(String nom) {
		this(nom, 3000, 2000, 01, 01);
	}

	public String dameNombre() { // getter
		return nombre + " Id: " + id;
	}

	public double dameSueldo() {// getter
		return sueldo;
	}

	public Date dameFechaContrato() { // getter
		return altaContrato;
	}

	public void subeSueldo(double porcentaje) { // setter
		double aumento = sueldo * porcentaje / 100;

		sueldo += aumento;
	}

	private final String nombre;

	private double sueldo;

	private Date altaContrato;

	private static int idSiguiente;

	private int id;

	public double estable_bonus(double gratificacion) {

		return Trabajadores.bonus_MarcoCambioEstado + gratificacion;
	}

}

class Jefatura extends Empleado implements Jefes {

	private double incentivo;

	public Jefatura(String nom, double sue, int agno, int mes, int día) {

		super(nom, sue, agno, mes, día);

	}

	public void estableceIncentivo(double b) {

		incentivo = b;
	}

	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo();
		return sueldoJefe + incentivo;
	}

	public String tomar_decisiones(String decision) {

		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}

	public double estable_bonus(double gratificacion) {

		double prima = 2000;
		return Trabajadores.bonus_MarcoCambioEstado + gratificacion + prima;
	}
}
