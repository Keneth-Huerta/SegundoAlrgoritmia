package serializacion;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {

		Admnistrador jefe = new Admnistrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);
		Empleado[] personal = new Empleado[3];
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

		try {

//			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
//					new FileOutputStream("C:\\Users\\kenet\\OneDrive\\Escritorio\\java-se\\empleado.txt"));
//			escribiendoFichero.writeObject(personal);
//			escribiendoFichero.close();

			ObjectInputStream recuperandoFichero = new ObjectInputStream(
					new FileInputStream("C:\\Users\\kenet\\OneDrive\\Escritorio\\java-se\\empleado.txt"));
			Empleado[] personalRecuperado = (Empleado[]) recuperandoFichero.readObject();
			recuperandoFichero.close();
			for (Empleado empleado : personalRecuperado) {
				System.out.println(empleado);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

//---------------

class Empleado implements Serializable {
	private static final long serialVersionUID = 1859525275143132405L;
	private String nombre;
	private double sueldo;
	private Date fechaContrato;

	public Empleado(String n, double s, int agno, int mes, int dia) {
		nombre = n;
		sueldo = s;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		fechaContrato = calendario.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void subirSueldo(double porcentaje) {

		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

	public String toString() {

		return "El nombre es = " + nombre + ", y su sueldo es = " + sueldo + ", fehca de contrato = " + fechaContrato;
	}

}

//-----------------------------------

class Admnistrador extends Empleado {
	private static final long serialVersionUID = 1859525275143132405L;
	private double incentivo;

	public Admnistrador(String n, double s, int agno, int mes, int dia) {

		super(n, s, agno, mes, dia);
		incentivo = 0;
	}

	public double getSueldo() {
		return super.getSueldo() + incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}

	public String toString() {

		return super.toString() + ", Incentivos=" + incentivo;
	}
}
