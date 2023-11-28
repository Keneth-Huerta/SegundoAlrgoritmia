package clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {

//		Empleado Administrativa = new Empleado("Elena", 45, 1500);
//		Jefe DirectorioComercial = new Jefe("Ana", 27, 3500);
//		Empleado nuevoEmpleado = DirectorioComercial;
		Pareja<Empleado> Administrativa = new Pareja<Empleado>();
		Pareja<Jefe> DirectorioComercial = new Pareja<Jefe>();
//		Pareja<Empleado> nuevoEmpleado = DirectorioComercial;
		
		Pareja.imprimirTrabajador(Administrativa);
		Pareja.imprimirTrabajador(DirectorioComercial);
	}

}
