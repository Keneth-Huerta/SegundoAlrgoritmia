import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

	public static void main(String[] args) {

		Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
		Cliente cl2 = new Cliente("Rafael Nadal", "00002", 250000);
		Cliente cl3 = new Cliente("Penelope Cruz", "00003", 300000);
		Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
		Cliente cl5 = new Cliente("Antonio Banderas", "00001", 200000);

		Set<Cliente> clientesBanco = new HashSet<Cliente>();
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
//		for (Cliente cliente : clientesBanco) {
//
////			System.out.println(cliente.getNombre() + " " + cliente.getnCuenta() + " " + cliente.getSaldo() + "\n");
//			if (cliente.getNombre().equals("Julio Iglesias")) {
//				
//				clientesBanco.remove(cliente);
//			}
//		}
		Iterator<Cliente> it = clientesBanco.iterator();
		while (it.hasNext()) {

			String nombreClientes = it.next().getNombre();
			if (nombreClientes.equals("Julio Iglesias")) {

				it.remove();
			}
		}
		for (Cliente cliente : clientesBanco) {

			System.out.println(cliente.getNombre() + " " + cliente.getnCuenta() + " " + cliente.getSaldo());
		}
//		Iterator<Cliente> it = clientesBanco.iterator();
//		while (it.hasNext()) {
//			String nombreClientes = it.next().getNombre();
//			String noClientes = it.next().getnCuenta();
//			System.out.println(nombreClientes);
//		}
	}

}
