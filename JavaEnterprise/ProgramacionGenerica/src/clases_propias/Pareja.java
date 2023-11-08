package clases_propias;

public class Pareja<T> {
	private T primero;

	public Pareja() {

		setPrimero(null);
	}

	public static void imprimirTrabajador(Pareja<? extends Empleado> p) {

		Empleado primero = p.getPrimero();
		System.out.println(primero);
	}

	public T getPrimero() {
		return primero;
	}

	public void setPrimero(T primero) {
		this.primero = primero;
	}
}
